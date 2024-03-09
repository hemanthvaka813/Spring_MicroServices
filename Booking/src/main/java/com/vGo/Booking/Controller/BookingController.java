package com.vGo.Booking.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vGo.Booking.DTO.BookingDTO;
import com.vGo.Booking.DTO.FlightDTO;
import com.vGo.Booking.DTO.PassengerDTO;
import com.vGo.Booking.Entity.CreditCard;
import com.vGo.Booking.Entity.Passenger;
import com.vGo.Booking.Entity.Ticket;
import com.vGo.Booking.Repository.CreditCardRepository;
import com.vGo.Booking.Service.BookingService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.validation.Valid;

@RestController
public class BookingController {
	
	//protected Logger logger = Logger.getLogger(BookingController.class.getName());
	
	@Autowired
	private BookingService ticketService;
	private Ticket ticket;
	private int noOfSeats;
		
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	FlightFeign ffeign;
	
	
	public BookingController() {
		ticket = new Ticket();		
	}
	
	
	
	@Autowired
	private CreditCardRepository creditCardRepository;

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public ResponseEntity<Boolean> validateCreditCard(@RequestBody CreditCard creditCard) {
		CreditCard cardDetails;
		boolean result = false;
		try {

			cardDetails =  creditCardRepository.findById(creditCard.getCardNumber()).get();
	
			
			if (cardDetails != null) {
				result = creditCard.getApin().equals(cardDetails.getApin())
						&& creditCard.getCvv().equals(cardDetails.getCvv())
						&& creditCard.getCardHolderName().equals(cardDetails.getCardHolderName());
				
			}
			
		} catch (Exception a) {
			
			return new ResponseEntity<Boolean>(result, HttpStatus.OK);
		}

		return new ResponseEntity<Boolean>(result, HttpStatus.OK);

	}

    @CircuitBreaker(name="Flightservice", fallbackMethod="BookingFallBack")
	@PostMapping(value = "/{flightId}/{username}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BookingDTO> bookFlight(@PathVariable("flightId") String flightId,
		 @Valid @RequestBody PassengerDTO passengerDetails, @PathVariable("username") String username) {
			  	
		List<Passenger> passengerList = new ArrayList<Passenger>();
		for (Passenger passengers : passengerDetails.getPassengerList()) {
			passengerList.add(passengers);
		    

		}
		System.out.println(passengerList.toString());

		int pnr = (int) (Math.random() * 1858955);

		ticket.setPnr(pnr);
		PassengerDTO psd=new PassengerDTO();
        // ResponseEntity<FlightDTO> flightDTO=restTemplate.getForEntity("http://Flight/vGo/flight/"+flightId, FlightDTO.class);
		ResponseEntity<FlightDTO> flightDTO=ffeign.getFlightss(flightId);
 		FlightDTO flight=flightDTO.getBody();

		double fare = flight.getFare();
		System.out.println("Fare per person:****** " + fare);
		System.out.println("List size:****** " + passengerDetails.getPassengerList().size());
		double totalFare = fare * (passengerDetails.getPassengerList().size());

		BookingDTO bookingDetails = new BookingDTO();
		psd.setPassengerList(passengerList);
		bookingDetails.setPassDTO(psd);
		ticket.setBookingDate(new Date());
		System.out.println(ticket.getBookingDate());
		ticket.setDepartureTime(flight.getDepartureTime());
		ticket.setFlightId(flight.getFlightId());
		ticket.setUserId(username);	
        ticket.setDepartureDate(flight.getFlightAvailableDate());
		ticket.setTotalFare(totalFare);
		noOfSeats = passengerDetails.getPassengerList().size();
		ticket.setNoOfSeats(noOfSeats);
	    ticketService.createTicket(ticket);
	    bookingDetails.setTicket(ticket);
    
		addPassengers(bookingDetails.getPassDTO().getPassengerList());
		
		//flightService.updateFlight(flightId, noOfSeats);
		System.out.println("Hemanth..");

		return new ResponseEntity<BookingDTO>(bookingDetails, HttpStatus.OK);

	}

	private void addPassengers(List<Passenger> passengers) {
		
		for (Passenger passenger : passengers) {
			passenger.setPnr(ticket.getPnr());	    

		}

		ticketService.createPassenger(passengers);

	}
	
	public String BookingFallBack(String flightId,Throwable throwable) {
		
			return " Due to Technical Isuues our services are not working wait for some time";
		
		
	}

}
