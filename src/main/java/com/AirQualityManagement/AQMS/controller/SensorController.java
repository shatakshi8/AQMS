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

/*
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class SensorController {

  @Autowired
  SensorRepository sensorRepository; 

	

  @GetMapping("/sensor")
  public ResponseEntity<List<Sensor>> getAllSensors(@RequestParam(required = false) int Floor) {
    try {
      List<Sensor> sensors = new ArrayList<Sensor>();

      if ( Floor == 0)
        sensorRepository.findAll().forEach(sensors::add);
      else
        sensorRepository.findByFloor(Floor).forEach(sensors::add);

      if (sensors.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(sensors, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/sensors/{id}")
  public ResponseEntity<Sensor> getSensorById(@PathVariable("id") long id) {
    Optional<Sensor> sensorData = sensorRepository.findById(id);

    if (sensorData.isPresent()) {
      return new ResponseEntity<>(sensorData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/sensors")
  public ResponseEntity<Sensor> createSensor(@RequestBody Sensor sensor) {
    try {
      Sensor _sensor = sensorRepository
          .save(new Sensor(sensor.getFloor(),sensor.getSO2() ,sensor.getNO2(),sensor.getCO2(),sensor.getSO() ));
      return new ResponseEntity<>(_sensor, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/sensors/{id}")
  public ResponseEntity<Sensor> updateSensor(@PathVariable("id") long id, @RequestBody Sensor sensor) {
    Optional<Sensor> sensorData = sensorRepository.findById(id);

    if (sensorData.isPresent()) {
      Sensor _sensor = sensorData.get();
      _sensor.setFloor(sensor.getFloor());
_sensor.setSO2(sensor.getSO2());
_sensor.setNO2(sensor.getNO2());
_sensor.setCO2(sensor.getCO2());
      
      return new ResponseEntity<>(sensorRepository.save(_sensor), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/sensors/{id}")
  public ResponseEntity<HttpStatus> deleteSensor(@PathVariable("id") long id) {
    try {
      sensorRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/sensors")
  public ResponseEntity<HttpStatus> deleteAllSensors() {
    try {
      sensorRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @GetMapping("/tutorials/published")
  public ResponseEntity<List<Tutorial>> findByPublished() {
    try {
      List<Tutorial> tutorials = tutorialRepository.findByPublished(true);

      if (tutorials.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(tutorials, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  } */

