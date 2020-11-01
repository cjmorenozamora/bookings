package cjmorenozamora.booking.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

	private Integer idHotel;
	
	private String name;
	
	private Integer category;
}
