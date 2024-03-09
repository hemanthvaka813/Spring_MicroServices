package com.vGo.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vGo.Booking.Entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, String> {

}
