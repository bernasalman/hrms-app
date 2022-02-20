package com.example.hrms.core.utilities;

public interface UserKontrolService {
	boolean validateByMernis(long nationalId, String firstName, String lastName, int yearOfBirth);
}
