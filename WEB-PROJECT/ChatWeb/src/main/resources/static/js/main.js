'use strict';

//var roomInput = $('#room-id');
//var testModel = $('#testModel');
//var connect_btn = document.querySelector('#connect_btn');

var contextPath = 'http://localhost:8080';
var btnSendInvite = document.querySelector('#btnSendInvite');
var formSubmitImage = document.querySelector('#form-file-id');
var inputImage = document.querySelector('#file-id');
var friendArea = document.querySelector('#FriendArea');
//var searchButton = document.querySelector('#searchButton');
var PhoneNeedInvite = document.querySelector('#PhoneNeedInvite');
var roomInput = document.querySelector('#room-id');
var hoat_dong = document.querySelector('#hoat-dong');
var usernamePage = document.querySelector('#username-page');
var chatPage = document.querySelector('#chat-page');
var usernameForm = document.querySelector('#usernameForm');
var messageForm = document.querySelector('#messageForm');
var messageInput = document.querySelector('#message');
var messageArea = document.querySelector('#messageArea');
var connectingElement = document.querySelector('.connecting');
var randomValue = document.querySelector('#randomValue');
var friendId = document.querySelector('#friendId');
//var roomIdDisplay = document.querySelector('#room-id-display');

var topic = null;
var urlImage = null;
var fileExtension = null;
var roomId = null;
var stompClient = null;
var stompClientMain = null;
var username = null;
var idAccount = null;
var fileName = null;
var socketName = null;
var currentSubscription;
var currentSubscriptionMain;


