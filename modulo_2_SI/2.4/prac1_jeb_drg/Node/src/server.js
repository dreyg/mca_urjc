const {
    httpPort,
    dbConnectionString,
} = require('./configuration');
const signals = require('./signals');
const db = require('./data/infrastructure/db')({ dbConnectionString });
console.log("db");
console.log(db);

const productsRepositoryContainer = require('./data/repositories/products');
const shoppingCartRepositoryContainer = require('./data/repositories/shoppingCarts');

const productsRepository = productsRepositoryContainer.init(db.schemas);
const shoppingCartRepository = shoppingCartRepositoryContainer.init(db.schemas);

const productServiceContainer = require('./domain/product/service');
const shoppingCartServiceContainer = require('./domain/shoppingCart/service');

const appContainer = require('./router/http/app');

const productService = productServiceContainer.init({
    productsRepository,
});

const shoppingCartService = shoppingCartServiceContainer.init({
    shoppingCartRepository,
});

const app = appContainer.init({
    productService,
    shoppingCartService,
});

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

