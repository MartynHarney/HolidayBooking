package com.qa.qaHoliday.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class HolidayBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 30)
	private String country;
	@Column(nullable = false, length = 25)
	private String weather;
	@Column(nullable = false)
	private float price;
	@Column(nullable = false)
	private boolean allInclusive;
	
	
	public HolidayBooking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HolidayBooking(long id, String country, String weather, float price, boolean allInclusive) {
		super();
		this.id = id;
		this.country = country;
		this.weather = weather;
		this.price = price;
		this.allInclusive = allInclusive;
	}


	public HolidayBooking(String country, String weather, float price, boolean allInclusive) {
		super();
		this.country = country;
		this.weather = weather;
		this.price = price;
		this.allInclusive = allInclusive;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getWeather() {
		return weather;
	}


	public void setWeather(String weather) {
		this.weather = weather;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public boolean isAllInclusive() {
		return allInclusive;
	}


	public void setAllInclusive(boolean allInclusive) {
		this.allInclusive = allInclusive;
	}


	@Override
	public int hashCode() {
		return Objects.hash(allInclusive, country, id, price, weather);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HolidayBooking other = (HolidayBooking) obj;
		return allInclusive == other.allInclusive && Objects.equals(country, other.country) && id == other.id
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& Objects.equals(weather, other.weather);
	}

}
