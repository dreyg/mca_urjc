const app = require('../src/app');
const supertest = require('supertest');
const { GenericContainer } = require("testcontainers");

const request = supertest(app)

let amazonDynamodb;

beforeAll(async () => {
    amazonDynamodb = await new GenericContainer("amazon/dynamodb-local","1.13.6")
        .withExposedPorts(8000)
        .start();

    AWS.config.update({
        region: process.env.AWS_REGION || 'local',
        endpoint: 'http://localhost:'+amazonDynamodb.getMappedPort(8000),
        accessKeyId: "xxxxxx", // No es necesario poner nada aquí
        secretAccessKey: "xxxxxx" // No es necesario poner nada aquí
    });

    await createTableIfNotExist("films");
});

afterAll(async () => {
    //await amazonDynamodb.connection.close();
    //await amazonDynamodb.stop();
});

test('Create new ad', async () => {

    let film = {
        id:"",
        film:"El mundo es nuestro",
        director:"Alberto Sanchez"
    }

    const response = await request.post('/api/films/')
        .send(film)
        .expect('Content-type', /json/)
        .expect(201)

    expect(response.body.director).toBe("Alberto Sanchez")
})