package io.sensors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirthingOuthTokenDTO {
    private String token_name;
    private String grant_type;
    private String acess_token_url;
    private String client_id;
    private String client_secret;
    private String scope;
    private String client_auth;

    public String getToken_name() {
        return token_name;
    }

    public void setToken_name(String token_name) {
        this.token_name = token_name;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getAcess_token_url() {
        return acess_token_url;
    }

    public void setAcess_token_url(String acess_token_url) {
        this.acess_token_url = acess_token_url;
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

    public String getClient_auth() {
        return client_auth;
    }

    public void setClient_auth(String client_auth) {
        this.client_auth = client_auth;
    }

    public AirthingOuthTokenDTO() {
    }

    public AirthingOuthTokenDTO(String token_name, String grant_type, String acess_token_url, String client_id, String client_secret, String scope, String client_auth) {
        this.token_name = token_name;
        this.grant_type = grant_type;
        this.acess_token_url = acess_token_url;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.scope = scope;
        this.client_auth = client_auth;
    }

    @Override
    public String toString() {
        return "AirthingOuthTokenDTO{" +
                "token_name='" + token_name + '\'' +
                ", grant_type='" + grant_type + '\'' +
                ", acess_token_url='" + acess_token_url + '\'' +
                ", client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", scope='" + scope + '\'' +
                ", client_auth='" + client_auth + '\'' +
                '}';
    }
}
