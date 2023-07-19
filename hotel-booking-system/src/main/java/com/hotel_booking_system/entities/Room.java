package com.hotel_booking_system.entities;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rooms")
public class Room {
	@Id
	private int roomnumber;
	private int floor;
	private String roomtype;
	private String bedtype;
	private Double tariff;
	private String roomstatus;

	@OneToMany(mappedBy = "room")
	@JsonIgnore
	private List<BookingHistory> bookinghistories;

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getBedtype() {
		return bedtype;
	}

	public void setBedtype(String bedtype) {
		this.bedtype = bedtype;
	}

	public Double getTariff() {
		return tariff;
	}

	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}

	public String getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(String roomstatus) {
		this.roomstatus = roomstatus;
	}

	public List<BookingHistory> getBookinghistories() {
		return bookinghistories;
	}

	public void setBookinghistories(List<BookingHistory> bookinghistories) {
		this.bookinghistories = bookinghistories;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bedtype, bookinghistories, floor, roomnumber, roomstatus, roomtype, tariff);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return Objects.equals(bedtype, other.bedtype) && Objects.equals(bookinghistories, other.bookinghistories)
				&& floor == other.floor && roomnumber == other.roomnumber
				&& Objects.equals(roomstatus, other.roomstatus) && Objects.equals(roomtype, other.roomtype)
				&& Objects.equals(tariff, other.tariff);
	}

	@Override
	public String toString() {
		return "Room [roomnumber=" + roomnumber + ", floor=" + floor + ", roomtype=" + roomtype + ", bedtype=" + bedtype
				+ ", tariff=" + tariff + ", roomstatus=" + roomstatus + ", bookinghistories=" + bookinghistories + "]";
	}

}
