package com.qa.qaHoliday.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.qa.qaHoliday.model.HolidayBooking;
import com.qa.qaHoliday.repo.Repo;

@Service
public class Services {
	
	private Repo repo;
	
	public Services(Repo repo) {
		super();
		this.repo = repo;
	}
	
	public boolean createBookingDB(HolidayBooking booking) {
		repo.save(booking);
		return true;
	}

	private ArrayList<HolidayBooking> bookingList = new ArrayList<>();
	
	public boolean createBooking(HolidayBooking booking) {
		booking.setId(bookingList.size() + 1);
		bookingList.add(booking);
		return true;
	}

	public HolidayBooking getByIndex(int index) {
		return bookingList.get(index);
	}

	public boolean remove(int index) {
		bookingList.remove(index);
		return true;
	}

	public boolean update(int index, HolidayBooking booking) {
		bookingList.set(index, booking);
		return true;
		
	}

	public boolean deleteAll() {
		bookingList.clear();
		return true;
		
	}

	public ArrayList<HolidayBooking> getBookings() {
		return bookingList;
	
	}


}
