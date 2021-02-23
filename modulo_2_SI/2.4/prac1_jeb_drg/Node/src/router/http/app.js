const http = require('http');
const express = require('express');
const listEndpoints = require('express-list-endpoints')

const app = express();
const productsRoutes = require('./routes/products/routes');
const shoppingCartRoutes = require('./routes/shoppingCart/routes');

module.exports.init = (services) => {
    app.use('/api', productsRoutes.init(services));
    app.use('/api', shoppingCartRoutes.init(services));

    const httpServer = http.createServer(app);

    return httpServer;
};

