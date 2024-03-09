package com.vGo.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vGo.Booking.Entity.Passenger;

@Repository
public interface Passengerrepository extends JpaRepository<Passenger, Integer> {

}
