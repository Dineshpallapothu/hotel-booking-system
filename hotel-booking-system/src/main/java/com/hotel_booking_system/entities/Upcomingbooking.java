package com.hotel_booking_system.entities;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Upcomingbooking")
public class Upcomingbooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int upcombookid;
	private int customerid;
	private Date startdate;
	private String roomtype;
	private String bedtype;
	private int Noofrooms;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerid", updatable = false, insertable = false)
	@JsonIgnore
	private Customer customer;

	public int getUpcombookid() {
		return upcombookid;
	}

	public void setUpcombookid(int upcombookid) {
		this.upcombookid = upcombookid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
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

	public int getNoofrooms() {
		return Noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		Noofrooms = noofrooms;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Noofrooms, bedtype, customer, customerid, roomtype, startdate, upcombookid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Upcomingbooking other = (Upcomingbooking) obj;
		return Noofrooms == other.Noofrooms && Objects.equals(bedtype, other.bedtype)
				&& Objects.equals(customer, other.customer) && customerid == other.customerid
				&& Objects.equals(roomtype, other.roomtype) && Objects.equals(startdate, other.startdate)
				&& upcombookid == other.upcombookid;
	}

	@Override
	public String toString() {
		return "Upcomingbooking [upcombookid=" + upcombookid + ", customerid=" + customerid + ", startdate=" + startdate
				+ ", roomtype=" + roomtype + ", bedtype=" + bedtype + ", Noofrooms=" + Noofrooms + ", customer="
				+ customer + "]";
	}

}
