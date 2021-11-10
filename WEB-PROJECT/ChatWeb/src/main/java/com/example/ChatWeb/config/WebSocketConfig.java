package com.example.ChatWeb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
        registry.addEndpoint("/example-endpoint").setAllowedOrigins("*").withSockJS();
 
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/topic");
    }
//    @Override
//   	public void configureMessageBroker(MessageBrokerRegistry config) {
//
//           long[] heartbeat = { 30000, 30000 };
//           config.enableSimpleBroker("/topic", "/queue", "/exchange")
//               .setTaskScheduler(new DefaultManagedTaskScheduler()) // enable heartbeats
//               .setHeartbeatValue(heartbeat); // enable heartbeats
//
////           config.enableStompBrokerRelay("/topic", "/queue", "/exchange"); // Uncomment for external message broker (ActiveMQ, RabbitMQ)
//           config.setApplicationDestinationPrefixes("/topic", "/queue"); // prefix in client queries
//           config.setUserDestinationPrefix("/user");
//       }
//    @Override
//    public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
//        registration.setMessageSizeLimit(8 * 1024);
//    }

}