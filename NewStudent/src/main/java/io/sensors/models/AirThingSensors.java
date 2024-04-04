package io.sensors.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.sensors.dto.AirthingSensorsDTO;

import javax.persistence.*;


@SqlResultSetMapping(
        name = "airthingsensormapping",
        classes = {
                @ConstructorResult(
                        targetClass = AirthingSensorsDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = String.class),
                                @ColumnResult(name = "username", type = String.class),
                                @ColumnResult(name = "vdmsid", type = String.class),
                                @ColumnResult(name = "device_id", type = String.class),
//                                @ColumnResult(name = "name", type = String.class),
//                                @ColumnResult(name = "client_id", type = String.class),
//                                @ColumnResult(name = "client_secret", type = String.class),
                        })
        })

@NamedNativeQuery(
        name = "AirThingSensors.getairthingsensors",
        query = "SELECT a.id, a.username, a.vdmsid,a.device_id FROM air_thing_sensors a WHERE a.id=?1",
        resultSetMapping = "airthingsensormapping"
)


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = AirThingSensors.class)
public class AirThingSensors {

    @Id
    @Column(length = 64)
    private String id;

    @Column(length = 64)
    private String username;

    @Column(length = 64)
    private String vdmsid;

    @Column(length = 64)
    private String device_id;

//    @Column(length = 64)
//    private String name;
//
//    @Column(length = 64)
//    private String client_id;
//
//    @Column(length = 64)
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

    public AirThingSensors() {
    }

    public AirThingSensors(String id, String username, String vdmsid, String device_id) {
        this.id = id;
        this.username = username;
        this.vdmsid = vdmsid;
        this.device_id = device_id;
    }

    @Override
    public String toString() {
        return "AirThingSensors{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", vdmsid='" + vdmsid + '\'' +
                ", device_id='" + device_id + '\'' +
                '}';
    }


}
