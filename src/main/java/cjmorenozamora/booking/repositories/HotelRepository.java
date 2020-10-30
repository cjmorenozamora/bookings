package cjmorenozamora.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cjmorenozamora.booking.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}
