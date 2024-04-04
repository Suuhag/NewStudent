package io.sensors.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.sensors.dto.AirthingAccessTokenDTO;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "airthingtokenmapping",
        classes = {
                @ConstructorResult(
                        targetClass = AirthingAccessTokenDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = String.class),
                                @ColumnResult(name = "client_secret", type = String.class),
                                @ColumnResult(name = "acesstoken_url", type = String.class),
                        })
        })

@NamedNativeQuery(
        name = "AirThingAccessToken.getaccesstoken",
        query = "SELECT t.id, t.client_secret, t.acesstoken_url FROM air_thing_access_token t WHERE t.id=?1",
        resultSetMapping = "airthingtokenmapping"
)

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = AirThingAccessToken.class)

public class AirThingAccessToken {
    @Id
    @Column(length = 64)
    private String id;

    @Column(length = 64)
    private String clientSecret;
    @Column(length = 64)
    private String acesstokenUrl;

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

    public String getAcessstokenUrl() {
        return acesstokenUrl;
    }

    public void setAcessstokenUrl(String acessstokenUrl) {
        this.acesstokenUrl = acessstokenUrl;
    }

    public AirThingAccessToken() {
    }

    public AirThingAccessToken(String id, String clientSecret, String acessstokenUrl) {
        this.id = id;
        this.clientSecret = clientSecret;
        this.acesstokenUrl = acessstokenUrl;
    }

    @Override
    public String toString() {
        return "AirThingAccessToken{" +
                "id='" + id + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                ", acessstokenUrl='" + acesstokenUrl + '\'' +
                '}';
    }
}
