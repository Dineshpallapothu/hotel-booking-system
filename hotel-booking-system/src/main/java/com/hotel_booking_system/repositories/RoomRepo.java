package com.hotel_booking_system.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel_booking_system.entities.Room;

public interface RoomRepo extends JpaRepository<Room, Integer> {

	List<Room> findByRoomtype(String type);

	List<Room> findByRoomtypeAndBedtypeAndRoomstatus(String roomtype, String bedtype, String roomstatus);

	Room findByRoomnumber(int roomNumber);

	@Query(value = "select count(*) as avaible_rooms from Rooms  where Roomstatus='Available' and Roomtype=:rtype and Bedtype=:btype"
			+ " and  not EXISTS (select * from upcomingbooking as h where  Startdate BETWEEN :sdate and :edate)", nativeQuery = true)
	int getavailable(@Param("rtype") String rtype, @Param("sdate") String sdate, @Param("edate") String edate,
			@Param("btype") String btype);
}
