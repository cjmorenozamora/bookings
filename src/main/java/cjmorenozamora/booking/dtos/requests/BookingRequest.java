package cjmorenozamora.booking.dtos.requests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import cjmorenozamora.booking.validations.constraint.DateCreateBookingConstraint;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@DateCreateBookingConstraint(message = "Dates are incorrect")
public class BookingRequest {

	@NotNull(message = "Hotel id is mandatory")
	private Integer hotel;

	@NotNull(message = "Entry date id is mandatory")
	private LocalDate entryDate;

	@NotNull(message = "Exit date is mandatory")
	private LocalDate exitDate;

	@NotNull(message = "Email is mandatory")
	private String email;
}
