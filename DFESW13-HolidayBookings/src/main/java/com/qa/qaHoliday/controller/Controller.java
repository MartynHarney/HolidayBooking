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
import com.qa.qaHoliday.services.ServicesDB;

@RestController
public class Controller {
	
	
	
	private ServicesDB service;
	
	public Controller(ServicesDB service) {
		super();
		this.service = service;
	}

	@PostMapping("/createBooking")
	public ResponseEntity<String> createBooking(@RequestBody HolidayBooking booking) {
		System.out.println(booking);
		service.createBooking(booking);
		ResponseEntity<String> response = new ResponseEntity<String>("Booking added with ID: " + booking.getId(), HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<HolidayBooking> getByid(@PathVariable("id") long id) {
		HolidayBooking result = service.getByid(id);
		ResponseEntity<HolidayBooking> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable("id") long id) {
		service.remove(id);
		String response = "Booking of id: " + id + "has been deleted";
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}


	@GetMapping("/getBookings")
	public ResponseEntity<ArrayList<HolidayBooking>> getBookings() {
		ArrayList<HolidayBooking> response = (ArrayList<HolidayBooking>) service.getBookings();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
		
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateByid(@PathVariable("id")long id, @RequestBody HolidayBooking booking){
		service.update(id, booking);
		String response = "Updating booking of id: " + id;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll(){
		service.deleteAll();
		return new ResponseEntity<>("All bookings deleted", HttpStatus.ACCEPTED);
	}


}
