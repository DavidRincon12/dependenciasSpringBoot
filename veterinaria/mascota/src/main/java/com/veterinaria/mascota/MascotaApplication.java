package com.veterinaria.mascota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class MascotaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MascotaApplication.class, args);
	}

}
