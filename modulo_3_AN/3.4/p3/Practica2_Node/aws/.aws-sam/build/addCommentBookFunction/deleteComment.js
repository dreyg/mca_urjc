'use strict';

// dbManager file will have DynamoDB functionality in further changes. For now, it just uses mocked data to test a REST Api
const dbManager = require('commentsDbManager');

exports.deleteCommentHandler = (event, context, callback) => {
    deleteComment(event.pathParameters.commentid, callback);
};

const deleteComment = (commentid, callback) => {
    dbManager.deleteComment(commentid)
        .then((res) => {
            sendResponse(200, res, callback);
        })
        .catch((err) => {
            console.log(err);
            sendResponse(500, err, callback);
        });
};

const sendResponse = (statusCode, message, callback) => {
    const res = {
        statusCode: statusCode,
        body: JSON.stringify(message)
    };
    callback(null, res);
};