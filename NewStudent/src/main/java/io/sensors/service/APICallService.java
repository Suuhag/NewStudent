package io.sensors.service;

import com.alibaba.fastjson.JSONException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.sensors.Repository.AirThingsSensorsRepository;
import io.sensors.dto.AirthingOuthTokenDTO;
import io.sensors.dto.AirthingSensorsDTO;
import io.sensors.utils.APIRequest;
import io.sensors.utils.AirThingsUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class APICallService {

    @Autowired
    AirThingsUtils airThingsUtils;

    @Autowired
    APIRequest apiRequest;

    private String airthingsSensorServerUrl = "http://localhost:3306";

    //    public JSONObject getAirthingAuthToken(String client_id, String client_secret) {
//
//        try {
//            //System.out.println("asdfvcd");
//
//            Map<String, String> headers = new HashMap<>();
//            headers.put("Content-Type", "application/x-www-form-urlencoded");
//
//            Map<String, String> encodedAirthingsData = new HashMap<>();
//            encodedAirthingsData.put("client_id", client_id);
//            encodedAirthingsData.put("client_secret", client_secret);
//            encodedAirthingsData.put("grant_type", "client_credentials");
//            String requestBody = this.getHashMapString(encodedAirthingsData);
//
//            ResponseEntity<String> response = apiRequest.httpRequest("https://accounts-api.airthings.com/v1/token",
//                    "GET", requestBody, headers, null, null, null);
//            //System.out.println("Response" + response);
//
//            if (response.getStatusCodeValue() == 200) {
//                JSONObject responseBody = new JSONObject(response.getBody());
//                return responseBody;
//            }
//
//        } catch (UnsupportedEncodingException e) {
//            System.out.println(e);
//        } catch (JSONException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }

    public String getHashMapString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();

        if (params != null) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
        }
        return result.toString();
    }

    public String getAirthingAuthToken(String client_id, String client_secret) {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/x-www-form-urlencoded");

            Map<String, String> encodedAirthingsData = new HashMap<>();
            encodedAirthingsData.put("client_id", client_id);
            encodedAirthingsData.put("client_secret", client_secret);
            encodedAirthingsData.put("grant_type", "client_credentials");
            String requestBody = this.getHashMapString(encodedAirthingsData);

            ResponseEntity<String> response = apiRequest.httpRequest("https://accounts-api.airthings.com/v1/token",
                    "GET", requestBody, headers, null, null, null);

            if (response.getStatusCodeValue() == 200) {
                JSONObject responseBody = new JSONObject(response.getBody());
                String token = responseBody.getString("access_token");
                return token;
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (org.json.JSONException e) {
            throw new RuntimeException(e);
        }
//        } catch (UnsupportedEncodingException | JSONException | org.json.JSONException e) {
//            System.out.println(e);
//            throw new RuntimeException(e);
//        }
        return null;
    }
}
