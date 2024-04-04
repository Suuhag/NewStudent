package io.sensors.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Base64;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ConfigurationProperties(prefix = "airthingsauthclienttokenutlis")

public class AirThingsAuthClientTokenUtlis {
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

    public byte[] base64StringToByteArray(String str) {
        byte[] bt = null;
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            bt = decoder.decode(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bt;
    }

    //Convert Bytes to Hexa string
    public String byteArrayToHexString(byte[] arr) {
        StringBuilder sbd = new StringBuilder();
        for (byte b : arr) {
            String tmp = Integer.toHexString(0xFF & b);
            if (tmp.length() < 2)
                tmp = "0" + tmp;
            sbd.append(tmp);
        }
        return sbd.toString();
    }

    public String base64StringToHexString(String base64String) {
        byte[] byteArray = this.base64StringToByteArray(base64String);
        String hexString = this.byteArrayToHexString(byteArray);
        return hexString;
    }

    public BigInteger stringDateTimeToUTCTimestamp(String stringDateTime) {
        try {
            if (stringDateTime != null) {
                Instant instant = Instant.parse(stringDateTime);
                return BigInteger.valueOf(instant.toEpochMilli());
            }
            return null;
        } catch (Exception e) {
            System.out.println("Error converting date time to timestamp " + e);
            return null;
        }
    }
}
