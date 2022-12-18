package com.AirQualityManagement.AQMS.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;







@Entity        //(name="Sensor_Values")  -->can be done like this also
@Table(name = "Sensor")
public class Sensor {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO) 
	
	@Column(name="id")
	private long id;
	
	

	@Column(name = "Floor")
	private int Floor;

	@Column(name = "SO2")
	private int SO2;

	@Column(name = "NO2")
	private int NO2;
	
	@Column(name = "CO2")
	private int CO2;
	
	
	@Column(name = "SO")
	private int SO;

	public Sensor() {

	}

	public Sensor (int id,int Floor, int SO2, int NO2,int CO2,int SO) {
		this.id=id;
		this.Floor=Floor;
		this.SO2=SO2;
		this.NO2=NO2;
		this.CO2=CO2;
		this.SO=SO; 
		
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id=id;
	}
	public int getFloor() {
		return Floor;
	}

	public void setFloor(int Floor) {
		this.Floor = Floor;
	}

	public int getSO2() {
		return SO2;
	}
	public void setSO2(int SO2) {
		this.SO2 = SO2;
	}

	
	public int getNO2() {
		return NO2;
	}
	public void setNO2(int NO2) {
		this.NO2 = NO2;
	}
	public int getCO2() {
		return CO2;
	}
	public void setCO2(int CO2) {
		this.CO2 = CO2;
	}
	public int getSO() {
		return SO;
	}
	public void setSO(int SO) {
		this.SO = SO;
	}

	
	

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", Floor=" +Floor + ", SO2=" + SO2 + ", NO2=" + NO2 +", CO2="+ CO2+", SO2="+ SO + "]";
	}

	

	

	
}