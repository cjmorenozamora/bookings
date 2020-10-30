package cjmorenozamora.booking.utils;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CompositeKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5637473243596765008L;
	
	private Date date;
	
	private Integer hotel_id;

}
