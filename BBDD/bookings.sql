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

-- INSERT DATA IN HOTEL	 
INSERT INTO public.hotels ("name",category) VALUES
	 ('AC CORDOBA',4),
	 ('MELIA',5),
	 ('AVERROES',2);
	 	 
-- INSERT DATA IN AVAILABILITY	 
INSERT INTO public.availability ("date",hotel_id,rooms) VALUES
	 ('2020-12-06',2,3),
	 ('2020-12-06',1,3),
	 ('2020-12-07',1,3),
	 ('2020-12-08',1,3),
	 ('2020-12-09',1,3),
	 ('2020-12-13',1,3),
	 ('2020-12-14',1,3),
	 ('2020-12-15',1,3),
	 ('2020-12-16',1,3),
	 ('2020-12-17',1,3);
INSERT INTO public.availability ("date",hotel_id,rooms) VALUES
	 ('2020-12-18',1,3),
	 ('2020-12-19',1,3),
	 ('2020-12-20',1,3),
	 ('2020-12-21',1,3),
	 ('2020-12-22',1,3),
	 ('2020-12-23',1,3),
	 ('2020-12-24',1,3),
	 ('2020-12-25',1,3),
	 ('2020-12-26',1,3),
	 ('2020-12-27',1,3);
INSERT INTO public.availability ("date",hotel_id,rooms) VALUES
	 ('2020-12-28',1,3),
	 ('2020-12-29',1,3),
	 ('2020-12-30',1,3),
	 ('2020-12-06',3,3),
	 ('2020-12-07',3,3),
	 ('2020-12-08',3,3),
	 ('2020-12-09',3,3),
	 ('2020-12-10',3,3),
	 ('2020-12-11',3,3),
	 ('2020-12-12',3,3);
INSERT INTO public.availability ("date",hotel_id,rooms) VALUES
	 ('2020-12-13',3,3),
	 ('2020-12-14',3,3),
	 ('2020-12-15',3,3),
	 ('2020-12-16',3,3),
	 ('2020-12-17',3,3),
	 ('2020-12-18',3,3),
	 ('2020-12-19',3,3),
	 ('2020-12-20',3,3),
	 ('2020-12-21',3,3),
	 ('2020-12-22',3,3);
INSERT INTO public.availability ("date",hotel_id,rooms) VALUES
	 ('2020-12-23',3,3),
	 ('2020-12-24',3,3),
	 ('2020-12-25',3,3),
	 ('2020-12-26',3,3),
	 ('2020-12-27',3,3),
	 ('2020-12-28',3,3),
	 ('2020-12-29',3,3),
	 ('2020-12-30',3,3),
	 ('2020-12-10',1,3),
	 ('2020-12-11',1,3);
INSERT INTO public.availability ("date",hotel_id,rooms) VALUES
	 ('2020-12-12',1,3),
	 ('2020-12-10',2,1),
	 ('2020-12-11',2,1),
	 ('2020-12-12',2,1);
	 
--Insert data in bookings
	 
INSERT INTO public.bookings (hotel_id,date_from,date_to,email) VALUES
	 (2,'2020-12-10','2020-12-12','aa'),
	 (2,'2020-12-10','2020-12-12','aa'),
	 (2,'2020-12-10','2020-12-12','aa'); 