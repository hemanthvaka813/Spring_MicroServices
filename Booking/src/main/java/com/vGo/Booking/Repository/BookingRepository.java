package com.vGo.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vGo.Booking.Entity.Ticket;

@Repository
public interface BookingRepository extends JpaRepository< Ticket, Integer>{

}
