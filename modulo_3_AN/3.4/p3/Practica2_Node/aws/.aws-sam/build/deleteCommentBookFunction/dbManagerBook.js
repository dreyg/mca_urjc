const uuid = require('uuid');
const AWS = require('aws-sdk');

AWS.config.update({
    endpoint: "https://dynamodb.eu-west-1.amazonaws.com",
    region: "eu-west-1"
});

const docClient = new AWS.DynamoDB.DocumentClient();
const table = 'books';

// This is a DB simulation. Data should be managed with a real database inside functions.

const getAllBooks = () => {
    const params = {
        TableName: table
    };

    return docClient.scan(params).promise();
};


const getBook = (bookid) => {    
    const params = {
        TableName: table,        
        Key: {
            "bookid": bookid
        },        
    };

    return docClient.scan(params).promise();
};

const addBook = (data) => {
    
    const params = {
        TableName: table,
        Item: {
            "bookid": uuid.v1(),
            "author": data.author,
            "title": data.title,
            "summary": data.summary,
            "publisher": data.publisher,
            "publicationYear": data.publicationYear,
               
        }
    };

    return docClient.put(params).promise();
};


const deleteBook = (bookid) => {
    const params = {
        TableName: table,
        Key: {
            "bookid": bookid
        },
        ConditionExpression: "bookid = :bookid",
        ExpressionAttributeValues: {
            ":bookid": bookid
        },
        ReturnValues: "ALL_OLD" // Returns the item content before it was deleted
    };

    return docClient.delete(params).promise();
};

const addCommentBook = (bookid) => {
    const params = {
        TableName: table
    };

    return docClient.scan(params).promise();
};

const deleteCommentBook = (bookid) => {
    const params = {
        TableName: table
    };

    return docClient.scan(params).promise();
};

module.exports = {
    getAllBooks,
    getBook,
    addBook,    
    deleteBook,
    addCommentBook,
    deleteCommentBook    
};