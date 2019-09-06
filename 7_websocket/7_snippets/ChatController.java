package sample;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;


public class ChatController {
	
	public OutputMessage send(String topic, Message message) throws Exception {
		return new OutputMessage(message.getFrom(), message.getText(), topic);
	}
}
