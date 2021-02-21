const http = require('http');
const express = require('express');

const app = express();
const productsRoutes = require('./routes/products/routes');

module.exports.init = (services) => {
    app.use('/products', productsRoutes.init(services));

    //console.log(app);

    const httpServer = http.createServer(app);
    return httpServer;
};

