'use strict';

// dbManager file will have DynamoDB functionality in further changes. For now, it just uses mocked data to test a REST Api
const dbManager = require('dbManagerBook');

exports.deleteBookHandler = (event, context, callback) => {
    deleteBook(event.pathParameters.bookid, callback);
};

const deleteBook = (bookid, callback) => {
    dbManager.deleteBook(bookid)
    .then((res) => {
        sendResponse(200, res, callback);
    })
    .catch((err) => {
        console.log(err);
        sendResponse(200, err, callback);
    });
};

const sendResponse = (statusCode, message, callback) => {
    const res = {
        statusCode: statusCode,
        body: JSON.stringify(message)
    };
    callback(null, res);
};