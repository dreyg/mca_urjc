const express = require('express');
const database = require('./database.js');
const booksRouter = require('./routes/bookRouter.js');
const usersRouter = require('./routes/userRouter.js');
const app = express();

var fs = require('fs');
var https = require('https');

//Convert json bodies to JavaScript object
app.use(express.json());
app.use('/books', booksRouter);
app.use('/users', usersRouter);

async function main() {

    await database.connect();

    https.createServer({
        key: fs.readFileSync('server.key'),
        cert: fs.readFileSync('server.cert')
        }, app).listen(3443, () => {
        console.log("Https server started in port 3443");
        });

    process.on('SIGINT', () => {
        database.disconnect();
        console.log('Process terminated');
        process.exit(0);
    });
}

main();