package com.AirQualityManagement.AQMS.Service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.AirQualityManagement.AQMS.Exception.exception;
import com.AirQualityManagement.AQMS.model.Sensor;
import com.AirQualityManagement.AQMS.repsitory.SensorRepository;
import com.AirQualityManagement.AQMS.Service.SensorService;

@Service
public class SensorServiceImpl implements SensorService {
private SensorRepository sensorRepository;
	
	public SensorServiceImpl(SensorRepository sensorRepository) {
		super();
		this.sensorRepository = sensorRepository;
	}

	public  Sensor saveSensors(Sensor sensor) {
		return sensorRepository.save(sensor);
	}

	public List<Sensor> getAllSensors() { 
		return sensorRepository.findAll();
	}

	public Sensor getSensorById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		return sensorRepository.findById(id).orElseThrow(() -> 
						new exception("Sensor", "Id", id));
		 
	}

	public Sensor updateSensors(Sensor sensor, long id) {
		
		// we need to check whether sensor with given id is exist in DB or not
		Sensor existingSensor = sensorRepository.findById(id).orElseThrow(
				() -> new exception("Sensor", "Id", id)); 
		
		existingSensor.setFloor(sensor.getFloor());
		existingSensor.setSO2(sensor.getSO2());
		existingSensor.setNO2(sensor.getNO2());
		existingSensor.setCO2(sensor.getCO2());
		existingSensor.setSO(sensor.getSO());
		
		// save existing employee to DB
		sensorRepository.save(existingSensor);
		return existingSensor;
	}

	public void deleteSensors(long id) {
		
		// check whether a sensor value exist in a DB or not
		sensorRepository.findById(id).orElseThrow(() -> 
								new exception("Sensor", "Id", id));
		sensorRepository.deleteById(id);
	}

}
