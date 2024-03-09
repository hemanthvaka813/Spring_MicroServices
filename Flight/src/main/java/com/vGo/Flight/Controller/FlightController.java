package com.vGo.Flight.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vGo.Flight.DTO.FlightDTO;
import com.vGo.Flight.Entity.Flight;
import com.vGo.Flight.Service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {
	
	@Autowired
	private FlightService flightServe;
	
	@GetMapping(value="/Destination")
	public ResponseEntity<List<String>> getDestinations(){
		List<String> res=flightServe.flightDestinations();
		return new ResponseEntity<List<String>>(res,HttpStatus.OK);
	}
	
	@GetMapping("/{flightId}")
	public Flight getFlights(@PathVariable("flightId") String flightId)  {
		if (flightId == "FL001") {
			throw new RuntimeException();
		}
			
		System.out.println("flight id" + flightId);
		return flightServe.getFlights(flightId);
	}
	
	@GetMapping(value="/source")
	public ResponseEntity<List<String>> getSource(){
		List<String> res=flightServe.flightSources();
		return new ResponseEntity<List<String>>(res,HttpStatus.OK);
	}
	
	@GetMapping(value="/{source}/{Destination}/{jDate}")
	public ResponseEntity<List<FlightDTO>> getFlights(@PathVariable ("source") String source,
			@PathVariable("Destination") String Destination,@PathVariable("jDate")@DateTimeFormat(pattern = "dd-MM-yy") Date jDate){
		List<FlightDTO> res=flightServe.availableFlights(source, Destination, jDate);
		return new ResponseEntity<List<FlightDTO>>(res,HttpStatus.OK);
	}

}
