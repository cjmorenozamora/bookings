package cjmorenozamora.booking.entities;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityPk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5637473243596765008L;
	
	private LocalDate date;
	
	private Integer hotelId;

}
