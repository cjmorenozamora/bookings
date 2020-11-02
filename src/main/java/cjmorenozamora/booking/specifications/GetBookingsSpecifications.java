package cjmorenozamora.booking.specifications;

import java.time.LocalDate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import cjmorenozamora.booking.entities.Booking;

public class GetBookingsSpecifications {

	public static Specification<Booking> containsHotel(Integer hotelId) {
		return new Specification<Booking>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -4150465452744735136L;

			@Override
			public Predicate toPredicate(Root<Booking> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				return criteriaBuilder.equal(root.get("hotelId"), hotelId);
			}
		};
	}

	public static Specification<Booking> containsDateFrom(LocalDate dateFrom) {
		return new Specification<Booking>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 6802448325126601757L;

			@Override
			public Predicate toPredicate(Root<Booking> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				return criteriaBuilder.greaterThanOrEqualTo(root.get("dateFrom"), dateFrom);
			}
		};
	}

	public static Specification<Booking> containsDateTo(LocalDate dateTo) {
		return new Specification<Booking>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 5601008590800119771L;

			@Override
			public Predicate toPredicate(Root<Booking> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

				return criteriaBuilder.lessThanOrEqualTo(root.get("dateFrom"), dateTo);
			}
		};
	}

}
