package com.example.hrms.core.utilities;

import org.springframework.stereotype.Service;

@Service
public class UserKontrolManager implements UserKontrolService {

	@Override
	public boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth) {
		FakeMernis client = new FakeMernis();

		try {
			boolean result = client.validateUser(nationalId, firstName, lastName, yearOfBirth);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
