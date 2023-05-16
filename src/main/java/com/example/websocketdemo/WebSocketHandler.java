package com.example.websocketdemo;

import java.io.IOException;
import java.net.InetAddress;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class WebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        InetAddress address = session.getRemoteAddress().getAddress();
        String ip = address.getHostAddress();
        System.out.println("New Text Message Received: " + message.getPayload() + " from IP: " + ip);
        session.sendMessage(new TextMessage(message.getPayload() +" from IP: " + ip ));
    }

}
