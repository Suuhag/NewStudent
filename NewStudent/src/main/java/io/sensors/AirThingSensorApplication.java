package io.sensors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})
//@EnableJpaRepositories("io.sensors.Repository")
//@ComponentScan("io.sensors.Repository")
public class AirThingSensorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirThingSensorApplication.class, args);
    }

}
