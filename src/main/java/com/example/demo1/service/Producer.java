package com.example.demo1.service;

import com.kafka.schema.UserExample;
import com.kafka.schema.UserGroup;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class Producer {

    static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, GenericRecord> sendKafkaTemplate;

    @Autowired
    public ReplyingKafkaTemplate<String, GenericRecord, GenericRecord> replyingKafkaTemplate;

    @Value("${kafka.topic.mock}")
    private String mockTopic;

    @Value("${kafka.topic.request}")
    private String requestTopic;

    public void sendExampleMessage(UserExample user) {

        ProducerRecord<String, GenericRecord> record = new ProducerRecord<>(mockTopic, user);

        sendKafkaTemplate.send(record);
    }

    public String requestReplyGroup(String userGroup) throws ExecutionException, InterruptedException {

        UserGroup group = new UserGroup();
        group.setGroup(userGroup);

        ProducerRecord<String, GenericRecord> record = new ProducerRecord<>(requestTopic, group);

        RequestReplyFuture<String, GenericRecord, GenericRecord> replyFuture = replyingKafkaTemplate.sendAndReceive(record);

        GenericRecord replyRecord = replyFuture.get().value();

        return replyRecord.toString();
    }
}
