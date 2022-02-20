package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.Working;

import java.util.List;

public interface WorkingService {

	Result add(Working wayOfWorking); //çalışma şekli ekleme
	DataResult<List<Working>> getAll();
 }
