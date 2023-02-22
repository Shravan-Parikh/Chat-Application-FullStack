package com.zos.service;

import com.zos.modal.Message;

public interface MessageService  {
	
	public Message sendMessage(Message message);
	
	public Message deleteMessage(Integer messageId);

}
