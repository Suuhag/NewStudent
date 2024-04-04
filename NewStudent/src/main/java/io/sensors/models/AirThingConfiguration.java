package io.sensors.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
//import io.sensors.dto.AirthingSensorsDTO;
import io.sensors.dto.AirthingConfigurationDTO;

import javax.persistence.*;
import java.util.Set;

@SqlResultSetMapping(
        name = "airthingconfigurationmapping",
        classes = {
                @ConstructorResult(
                        targetClass = AirthingConfigurationDTO.class,
                        columns = {
                                @ColumnResult(name = "token_name", type = String.class),
                                @ColumnResult(name = "grant_type", type = String.class),
                                @ColumnResult(name = "callback_url", type = String.class),
                                @ColumnResult(name = "auth_url", type = String.class),
                                @ColumnResult(name = "acess_token_url", type = String.class),
                                @ColumnResult(name = "client_id", type = String.class),
                                @ColumnResult(name = "client_secret", type = String.class),
                                @ColumnResult(name = "scope", type = String.class),
                                @ColumnResult(name = "state", type = String.class),
                                @ColumnResult(name = "client_auth", type = String.class),
                                @ColumnResult(name = "refresh_token_url", type = String.class),
                                @ColumnResult(name = "auth_request", type = String.class),
                                @ColumnResult(name = "token_request", type = String.class),
                                @ColumnResult(name = "refresh_request", type = String.class),
                        })
        })

@NamedNativeQuery(
        name = "AirThingConfiguration.getairthingconfiguration",
        query = "SELECT c.token_name, c.grant_type, c.callback_url, c.auth_url, c.acess_token_url, c.client_id, c.client_secret, c.scope, c.state, c.client_auth, c.refresh_token_url, c.auth_request, c.token_request, c.refresh_request FROM air_thing_configuration c WHERE c.client_id=?1",
        resultSetMapping = "airthingconfigurationmapping"
)

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = AirThingConfiguration.class)
public class AirThingConfiguration {
    @Column(length = 64)
    private String token_name;

    @Column(length = 64)
    private String grant_type;

    @Column(length = 64)
    private String callback_url;

    @Column(length = 64)
    private String auth_url;

    @Column(length = 64)
    private String acess_token_url;

    @Id
    @Column(length = 64)
    private String client_id;

    @Column(length = 64)
    private String client_secret;

    @Column(length = 64)
    private String scope;

    @Column(length = 64)
    private String state;

    @Column(length = 64)
    private String client_auth;

    @Column(length = 64)
    private String refresh_token_url;

    @Column(length = 64)
    private String auth_request;

    @Column(length = 64)
    private String token_request;

    @Column(length = 64)
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

    public AirThingConfiguration() {
    }

    public AirThingConfiguration(String token_name, String grant_type, String callback_url, String auth_url, String acess_token_url, String client_id, String client_secret, String scope, String state, String client_auth, String refresh_token_url, String auth_request, String token_request, String refresh_request) {
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
        return "AirThingConfiguration{" +
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
