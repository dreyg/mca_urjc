const express = require('express');
const server = require('../server.js');
const router = express.Router();
const { Plant } = require('../models/plant.js');
const amqp = require('amqplib/callback_api');

const PLANT_NOT_FOUND_RESPONSE = { "error": "Plant not found" }
const CONN_URL = 'amqp://guest:guest@localhost';

let ch = null;

process.on('exit', (code) => {
    ch.close();
    console.log(`Closing rabbitmq channel`);
});

function toPlainObj(model){

    //JSON.stringify(model) returns a plain JSON as string

    if(model instanceof Array){
        return model.map( m => toPlainObj(m));
    } else {
        return model.get({ plain: true });
    }
}


router.get('/:id', async (req, res) => {
    const id = req.params.id;

    const rows = await Plant.findAll({ where: { id } });

    console.log('Plant with id:', toPlainObj(rows[0]));

    if (!rows[0]) {
        return res.status(404).send(PLANT_NOT_FOUND_RESPONSE);
    }

    res.send(rows[0]);
});

router.get('/:name', async (req, res) => {
    const name = req.params.name;

    const rows = await Plant.findAll({ where: { name } });

    console.log('Plant with id:', toPlainObj(rows[0]));

    if (!rows[0]) {
        return res.status(404).send(PLANT_NOT_FOUND_RESPONSE);
    }

    res.send(rows[0]);
});

router.post('/', async (req, res) => {

    await Plant.create({
        city: req.body.city, progress: 0, completed:false ,planning:null
    }).then(data => { res.send(data); // mostrar por pantalla "data" con 0%
    }).catch(err => {
        res.status(500).send({
            message:
                err.message || "Some error occurred while creating the Plant."
        });
    });

    console.log('Plant inserted');

    // llamada a planner
    amqp.connect(CONN_URL, async function (err, conn) {

        ch = await conn.createChannel();

        var msg = {"id:" : data.id +", city:" + req.body.city};

        setInterval(() => {

            const data = "Data " + msg;

            console.log("publishToQueue: '" + data + "'");

            ch.sendToQueue("eoloplantCreationProgressNotifications", Buffer.from(data));

        }, 1000);


    });

});

// mensaje recibido.
amqp.connect(CONN_URL, async function (err, conn) {

    let ch = await conn.createChannel();

    ch.consume('eoloplantCreationProgressNotifications', function (msg) {

            console.log("Message:", msg.content.toString());
            // enviar mensaje al client para actualizar info.
            server.send(msg);

        }, { noAck: true }
    );

    // TODO guardar estado en la bdd



});

router.delete('/:id', async (req, res) => {
    const id = req.params.id;

    await Plant.destroy({ where: { id } });

    console.log('Deleted plant with id:', id);

});

router.delete('/:name', async (req, res) => {
    const name = req.params.name;

    await Plant.destroy({ where: { name } });

    console.log('Deleted plant with name:', name);

});

module.exports = router;