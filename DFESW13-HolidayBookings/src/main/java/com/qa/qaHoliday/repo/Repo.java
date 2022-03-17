package com.qa.qaHoliday.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.qaHoliday.model.HolidayBooking;

public interface Repo extends JpaRepository<HolidayBooking, Long> {
	

	public List<HolidayBooking> findByCountry(String country);
	
	public List<HolidayBooking> findByWeather(String weather);

	public List<HolidayBooking> findByPriceGreaterThan(float price);
	
	public List<HolidayBooking> findByAllInclusive(boolean bool);
	
	public List<HolidayBooking> findByOrderByCountryAsc();
	
	public List<HolidayBooking> findByOrderByPriceDesc();

}

