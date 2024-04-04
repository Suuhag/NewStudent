package io.sensors.Repository;

import io.sensors.dto.AirthingAccessTokenDTO;
import io.sensors.dto.AirthingOuthTokenDTO;
import io.sensors.models.AirThingToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface AirThingsOuthTokenRepository extends JpaRepository<AirThingToken, String> {
    @Query(nativeQuery = true)
    Set<AirthingOuthTokenDTO> getclienttoken(String client_id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO air_thing_token(token_name,grant_type,acess_token_url,client_id,client_secret,scope,client_Auth) VALUES(?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void upsertairthingclienttoken(String token_name, String grant_type, String acess_token_url, String client_id, String client_secret, String scope, String client_auth);


    @Modifying
    @Transactional
    @Query(value = "UPDATE air_thing_token SET device_id = NULL WHERE client_id = ?1", nativeQuery = true)
    void deleteAirthingconfiguration(String id);

}
