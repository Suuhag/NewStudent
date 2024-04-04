package io.sensors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Value;

import javax.persistence.Column;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirthingAccessTokenDTO {
    private String id;

    private String clientSecret;

    private String tokenUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public AirthingAccessTokenDTO() {
    }

    public AirthingAccessTokenDTO(String id, String clientSecret, String tokenUrl) {
        this.id = id;
        this.clientSecret = clientSecret;
        this.tokenUrl = tokenUrl;
    }

    @Override
    public String toString() {
        return "AirthingAccessTokenDTO{" +
                "id='" + id + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", tokenUrl='" + tokenUrl + '\'' +
                '}';
    }
}
