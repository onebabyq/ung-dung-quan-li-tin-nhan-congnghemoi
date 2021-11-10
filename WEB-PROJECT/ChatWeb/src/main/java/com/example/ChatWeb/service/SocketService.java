package com.example.ChatWeb.service;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.ChatWeb.model.EchoModel;






/**
 * Created by Naik on 23.02.17.
 */
@Service
public
class SocketService {
	private static final Logger log = LoggerFactory.getLogger(SocketService.class);
    @Autowired
    private SimpMessagingTemplate simpTemplate;

   public void echoMessage(String message) {
        log.debug("Start convertAndSend ${new Date()}");
        simpTemplate.convertAndSend("/topic/greetings", new EchoModel(message));
        log.debug("End convertAndSend ${new Date()}");
    }
}
