package com.AirQualityManagement.AQMS.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.AirQualityManagement.AQMS.model.Sensor;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirQualityManagement.AQMS.Service.SensorService;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
	
	@Autowired
	private SensorService sensorService;
	
	

	/*public SensorController(SensorService sensorService) {
		super();
		this.sensorService = sensorService;
	} */
	
	// build create sensor REST API
	@PostMapping("createsensors")
	public ResponseEntity<Sensor> saveSensors(@RequestBody Sensor sensor){
		return new ResponseEntity<Sensor>(sensorService.saveSensors(sensor), HttpStatus.CREATED);
	}
	
	// build get all sensor REST API
	@GetMapping("readsensors")
	public List<Sensor> getAllSensors(){
		return sensorService.getAllSensors();
	}
	
	// build get sensor by id REST API
	// http://localhost:8080/api/employees/1
	@GetMapping("{id}")
	public ResponseEntity<Sensor> getSensorById(@PathVariable("id") long sensorId){
		return new ResponseEntity<Sensor>(sensorService.getSensorById(sensorId), HttpStatus.OK);
	}
	
	// build update sensor REST API
	// http://localhost:8080/api/sensor/1
	@PutMapping("{id}")
	public ResponseEntity<Sensor> updateSensors(@PathVariable("id") long id
												  ,@RequestBody Sensor sensor){
		return new ResponseEntity<Sensor>(sensorService.updateSensors(sensor, id), HttpStatus.OK);
	}
	 
	// build delete sensor REST API
	// http://localhost:8080/api/employees/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteSensors(@PathVariable("id") long id){
		
		// delete employee from DB
		sensorService.deleteSensors(id);
		
		return new ResponseEntity<String>("Deleted successfully!.", HttpStatus.OK);
	} 
	
	
}



