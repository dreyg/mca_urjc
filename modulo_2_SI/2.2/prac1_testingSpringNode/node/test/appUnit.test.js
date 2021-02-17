const app = require('../src/app')
const supertest = require('supertest')
const AWS = require('aws-sdk');

jest.mock('aws-sdk');


let film = {
    id:"",
    film:"El mundo es nuestro",
    director:"Alberto Sanchez"
}

function setDocumentClient(mockedImplementation){
    AWS.DynamoDB.DocumentClient.mockImplementation(() => mockedImplementation);
}

describe("test films", ()=>{



test('Get new film', async () => {

    const documentClient = {
        scan:(_, cb) => cb(null, film)
    }

    setDocumentClient(documentClient)

    const response = await request.get('/api/films/')
        .expect(200)

})

test('Create new film', async () => {

    const documentClient = {
        put:(params, cb) => cb(null, film)
    }

    setDocumentClient(documentClient)

    const response = await supertest(app).post('/api/films/')
        .expect(201)

    //expect(response.body.director).toBe("Alberto Sanchez")


})

})