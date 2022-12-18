package com.AirQualityManagement.AQMS.Service;
 import com.AirQualityManagement.AQMS.model.Sensor;


import java.util.List;

import org.springframework.stereotype.Service;
@Service



public interface SensorService {
	Sensor saveSensors(Sensor sensor);
	List<Sensor> getAllSensors();
	Sensor getSensorById(long id);
	Sensor updateSensors(Sensor sensor, long id);
	void deleteSensors(long id);
}