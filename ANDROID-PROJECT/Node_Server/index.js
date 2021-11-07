var express = require("express");
var app = express();
var server = require("http").createServer(app);
var io = require("socket.io").listen(server);

var fs = require("fs");
server.listen(process.env.PORT || 3000);

io.sockets.on('connection', function(socket){
    console.log('Connected');
})