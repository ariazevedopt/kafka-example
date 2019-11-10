package com.example.demo1.config;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;
import io.confluent.kafka.serializers.subject.TopicRecordNameStrategy;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class kafkaConfig {

    @Autowired
    private KafkaProperties properties;

    @Value("${kafka.topic.request}")
    private String requestTopic;

    @Value("${kafka.topic.reply}")
    private String replyTopic;

    @Value("${kafka.request-reply.timeout-ms}")
    private Long replyTimeout;


    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, properties.getSchemaRegistry());
        props.put(AbstractKafkaAvroSerDeConfig.AUTO_REGISTER_SCHEMAS, properties.getSchemaAutoregister());

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(KafkaAvroSerializerConfig.VALUE_SUBJECT_NAME_STRATEGY, TopicRecordNameStrategy.class.getName());

        setSecurityProperties(props);

        return props;
    }

    private void setSecurityProperties(Map<String, Object> props) {
        KafkaPropertiesSecurity securityProperties = properties.getSsl();

        Boolean kafkaSecurityEnabled = securityProperties.getEnabled();
        if (kafkaSecurityEnabled) {
            props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, securityProperties.getProtocol());
            props.put(SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, securityProperties.getKeyStoreLocation());
            props.put(SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, securityProperties.getKeyStorePassword());
            props.put(SslConfigs.SSL_KEY_PASSWORD_CONFIG, securityProperties.getKeyPassword());
            props.put(SslConfigs.SSL_KEYSTORE_TYPE_CONFIG, securityProperties.getKeyStoreType());
            props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, securityProperties.getTrustStoreLocation());
            props.put(SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, securityProperties.getTrustStorePassword());
            props.put(SslConfigs.SSL_ENDPOINT_IDENTIFICATION_ALGORITHM_CONFIG, securityProperties.getEndPointIdentificationAlgorithm());


        }
    }

    @Bean
    public ProducerFactory<String, GenericRecord> requestProducerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    //Send User
    @Bean
    public KafkaTemplate<String, GenericRecord> sendKafkaTemplate() {
        return new KafkaTemplate<>(requestProducerFactory());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, properties.getSchemaRegistry());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getConsumerGroupId());

        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);

        setSecurityProperties(props);

        return props;
    }

    @Bean
    public ConsumerFactory<String, GenericRecord> kafkaListenerContainerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    // Request-Reply configurations

    @Bean
    public KafkaMessageListenerContainer<String, GenericRecord> replyListenerContainer() {
        ContainerProperties containerProperties = new ContainerProperties(replyTopic);
        return new KafkaMessageListenerContainer<>(kafkaListenerContainerFactory(), containerProperties);
    }


    @Bean
    public ReplyingKafkaTemplate<String, GenericRecord, GenericRecord> replyingKafkaTemplate() {
        ReplyingKafkaTemplate<String, GenericRecord, GenericRecord> replyingKafkaTemplate = new ReplyingKafkaTemplate<>(requestProducerFactory(), replyListenerContainer());
        replyingKafkaTemplate.setDefaultTopic(requestTopic);
        replyingKafkaTemplate.setReplyTimeout(replyTimeout);
        return replyingKafkaTemplate;
    }
}
