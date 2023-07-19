package com.hotel_booking_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel_booking_system.entities.BookingHistory;

public interface BookingHisoryrepo extends JpaRepository<BookingHistory, Integer> {

	List<BookingHistory> findByCustomer_Customerid(int customerid);
}
