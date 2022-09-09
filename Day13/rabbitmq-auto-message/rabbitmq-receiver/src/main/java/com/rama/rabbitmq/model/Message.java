package com.rama.rabbitmq.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Message.class)
public class Message {

	private String to;
	private String from;
	private String content;
	private String messageId;

	public Message() {
	}

	public Message(String to, String from, String content, String messageId) {
		this.to = to;
		this.from = from;
		this.content = content;
		this.messageId = messageId;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	@Override
	public String toString() {
		return "Message [To=" + to + ", From=" + from + "Content= "+ content +" Message id= "+messageId+"]";
	}

}
