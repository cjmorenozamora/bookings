package cjmorenozamora.booking.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cjmorenozamora.booking.dtos.models.HotelDto;
import cjmorenozamora.booking.entities.Availability;
import cjmorenozamora.booking.entities.AvailabilityPk;
import cjmorenozamora.booking.entities.Hotel;
import cjmorenozamora.booking.repositories.AvailabilityRepository;
import cjmorenozamora.booking.services.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

	@Autowired
	AvailabilityRepository repository;

	@Override
	public void createAvailability(Integer hotelId, LocalDate dateFrom, LocalDate dateTo, Integer rooms) {

		List<LocalDate> dateList = new ArrayList<LocalDate>();
		dateList = dateFrom.datesUntil(dateTo.plusDays(1)).collect(Collectors.toList());
		for (LocalDate date : dateList) {
			insertAvailability(hotelId, rooms, date);
		}

	}

	@Override
	public List<HotelDto> getAvailability(LocalDate entryDate, LocalDate exitDate) {
		List<Hotel> hotels = repository.findHotels(entryDate, exitDate);
		ModelMapper modelMapper = new ModelMapper();
		List<HotelDto> hotelsRest = new ArrayList<>();

		hotels.forEach(hotel -> hotelsRest.add(modelMapper.map(hotel, HotelDto.class)));

		return hotelsRest;
	}

	private void insertAvailability(Integer hotelId, Integer rooms, LocalDate date) {
		AvailabilityPk pk = AvailabilityPk.builder().date(date).hotelId(hotelId).build();

		if (repository.findById(pk).isEmpty()) {
			Availability availability = Availability.builder().hotelId(hotelId).date(date).rooms(rooms).build();

			repository.save(availability);
		}
	}

}
