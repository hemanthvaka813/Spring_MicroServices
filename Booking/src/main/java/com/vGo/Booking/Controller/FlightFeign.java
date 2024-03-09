package com.vGo.Booking.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vGo.Booking.DTO.FlightDTO;

@FeignClient(name="Flight",url="http://localhost:8117")
public interface FlightFeign {
	
	@RequestMapping(value="/vGo/flight/{flightId}")
	ResponseEntity<FlightDTO> getFlightss(@PathVariable("flightId") String flightId);

}
