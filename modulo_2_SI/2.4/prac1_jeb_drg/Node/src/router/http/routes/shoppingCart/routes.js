const express = require('express');
const router = express.Router();
var bodyParser = require('body-parser')

// create application/json parser
var jsonParser = bodyParser.json()


function init({
                  shoppingCartService,
              }) {

    router.post('/shoppingcarts/',  jsonParser, async (req, res) => {

        console.log(req.body);


        const newShoppingCart = await shoppingCartService.createShoppingCart({
            status: req.body.status,
        });
        return res.send({
            data: newShoppingCart,
        });
    });

    router.patch('/updateShoppingCart/:id', async (req, res) => {
        //implements updateShoppingCart

    });

    router.get('/shoppingcarts/:id', async (req, res) => {
        //implements findShoppingCartById

    });

    router.delete('/shoppingcarts/:id', async (req, res) => {
        //implements deleteShoppingCart

    });

    router.post('/shoppingcarts/:id', async (req, res) => {
        //implements addProductToShoppingCart

    });



    router.post('/products/:cart_id/product/:prod_id/quantity/:prod_quantity', async (req, res) => {
        //implements deleteProductFromShoppingCart

    });

    return router;
}


module.exports.init = init;
