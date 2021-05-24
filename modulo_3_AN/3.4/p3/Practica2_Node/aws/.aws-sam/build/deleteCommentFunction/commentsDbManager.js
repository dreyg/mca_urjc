const uuid = require('uuid');
const AWS = require('aws-sdk');

AWS.config.update({
    endpoint: "https://dynamodb.eu-west-1.amazonaws.com",
    region: "eu-west-1"
});

const docClient = new AWS.DynamoDB.DocumentClient();
const table = 'comments';

// This is a DB simulation. Data should be managed with a real database inside functions.

const getAllComments = () => {
    const params = {
        TableName: table
    };

    return docClient.scan(params).promise();
};

const addComment = (data) => {
    const params = {
        TableName: table,
        Item: {
            "commentid": uuid.v1(),
            "comment": data.comment,
            "userNick": data.userNick,
            "score": data.score
        }
    };

    return docClient.put(params).promise();
};

const updateComment = (data) => {
    const params = {
        TableName: table,
        Key: {
            "commentid": data.commentid
        },
        UpdateExpression: "set #te = :t, userNick = :n, score = :s",
        ExpressionAttributeNames: { // Used when there are reserved words in DynamoDB, like name
            "#te": 'comment'
        },
        ExpressionAttributeValues: {
            ":t": data.comment,
            ":n": data.userNick,
            ":s": data.score
        },
        ReturnValues: "ALL_OLD" // Returns the item content before it was updated
    };

    return docClient.update(params).promise();
};

const deleteComment = (commentid) => {
    const params = {
        TableName: table,
        Key: {
            "commentid": commentid
        },
        ConditionExpression: "commentid = :commentid",
        ExpressionAttributeValues: {
            ":commentid": commentid
        },
        ReturnValues: "ALL_OLD" // Returns the item content before it was deleted
    };

    return docClient.delete(params).promise();
};

module.exports = {
    getAllComments,
    addComment,
    updateComment,
    deleteComment
};