package com.hotel_booking_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel_booking_system.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}
