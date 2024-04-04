package io.sensors.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Base64;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@ConfigurationProperties(prefix = "airthingsutils")
public class AirThingsUtils {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
