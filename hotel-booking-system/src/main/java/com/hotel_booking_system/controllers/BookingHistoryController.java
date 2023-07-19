package com.hotel_booking_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hotel_booking_system.entities.BookingHistory;
import com.hotel_booking_system.repositories.BookingHisoryrepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class BookingHistoryController {

	@Autowired
	BookingHisoryrepo bookinghisoryrepo;

	// List of booking history by given customer id
	@Operation(summary = "Get booking history", description = "Get booking history of given customer id")
	@GetMapping("/get/bookinghistory/customer/{id}")
	public List<BookingHistory> getbookinghistorybycustid(@PathVariable("id") int id) {
		List<BookingHistory> bh=bookinghisoryrepo.findByCustomer_Customerid(id);
		if(bh.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"unable to identify");
		}else {
			return bh;
		}
		
	}

	// add a new booking history with relevant details
	@Operation(summary = "Insert the booking history", description = "Insert the relevant data in booking history")
	@PostMapping("/insert/data")
	public BookingHistory insert(@RequestBody BookingHistory bookinghistory) {
		int id=bookinghistory.getBookinghistoryid();
		BookingHistory bh=bookinghisoryrepo.findById(id).get();
		if (bookinghistory == null || bh.equals(bookinghistory)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Try again");
		} else {
			bookinghisoryrepo.save(bookinghistory);
		}
		return bookinghistory;
	}
}
