const uuid = require('uuid');
const AWS = require('aws-sdk');

AWS.config.update({
    endpoint: "https://dynamodb.eu-west-1.amazonaws.com",
    region: "eu-west-1"
});

const docClient = new AWS.DynamoDB.DocumentClient();
const tableComments = 'comments';
const tableBooks = 'books';

// This is a DB simulation. Data should be managed with a real database inside functions.

const getAllBooks = () => {
    console.log("Dentro del getAllBooks")
    const params = {
        TableName: tableBooks
    };

    return docClient.scan(params).promise();
};


const getBook = (bookid) => {    
    const params = {
        TableName: tableBooks,        
        Key: {
            "bookid": bookid
        },        
    };

    const books = docClient.query(params).promise();
    return books.Items[0];    
};

const addBook = (data) => {
    
    const params = {
        TableName: tableBooks,
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


const updateBook = (data) => {
    const params = {
        TableName: tableBooks,
        Key: {
            "bookid": data.bookid
        },
        UpdateExpression: "set title = :t, summary = :s, author = :a, publisher = :e, publishYear = :p",
        ExpressionAttributeValues: {
            ":t": data.title,
            ":s": data.summary,
            ":a": data.author,
            ":e": data.publisher,
            ":p": data.publishYear
        },
        ReturnValues: "ALL_OLD" // Returns the item content before it was updated
    };

    return docClient.update(params).promise();
};

const deleteBook = (bookid) => {
    const params = {
        TableName: tableBooks,
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

const addCommentBook = (bookid, data) => {

    console.log(bookid);
    console.log(data);

    //create the comment    
    const paramsComment = {
        TableName: tableComments,
        Key: {
            "commentid": uuid.v1()
        },
        Item: {
            "comment": data.comment,
            "userNick": data.userNick,
            "score": data.score
        },
        ReturnValues: "ALL_NEW"
    }


    //add comment to book
    const commentCreated = docClient.update(paramsComment).promise();
    const paramsBook = {
        TableName: tableBooks,
        Key: {
            "bookid": data.bookid
        },
        UpdateExpression: "set comments = list_append(comments, :c)",
        ExpressionAttributeValues: {
            ":c": [{
                id: commentCreated.Attributes.commentid,
                userNick: data.userNick,
                comment: data.comment
            }]
        },
        ReturnValues: "ALL_NEW"

    };

    return docClient.update(paramsBook).promise();

}

const deleteCommentBook = (bookid) => {
    const params = {
        TableName: tableBooks
    };

    return docClient.scan(params).promise();
};

module.exports = {
    getAllBooks,
    getBook,
    addBook,    
    updateBook,
    deleteBook,
    addCommentBook,
    deleteCommentBook
      
};