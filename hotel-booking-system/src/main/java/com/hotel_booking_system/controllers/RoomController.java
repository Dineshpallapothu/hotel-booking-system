package com.hotel_booking_system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.hotel_booking_system.entities.BookingHistory;
import com.hotel_booking_system.entities.Room;
import com.hotel_booking_system.repositories.BookingHisoryrepo;
import com.hotel_booking_system.repositories.RoomRepo;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@CrossOrigin
public class RoomController {
	@Autowired
	RoomRepo roomrepo;
	@Autowired
	BookingHisoryrepo bookinghistoryrepo;

	// List of rooms
	@Operation(summary = "Retrive all rooms", description = "It can retrive all room details")
	@GetMapping("/getallrooms")
	public List<Room> getallroom() {
		List<Room> rooms=roomrepo.findAll();
		
		if(rooms.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"sorry you dont have");
		}
		else {
			return rooms;
		}
	}

	// List of rooms in a given type
	@Operation(summary = "Retrive all rooms`by roomtype", description = "it can retrive all room by given type")
	@GetMapping("/getroom")
	public List<Room> getroombytype(@RequestParam(required=false) String type) {
		List<Room> rooms=roomrepo.findByRoomtype(type);
		if(rooms.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"sorry you dont have");
		}
		else {
			return rooms;
		}
		
	}

	// list of rooms in a given room type and bed type that are currently
	@Operation(summary = "Find rooms given type", description = " ")
	@GetMapping("/getroom/roomtype/{roomtype}/bedtype/{bedtype}")
	public List<Room> getroomgiventype(@PathVariable("roomtype") String roomtype,
			@PathVariable("bedtype") String bedtype) {
		return roomrepo.findByRoomtypeAndBedtypeAndRoomstatus(roomtype, bedtype, "available");
	}

	// rooms are available in the given type
	@Operation(summary = "We can get available`rooms", description = "We can get available rooms by given date and roomtype and bedtype")
	@GetMapping("/getavailable")
	public String getavailable(@RequestParam("rtype") String rtype, @RequestParam("sdate") String sdate,
			@RequestParam("edate") String edate, @RequestParam("btype") String btype) {
		int num = roomrepo.getavailable(rtype, sdate, edate, btype);
		return "available rooms  " + num;
	}

	// room avilable in the given dates and room type
	@Operation(summary = "Update status", description = "It can update the status of room")
	@PutMapping("/update/{roomnumber}/{status}")
	public Room insert(@PathVariable("roomnumber") int roomnumber, @PathVariable("status") String status) {
		var obj = roomrepo.findByRoomnumber(roomnumber);
		if (obj != null) {
			obj.setRoomstatus(status);
			roomrepo.save(obj);

			return obj;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "sorry");
		}

	}

	// handle check out
	@Operation(summary = "Insert and update ", description = "We can update room status and insert the booking history data")
	@PostMapping("/insertandupdate")
	public BookingHistory insert(@RequestParam("roomnumber") int roomnumber, @RequestParam("status") String status,
			@RequestBody BookingHistory bookinghistory) {
		var rooms = roomrepo.findById(roomnumber);
		if (rooms.isPresent()) {
			Room room = rooms.get();
			room.setRoomstatus(status);
			roomrepo.save(room);

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "room not found");
		}
		if (bookinghistory == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "check data once");
		} else {
			bookinghistoryrepo.save(bookinghistory);
		}

		return bookinghistory;

	}
}
