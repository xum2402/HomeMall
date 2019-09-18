package com.mall.malladmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableAdminServer
public class MalladminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MalladminApplication.class, args);
    }

}
