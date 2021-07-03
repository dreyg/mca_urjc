'use strict';

// dbManager file will have DynamoDB functionality in further changes. For now, it just uses mocked data to test a REST Api
const dbManager = require('dbManagerUser');

exports.getUserHandler = (event, context, callback) => {
    getUser(event.pathParameters.userid,callback);    
};

const getUser = (userid, callback) => {
    console.log("Dentro de getUser");
    console.log(userid);    
    
    dbManager.getUser(userid)
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