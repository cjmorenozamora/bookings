package cjmorenozamora.booking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cjmorenozamora.booking.entities.Availability;
import cjmorenozamora.booking.utils.CompositeKeyAvailability;

public interface AvailabilityRepository extends JpaRepository<Availability,CompositeKeyAvailability>{

}
