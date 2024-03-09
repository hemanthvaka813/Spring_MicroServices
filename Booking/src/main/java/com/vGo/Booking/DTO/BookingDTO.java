package com.vGo.Booking.DTO;




import com.vGo.Booking.Entity.Ticket;


public class BookingDTO {
	
	
	private PassengerDTO passDTO;
	private Ticket ticket;
	
	
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public PassengerDTO getPassDTO() {
		return passDTO;
	}

	public void setPassDTO(PassengerDTO passDTO) {
		this.passDTO = passDTO;
	}


}
