const express = require('express');
const router = express.Router();


function init({productsService}) {

    console.log("testproductsServiceRouter");
    console.log(productsService);

    router.post('/api/product/', async (req, res) => {

        console.log("Dentro de post");
        const newProduct = await productsService.createProduct({
            id: req.body.id,
            name: req.body.name,
            description: req.body.description,
        });
        return res.send({
            data: newProduct,
        });
    });

    router.get('/:productId', async (req, res) => {
        const ProductDoc = await productsService.findProductById({
            postId: req.params.postId,
        });
        return res.send({
            data: ProductDoc,
        });
    });

    return router;
}


module.exports.init = init;
