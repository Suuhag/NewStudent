package io.sensors.Repository;

import io.sensors.dto.AirthingAuthClientTokenDTO;
import io.sensors.dto.AirthingOuthTokenDTO;
import io.sensors.models.AirThingAuthClientToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface AirthingsAuthClientTokenRepository extends JpaRepository<AirThingAuthClientToken, String> {

    @Query(nativeQuery = true)
    Set<AirthingAuthClientTokenDTO> getauthclienttoken(String id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO air_thing_auth_client_token(id,client_id,client_secret,scope,access_token) VALUES(?1,?2,?3,?4,?5)", nativeQuery = true)
    void upsertairthingauthclienttoken(String id, String client_id, String client_secret, String scope, String access_token);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM air_thing_auth_client_token WHERE id = ?1", nativeQuery = true)
    void deleteAirthingauthclienttoken(String id);
}
