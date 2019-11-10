package com.example.demo1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.kafka")
public class KafkaProperties {

    private String bootstrapServers;
    private String schemaRegistry;
    private Boolean schemaAutoregister;
    private String consumerGroupId;
    private KafkaPropertiesSecurity ssl;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getSchemaRegistry() {
        return schemaRegistry;
    }

    public void setSchemaRegistry(String schemaRegistry) {
        this.schemaRegistry = schemaRegistry;
    }

    public Boolean getSchemaAutoregister() {
        return schemaAutoregister;
    }

    public void setSchemaAutoregister(Boolean schemaAutoregister) {
        this.schemaAutoregister = schemaAutoregister;
    }

    public String getConsumerGroupId() {
        return consumerGroupId;
    }

    public void setConsumerGroupId(String consumerGroupId) {
        this.consumerGroupId = consumerGroupId;
    }

    public KafkaPropertiesSecurity getSsl() {
        return ssl;
    }

    public void setSsl(KafkaPropertiesSecurity ssl) {
        this.ssl = ssl;
    }

}
