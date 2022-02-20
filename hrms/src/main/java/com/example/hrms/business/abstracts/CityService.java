package com.example.hrms.business.abstracts;

import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.entities.concretes.City;

import java.util.List;

public interface CityService {

	Result add(City city);

	DataResult<List<City>> getAll();
}
