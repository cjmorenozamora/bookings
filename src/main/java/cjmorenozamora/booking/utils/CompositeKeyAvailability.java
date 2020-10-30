package cjmorenozamora.booking.utils;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class CompositeKeyAvailability implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5637473243596765008L;
	
	private LocalDate date;
	
	private Integer hotelId;

}
