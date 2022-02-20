package com.example.hrms.business.concretes;

import com.example.hrms.business.Mesajlar;
import com.example.hrms.business.abstracts.WorkingService;
import com.example.hrms.core.utilities.result.DataResult;
import com.example.hrms.core.utilities.result.Result;
import com.example.hrms.core.utilities.result.SuccessDataResult;
import com.example.hrms.core.utilities.result.SuccessResult;
import com.example.hrms.dataAccess.abstracts.WorkingDao;
import com.example.hrms.entities.concretes.Working;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingManager implements WorkingService {

	private WorkingDao workingDao;

	@Autowired
	public WorkingManager(WorkingDao workingDao) {
		super();
		this.workingDao = workingDao;
	}

	@Override
	public Result add(Working working) {
		this.workingDao.save(working);
		return new SuccessResult(Mesajlar.workingEklendi);
	}

	@Override //çalışma şeklinin giirilmesinde
	public DataResult<List<Working>> getAll() {
		return new SuccessDataResult<List<Working>>
				(this.workingDao.findAll(),
						Mesajlar.workingListle);
	}

}
