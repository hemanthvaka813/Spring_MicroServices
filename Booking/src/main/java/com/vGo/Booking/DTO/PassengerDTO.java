package com.vGo.Booking.DTO;

import java.util.List;

import com.vGo.Booking.Entity.Passenger;

import jakarta.validation.constraints.NotEmpty;

public class PassengerDTO {
	
	@NotEmpty(message = "Passenger List cannot be empty for booking!")
	List<Passenger> passengerList;
    

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public PassengerDTO() {
		super();
	}

	public PassengerDTO(List<Passenger> passengerList) {
		super();
		this.passengerList = passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerList=" + passengerList + "]";
	}

}
