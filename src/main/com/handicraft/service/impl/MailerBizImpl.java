package com.handicraft.service.impl;

import com.handicraft.model.UserDO;
import com.handicraft.service.MailerBiz;
import com.reza.mail.MailManager;

public class MailerBizImpl implements MailerBiz {
	private static String EMAIL_FOOTER = "\n\n Persian Handicrafts Online Team";
	MailManager mailManager;
	
	@Override
	public void sendNewPassword(UserDO user, String newPassword) {
		String SUBJECT_NEW_PASSWORD = "Your new password from Persian Handicrafts Online";
		String newPasswordContent = "Your new password is: " + newPassword + "\n" + EMAIL_FOOTER;
		mailManager.sendMail(user.getEmail(), SUBJECT_NEW_PASSWORD , newPasswordContent );
		
	}

	@Override
	public void emailAlert(String message) {
		mailManager.sendEmailToDefault("alert from handicraft" , message );
	}

	public void setMailManager(MailManager mailManager) {
		this.mailManager = mailManager;
	}
}
