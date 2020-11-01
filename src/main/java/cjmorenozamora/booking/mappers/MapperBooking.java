package cjmorenozamora.booking.mappers;

import org.springframework.stereotype.Component;

import cjmorenozamora.booking.dtos.models.BookingDto;
import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.entities.Booking;

@Component
public class MapperBooking {

	public BookingDto mapperBooking(Booking bookingEntity) {
		HotelDto hotelDto = HotelDto.builder().category(bookingEntity.getHotel().getCategory())
				.idHotel(bookingEntity.getHotelId()).name(bookingEntity.getHotel().getName()).build();

		return BookingDto.builder().hotel(hotelDto).bookingId(bookingEntity.getId())
				.dateFrom(bookingEntity.getDateFrom()).dateTo(bookingEntity.getDateTo()).email(bookingEntity.getEmail())
				.build();
	}
}
