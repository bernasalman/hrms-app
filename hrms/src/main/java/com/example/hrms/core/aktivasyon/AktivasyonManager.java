package com.example.hrms.core.aktivasyon;

import com.example.hrms.core.entities.User;
import org.springframework.stereotype.Service;

@Service
public class AktivasyonManager implements AktivasyonService {

	@Override
	public boolean sendMail(User user) {
		return true;
	}

}
