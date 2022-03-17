package com.qa.qaHoliday.controller;

import java.util.ArrayList;
import java.util.List;

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
		service.createBooking(booking);
		ResponseEntity<String> response = new ResponseEntity<String>("Booking added with ID: " + booking.getId(), HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getId/{id}")
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


	@GetMapping("/getCountry/{country}")
	public ResponseEntity<List<HolidayBooking>> getByCountry(@PathVariable("country") String country){
		List<HolidayBooking> response = service.getByCountry(country);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getPrice/{price}")
	public ResponseEntity<List<HolidayBooking>> getByPriceGreater(@PathVariable("price") float price){
		List<HolidayBooking> response = service.getByPriceGreater(price);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllIncl/{bool}")
	public ResponseEntity<List<HolidayBooking>> getByAllInclusive(@PathVariable("bool") boolean bool){
		List<HolidayBooking> response = service.getAllInclusive(bool);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll/sortCountry")
	public ResponseEntity<List<HolidayBooking>> getByAllSortCountry(){
		List<HolidayBooking> response = service.getAllOrderByCountry();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll/sortPrice")
	public ResponseEntity<List<HolidayBooking>> getByAllSortPrice(){
		List<HolidayBooking> response = service.getAllOrderByPrice();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
}
