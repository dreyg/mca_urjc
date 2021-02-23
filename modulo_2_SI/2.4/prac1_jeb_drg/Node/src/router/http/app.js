const http = require('http');
const express = require('express');
const listEndpoints = require('express-list-endpoints')

const app = express();
const productsRoutes = require('./routes/products/routes');

module.exports.init = (services) => {
    app.use('/api', productsRoutes.init(services));

    const httpServer = http.createServer(app);

    return httpServer;
};

