package com.qa.qaHoliday.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.qaHoliday.model.HolidayBooking;
import com.qa.qaHoliday.repo.Repo;

@Service
public class ServicesDB {
	
	private Repo repo;

	public ServicesDB(Repo repo) {
		super();
		this.repo = repo;
	}

	public boolean createBooking(HolidayBooking booking) {
		repo.save(booking);
		return true;
		
	}


	public boolean remove(long id) {
		repo.deleteById(id);
		return true;
		
	}

	public List<HolidayBooking> getBookings() {
		return repo.findAll();
	}

	public void update(long id, HolidayBooking booking) {
		HolidayBooking oldBooking = getByid(id);
		
		oldBooking.setCountry(booking.getCountry());
		oldBooking.setWeather(booking.getWeather());
		oldBooking.setPrice(booking.getPrice());
		oldBooking.setAllInclusive(booking.isAllInclusive());
		
		
	}

	public boolean deleteAll() {
		repo.deleteAll();
		return true;
		
	}

	public HolidayBooking getByid(long id) {
		return repo.findById(id).get();
	}


}
