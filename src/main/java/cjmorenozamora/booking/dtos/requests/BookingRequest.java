package cjmorenozamora.booking.dtos.requests;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingRequest {

	private Integer hotel;
	
	private LocalDate entryDate;
	
	private LocalDate exitDate;
	
	private String email;
}
