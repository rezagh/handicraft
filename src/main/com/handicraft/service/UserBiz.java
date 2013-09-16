package com.handicraft.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.handicraft.model.UserDO;

public interface UserBiz extends UserDetailsService{
	public Long registerUser(UserDO user);
	public void generateAndSendNewPassword(UserDO user);
	public void changePassword(UserDO user);
	public void updateUser(UserDO user);
}
