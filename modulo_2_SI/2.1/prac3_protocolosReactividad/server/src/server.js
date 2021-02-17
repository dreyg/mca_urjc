const express = require('express');
const database = require('./database.js');
const plantsRouter = require('./routes/plantRouter.js');
const WebSocket = require('ws');
const app = express();

const wss = new WebSocket.Server({ port: 8080 });

//Convert json bodies to JavaScript object
app.use(express.json());
app.use('/api/eoloplants', plantsRouter);


async function main() {

    await database.connect();

    app.listen(3000, () => {
        console.log('Server listening on port 3000!');
    });

    wss.on('connection', function connection(ws, req) {

        console.log('User connected');

        ws.on('message', function (msg) {
            console.log('Message received:' + msg);
        });

    });



    process.on('SIGINT', () => {
        database.disconnect();
        console.log('Process terminated');
        process.exit(0);
    });
}

main();