var colors = [
	'#2196F3', '#32c787', '#00BCD4', '#ff5652',
	'#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];


window.onload = function exampleFunction() {
	//alert("starting... userName : ");
	//roomId = roomInput.textContent;
	//if(roomId!=0)
	//if(roomInput.textContent!=0)
	messageArea.scrollTop = messageArea.scrollHeight;
	connect();
	// Function to be executed
}

function connect(event) {
	roomId = roomInput.textContent;
	username = document.querySelector('#name').textContent;
	idAccount = document.querySelector('#idAccount').textContent;
	if (username) {

		var socket = new SockJS('/ws');
		//var socketMain = new SockJS('/ws');
		stompClient = Stomp.over(socket);
		//stompClientMain = Stomp.over(socketMain);
		//stompClientMain.connect({}, onConnectedMain, onError);
		stompClient.connect({}, onConnected, onError);

	}
	event.preventDefault();
}
// Leave the current room and enter a new one.
function enterRoom(newRoomId, stompClient) {
	var roomId = newRoomId;
	//alert("room-id: "+roomId)
	topic = `/app/chat/${newRoomId}`;

	if (currentSubscription) {
		currentSubscription.unsubscribe();
	}
/*	if (currentSubscriptionMain) {
		currentSubscriptionMain.unsubscribe();
	}*/
//	if(roomId==0)
//		currentSubscriptionMain = stompClientMain.subscribe(`/topic/${roomId}`, onMessageReceivedMain);
	currentSubscription = stompClient.subscribe(`/topic/${roomId}`, onMessageReceived);
	stompClient.send(`${topic}/addUser`,
		{},
		JSON.stringify({ idSender: idAccount, sender: username, type: 'JOIN' })
	);
}
function onConnectedMain() {
	enterRoom(0, stompClientMain);
	connectingElement.classList.add('hidden');
}
function onConnected() {
	enterRoom(roomInput.textContent, stompClient);
	connectingElement.classList.add('hidden');
}


function onError(error) {
	connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
	connectingElement.style.color = 'red';
}

function sendImage(event) {
	//alert("func sendMessage!!!");
	var messageContent = urlImage;
	//alert(fileExtension);
	var content_type = null;
	if (fileExtension == 'jpg' || fileExtension == 'png' || fileExtension == 'jpeg')
		content_type = 'IMAGE';
	else if (fileExtension == 'mp4')
		content_type = 'VIDEO';
	else content_type = 'FILE';

	if (messageContent && stompClient) {
		var chatMessage = {
			idSender: idAccount,
			sender: username,
			contentType: content_type,
			content: messageContent,
			type: 'CHAT',
			roomId: roomId
		};
		//stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
		stompClient.send(`${topic}/sendMessage`, {}, JSON.stringify(chatMessage));

	}

}
function sendMessage(event) {
	//alert("func sendMessage!!!");
	var messageContent = messageInput.value.trim();
	if (messageContent && stompClient) {
		var chatMessage = {
			idSender: idAccount,
			sender: username,
			contentType: 'TEXT',
			content: messageInput.value,
			type: 'CHAT',
			roomId: roomId
		};
		//stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(chatMessage));
		stompClient.send(`${topic}/sendMessage`, {}, JSON.stringify(chatMessage));
		messageInput.value = '';
	}
	event.preventDefault();
}
function sendInvite(event) {
    //alert("Đã gửi lời mời kết bạn thành công !!!");
	//alert("telReceiver: 0");
	var messageContent = PhoneNeedInvite.value.trim();
	//alert("telReceiver: 1");
	if (messageContent && stompClient) {
		//alert("telReceiver: 2");
		//alert("messageContent: "+messageContent);
		var inviteMessage = {
			idSender: idAccount,
			sender: username,
			content: "Lời mời kết bạn!!!",
			type: 'INVITE',
			telReceiver: messageContent
		};
		//alert("telReceiver: "+chatMessage.telReceiver);
		stompClient.send(`${topic}/sendInvite`, {}, JSON.stringify(inviteMessage));
		messageInput.value = '';
		//alert("telReceiver: 3");
	}
	event.preventDefault();
	//alert("step finish!!!");
}
/*function onMessageReceivedMain(payload) {
//	alert("mark onmessagereceivedmain");
	var message = JSON.parse(payload.body);
	if (message.type === 'INVITE' && idAccount == message.idReceiver ) {

		var div3Element = document.createElement('div');
		var h3Element = document.createElement('h3');
		
		h3Element.textContent = message.sender;
		var pElement = document.createElement('p');
		
		var spanElement = document.createElement('span');
	
		spanElement.textContent = message.content;
		
		var buttonElement = document.createElement('button');
		
		buttonElement.classList.add('button');
		buttonElement.classList.add('button1');
		
		buttonElement.textContent = "Chấp nhận";
		
		var aElement = document.createElement('a');
		
		aElement.href = contextPath + '/accept/' + message.idSender;
		aElement.appendChild(buttonElement);
		var button2Element = document.createElement('button');
		button2Element.classList.add('button');
		button2Element.classList.add('button3');
		button2Element.textContent = "Từ chối";
		
		pElement.appendChild(spanElement);
		pElement.appendChild(aElement);
		pElement.appendChild(button2Element);
		div3Element.appendChild(h3Element);
		div3Element.appendChild(pElement);
		
		var divElement = document.createElement('div');
		divElement.classList.add('friend');
		//divElement.appendChild(imgElement);
		divElement.appendChild(div3Element);
		friendArea.appendChild(divElement);
	}
}*/

function onMessageReceived(payload) {
	var message = JSON.parse(payload.body);
	//alert("mark onmessagereceived");
	if (message.type === 'JOIN' && message.idSender != idAccount) {
		hoat_dong.textContent = "Vừa mới hoạt động";
		//messageElement.classList.add('event-message');
		//message.content = message.sender + ' joined!';
	} else if (message.type === 'LEAVE' && message.idSender != idAccount) {
		hoat_dong.textContent = "Hoạt động ít phút trước";
		//messageElement.classList.add('event-message');
		//message.content = message.sender + ' left!';
	} else if (message.type === 'CHAT') {
	//	alert("ID sender: "+message.idSender+" /ID Account:"+idAccount);
		var messageElement = document.createElement('li');
		if (message.idSender == idAccount)
			messageElement.classList.add('me');
		else messageElement.classList.add('u');
		messageElement.classList.add('chat-message');

		if (message.contentType == 'TEXT') {
			var textElement = document.createElement('p');
			var messageText = document.createTextNode(message.content);
			textElement.appendChild(messageText);
			messageElement.appendChild(textElement);
		}
		if (message.contentType == 'IMAGE') {
			var imgElement = document.createElement('img');
			imgElement.src = message.content;
			imgElement.width = 200;
			imgElement.height = 200;
			messageElement.appendChild(imgElement);
		}
		if (message.contentType == 'FILE') {
			var imgElement = document.createElement('img');
			imgElement.src = contextPath + '/image/file-image.jpg';
			imgElement.width = 200;
			imgElement.height = 200;
			// <a href="#">fileabc.xlsx</a>
			var aElement = document.createElement('a');
			aElement.href = message.content;
			var messageText = document.createTextNode(message.fileName);
			aElement.appendChild(messageText);
			var brElement = document.createElement('br');
			messageElement.appendChild(imgElement);
			messageElement.appendChild(brElement);
			messageElement.appendChild(aElement);
		}
		if (message.contentType == 'VIDEO') {

			//<video width="320" height="240" controls>
			//       <source src="video-test.mp4" type="video/mp4">
			//    </video><br>
			//     <a href="#">fileabc.xlsx</a>
			var videoElement = document.createElement('video');
			
			videoElement.width = 320;
			videoElement.height = 240;
			videoElement.controls = true;
			
			var sourceElement = document.createElement('source');
			sourceElement.src = message.content;
			sourceElement.type='video/mp4';
			
			videoElement.appendChild(sourceElement);
			
			// <a href="#">fileabc.xlsx</a>
			var aElement = document.createElement('a');
			aElement.href = message.content;
			var messageText = document.createTextNode(message.fileName);
			aElement.appendChild(messageText);
			var brElement = document.createElement('br');
			messageElement.appendChild(videoElement);
			messageElement.appendChild(brElement);
			messageElement.appendChild(aElement);
		}
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

function changeImage(event) {
	fileName = inputImage.files[0].name;

	// Regular expression for file extension.
	fileExtension = fileName.split('.').pop();
	var randomName = new Date().valueOf()+"_"+fileName;
	urlImage = contextPath + '/file/download/' + randomName;
    randomValue.value = randomName;
	document.getElementById('form-file-id').submit();
	sendImage();
	event.preventDefault();
	var frdId = friendId.value;
	window.location.href = contextPath+"/dual/withFriend/"+frdId;
}
btnSendInvite.onclick = function(event){
	//event.preventDefault();
	sendInvite();
	//document.querySelector('#kb_area').remove();
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
