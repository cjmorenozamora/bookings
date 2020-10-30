package cjmorenozamora.booking.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import cjmorenozamora.booking.utils.CompositeKey;
import lombok.Data;

@Entity
@Table(name="availability")
@IdClass(CompositeKey.class)
@Data
public class Availability {

	@Id
	private Date date;
	@Id
	private Integer hotel_id;
	
	private Integer rooms;
	
}
