package cjmorenozamora.booking.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="bookings")
@Data
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="hotel_id")
	private Integer hotelId;
	
	@Column(name="date_from")
	private LocalDate dateFrom;
	
	@Column(name="date_to")
	private LocalDate dateTo;
	
	private String email;
}
