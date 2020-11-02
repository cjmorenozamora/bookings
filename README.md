# bookings

# Montar BBDD.
  Se ha utilizado docker para crear un contenedor donte estará alojada nuestra BBDD. Instalamos docker desde su pagina web https://www.docker.com/get-started, eligiendo el SO correspondiente a su PC.
  
  Una vez realizada la instalación accedemos a la terminal y ejecutamos el siguiente comando.
    
    docker run -p 5432:5432 --name yourContainerName -e POSTGRES_PASSWORD=yourPassword -d postgres
    
  A continuación cargaremos nuestro script 'bookings.sql' en la base de datos.
    
    docker cp RutaCorrespondiente/bookings.sql prueba:/docker-entrypoint-initdb.d/dump.sql

    docker exec -u postgres prueba psql postgres postgres -f docker-entrypoint-initdb.d/dump.sql

  Ya tenemos la BBDD disponible para ejecutar al aplicación.


# Levantar Aplicación con Maven

  Abrimos una terminal en el directorio raiz del proyecto y ejecutamos mvn spring-boot:run. Una vez terminada la ejecución ya tendremos disponible la aplicación.


# Urls para probar la aplicación.
  Se recomienda utilizar Postman. Se aconseja prestar atención a los resultados de las ejecuciones, ya que la base de datos sufrirá cambios con algunas de las pruebas.
  
  ● Consulta de hoteles: devolverá el listado de hoteles que existen
     GET. http://localhost:8080/hotels

  ● Abrir disponibilidad: Dado un hotel, un rango de fechas y un número de
habitaciones, se creará disponibilidad para dichas fechas. Si ya existe
disponibilidad en alguna fecha, no se actualizará.
     PUT. http://localhost:8080/availability
     Body:
        {
	        "hotel":2,
	        "dateFrom":"2020-12-10",
	        "dateTo":"2020-12-12",
	        "rooms":3
        }
 
  ● Consulta de disponibilidad: devolverá qué hoteles tienen disponibilidad dadas
unas fechas de entrada y salida.
     GET. http://localhost:8080/availability?entryDate=2020-12-10&exitDate=2020-12-15


  ● Reserva de habitación: Dado un hotel, unas fechas de entrada y salida y un
email, se creará una reserva.
     POST. http://localhost:8080/booking
     Body:
         {
	         "hotel":2,
	         "entryDate":"2020-10-10",
	         "exitDate":"2020-12-12",
	         "email":"aa"
         }

● Consulta de reservas: Dado un hotel y unas fechas de inicio y fin, devolver las
reservas realizadas. (Consulta dinámica).
     GET. http://localhost:8080/bookings
     GET. http://localhost:8080/bookings?hotel=1
     GET. http://localhost:8080/bookings?hotel=1&entryDate=2020-12-10&exitDate=2020-12-12    
     
● Obtener reserva: dado un id de reserva, devolver los datos de la misma.
     GET. http://localhost:8080/bookings/1

● Cancelar reserva: Dado un id de reserva, eliminar la misma y actualizar la
disponibilidad del hotel para los días necesarios.
     DELETE. http://localhost:8080/bookings/1
