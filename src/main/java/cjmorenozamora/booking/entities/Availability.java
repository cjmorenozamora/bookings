package cjmorenozamora.booking.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import cjmorenozamora.booking.utils.CompositeKeyAvailability;
import lombok.Data;

@Entity
@Table(name="availability")
@IdClass(CompositeKeyAvailability.class)
@Data
public class Availability {

	@Id
	private LocalDate date;
	
	@Id
	@Column(name="hotel_id")
	private Integer hotelId;
	
	private Integer rooms;
	
}
