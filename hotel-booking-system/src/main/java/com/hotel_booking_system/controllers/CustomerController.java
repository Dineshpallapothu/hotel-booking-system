package com.hotel_booking_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hotel_booking_system.entities.Customer;
import com.hotel_booking_system.repositories.CustomerRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class CustomerController {
	@Autowired
	CustomerRepo customerrepo;

	// List of all customer details
	@Operation(summary = " All the customer", description = "It can retrive all the costumer details")
	@GetMapping("/getallcust")
	public List<Customer> getall() {
		if(customerrepo.findAll().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"its doesnt contain anythings");
		}
		else {
			List<Customer> customers= customerrepo.findAll();
			return customers;
		}
		
	}
}
