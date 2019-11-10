package com.example.demo1.config;

public class KafkaPropertiesSecurity {

    private Boolean enabled;
    private String protocol;
    private String keyStoreLocation;
    private String keyStorePassword;
    private String keyPassword;
    private String keyStoreType;
    private String trustStoreLocation;
    private String trustStorePassword;
    private String endPointIdentificationAlgorithm;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getKeyStoreLocation() {
        return keyStoreLocation;
    }

    public void setKeyStoreLocation(String keyStoreLocation) {
        this.keyStoreLocation = keyStoreLocation;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public String getKeyStoreType() {
        return keyStoreType;
    }

    public void setKeyStoreType(String keyStoreType) {
        this.keyStoreType = keyStoreType;
    }

    public String getTrustStoreLocation() {
        return trustStoreLocation;
    }

    public void setTrustStoreLocation(String trustStoreLocation) {
        this.trustStoreLocation = trustStoreLocation;
    }

    public String getTrustStorePassword() {
        return trustStorePassword;
    }

    public void setTrustStorePassword(String trustStorePassword) {
        this.trustStorePassword = trustStorePassword;
    }

    public String getEndPointIdentificationAlgorithm() {
        return endPointIdentificationAlgorithm;
    }

    public void setEndPointIdentificationAlgorithm(String endPointIdentificationAlgorithm) {
        this.endPointIdentificationAlgorithm = endPointIdentificationAlgorithm;
    }
}
