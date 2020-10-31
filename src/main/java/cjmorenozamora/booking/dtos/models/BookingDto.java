package cjmorenozamora.booking.dtos.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookingDto {

	private Integer bookingId;
	
	private HotelDto hotel;
	
	private LocalDate entryDate;
	
	private LocalDate exitDate;
}
