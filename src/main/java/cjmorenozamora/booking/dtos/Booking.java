package cjmorenozamora.booking.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class Booking {

	private Integer bookingId;
	
	private Hotel hotel;
	
	private Date entryDate;
	
	private Date exitDate;
}
