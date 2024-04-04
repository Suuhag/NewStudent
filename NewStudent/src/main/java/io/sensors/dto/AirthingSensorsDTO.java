package io.sensors.dto;

public class AirthingSensorsDTO {

    private String id;
    private String username;
    private String vdmsid;
    private String device_id;

//    private String name;
//    private String client_id;
//    private String client_secret;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVdmsid() {
        return vdmsid;
    }

    public void setVdmsid(String vdmsid) {
        this.vdmsid = vdmsid;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public AirthingSensorsDTO() {
    }

    public AirthingSensorsDTO(String id, String username, String vdmsid, String device_id) {
        this.id = id;
        this.username = username;
        this.vdmsid = vdmsid;
        this.device_id = device_id;
    }

    @Override
    public String toString() {
        return "AirthingSensorsDTO{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", vdmsid='" + vdmsid + '\'' +
                ", device_id='" + device_id + '\'' +
                '}';
    }
}
