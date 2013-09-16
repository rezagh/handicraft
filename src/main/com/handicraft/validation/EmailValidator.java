package com.handicraft.validation;

import org.apache.commons.lang.StringUtils;

public class EmailValidator {
	public static boolean isEmailValid(String email){
		if(StringUtils.isEmpty(email)) return false;
		if(!email.contains("@")) return false;
		if(!email.contains(".")) return false;
		return true;
	}
}
