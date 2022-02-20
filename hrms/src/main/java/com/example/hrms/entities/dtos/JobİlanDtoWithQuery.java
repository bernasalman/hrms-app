package com.example.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobİlanDtoWithQuery {

	private int id;

	private int openPositionCount;

	private LocalDate createDate;

	private Date lastApplyDate;

	private String companyName;
	
	private String title;
	
	private String city;
	
	private String educationLevel;
	
	private String workTime;
	
	private String workType;
}
