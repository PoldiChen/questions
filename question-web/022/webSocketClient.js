/**
 * @user chenxihong
 * @date 2018/3/11 9:49
 * @desc
 */

var webSocket = new WebSocket('ws://localhost:8080');

webSocket.onpen = function() {
    console.log('client: open');
    webSocket.send('params');
};

webSocket.onmessage = function(event) {
    console.log('client: receive message ' + event.data);
};

webSocket.onclose = function(event) {
    console.log('client: closed');
};
