'use strict';

//var roomInput = $('#room-id');
//var testModel = $('#testModel');
//var connect_btn = document.querySelector('#connect_btn');
var roomInput = document.querySelector('#room-id');
var hoat_dong = document.querySelector('#hoat-dong');
var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
//var roomIdDisplay = document.querySelector('#room-id-display');

var topic = null;
var roomId = null;
var stompClient = null;
var username = null;
var socketName = null;
var currentSubscription;

var colors = [
	'#2196F3', '#32c787', '#00BCD4', '#ff5652',
	'#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];


window.onload = function exampleFunction() {
	//alert("starting... : ");
	//roomId = roomInput.textContent;
	//if(roomId!=0)
	//if(roomInput.textContent==1)
	connect();
	// Function to be executed
}

function connect(event) {
	//alert(document.querySelector('#name').value.trim());
	username = document.querySelector('#name').textContent;

	if (!username) {
		username = "HoangSon";
	}
	//alert("username 1: " + username);
	if (username) {
		//alert("username: "+ username);
		//alert("conect 1 ");
		// usernamePage.classList.add('hidden');
		// chatPage.classList.remove('hidden');
		//var socketId = document.querySelector('#idSocket').textContent;


		var socket = new SockJS('/ws');
		//alert("conect 2 ");
		stompClient = Stomp.over(socket);
		//alert("conect 3 ");
		stompClient.connect({}, onConnected, onError);
	}
	//alert("conect 4 ");
	event.preventDefault();
}
// Leave the current room and enter a new one.
function enterRoom(newRoomId) {
	//alert("Enter room: Start");
	roomId = newRoomId;
	//Cookies.set('roomId', roomId);
	//roomIdDisplay.textContent = roomId;
	topic = `/app/chat/${newRoomId}`;

	if (currentSubscription) {
		currentSubscription.unsubscribe();
	}
	currentSubscription = stompClient.subscribe(`/topic/${roomId}`, onMessageReceived);

	stompClient.send(`${topic}/addUser`,
		{},
		JSON.stringify({ sender: username, type: 'JOIN' })
	);
	//alert("Enter room: " + roomId)
}

function onConnected() {
	//alert("onConnected");
	enterRoom(roomInput.textContent);

	connectingElement.classList.add('hidden');

}


function onError(error) {
	connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
	connectingElement.style.color = 'red';
}


function sendMessage(event) {
	//alert("func sendMessage!!!");
	var messageContent = messageInput.value.trim();
	if (messageContent && stompClient) {
		var chatMessage = {
			sender: username,
			content: messageInput.value,
			type: 'CHAT'
		};
		//stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
		stompClient.send(`${topic}/sendMessage`, {}, JSON.stringify(chatMessage));
		messageInput.value = '';
	}
	event.preventDefault();
}


function onMessageReceived(payload) {
	var message = JSON.parse(payload.body);



	if (message.type === 'JOIN' && message.sender != username) {
		hoat_dong.textContent = "Vừa mới hoạt động";
		//messageElement.classList.add('event-message');
		//message.content = message.sender + ' joined!';
	} else if (message.type === 'LEAVE' && message.sender != username) {
		hoat_dong.textContent = "Hoạt động ít phút trước";
		//messageElement.classList.add('event-message');
		//message.content = message.sender + ' left!';
	} else if (message.type === 'CHAT') {

		var messageElement = document.createElement('li');
		if (message.sender == username)
			messageElement.classList.add('me');
		else messageElement.classList.add('u');
		messageElement.classList.add('chat-message');

		var textElement = document.createElement('p');
		var messageText = document.createTextNode(message.content);
		textElement.appendChild(messageText);

		messageElement.appendChild(textElement);

		messageArea.appendChild(messageElement);
		messageArea.scrollTop = messageArea.scrollHeight;
	}

}


function getAvatarColor(messageSender) {
	var hash = 0;
	for (var i = 0; i < messageSender.length; i++) {
		hash = 31 * hash + messageSender.charCodeAt(i);
	}
	var index = Math.abs(hash % colors.length);
	return colors[index];
}
messageForm.onclick = function(event) {
	//alert("Message Click Send");
	event.preventDefault();
	sendMessage();
}
$(document).ready(function() {

	//if(roomInput.textContent!="")
	//	connect();
	/*  var savedName = Cookies.get('name');
	  if (savedName) {
		nameInput.val(savedName);
	  }
	
	  var savedRoom = Cookies.get('roomId');
	  if (savedRoom) {
		roomInput.val(savedRoom);
	  }*/

	//usernamePage.classList.remove('hidden');
	usernameForm.addEventListener('submit', connect, true);
	messageForm.addEventListener('submit', sendMessage, true);

});
