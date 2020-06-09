//package com.hoy.reader.config;
//
//import kafka.tools.ConsoleConsumer;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//@Slf4j
//@Component
//public class KafkaCosumerConfig {
//    private KafkaConsumer<String,String> consumer = null;
//
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServer;
//
//    @Value("${spring.kafka.consumer.group-id}")
//    private String groupID;
//
//    @Value("${spring.kafka.consumer.value-deserializer}")
//    private String keyDeSerializer;
//
//    @Value("${spring.kafka.consumer.value-deserialize}")
//    private String valueDeserializer;
//
//    @Value("${spring.kafka.consumer.auto-offset-reset}")
//    private String offsetReset;
//
//    @Value("${spring.kafka.template.default-topic}")
//    private String topicName;
//
//    @Value("${spring.kafka.consumer.max-poll-records}")
//    private String maxPollRecords;
//
////    @Value("${spring.kafka.consumer.enable-auto-commit")
////    private boolean enableAutoCommit;
//
//
//    @PostConstruct
//    public  void budild(){
//        Properties properties = new Properties();
//        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
//        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupID);
//        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeSerializer);
//        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
//        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, offsetReset);
//        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
////        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,String.valueOf(enableAutoCommit));
//        consumer = new KafkaConsumer<>(properties);
//    }
//
//    @KafkaListener(topics="#{spring.kafka.template.default-topic")
//    public void consume(@Headers MessageHeaders headers, @Payload String payload){
//        log.info("consume headers : " + headers.toString());
//        log.info("consume payload : " + payload);
//    }
//}
