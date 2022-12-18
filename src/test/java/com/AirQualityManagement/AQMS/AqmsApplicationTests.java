package com.AirQualityManagement.AQMS;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.AirQualityManagement.AQMS.model.Sensor;
import com.AirQualityManagement.AQMS.repsitory.SensorRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AqmsApplicationTests {

	@Autowired
	SensorRepository sensorRepository;
	
	@Test
	@Order(1)
	public void testCreate () {
		
		Sensor s= new Sensor();
		s.setId(4L);
		s.setFloor(2);
		s.setSO2(23);
		s.setNO2(34);
		s.setCO2(56);
		s.setSO(55);
		
		sensorRepository.save(s);
		
		/*	Sensor s = new Sensor();
	s.setId(12L);
	
		s.setFloor(1);
		s.setSO2(11);
		s.setNO2(12);
		s.setCO2(1);
		s.setSO(11);
		
		sensorRepository.save(s); */
		
		//System.out.println(s.getId());
	assertNotNull(sensorRepository.findById(4L).get());    
	
	} 
	
	@Test
	@Order(2)
	public void testReadAll () {
		List<Sensor> list = sensorRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testRead () {
		Sensor sensor = sensorRepository.findById(3L).get();
		assertEquals(4, sensor.getFloor());
	}
	
	
	@Test
	@Order(4)
	public void testUpdate () {
		Sensor s = sensorRepository.findById(3L).get();
		s.setFloor(4);
		s.setSO2(36);
		s.setNO2(68);
		s.setCO2(88);
		s.setSO(79);
		sensorRepository.save(s);
		assertNotEquals(3, sensorRepository.findById(3L).get().getFloor());
	}
	
	
	@Test
	@Order(5)
	public void testDelete () {
		sensorRepository.deleteById(4L);
		assertThat(sensorRepository.existsById(4L)).isFalse();
	}
}