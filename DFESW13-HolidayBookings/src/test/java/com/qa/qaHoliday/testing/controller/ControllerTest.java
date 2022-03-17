package com.qa.qaHoliday.testing.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.qaHoliday.model.HolidayBooking;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	HolidayBooking testBooking = new HolidayBooking("test country", "test weather", 1, true);
	
	@BeforeAll
	public void setup() throws Exception {
		
		String bookingJson = mapper.writeValueAsString(testBooking);
		RequestBuilder req = post("/createBooking").contentType(MediaType.APPLICATION_JSON).content(bookingJson);
		mvc.perform(req);
		
	}
	
	@Test
	public void testCreate() throws Exception {
		String bookingJson = mapper.writeValueAsString(testBooking);
		RequestBuilder req = post("/createBooking").contentType(MediaType.APPLICATION_JSON).content(bookingJson);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().string("Booking added with ID: 6");
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	public void testGetId() throws Exception {
		HolidayBooking testBookingId = testBooking;
		testBookingId.setId(6l);
		String testBookingIdJson = mapper.writeValueAsString(testBookingId);
		RequestBuilder req = get("/getId/6");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testBookingIdJson);
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
}
