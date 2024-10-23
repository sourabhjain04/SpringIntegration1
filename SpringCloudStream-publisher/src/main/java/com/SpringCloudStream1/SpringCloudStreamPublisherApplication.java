package com.SpringCloudStream1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringCloudStreamPublisherApplication {

	private final StreamBridge streamBridge;
	
	public SpringCloudStreamPublisherApplication(StreamBridge streamBridge) {
		this.streamBridge = streamBridge;
	}
	@PostMapping("/publish")
	public Book publishEvent(@RequestBody Book book) {
		Message<Book> message = MessageBuilder.withPayload(book).build();
		streamBridge.send("output-out-0",message);
		return book;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamPublisherApplication.class, args);
	}

}
