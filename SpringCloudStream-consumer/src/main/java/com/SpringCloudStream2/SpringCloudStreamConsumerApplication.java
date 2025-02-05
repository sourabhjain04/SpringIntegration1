package com.SpringCloudStream2;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudStreamConsumerApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
	}
	
	@Bean
	public Consumer<Book> consumeMessage(){
		return book->logger.info("Consumed PayLoad : " + book);
	}

}
