package com.example.rabbitlistener;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerEndpoint;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig  implements RabbitListenerConfigurer {

	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("localhost");
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
	}
	
	//@Bean
	//public MessageConverter jsonMessageConverter(){
	//   return new Jackson2JsonMessageConverter();
	//}
	
	@Bean
    public SimpleRabbitListenerContainerFactory jsaFactory(ConnectionFactory connectionFactory,
            SimpleRabbitListenerContainerFactoryConfigurer configurer) {
    	
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        //factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }
    
	//Outra forma de definir factory
   /* @Bean
    public MessageConverter consumerJackson2MessageConverter() {
      // return new MappingJackson2MessageConverter();
       return new Jackson2JsonMessageConverter();
    }*/
    
    /*@Bean
    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
       DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
       factory.setMessageConverter(new Jackson2JsonMessageConverter());
       return factory;
    }*/
     
    @Override
    public void configureRabbitListeners(final RabbitListenerEndpointRegistrar registrar) {
       //registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
       
       //Endpoints
       SimpleRabbitListenerEndpoint endpoint = new SimpleRabbitListenerEndpoint();
       
       endpoint.setId("posto");
       String pdv = "PDV1"; //nome da fila
       endpoint.setQueueNames(pdv);
       endpoint.setMessageListener(new ConsumerPosto());
       
       registrar.registerEndpoint(endpoint);
       
     //Endpoints
       SimpleRabbitListenerEndpoint endpoint2 = new SimpleRabbitListenerEndpoint();
       
       endpoint2.setId("outro"); //simulando um outro endpoint para exemplificar a necessidade do mesmo PDV ler outra fila
       pdv = "PDV2"; //Poderia ser uma fila chamada "carga_de_dados", por exemplo
       endpoint2.setQueueNames(pdv);
       endpoint2.setMessageListener(new ConsumerOutro());
       
       registrar.registerEndpoint(endpoint2);
    }
}
