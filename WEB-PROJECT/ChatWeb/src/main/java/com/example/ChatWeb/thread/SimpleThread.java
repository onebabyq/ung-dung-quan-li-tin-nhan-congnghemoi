package com.example.ChatWeb.thread;

import com.example.ChatWeb.dto.UserDTO;
import com.example.ChatWeb.model.ChatMessage;
import com.example.ChatWeb.service.MessageService;
import com.example.ChatWeb.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.client.RestTemplate;

public class SimpleThread implements Runnable {
    private StorageService storageService;
    ChatMessage chatMessage;
    long roomId;
    SimpMessageSendingOperations messagingTemplate;
    RestTemplate restTemplate;
    public SimpleThread(SimpMessageSendingOperations messagingTemplate, ChatMessage chatMessage, long roomId, StorageService storageService, RestTemplate restTemplate){
        this.chatMessage = chatMessage;
        this.roomId = roomId;
        this.messagingTemplate = messagingTemplate;
        this.storageService = storageService;
        this.restTemplate = restTemplate;
    }
    public void run() {
        //System.out.println("thread is running...");
        do{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(pingUrlFile(chatMessage.getContent())==false);
        messagingTemplate.convertAndSend("/topic/" + roomId, chatMessage);
    }

    public boolean pingUrlFile(String fileName) {
       String url = "http://localhost:8080/file/download/" + fileName;
        ResponseEntity<ByteArrayResource> response = restTemplate.exchange(url, HttpMethod.GET, null, ByteArrayResource.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            return true;
        }
        return false;
    }

    /*public static void main(String args[]) {
        Multi3 m1 = new Multi3();
        Thread t1 = new Thread(m1);
        t1.start();
    }*/
}