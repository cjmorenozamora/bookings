package cjmorenozamora.booking.validations.implementations;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cjmorenozamora.booking.dtos.requests.BookingRequest;
import cjmorenozamora.booking.validations.constraint.DateCreateBookingConstraint;

public class DateCreateBookingImpl implements ConstraintValidator<DateCreateBookingConstraint, BookingRequest> {

	@Override
	public boolean isValid(BookingRequest bookingRequest, ConstraintValidatorContext context) {
		boolean resultado = true;
		LocalDate entryDate = bookingRequest.getEntryDate();
		LocalDate exitDate = bookingRequest.getExitDate();

		if ((entryDate == null || exitDate == null) || (entryDate.isBefore(LocalDate.now()))
				|| (exitDate.compareTo(entryDate) < 0)) {

			resultado = false;
		}

		return resultado;

	}
}
