package cjmorenozamora.booking.dtos.requests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;

import cjmorenozamora.booking.validations.constraint.DateCreateAvailabilityConstraint;
import lombok.Data;

@Data
@DateCreateAvailabilityConstraint(message = "Dates are incorrect")
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
