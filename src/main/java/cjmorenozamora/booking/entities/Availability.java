package cjmorenozamora.booking.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="availability")
@IdClass(AvailabilityPk.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Availability {

	@Id
	private LocalDate date;
	
	@Id
	@Column(name="hotel_id")
	private Integer hotelId;
	
	private Integer rooms;
	
}
