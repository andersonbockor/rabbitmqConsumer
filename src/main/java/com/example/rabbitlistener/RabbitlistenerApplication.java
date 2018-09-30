package com.example.rabbitlistener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitlistenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitlistenerApplication.class, args);
	}
	
	/*@RabbitListener(queues="${jsa.rabbitmq.queue}", containerFactory="jsaFactory")
    public void recievedMessage(SimpleMessage ms) {
        System.out.println("Recieved Message: " + ms);
    }*/
}
