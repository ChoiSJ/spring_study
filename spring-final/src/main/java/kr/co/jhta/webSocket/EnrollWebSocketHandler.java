package kr.co.jhta.webSocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EnrollWebSocketHandler extends TextWebSocketHandler {
	
	private Set<WebSocketSession> sessions 
		= Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
	public void sendMessage(String message) throws Exception {
		Iterator<WebSocketSession> iterator = sessions.iterator();
		
		while(iterator.hasNext()) {
			WebSocketSession savedSession = iterator.next();
			
			try {
				savedSession.sendMessage(new TextMessage(message));
			} catch (IOException e) {
				iterator.remove();
			}
			
		}
		
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessions.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessions.remove(session);
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		sessions.remove(session);
	}
	

}
