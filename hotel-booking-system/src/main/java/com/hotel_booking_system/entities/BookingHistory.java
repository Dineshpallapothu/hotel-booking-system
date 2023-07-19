package com.hotel_booking_system.entities;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bookinghistory")
public class BookingHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookinghistoryid;
	@Column(name = "customerid")
	private int customerid;
	@Column(name = "roomnumber")
	private int roomnumber;
	private Date startdate;
	private Date enddate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerid", updatable = false, insertable = false)
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomnumber", referencedColumnName = "roomnumber", updatable = false, insertable = false)
	@JsonIgnore
	private Room room;

	public int getBookinghistoryid() {
		return bookinghistoryid;
	}

	public void setBookinghistoryid(int bookinghistoryid) {
		this.bookinghistoryid = bookinghistoryid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public int getRoomnumber() {
		return roomnumber;
	}

	public void setRoomnumber(int roomnumber) {
		this.roomnumber = roomnumber;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Customer getCust() {
		return customer;
	}

	@JsonIgnore
	public void setCust(Customer cust) {
		this.customer = cust;
	}

	public Room getRoom() {
		return room;
	}

	@JsonIgnore
	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookinghistoryid, customer, customerid, enddate, room, roomnumber, startdate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingHistory other = (BookingHistory) obj;
		return bookinghistoryid == other.bookinghistoryid && Objects.equals(customer, other.customer)
				&& customerid == other.customerid && Objects.equals(enddate, other.enddate)
				&& Objects.equals(room, other.room) && roomnumber == other.roomnumber
				&& Objects.equals(startdate, other.startdate);
	}

	@Override
	public String toString() {
		return "BookingHistory [bookinghistoryid=" + bookinghistoryid + ", customerid=" + customerid + ", roomnumber="
				+ roomnumber + ", startdate=" + startdate + ", enddate=" + enddate + ", customer=" + customer
				+ ", room=" + room + "]";
	}

}
