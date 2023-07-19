package com.hotel_booking_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel_booking_system.entities.Upcomingbooking;

public interface UpCominngBookingrepo extends JpaRepository<Upcomingbooking, Integer> {
	//List<Upcomingbooking> findByCustomer_customerid(int customerid);>
	List<Upcomingbooking> findByCustomerid(int customerid);
}
