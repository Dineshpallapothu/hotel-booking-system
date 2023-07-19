package com.hotel_booking_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hotel_booking_system.entities.Upcomingbooking;
import com.hotel_booking_system.repositories.UpCominngBookingrepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class UpComingBookingController {
	@Autowired
	UpCominngBookingrepo upcominngbookingrepo;

	// List of all upcoming bookings
	@Operation(summary = "  Get upcomig bookings", description = "We will all upcoming booking")
	@GetMapping("/getallupcomingbookings")
	public List<Upcomingbooking> getupcoming() {
		return upcominngbookingrepo.findAll();
	}

	// List of upcoming bookings by given customer id
	@Operation(summary = "Get upcoming booking by id", description = "Get all upcoming bookings by custome id")
	@GetMapping("/getupcoming/customer/{id}")
	public List<Upcomingbooking> getupcomingbycustomer(@PathVariable("id") int id) {
		return upcominngbookingrepo.findByCustomerid(id);
	}

}
