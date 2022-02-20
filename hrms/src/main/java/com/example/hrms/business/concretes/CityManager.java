package com.example.hrms.business.concretes;

import com.example.hrms.business.Mesajlar;
import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.utilities.BusinessRules;
import com.example.hrms.core.utilities.result.*;
import com.example.hrms.dataAccess.abstracts.CityDao;
import com.example.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		var result = BusinessRules.run(checkIfNameExists(city));
		if (result != null) {
			return result;
		}
		this.cityDao.save(city);
		return new SuccessResult(Mesajlar.cityEklendi);
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), Mesajlar.cityListele);
	}

	private Result checkIfNameExists(City city) {
		if (this.cityDao.getByName(city.getName()) != null) {
			return new ErrorResult(Mesajlar.cityNameVar);
		}
		return new SuccessResult();
	}

}
