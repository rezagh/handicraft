package com.handicraft.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;

import com.handicraft.model.InquiryDO;
import com.handicraft.model.type.InquiryTypeEnum;
import com.handicraft.util.Codes;
import com.handicraft.validation.InquiryValidator;
import com.reza.mail.MailManager;

public class InquiryController extends ParentMultiAction{
	private static final Log log = LogFactory.getLog(InquiryController.class);
	MailManager mailManager;
	
	public ModelAndView sendInquiry(HttpServletRequest request, HttpServletResponse response, InquiryDO inquiry) throws Exception {
		ValidationUtils.invokeValidator(new InquiryValidator(), inquiry, errors);
		if (errors.hasErrors()) {
			Map returnMap = new HashMap();
			returnMap.put(Codes.VAR_INQUIRY_TYPES, InquiryTypeEnum.values());
			returnMap.putAll(errors.getModel());
			return  new ModelAndView("inquiry",returnMap);
		}
		
		mailManager.sendEmailToDefault("From Handicrafts " , "From: " + inquiry.getEmail() + " : " + inquiry.getMessage());
		return new ModelAndView("inquirySuccess");
    }

	public ModelAndView listInquiryPage(HttpServletRequest request, HttpServletResponse response, InquiryDO inquiry) throws Exception {
		Map model = new HashMap();
		model.put(Codes.VAR_INQUIRY_TYPES, InquiryTypeEnum.values());
		return new ModelAndView(Codes.PAGE_LIST_INQUIRY,model);
    }

	public void setMailManager(MailManager mailManager) {
		this.mailManager = mailManager;
	}
}
