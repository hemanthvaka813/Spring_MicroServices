package com.vGo.Flight.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vGo.Flight.DTO.FlightDTO;
import com.vGo.Flight.Entity.Flight;
import com.vGo.Flight.Repository.FlightRepository;

@Service
public class FlightService {
	@Autowired
	private FlightRepository flightRepo;
	
	public List<String> flightDestinations(){
		List<String> n=flightRepo.findFlightDestinations();
		return n;
	}
	public List<String> flightSources(){
		List<String> n=flightRepo.findFlightSources();
		return n;
	}
	
	public List<FlightDTO> availableFlights(String source,String Dest,Date jDate){
		List<Flight> vimanam=flightRepo.findFlightDetails(source, Dest, jDate);
		List<FlightDTO> unnaVimanam=new ArrayList<>();
		for(Flight fuk:vimanam) {
			FlightDTO flights=new FlightDTO();
			flights.setSource(fuk.getSource());
			flights.setDestination(fuk.getDestination());
			flights.setFlightId(fuk.getFlightId());
			flights.setAirlines(fuk.getAirlines());
			flights.setArrivalTime(fuk.getArrivalTime());
			flights.setDepartureTime(fuk.getDepartureTime());
			flights.setFare(fuk.getFare());
			flights.setJourneyDate(fuk.getFlightAvailableDate());
			flights.setSeatCount(fuk.getAirlines());
			unnaVimanam.add(flights);
		}
		return unnaVimanam;
	}
	
	public Flight getFlights(String flightId) {
		return flightRepo.findById(flightId).get();

	}

}
