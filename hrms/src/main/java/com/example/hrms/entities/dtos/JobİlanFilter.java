package com.example.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobİlanFilter {

	private List<Integer> cityId;
	private List<Integer> jobTitleId;
	private List<Integer> workTimeId;
	private List<Integer> workTypeId;
}
