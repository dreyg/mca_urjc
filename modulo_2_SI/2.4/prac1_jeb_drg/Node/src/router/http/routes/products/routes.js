const express = require('express');
const router = express.Router();
var bodyParser = require('body-parser')

// create application/json parser
var jsonParser = bodyParser.json()


function init({
                  productService,
              }) {

    router.post('/product/',  jsonParser, async (req, res) => {

        console.log(req.body);


        const newProduct = await productService.createProduct({
            id: req.body.id,
            name: req.body.name,
            description: req.body.description,
        });
        return res.send({
            data: newProduct,
        });
    });

    router.get('/products/:productId', async (req, res) => {

        console.log(req.params);
        const ProductDoc = await productService.findProductById({
            productId: req.params.productId,
        });
        return res.send({
            data: ProductDoc,
        });
    });

    router.get('/products/', async (req, res) => {


        const ProductDoc = await productService.findAllProducts({
        });
        return res.send({
            data: ProductDoc,
        });
    });

    router.delete('/products/:productId', async (req, res) => {

        const ProductDoc = await productService.deleteProductById({
            productId: req.params.productId,
        });
        return res.send({
            data: ProductDoc,
        });
    });

    return router;
}


module.exports.init = init;
