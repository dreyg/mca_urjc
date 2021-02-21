const {
    httpPort,
    dbConnectionString,
} = require('./configuration');
const signals = require('./signals');
const db = require('./data/infrastructure/db')({ dbConnectionString });
const productsRepositoryContainer = require('./data/repositories/products');
const productsRepository = productsRepositoryContainer.init(db.schemas);

console.log("productsRepository");
console.log(productsRepository);

const productServiceContainer = require('./domain/product/service');
const appContainer = require('./router/http/app');

//console.log(appContainer);


const productService = productServiceContainer.init({
    productsRepository
});

const app = appContainer.init({
    productService,
});



//console.log(app);

let server;
server = app.listen(httpPort, () => {
    //logging.info(`Listening on *:${httpPort}`);
    console.log(`Listening on *:${httpPort}`);
});

const shutdown = signals.init(async () => {
    await db.close();
    await server.close();
});

(async () => {
    try {
        await db.connect();
    } catch (error) {
        await shutdown();
    }
})();

process.on('SIGINT', shutdown);
process.on('SIGTERM', shutdown);
