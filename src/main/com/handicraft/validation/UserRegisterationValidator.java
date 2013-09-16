package com.handicraft.validation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.handicraft.model.UserDO;

public class UserRegisterationValidator implements Validator {
	Log log = LogFactory.getLog(UserRegisterationValidator.class);

	public boolean supports(Class clazz) {
    	return clazz.equals(UserDO.class);
    }
    
    public void validate(Object obj, Errors e) {
    	UserDO user = (UserDO)obj;
    	
    	if(!EmailValidator.isEmailValid(user.getEmail())){
    		ValidationUtils.rejectIfEmpty(e, "email","","email address not valid.");
    	}
    	
    	ValidationUtils.rejectIfEmpty(e, "password","","password cannnot be empty.");
    	//TODO better password validator needed
    	
    	ValidationUtils.rejectIfEmpty(e, "firstname","","firstname cannnot be empty.");
    	ValidationUtils.rejectIfEmpty(e, "lastname","","lastname cannnot be empty.");
    	ValidationUtils.rejectIfEmpty(e, "addressLine1","","addressLine1 cannnot be empty.");
    	ValidationUtils.rejectIfEmpty(e, "city","","city cannnot be empty.");
    	ValidationUtils.rejectIfEmpty(e, "state","","state cannnot be empty.");
    	ValidationUtils.rejectIfEmpty(e, "postCode","","postCode cannnot be empty.");
    	ValidationUtils.rejectIfEmpty(e, "country","","country cannnot be empty.");
    }
}
