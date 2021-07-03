'use strict';

// dbManager file will have DynamoDB functionality in further changes. For now, it just uses mocked data to test a REST Api
const dbManager = require('dbManagerUser');

exports.getCommentUserHandler = (event, context, callback) => {
    getCommentsUser(event.pathParameters.userid, event.body, callback);
};

const getCommentsUser = (userid, data, callback) => {
    data = JSON.parse(data);
    data.userid = userid;

    dbManager.getUser(data)
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