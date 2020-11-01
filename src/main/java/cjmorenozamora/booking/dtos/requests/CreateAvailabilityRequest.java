package cjmorenozamora.booking.dtos.requests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CreateAvailabilityRequest {

	@NotNull(message = "Hotel is mandatory")
	private Integer hotel;
	
	@NotNull(message = "Date from is mandatory")
	private LocalDate dateFrom;
	
	@NotNull(message = "Date to is mandatory")
	private LocalDate dateTo;
	
	@NotNull(message = "Number rooms is mandatory")
	private Integer rooms;
}
