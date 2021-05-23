const uuid = require('uuid');
const AWS = require('aws-sdk');

AWS.config.update({
    endpoint: "https://dynamodb.eu-west-1.amazonaws.com",
    region: "eu-west-1"
});

const docClient = new AWS.DynamoDB.DocumentClient();
const table = 'users';

// This is a DB simulation. Data should be managed with a real database inside functions.

const getAllUsers = () => {
    const params = {
        TableName: table
    };

    return docClient.scan(params).promise();
};


const getUser = (userid) => {

    console.log("Dentro de dbManager, vamos a ver que tiene el data");
    console.log(userid);
    const params = {
        TableName: table,        
        Key: {
            "userid": userid
        },        
    };

    return docClient.scan(params).promise();
};

const addUser = (data) => {
    console.log(data);
    const params = {
        TableName: table,
        Item: {
            "userid": uuid.v1(),
            "nick": data.nick,
            "email": data.email            
        }
    };

    return docClient.put(params).promise();
};

const updateUser = (data) => {
    console.log(data);
    const params = {
        TableName: table,
        Key: {
            "userid": data.userid
        },
        UpdateExpression: "set email = :e",
        
        ExpressionAttributeValues: {            
            ":e": data.email            
        },
        ReturnValues: "ALL_OLD" // Returns the item content before it was updated
    };

    return docClient.update(params).promise();
};





const deleteUser = (userid) => {
    const params = {
        TableName: table,
        Key: {
            "userid": userid
        },
        ConditionExpression: "userid = :userid",
        ExpressionAttributeValues: {
            ":userid": userid
        },
        ReturnValues: "ALL_OLD" // Returns the item content before it was deleted
    };

    return docClient.delete(params).promise();
};

module.exports = {
    getAllUsers,
    getUser,
    addUser,
    updateUser,
    deleteUser    
};