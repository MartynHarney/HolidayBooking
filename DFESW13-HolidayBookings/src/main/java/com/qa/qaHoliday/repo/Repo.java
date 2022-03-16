package com.qa.qaHoliday.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.qaHoliday.model.HolidayBooking;

public interface Repo extends JpaRepository<HolidayBooking, Long> {
	

}
