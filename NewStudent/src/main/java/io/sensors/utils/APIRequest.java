package io.sensors.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

@Service
public class APIRequest {
    public ResponseEntity<String> validateResponse(HttpURLConnection con) throws IOException {
        int status = con.getResponseCode();
        BufferedReader in = null;
        String inputLine = null;
        if (status > 299) {
            in = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        } else {
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        }

        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();
        return new ResponseEntity<String>(content.toString(), HttpStatus.valueOf(status));
    }

    public String getParamsString(String apiurl, Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        result.append(apiurl);

        if (params != null) {
            result.append("?");
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


    public ResponseEntity<String> httpRequest(String apiurl, String requestMethod, String requestBody, Map<String, String> headers, Map<String, String> parameters, Integer connectionTimeout, Integer readTimeout) {

        try {
            URL url = new URL(getParamsString(apiurl, parameters));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(requestMethod);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("charset", "UTF-8");


            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    con.setRequestProperty(header.getKey(), header.getValue());
                }
            }

            if (readTimeout == null)
                readTimeout = 50000;
            if (connectionTimeout == null)
                connectionTimeout = 50000;

            con.setDoOutput(true);
            con.setReadTimeout(readTimeout);
            con.setConnectTimeout(connectionTimeout);

            if (requestBody != null) {
                DataOutputStream out = new DataOutputStream(con.getOutputStream());
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = requestBody.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
                out.flush();
                out.close();
            }

            return this.validateResponse(con);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }

    // temepropry with basic auth

    public ResponseEntity<String> httpRequesttest(String apiurl, String requestMethod, String requestBody, Map<String, String> headers, Map<String, String> parameters, Integer connectionTimeout, Integer readTimeout) {

        try {
            URL url = new URL(getParamsString(apiurl, parameters));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(requestMethod);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("charset", "UTF-8");

            // test
            final String customerKey = "c244fh1ih8qg00aumk80";
            // Customer secret
            final String customerSecret = "bea191be24984a53ad24dd6a5f735586";

            // Concatenate customer key and customer secret and use base64 to encode the concatenated string
            String plainCredentials = customerKey + ":" + customerSecret;
            String base64Credentials = new String(java.util.Base64.getEncoder().encode(plainCredentials.getBytes()));
            // Create authorization header
            String authorizationHeader = "Basic " + base64Credentials;


            con.setRequestProperty("Authorization", authorizationHeader);
            // test End

            if (headers != null) {
                for (Map.Entry<String, String> header : headers.entrySet()) {
                    con.setRequestProperty(header.getKey(), header.getValue());
                }
            }

            if (readTimeout == null)
                readTimeout = 50000;
            if (connectionTimeout == null)
                connectionTimeout = 50000;

            con.setDoOutput(true);
            con.setReadTimeout(readTimeout);
            con.setConnectTimeout(connectionTimeout);

            if (requestBody != null) {
                DataOutputStream out = new DataOutputStream(con.getOutputStream());
                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = requestBody.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
                out.flush();
                out.close();
            }

            return this.validateResponse(con);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
    }
}
