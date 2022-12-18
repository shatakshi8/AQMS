package com.AirQualityManagement.AQMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.AirQualityManagement.AQMS."})
public class AqmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AqmsApplication.class, args);
	}

}


 