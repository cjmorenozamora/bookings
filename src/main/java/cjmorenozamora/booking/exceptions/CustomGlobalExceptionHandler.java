package cjmorenozamora.booking.exceptions;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> methodArgumentNotValidException(HttpServletResponse response,
			MethodArgumentNotValidException e) {
		
		return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> dateUntilsException(HttpServletResponse response, IllegalArgumentException e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InstantiationException.class)
	public ResponseEntity<String> builderException(HttpServletResponse response, InstantiationException e) {

		return new ResponseEntity<>("ERROR builder lombok", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> builderException(HttpServletResponse response, RuntimeException e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(HttpServletResponse response, NoSuchElementException e) {

		return new ResponseEntity<>("No existe la entidad", HttpStatus.NOT_FOUND);
	}

}
