package com.vGo.Flight.DTO;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class FlightDTO {
	
	@NotEmpty(message = "Please enter the origin")
	@NotNull(message = "Soource is mandatory")
	private String source;

	@NotEmpty(message = "Please enter the destination")
	@NotNull(message = "Destination is mandatory")
	private String destination;
	@NotEmpty(message = "Please enter the journey date")
	@NotNull(message = "Journey date is mandatory")
	private Date journeyDate;

	private double fare;
	private String flightId;

	private String seatCount;
	private String departureTime;
	private String arrivalTime;
	private String airlines;
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
	public Date getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double d) {
		this.fare = d;
	}
	public String getFlightId() {
		return flightId;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}
	public String getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(String seatCount) {
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
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	
	
}
