package cjmorenozamora.booking.repositories;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import cjmorenozamora.booking.entities.Availability;

public interface AvailabilityRepository extends CrudRepository<Availability,Date>{

}
