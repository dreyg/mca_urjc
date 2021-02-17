let socket = new WebSocket("ws://localhost:8080/");

socket.onopen = function (e) {
    console.log("WebSocket connection established");
};

socket.onmessage = function (event) {
    console.log(`[message] Data received from server: ${event.data}`);
};

socket.onclose = function (event) {
    if (event.wasClean) {
        console.log(`[close] Connection closed cleanly, code=${event.code} reason=${event.reason}`);
    } else {
        console.log('[close] Connection died');
    }
};

socket.onerror = function (error) {
    console.log(`[error] ${error.message}`);
};

const userAction = async () => {
    const response = await fetch('http://localhost:3000/api/eoloplants/', {
        method: 'POST',
        body: JSON.stringify({
            city: "Madrid"
        }),
        headers: {
            'Content-Type': 'application/json'
        }
    });
    const myJson = await response.json(); //extract JSON from the http response
    console.log(myJson);
}

function sendMessage() {

    socket.send("Hola mundo webSocket!");
    console.log("WebSocket message sent");
}