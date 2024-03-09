package com.vGo.Booking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vGo.Booking.Entity.Passenger;
import com.vGo.Booking.Entity.Ticket;
import com.vGo.Booking.Repository.BookingRepository;
import com.vGo.Booking.Repository.Passengerrepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepo;
	@Autowired
	private Passengerrepository passengerRepo;
	
	
	public void createPassenger(List<Passenger> passengers) {

		passengerRepo.saveAll(passengers);

	}
	public void createTicket(Ticket ticket) {

		bookingRepo.saveAndFlush(ticket);

	}

}
