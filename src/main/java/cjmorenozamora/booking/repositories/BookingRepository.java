package cjmorenozamora.booking.repositories;

import org.springframework.data.repository.CrudRepository;
import cjmorenozamora.booking.entities.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer>{

}
