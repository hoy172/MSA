package com.hoy.reader;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableScheduling
//@EnableDiscoveryClient
//@EnableResourceServer
@SpringBootApplication
@Slf4j
public class ReaderApplication {



	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	public static void main(String[] args) {
		SpringApplication.run(ReaderApplication.class, args);
	}



	@KafkaListener(topics = "test")
	public void listner(ConsumerRecord consumerRecord){


//		log.info(consumerRecord.value().toString());
		LogMessage logMessage = new LogMessage();
		logMessage.setType("LOG");
		logMessage.setMessage(consumerRecord.value().toString());
		log.info(consumerRecord.toString());
		simpMessagingTemplate.convertAndSend("/send",consumerRecord.value().toString());

	}
}
