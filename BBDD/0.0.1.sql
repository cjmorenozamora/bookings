-- DROP TABLE public.hotels;

CREATE TABLE public.hotels (
	id serial NOT NULL,
	"name" varchar NOT NULL,
	category int4 NOT NULL,
	CONSTRAINT hotels_pk PRIMARY KEY (id)
);

-- DROP TABLE public.availability;

CREATE TABLE public.availability (
	"date" date NOT NULL,
	hotel_id int4 NOT NULL,
	rooms int4 NOT NULL,
	CONSTRAINT availability_pk PRIMARY KEY (date, hotel_id),
	CONSTRAINT availability_fk FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);
-- DROP TABLE public.bookings;

CREATE TABLE public.bookings (
	id serial NOT NULL,
	hotel_id int4 NOT NULL,
	date_from date NOT NULL,
	date_to date NOT NULL,
	email varchar(100) NOT NULL,
	CONSTRAINT bookings_pk PRIMARY KEY (id),
	CONSTRAINT bookings_fk FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);