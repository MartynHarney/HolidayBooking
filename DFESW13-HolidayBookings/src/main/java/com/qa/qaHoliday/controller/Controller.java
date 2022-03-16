package com.qa.qaHoliday.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.qaHoliday.model.HolidayBooking;

//@RestController
public class Controller {
	
	private ArrayList<HolidayBooking> bookingList = new ArrayList<>();
	
	@GetMapping("/getBookings")
	public ArrayList<HolidayBooking> getBookings() {
		return bookingList;
	}

	@PostMapping("/createSetBooking")
	public boolean createSetBooking() {
		bookingList.add(new HolidayBooking("Wales", "rainy", 14f, true));
		return true;
	}

	@PostMapping("/createBooking")
	public boolean createBooking(@RequestBody HolidayBooking booking) {
		System.out.println(booking);
		booking.setId(bookingList.size() + 1);
		bookingList.add(booking);
		return true;
	}
	
	@GetMapping("/get/{index}")
	public HolidayBooking getByIndex(@PathVariable("index") int index) {
		return bookingList.get(index);
	}
	
	@DeleteMapping("/delete/{index}")
	public boolean deleteByIndex(@PathVariable("index") int index) {
		bookingList.remove(index);
		return true;
	}

	@DeleteMapping("/deleteAll")
	public boolean deleteAll() {
		bookingList.clear();
		return true;
	}

	@PutMapping("/update/{index}")
	public boolean update(@PathVariable("index")int index, @RequestBody HolidayBooking booking) {
		bookingList.set(index, booking);
		System.out.println("Object of index " + index + "updated.");
		return true;
	}
	
	@PostMapping("/postArray")
	public boolean addArrayBookings(@RequestBody HolidayBooking[] bookingArray) {
		for(HolidayBooking booking : bookingArray) {
			bookingList.add(booking);
		}
		return true;
	}
	

	@PutMapping("/updateByCountry/{value}")
	public boolean updateAllObjects(@PathVariable("query") String query, @PathVariable("value") String value, @RequestBody HolidayBooking booking) {
		
		int i = 0;
		
		for(HolidayBooking bookingObj : bookingList) {
			if(bookingObj.getCountry() == value) {
				System.out.println(i);
				bookingList.set(i, booking);
				
				bookingObj.setCountry(booking.getCountry());
				bookingObj.setAllInclusive(booking.isAllInclusive());
				bookingObj.setPrice(booking.getPrice());
				bookingObj.setWeather(booking.getWeather());
			}
			i++;
		}
	return true;
	}
	




}
