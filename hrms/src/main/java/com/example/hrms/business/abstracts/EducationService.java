package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.Education;

import java.util.List;

public interface EducationService {

	Result add(Education education);
	DataResult<List<Education>> getAll();
}
