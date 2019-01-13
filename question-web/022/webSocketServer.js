/**
 * @user chenxihong
 * @date 2018/3/11 9:41
 * @desc
 */

var app = require('express')();
var server = require('http').Server(app);
var webSocket = require('ws');

var webSocketServer = new WebSocket.Server({ port: 8080 });

webSocketServer.on('connection', function connection(ws) {
    console.log('server: receive connection.');
    ws.on('message', function(message) {
        console.log('server: receive message ' + message);
    });
    ws.send('result');
});

app.get('/', function(request, response) {
    response.sendfile(__dirname + '/index.html');
});

app.listen(3000);
