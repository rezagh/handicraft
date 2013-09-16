package com.handicraft.validation;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.handicraft.model.InquiryDO;
import com.handicraft.util.ControllerUtil;

public class InquiryValidator implements Validator {
	Log log = LogFactory.getLog(InquiryValidator.class);

	public boolean supports(Class clazz) {
    	return clazz.equals(InquiryDO.class);
    }
    
    public void validate(Object obj, Errors e) {
    	InquiryDO inquiry = (InquiryDO)obj;
    	if (ControllerUtil.getUser() == null && StringUtils.isEmpty(inquiry.getEmail()))
    		ValidationUtils.rejectIfEmpty(e, "email","","Email is Mandatory");
    	ValidationUtils.rejectIfEmpty(e, "message","","Message is Mandatory");
    	
    }
}
