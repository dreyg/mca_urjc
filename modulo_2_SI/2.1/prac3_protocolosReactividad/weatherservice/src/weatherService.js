function getWeather(call, callback){

    console.log('Request received: '+JSON.stringify(call));

    var { city } = call.request;
    var weather = "sunny";
    callback(null, { city: city + " " + weather});
}

exports.getWeather = getWeather;