package com.example.hrms.api.controllers;

import com.example.hrms.business.abstracts.EducationService;
import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.ErrorDataResult;
import com.example.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/educationlevels")
@CrossOrigin
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	

	@GetMapping("/getall")
	public DataResult<List<Education>> getAll() {
		return this.educationService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid Education education) {
		return ResponseEntity.ok(this.educationService.add(education));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama hataları");
		return errors;

	}
}
