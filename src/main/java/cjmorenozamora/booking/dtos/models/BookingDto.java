package cjmorenozamora.booking.dtos.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	private Integer bookingId;
	
	private HotelDto hotel;
	
	private LocalDate dateFrom;
	
	private LocalDate dateTo;
	
	private String email;
}
