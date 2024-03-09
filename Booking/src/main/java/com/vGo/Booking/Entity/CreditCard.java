package com.vGo.Booking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Credit_Card")
public class CreditCard {
	
	@Id
	private String cardNumber;

	private String cardHolderName;

	private String cvv;

	private String apin;

	private String expiryMonth;

	private String expiryYear;
	private String totalBill;

	
	public String getCardNumber() {
		return cardNumber;
	}

	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	public String getCardHolderName() {
		return cardHolderName;
	}

	
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	
	public String getCvv() {
		return cvv;
	}

	
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	
	public String getApin() {
		return apin;
	}

	
	public void setApin(String apin) {
		this.apin = apin;
	}

	
	public String getExpiryMonth() {
		return expiryMonth;
	}

	
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	
	public String getExpiryYear() {
		return expiryYear;
	}

	/**
	 * @param expiryYear the expiryYear to set
	 */
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	/**
	 * @return the totalBill
	 */
	public String getTotalBill() {
		return totalBill;
	}

	
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}

	@Override
	public String toString() {
		return "CreditCardDetails [cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", cvv=" + cvv
				+ ", apin=" + apin + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", totalBill="
				+ totalBill + "]";
	}

}
