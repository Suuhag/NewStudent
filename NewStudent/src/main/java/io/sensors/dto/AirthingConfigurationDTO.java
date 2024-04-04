package io.sensors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirthingConfigurationDTO {
    private String token_name;
    private String grant_type;
    private String callback_url;
    private String auth_url;
    private String acess_token_url;
    private String client_id;
    private String client_secret;
    private String scope;
    private String state;
    private String client_auth;
    private String refresh_token_url;
    private String auth_request;
    private String token_request;
    private String refresh_request;

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

    public String getCallback_url() {
        return callback_url;
    }

    public void setCallback_url(String callback_url) {
        this.callback_url = callback_url;
    }

    public String getAuth_url() {
        return auth_url;
    }

    public void setAuth_url(String auth_url) {
        this.auth_url = auth_url;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClient_auth() {
        return client_auth;
    }

    public void setClient_auth(String client_auth) {
        this.client_auth = client_auth;
    }

    public String getRefresh_token_url() {
        return refresh_token_url;
    }

    public void setRefresh_token_url(String refresh_token_url) {
        this.refresh_token_url = refresh_token_url;
    }

    public String getAuth_request() {
        return auth_request;
    }

    public void setAuth_request(String auth_request) {
        this.auth_request = auth_request;
    }

    public String getToken_request() {
        return token_request;
    }

    public void setToken_request(String token_request) {
        this.token_request = token_request;
    }

    public String getRefresh_request() {
        return refresh_request;
    }

    public void setRefresh_request(String refresh_request) {
        this.refresh_request = refresh_request;
    }

    public AirthingConfigurationDTO() {
    }

    public AirthingConfigurationDTO(String token_name, String grant_type, String callback_url, String auth_url, String acess_token_url, String client_id, String client_secret, String scope, String state, String client_auth, String refresh_token_url, String auth_request, String token_request, String refresh_request) {
        this.token_name = token_name;
        this.grant_type = grant_type;
        this.callback_url = callback_url;
        this.auth_url = auth_url;
        this.acess_token_url = acess_token_url;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.scope = scope;
        this.state = state;
        this.client_auth = client_auth;
        this.refresh_token_url = refresh_token_url;
        this.auth_request = auth_request;
        this.token_request = token_request;
        this.refresh_request = refresh_request;
    }

    @Override
    public String toString() {
        return "AirthingConfigurationDTO{" +
                "token_name='" + token_name + '\'' +
                ", grant_type='" + grant_type + '\'' +
                ", callback_url='" + callback_url + '\'' +
                ", auth_url='" + auth_url + '\'' +
                ", acess_token_url='" + acess_token_url + '\'' +
                ", client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", scope='" + scope + '\'' +
                ", state='" + state + '\'' +
                ", client_auth='" + client_auth + '\'' +
                ", refresh_token_url='" + refresh_token_url + '\'' +
                ", auth_request='" + auth_request + '\'' +
                ", token_request='" + token_request + '\'' +
                ", refresh_request='" + refresh_request + '\'' +
                '}';
    }
}

