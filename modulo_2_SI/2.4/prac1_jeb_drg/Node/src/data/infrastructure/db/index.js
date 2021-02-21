
const mongoose = require('mongoose');
const schemasFactory = require('./schemas');
//const logging = require('../../../common/logging');
mongoose.Promise = require('bluebird');

module.exports = ({ dbConnectionString }) => {

    console.log("testdbConnectionString");
    console.log(dbConnectionString);

    if (!dbConnectionString) {
        throw new Error('add correct format of config with dbConnectionString');
    }


    const options = {
        promiseLibrary: require('bluebird'),
    };


    // Check for errors on connecting to Mongo DB
    mongoose.connection.on('error', (err) => {
        //logging.error(`Error! DB Connection failed. Error: ${err}`);
        return err;
    });


    // Connection opened successfully
    mongoose.connection.once('open', () => {
        //logging.info('Connection to MongoDB established');
        // mongoose.connection.db.dropDatabase()
        console.log("Connection to MongoDB established");
    });

    mongoose.connection.on('disconnected', () => {
        //logging.info('Connection to MongoDB closed');
        //logging.info('-------------------');
    });

    const schemas = schemasFactory.create(mongoose);

    return Object.assign(
        {
            getConnection() {
                return mongoose.connection;
            },

            connect() {
                // Open Connection to Mongo DB
                return mongoose.connect(dbConnectionString, options);
            },
            close() {
                return mongoose.connection.close();
            },
        },
        {
            schemas,
        },
    );
};
