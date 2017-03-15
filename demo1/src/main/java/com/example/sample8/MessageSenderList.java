package com.example.sample8;

import java.util.List;

public class MessageSenderList {
	
	List<Sender> senders;
	
	public void setSenders(List<Sender> senders) {
		this.senders = senders;
	}
	
	public void sendMessage(String message) {
		for (Sender sender : senders) {
			sender.send(message);
		}
	}
}
