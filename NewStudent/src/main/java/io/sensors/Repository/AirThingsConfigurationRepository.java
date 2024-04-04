package io.sensors.Repository;

import io.sensors.dto.AirthingConfigurationDTO;
import io.sensors.models.AirThingConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Set;

@Repository
public interface AirThingsConfigurationRepository extends JpaRepository<AirThingConfiguration, String> {
    @Query(nativeQuery = true)
    Set<AirthingConfigurationDTO> getairthingconfiguration(String clientId);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO air_thing_configuration(token_name,grant_type,callback_url,auth_url,acess_token_url,client_id,client_secret,scope,state,client_auth,refresh_token_url,auth_request,token_request,refresh_request) VALUES(?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14)", nativeQuery = true)
    void upsertairthingconfiguration(String token_name, String grant_type, String callback_url, String auth_url, String acesss_token_url, String client_id, String client_secret, String scope, String state, String client_auth, String refresh_token_url, String auth_request, String token_request, String refresh_request);


    @Modifying
    @Transactional
    @Query(value = "UPDATE air_thing_configuration SET device_id = NULL WHERE clientId = ?1", nativeQuery = true)
    void deleteAirthingconfiguration(String id);
}
