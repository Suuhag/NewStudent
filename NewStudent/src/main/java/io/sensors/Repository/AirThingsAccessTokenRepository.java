package io.sensors.Repository;

import io.sensors.dto.AirthingAccessTokenDTO;
import io.sensors.models.AirThingAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AirThingsAccessTokenRepository extends JpaRepository<AirThingAccessToken, String> {
    @Query(nativeQuery = true)
    Set<AirthingAccessTokenDTO> getaccesstoken(String id);
}

