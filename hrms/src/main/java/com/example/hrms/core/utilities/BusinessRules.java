package com.example.hrms.core.utilities;

import com.example.hrms.core.utilities.result.Result;

public class BusinessRules {

	public static Result run(Result... logics) {
		for (var logic : logics) {

			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return null;
	}

}
