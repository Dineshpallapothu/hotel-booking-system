package com.hotel_booking_system.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	private String customername;
	private String email;
	private String mobile;
	private String gender;

	@OneToMany(mappedBy = "customer")
	private List<BookingHistory> bookinghistories;

	@OneToMany
	@JsonIgnore
	private List<Upcomingbooking> upcomingbookings;

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@JsonIgnore
	public List<BookingHistory> getBookingHistory() {
		return bookinghistories;
	}

	public void setBookingHistory(List<BookingHistory> bookingHistory) {
		bookinghistories = bookingHistory;
	}

	public List<Upcomingbooking> getUpcomingbookings() {
		return upcomingbookings;
	}

	public void setUpcomingbookings(List<Upcomingbooking> upcomingbookings) {
		this.upcomingbookings = upcomingbookings;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookinghistories, customerid, customername, email, gender, mobile, upcomingbookings);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(bookinghistories, other.bookinghistories) && customerid == other.customerid
				&& Objects.equals(customername, other.customername) && Objects.equals(email, other.email)
				&& Objects.equals(gender, other.gender) && Objects.equals(mobile, other.mobile)
				&& Objects.equals(upcomingbookings, other.upcomingbookings);
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", email=" + email
				+ ", mobile=" + mobile + ", gender=" + gender + ", BookingHistory=" + bookinghistories
				+ ", upcomingbookings=" + upcomingbookings + "]";
	}

}
