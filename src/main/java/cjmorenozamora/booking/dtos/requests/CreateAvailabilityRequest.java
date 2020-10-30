package cjmorenozamora.booking.dtos.requests;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CreateAvailabilityRequest {

	private Integer hotel;
	
	private LocalDate entryDate;
	
	private LocalDate exitDate;
	
	private Integer rooms;
}
