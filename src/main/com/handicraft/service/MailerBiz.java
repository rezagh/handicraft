package com.handicraft.service;

import com.handicraft.model.UserDO;

public interface MailerBiz {
	public void sendNewPassword(UserDO user, String password);
	public void emailAlert(String message);
}
