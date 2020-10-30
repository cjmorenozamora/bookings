package cjmorenozamora.booking.dtos.requests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateAvailabilityRequest {

	@NotNull(message = "Hotel is mandatory")
	private Integer hotel;
	
	@NotNull(message = "Entry date is mandatory")
	private LocalDate entryDate;
	
	@NotNull(message = "Exit date is mandatory")
	private LocalDate exitDate;
	
	@NotNull(message = "Number rooms is mandatory")
	private Integer rooms;
}
