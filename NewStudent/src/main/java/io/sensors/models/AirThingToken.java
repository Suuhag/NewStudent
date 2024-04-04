package io.sensors.models;

import io.sensors.dto.AirthingOuthTokenDTO;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "airthinguthTokenmapping",
        classes = {
                @ConstructorResult(
                        targetClass = AirthingOuthTokenDTO.class,
                        columns = {
                                @ColumnResult(name = "token_name", type = String.class),
                                @ColumnResult(name = "grant_type", type = String.class),
                                @ColumnResult(name = "acess_token_url", type = String.class),
                                @ColumnResult(name = "client_id", type = String.class),
                                @ColumnResult(name = "client_secret", type = String.class),
                                @ColumnResult(name = "scope", type = String.class),
                                @ColumnResult(name = "client_auth", type = String.class),
                        })
        })

@NamedNativeQuery(
        name = "AirThingToken.getclienttoken",
        query = "SELECT o.token_name, o.grant_type, o.acess_token_url, o.client_id, o.client_secret, o.scope, o.client_auth FROM air_thing_token o WHERE o.client_id=?1",
        resultSetMapping = "airthinguthTokenmapping"
)

@Entity
public class AirThingToken {
    @Column(length = 64)
    private String token_name;

    @Column(length = 64)
    private String grant_type;

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

    public AirThingToken() {
    }

    public AirThingToken(String token_name, String grant_type, String acess_token_url, String client_id, String client_secret, String scope, String client_auth) {
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
        return "AirThingToken{" +
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
