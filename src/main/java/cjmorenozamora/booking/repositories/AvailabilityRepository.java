package cjmorenozamora.booking.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cjmorenozamora.booking.entities.Availability;
import cjmorenozamora.booking.entities.AvailabilityPk;
import cjmorenozamora.booking.entities.Hotel;

public interface AvailabilityRepository extends JpaRepository<Availability,AvailabilityPk>{

	@Query("SELECT DISTINCT a.hotel FROM Availability a JOIN a.hotel WHERE a.rooms>0 AND a.date BETWEEN ?1 AND ?2")
	List<Hotel> findHotels(LocalDate entryDate, LocalDate exitDate);
	
	@Modifying
	@Query("UPDATE Availability a SET a.rooms = a.rooms-1 WHERE (a.date BETWEEN ?1 AND ?2) AND (a.hotel.id = ?3)")
	Integer updateAvailability(LocalDate entryDate, LocalDate exitDate, Integer hotelId);

}
