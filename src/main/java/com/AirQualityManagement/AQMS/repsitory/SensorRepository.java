package com.AirQualityManagement.AQMS.repsitory;


import com.AirQualityManagement.AQMS.model.Sensor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface SensorRepository extends JpaRepository<Sensor, Long>{
	
	
	// List<Sensor> findById (long Id);  //defining method in interface , returning list of ids(defined in model) 
	
}

