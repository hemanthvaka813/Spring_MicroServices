package com.vGo.Flight.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="FLIGHT_DETAILS")
public class Flight {
	
	@Id
	private String flightId;
	private String source;
	private String destination;
	private String airlines;
	private double fare;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	@Temporal(TemporalType.DATE)
	private Date flightAvailableDate;
	private Integer seatCount;

	private String departureTime;
	private String arrivalTime;
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public Date getFlightAvailableDate() {
		return flightAvailableDate;
	}
	public void setFlightAvailableDate(Date flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}
	public Integer getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public Flight() {
		
	}
	public Flight(String flightId, String source, String destination, String airlines, double fare,
			Date flightAvailableDate, Integer seatCount, String departureTime, String arrivalTime) {
		super();
		this.flightId = flightId;
		this.source = source;
		this.destination = destination;
		this.airlines = airlines;
		this.fare = fare;
		this.flightAvailableDate = flightAvailableDate;
		this.seatCount = seatCount;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", source=" + source + ", destination=" + destination + ", airlines="
				+ airlines + ", fare=" + fare + ", flightAvailableDate=" + flightAvailableDate + ", seatCount="
				+ seatCount + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + "]";
	}
	
	
	
	
}
