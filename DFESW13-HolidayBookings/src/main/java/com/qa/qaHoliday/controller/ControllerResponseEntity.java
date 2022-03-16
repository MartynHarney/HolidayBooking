package com.qa.qaHoliday.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.qaHoliday.model.HolidayBooking;
import com.qa.qaHoliday.services.Services;

@RestController
public class ControllerResponseEntity {
	
	
	
	private Services service;
	
	public ControllerResponseEntity(Services service) {
		super();
		this.service = service;
	}

	@PostMapping("/createBooking")
	public ResponseEntity<String> createBooking(@RequestBody HolidayBooking booking) {
		System.out.println(booking);
		service.createBookingDB(booking);
		ResponseEntity<String> response = new ResponseEntity<String>("Booking added with ID: " + booking.getId(), HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/get/{index}")
	public ResponseEntity<HolidayBooking> getByIndex(@PathVariable("index") int index) {
		HolidayBooking result = service.getByIndex(index);
		ResponseEntity<HolidayBooking> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/delete/{index}")
	public ResponseEntity<String> deleteByIndex(@PathVariable("index") int index) {
		service.remove(index);
		String response = "Booking of index: " + index + "has been deleted";
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}


	@GetMapping("/getBookings")
	public ResponseEntity<ArrayList<HolidayBooking>> getBookings() {
		ArrayList<HolidayBooking> response = service.getBookings();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
		
	}

	@PutMapping("/update/{index}")
	public ResponseEntity<String> updateByIndex(@PathVariable("index")int index, @RequestBody HolidayBooking booking){
		service.update(index, booking);
		String response = "Updating booking of index: " + index;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll(){
		service.deleteAll();
		return new ResponseEntity<>("All bookings deleted", HttpStatus.ACCEPTED);
	}


}
