package io.sensors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirthingAuthClientTokenDTO {

    private String id;
    private String client_id;
    private String client_secret;
    private String scope;
    private String access_token;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public AirthingAuthClientTokenDTO() {
    }

    public AirthingAuthClientTokenDTO(String id, String client_id, String client_secret, String scope, String access_token) {
        this.id = id;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.scope = scope;
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "AirthingAuthClientTokenDTO{" +
                "id='" + id + '\'' +
                ", client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", scope='" + scope + '\'' +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
