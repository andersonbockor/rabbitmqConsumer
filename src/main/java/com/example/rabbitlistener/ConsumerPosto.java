package com.example.rabbitlistener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;


@Component
public class ConsumerPosto implements MessageListener{
	
	private Gson gson = new Gson();

	//É possível transformar em CustomMessage automaticamente, mas dessa forma o Spring não injeta a queue de forma dinâmica
	
	//private static final String QUEUE_PDV = "PDV";
	//private static final String[] pdvs = {QUEUE_PDV+"1",QUEUE_PDV+"2"};
	
	//@RabbitListener(queues = {"PDV1","PDV2"}, containerFactory="jsaFactory") - Factory dinâmico
	//@RabbitListener(queues = "#{'${property.with.comma.delimited.queue.names}'.split(',')}")
	//@RabbitListener(queues = "${myQueue.property}")
	/*@RabbitListener(containerFactory="postoFactory")
    public void recievedMessage(CustomMessage message) {
		System.out.println(message.toString());
    }*/

	@Override
	public void onMessage(Message msg) {
		// TODO Auto-generated method stub
		
		CustomMessage cmsg = gson.fromJson(new String(msg.getBody()), CustomMessage.class); // uso do gson para identificar o CustomMessage
		System.out.println(cmsg.toString());
	}
	
}
