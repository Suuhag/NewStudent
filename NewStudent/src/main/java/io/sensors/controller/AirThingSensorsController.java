package io.sensors.controller;

import com.alibaba.fastjson.JSONObject;
import io.sensors.Repository.AirThingsSensorsRepository;
import io.sensors.dto.*;
import io.sensors.service.AirthingSensorService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AirThingSensorsController {

    @Autowired
    AirthingSensorService airthingSensorService;

    @Autowired
    AirThingsSensorsRepository airThingsSensorsRepository;

    //To Test
//    @RequestMapping(method = RequestMethod.GET, value = "id/getToken")
//    public Set<AirthingAccessTokenDTO> getaccesstoken(@RequestParam String id) {
//        return airthingSensorService.getaccesstoken(id);
//    }

    //*********************************Airthings Sensors***********************************************
    //Get Airthings Sensors
    @RequestMapping(method = RequestMethod.GET, value = "user/{username}/vdms/{vdmsid}/getairthingsensors")
    public Set<AirthingSensorsDTO> getairthingsensors(@RequestParam String id) {
        return airthingSensorService.getairthingsensors(id);
    }

    //Upsert Airthings Sensors
    @RequestMapping(method = RequestMethod.POST, value = "user/{username}/vdms/{vdmsid}/upsertairthingSensors")
    public void upsertairthingSensors(@RequestBody AirthingSensorsDTO airthingSensorsDTO) {
        airthingSensorService.upsertairthingSensors(airthingSensorsDTO);
    }

    //Delete Airthings Sensors
    @RequestMapping(method = RequestMethod.DELETE, value = "id/deleteairthingsensors")
    public void deleteAirthingSensors(@RequestBody List<AirthingSensorsDTO> airthingSensorsDTO) {
        airthingSensorService.deleteAirthingSensors(airthingSensorsDTO);
    }

    //*********************************Airthings Configuration***********************************************
    //GENERATING NEW ACCESS TOKEN
    //Get Airthings Sensors Configuration
    @RequestMapping(method = RequestMethod.GET, value = "clientId/getairthingconfiguration")
    public Set<AirthingConfigurationDTO> getauthtoken(@RequestParam String clientId) {
        return airthingSensorService.getairthingconfiguration(clientId);
    }

    //Upsert Airthings Sensors Configuration
    @RequestMapping(method = RequestMethod.POST, value = "user/{username}/vdms/{vdmsid}/upsertairthingconfiguration")
    public void upsertairthingconfiguration(@RequestBody AirthingConfigurationDTO airthingConfigurationDTO) {
        airthingSensorService.upsertairthingconfiguration(airthingConfigurationDTO);
    }

    //Delete Airthings Configuration
    @RequestMapping(method = RequestMethod.DELETE, value = "id/deleteairthingconfiguration")
    public void deleteAirthingconfiguration(@RequestBody List<AirthingConfigurationDTO> airthingConfigurationDTO) {
        airthingSensorService.deleteAirthingconfiguration(airthingConfigurationDTO);
    }


    //********************************Token Generation********************************
    @RequestMapping(method = RequestMethod.POST, value = "outhToken/token")
    public String generateAccessToken(@RequestBody JSONObject requestbody) throws JSONException {
        //System.out.println(requestbody);
        return airthingSensorService.generateAccessToken(requestbody);
    }


    //*********************************Airthings Client Credentials*************************************
    //Get Airthings Client Credentials
    @RequestMapping(method = RequestMethod.GET, value = "client_id/getclienttoken")
    public Set<AirthingOuthTokenDTO> getclienttoken(@RequestParam String client_id) {
        return airthingSensorService.getclienttoken(client_id);
    }

    //Upsert Airthings Client Credentials
    @RequestMapping(method = RequestMethod.POST, value = "user/{username}/vdms/{vdmsid}/upsertclienttoken")
    public void upsertairthingclienttoken(@RequestBody AirthingOuthTokenDTO airthingOuthTokenDTO) {
        airthingSensorService.upsertairthingclienttoken(airthingOuthTokenDTO);
    }

    //Delete Airthings Client Credentials
    @RequestMapping(method = RequestMethod.DELETE, value = "client_id/deleteairthingclienttoken")
    public void deleteAirthingclienttoken(@RequestBody List<AirthingOuthTokenDTO> airthingOuthTokenDTO) {
        airthingSensorService.deleteAirthingclienttoken(airthingOuthTokenDTO);
    }


    //*********************************Airthings Token Generation*************************************

    //Get Airthings Auth Client Token
    @RequestMapping(method = RequestMethod.GET, value = "id/getauthclienttoken")
    public Set<AirthingAuthClientTokenDTO> getauthclienttoken(@RequestParam String id) {
        return airthingSensorService.getauthclienttoken(id);
    }

    //Upsert Airthings Auth Client Token
    @RequestMapping(method = RequestMethod.POST, value = "user/{username}/vdms/{vdmsid}/upsertauthclienttoken")
    public void upsertairthingauthclienttoken(@RequestBody AirthingAuthClientTokenDTO airthingAuthClientTokenDTO) {
        airthingSensorService.upsertairthingauthclienttoken(airthingAuthClientTokenDTO);
    }

    //Delete Airthings Auth Client Token
    @RequestMapping(method = RequestMethod.DELETE, value = "id/deleteauthclienttoken")
    public void deleteAirthingauthclienttoken(@RequestBody List<AirthingAuthClientTokenDTO> airthingAuthClientTokenDTO) {
        airthingSensorService.deleteAirthingauthclienttoken(airthingAuthClientTokenDTO);
    }

}
