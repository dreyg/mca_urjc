const grpc = require('grpc');
const WeatherService = require('./interface');

var client = new WeatherService('localhost:9090', grpc.credentials.createInsecure());

client.getWeather({city: 'Madrid'}, (error, response) => {

    if(error){
        return console.error(error);
    } else {
        console.log("Response: "+JSON.stringify(response));
    }

});