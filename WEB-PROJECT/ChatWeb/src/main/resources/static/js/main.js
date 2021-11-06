'use strict';
//var roomInput = $('#room-id');
//var testModel = $('#testModel');

var roomInput = document.querySelector('#room-id');
var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
//var roomIdDisplay = document.querySelector('#room-id-display');

var topic = null;
var roomId=null;
var stompClient = null;
var username = null;
var socketName = null;
var currentSubscription;

var colors = [
	'#2196F3', '#32c787', '#00BCD4', '#ff5652',
	'#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];
window.onload = function exampleFunction() {
	alert("starting... : " );
	roomId = roomInput.textContent;
	//if(roomId!=0)
		connect();
	// Function to be executed
}

function connect(event) {
	//alert(document.querySelector('#name').value.trim());
	username = document.querySelector('#name').textContent;

	if (!username) {
		username = "HoangSon";
	}
	alert("username 1: "+username);
	if (username) {
		//alert("username: "+ username);
		// usernamePage.classList.add('hidden');
		// chatPage.classList.remove('hidden');
		//var socketId = document.querySelector('#idSocket').textContent;


		var socket = new SockJS('/ws');

		stompClient = Stomp.over(socket);

		stompClient.connect({}, onConnected, onError);
	}
	event.preventDefault();
}
// Leave the current room and enter a new one.
function enterRoom(newRoomId) {
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
	alert("Enter room: "+roomId)
}

function onConnected() {
	if(roomId!=0)
		enterRoom(roomInput);

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

	var messageElement = document.createElement('li');
	if (message.sender == username)
		messageElement.classList.add('me');
	else messageElement.classList.add('u');

	if (message.type === 'JOIN') {
		messageElement.classList.add('event-message');
		message.content = message.sender + ' joined!';
	} else if (message.type === 'LEAVE') {
		messageElement.classList.add('event-message');
		message.content = message.sender + ' left!';
	} else {
		messageElement.classList.add('chat-message');

		//var avatarElement = document.createElement('i');
		//var avatarText = document.createTextNode(message.sender[0]);
		//avatarElement.appendChild(avatarText);
		//avatarElement.style['background-color'] = getAvatarColor(message.sender);

		//messageElement.appendChild(avatarElement);

		//var usernameElement = document.createElement('span');
		//var usernameText = document.createTextNode(message.sender);
		//usernameElement.appendChild(usernameText);
		//messageElement.appendChild(usernameElement);
	}

	var textElement = document.createElement('p');
	var messageText = document.createTextNode(message.content);
	textElement.appendChild(messageText);

	messageElement.appendChild(textElement);

	messageArea.appendChild(messageElement);
	messageArea.scrollTop = messageArea.scrollHeight;
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
