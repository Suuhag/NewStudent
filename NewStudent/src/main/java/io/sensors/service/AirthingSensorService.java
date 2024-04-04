package io.sensors.service;

import io.sensors.Repository.*;
import io.sensors.dto.*;
import io.sensors.utils.AirThingsUtils;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AirthingSensorService {

    @Autowired
    AirThingsSensorsRepository airThingsSensorsRepository;

    @Autowired
    AirThingsConfigurationRepository airThingsConfigurationRepository;

    @Autowired
    AirThingsAccessTokenRepository airthingsAccessTokenRepository;

    @Autowired
    AirThingsOuthTokenRepository airThingsOuthTokenRepository;

    @Autowired
    AirthingsAuthClientTokenRepository airthingsAuthClientTokenRepository;

    @Autowired
    APICallService apiCallService;

    @Autowired
    AirThingsUtils airThingsUtils;

//    public String generateAccessToken(com.alibaba.fastjson.JSONObject requestBody) throws JSONException {
//        String clientId = requestBody.getString("client_id");
//        String clientSecret = requestBody.getString("client_secret");
//        org.json.JSONObject response = apiCallService.getAirthingAuthToken(clientId, clientSecret);
//        airThingsUtils.setToken(response.getString("access_token"));
//        return response.getString("access_token");
//    }

    //    public String generateAccessToken(String client_id, String client_secret) throws JSONException {
//        org.json.JSONObject response = apiCallService.getAirthingAuthToken(client_id, client_secret);
//        airThingsUtils.setToken(response.getString("access_token"));
//        return response.getString("access_token");
//    }

    public Set<AirthingSensorsDTO> getairthingsensors(String id) {
        return airThingsSensorsRepository.getairthingsensors(id);
    }

    public void upsertairthingSensors(AirthingSensorsDTO airthingSensorsDTO) {
        airThingsSensorsRepository.upsertairthingSensors(airthingSensorsDTO.getId(), airthingSensorsDTO.getUsername(), airthingSensorsDTO.getVdmsid(), airthingSensorsDTO.getDevice_id());
    }

    public Set<AirthingConfigurationDTO> getairthingconfiguration(String clientId) {
        return airThingsConfigurationRepository.getairthingconfiguration(clientId);
    }

    public void upsertairthingconfiguration(AirthingConfigurationDTO airthingConfigurationDTO) {
        airThingsConfigurationRepository.upsertairthingconfiguration(airthingConfigurationDTO.getToken_name(), airthingConfigurationDTO.getGrant_type(), airthingConfigurationDTO.getCallback_url(), airthingConfigurationDTO.getAuth_url(), airthingConfigurationDTO.getAcess_token_url(), airthingConfigurationDTO.getClient_id(), airthingConfigurationDTO.getClient_secret(), airthingConfigurationDTO.getScope(), airthingConfigurationDTO.getState(), airthingConfigurationDTO.getClient_auth(), airthingConfigurationDTO.getRefresh_token_url(), airthingConfigurationDTO.getAuth_request(), airthingConfigurationDTO.getToken_request(), airthingConfigurationDTO.getRefresh_request());
    }


    public Set<AirthingAccessTokenDTO> getaccesstoken(String id) {
        // Get token  System.out.println(airThingsUtils.getToken());
        return airthingsAccessTokenRepository.getaccesstoken(id);
    }


    public void deleteAirthingSensors(List<AirthingSensorsDTO> AirThingSensors) {
        for (AirthingSensorsDTO AirThingSensor : AirThingSensors) {
            airThingsSensorsRepository.deleteById(AirThingSensor.getId());
        }
    }


    public void deleteAirthingconfiguration(List<AirthingConfigurationDTO> AirThingConfiguration) {
        for (AirthingConfigurationDTO AirThingConfig : AirThingConfiguration) {
            airThingsConfigurationRepository.deleteById(AirThingConfig.getClient_id());
        }
    }

    public String generateAccessToken(com.alibaba.fastjson.JSONObject requestBody) throws JSONException {
        String clientId = requestBody.getString("client_id");
        String clientSecret = requestBody.getString("client_secret");
        String response_token = apiCallService.getAirthingAuthToken(clientId, clientSecret);
        System.out.println("Token : " + response_token);
        if (response_token != null) {
            return "success";
        }
        return null;
    }

    public Set<AirthingOuthTokenDTO> getclienttoken(String client_id) {
        return airThingsOuthTokenRepository.getclienttoken(client_id);
    }

    public void upsertairthingclienttoken(AirthingOuthTokenDTO airthingOuthTokenDTO) {
        airThingsOuthTokenRepository.upsertairthingclienttoken(airthingOuthTokenDTO.getToken_name(), airthingOuthTokenDTO.getGrant_type(), airthingOuthTokenDTO.getAcess_token_url(), airthingOuthTokenDTO.getClient_id(), airthingOuthTokenDTO.getClient_secret(), airthingOuthTokenDTO.getScope(), airthingOuthTokenDTO.getClient_auth());
    }

    public void deleteAirthingclienttoken(List<AirthingOuthTokenDTO> airthingOuthTokenDTOs) {
        for (AirthingOuthTokenDTO airthingOuthTokenDTO : airthingOuthTokenDTOs) {
            airThingsOuthTokenRepository.deleteById(airthingOuthTokenDTO.getClient_id());
        }
    }


    public Set<AirthingAuthClientTokenDTO> getauthclienttoken(String id) {
        return airthingsAuthClientTokenRepository.getauthclienttoken(id);
    }

    public void upsertairthingauthclienttoken(AirthingAuthClientTokenDTO airthingAuthClientTokenDTO) {
        airthingsAuthClientTokenRepository.upsertairthingauthclienttoken(airthingAuthClientTokenDTO.getId(), airthingAuthClientTokenDTO.getClient_id(), airthingAuthClientTokenDTO.getClient_secret(), airthingAuthClientTokenDTO.getScope(), airthingAuthClientTokenDTO.getAccess_token());
    }

    public void deleteAirthingauthclienttoken(List<AirthingAuthClientTokenDTO> airthingAuthClientTokenDTOs) {
        for (AirthingAuthClientTokenDTO airthingAuthClientTokenDTO : airthingAuthClientTokenDTOs) {
            airthingsAuthClientTokenRepository.deleteById(airthingAuthClientTokenDTO.getId());
        }
    }
}
