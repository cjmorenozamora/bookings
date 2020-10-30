package cjmorenozamora.booking.dtos.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Booking {

	private Integer bookingId;
	
	private Hotel hotel;
	
	private LocalDate entryDate;
	
	private LocalDate exitDate;
}
