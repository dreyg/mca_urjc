const uuid = require('uuid');
const AWS = require('aws-sdk');

AWS.config.update({
    endpoint: "https://dynamodb.eu-west-1.amazonaws.com",
    region: "eu-west-1"
});

const docClient = new AWS.DynamoDB.DocumentClient();
const table = 'comments';


const addCommentBook = (bookid,data) => {

    console.log(bookid);
    console.log(data);
    
    //añado el comentario al libro    
    const params = {
        TableName: table,
        Item: {    
            "commentid":uuid.v1(),
            ":bookid":bookid,
            ":commentsid":{                
                "comment":data.comment,
                "user":{
                    "userNick": data.userNick,
                },
                "score": data.score  
            },          
        }
    }
    console.log("Realizo el put");
    return docClient.put(params).promise();
};



const deleteCommentBook = (bookid) => {
    const params = {
        TableName: table
    };

    return docClient.scan(params).promise();
};

module.exports = {
    addCommentBook,
    deleteCommentBook
};