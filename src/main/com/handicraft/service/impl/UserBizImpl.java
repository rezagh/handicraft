package com.handicraft.service.impl;

import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.handicraft.model.UserDO;
import com.handicraft.model.type.RoleEnum;
import com.handicraft.service.MailerBiz;
import com.handicraft.service.UserBiz;
public class UserBizImpl extends GenericServiceImpl implements UserBiz {
	//private GenericService	genericService;
	private Log log= LogFactory.getLog(UserBizImpl.class);
	private MailerBiz mailerBiz;
	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		log.debug("User trying to login: " + username);
		//DetachedCriteria query = DetachedCriteria.forClass(UserDO.class).add( Property.forName("username").eq(username));
		List<UserDO> users = genericDao.findByColumn(UserDO.class, "email", username);
		
		if(users == null || users.size() == 0 ) return null;
		log.debug("user being returned is: " + users.get(0).toString());
		return users.get(0);
	}

	@Override
	public Long registerUser(UserDO user) {
		user.setRole(RoleEnum.ROLE_USER.name());
		user.setAccountNonLocked(true);
		Long id = this.genericDao.save(user);
		//TODO send email ?
		//mailerBiz.emailAlert("a new user registered:" + user.getUsername());
		return id;
	}


	@Override
	public void changePassword(UserDO user) {
		genericDao.update(user);
	}


	@Override
	public void generateAndSendNewPassword(UserDO user) {
		Random random = new Random();
        String newPassword = random.nextInt(100000) + "iR" +
        					"abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26)) ;
        // 26 > letter >= 0 
        //that "iR" should stay in the middle!
        
        //TODO save password before of after sending ?! check tx here.
        
        //user validity checks has be done before this point
        user.setPassword(newPassword);
        user.setAccountNonLocked(true);
        //user.setIsActive(true);
        user.setLoginAttemptCount(0);
        genericDao.update(user);//save password first
        log.debug("user " + user + " will have the new password " + newPassword + " . Sending email:");
        mailerBiz.sendNewPassword(user, newPassword);
	}


	public void setMailerBiz(MailerBiz mailerBiz) {
		this.mailerBiz = mailerBiz;
	}

	@Override
	public void updateUser(UserDO user) {
		genericDao.update(user);
	}

}
