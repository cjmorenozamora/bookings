package cjmorenozamora.booking.exceptions;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(HttpServletResponse response, MethodArgumentNotValidException e){
		
		
		Map<String, String> errors = new HashMap<>();
	    e.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    
	    });		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }

	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> dateUntilsException(HttpServletResponse response, IllegalArgumentException e){
			
		return new ResponseEntity<>("Incorrect date range",HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
	@ExceptionHandler(InstantiationException.class)
    public ResponseEntity<String> builderException(HttpServletResponse response, InstantiationException e){
			
		return new ResponseEntity<>("ERROR builder lombok",HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	
	@ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> builderException(HttpServletResponse response, RuntimeException e){
			
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
