package com.example.rabbitlistener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ConsumerOutro implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		System.out.println(msg);
	}

}
