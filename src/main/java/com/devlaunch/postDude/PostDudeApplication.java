package com.devlaunch.postDude;

import com.devlaunch.postDude.common.utilities.exceptions.BusinessException;
import com.devlaunch.postDude.common.utilities.results.ErrorDataResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PostDudeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostDudeApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors, "VALIDATION.EXCEPTION");
		return errorDataResult;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException) {
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(businessException.getMessage(),
				"BUSINESS.EXCEPTION");
		return errorDataResult;
	}

}
