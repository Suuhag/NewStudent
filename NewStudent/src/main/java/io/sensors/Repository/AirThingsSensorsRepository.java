package io.sensors.Repository;

import io.sensors.dto.AirthingSensorsDTO;
import io.sensors.models.AirThingSensors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface AirThingsSensorsRepository extends JpaRepository<AirThingSensors, String> {

    @Query(nativeQuery = true)
    Set<AirthingSensorsDTO> getairthingsensors(String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO air_thing_sensors(id, username, vdmsid, device_id) VALUES(?1,?2,?3,?4)", nativeQuery = true)
    void upsertairthingSensors(String id, String username, String vdmsid, String device_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE air_thing_sensors SET device_id = NULL WHERE id = ?1", nativeQuery = true)
    void deleteAirthingconfiguration(String id);
}
