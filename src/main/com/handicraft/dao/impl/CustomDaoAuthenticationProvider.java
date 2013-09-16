package com.handicraft.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.handicraft.dao.GenericDao;
import com.handicraft.model.UserDO;
import com.reza.constant.Constant;

public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {
    Log log = LogFactory.getLog(CustomDaoAuthenticationProvider.class);
	GenericDao genericDao;
	
	//int maxTry;// = new Integer(constant.get("MAX_LOGIN_ATTEMPT_COUNT"));
	
    //user details comes from db and auth token from FE
	protected void additionalAuthenticationChecks(UserDetails userDetails,UsernamePasswordAuthenticationToken authentication)
     																throws AuthenticationException{

		int maxTry = new Integer(Constant.get("MAX_LOGIN_ATTEMPT_COUNT"));
		//copied this bit from the spring source:
		Object salt = null;
		if (super.getSaltSource() != null) {
            salt = super.getSaltSource().getSalt(userDetails);
        }

        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"),
                    super.isIncludeDetailsObject() ? userDetails : null);
        }

        String presentedPassword = authentication.getCredentials().toString();
    	UserDO dbUser = (UserDO)userDetails;

        if (!super.getPasswordEncoder().isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
        	dbUser.setLoginAttemptCount(dbUser.getLoginAttemptCount() + 1);
        	genericDao.update(dbUser);
        	
        	if(dbUser.getLoginAttemptCount() > maxTry) {
        		dbUser.setAccountNonLocked(false);//lock the account
        		genericDao.update(dbUser);
        		log.debug("user locked: " + dbUser);
            	throw new LockedException("UserDetailsService.locked", super.isIncludeDetailsObject() ? userDetails : null);
        	}
        	
        	throw new BadCredentialsException(messages.getMessage(
                    "AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"),
                    super.isIncludeDetailsObject() ? userDetails : null);

        	
        }
        //the auth is ok
        dbUser.setLoginAttemptCount(0);
        genericDao.update(dbUser);
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}


}
