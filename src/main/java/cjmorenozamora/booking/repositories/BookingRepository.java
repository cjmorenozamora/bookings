package cjmorenozamora.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cjmorenozamora.booking.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
