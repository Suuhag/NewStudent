package io.sensors.models;


import io.sensors.dto.AirthingAuthClientTokenDTO;
import io.sensors.dto.AirthingSensorsDTO;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "airthingauthtokenmapping",
        classes = {
                @ConstructorResult(
                        targetClass = AirthingAuthClientTokenDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = String.class),
                                @ColumnResult(name = "client_id", type = String.class),
                                @ColumnResult(name = "client_secret", type = String.class),
                                @ColumnResult(name = "scope", type = String.class),
                                @ColumnResult(name = "access_token", type = String.class),
                        })
        })

@NamedNativeQuery(
        name = "AirThingAuthClientToken.getauthclienttoken",
        query = "SELECT u.id, u.client_id, u.client_secret,u.scope,u.access_token FROM air_thing_auth_client_token u WHERE u.id=?1",
        resultSetMapping = "airthingauthtokenmapping"
)

@Entity
public class AirThingAuthClientToken {
    @Id
    @Column(length = 64)
    private String id;

    @Column(length = 64)
    private String client_id;

    @Column(length = 64)
    private String client_secret;

    @Column(length = 64)
    private String scope;

    @Column(length = 64)
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

    public AirThingAuthClientToken() {
    }

    public AirThingAuthClientToken(String id, String client_id, String client_secret, String scope, String access_token) {
        this.id = id;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.scope = scope;
        this.access_token = access_token;
    }

    @Override
    public String toString() {
        return "AirThingAuthClientToken{" +
                "id='" + id + '\'' +
                ", client_id='" + client_id + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", scope='" + scope + '\'' +
                ", access_token='" + access_token + '\'' +
                '}';
    }
}
