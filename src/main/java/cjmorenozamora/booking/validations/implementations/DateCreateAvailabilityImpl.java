package cjmorenozamora.booking.validations.implementations;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cjmorenozamora.booking.dtos.requests.BookingRequest;
import cjmorenozamora.booking.dtos.requests.CreateAvailabilityRequest;
import cjmorenozamora.booking.validations.constraint.DateCreateAvailabilityConstraint;

public class DateCreateAvailabilityImpl implements ConstraintValidator<DateCreateAvailabilityConstraint, CreateAvailabilityRequest> {

	@Override
	public boolean isValid(CreateAvailabilityRequest availabilityRequest, ConstraintValidatorContext context) {
		boolean resultado = true;
		LocalDate entryDate = availabilityRequest.getDateFrom();
		LocalDate exitDate = availabilityRequest.getDateTo();

		if ((entryDate == null || exitDate == null) || (entryDate.isBefore(LocalDate.now()))
				|| (exitDate.compareTo(entryDate) < 0)) {

			resultado = false;
		}

		return resultado;

	}
}
