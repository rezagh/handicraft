package com.handicraft.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;

import com.handicraft.model.UserDO;
import com.handicraft.model.type.CountryEnum;

public class ControllerUtil {
	public static void addCountiesToSession(HttpServletRequest request){
		if(request.getSession().getAttribute(Codes.COUNTRIES) != null) return ;
		request.getSession().setAttribute(Codes.COUNTRIES, Arrays.asList(CountryEnum.values()));
	}

	public static UserDO getSessionUser(HttpServletRequest request){
		if(request.getSession().getAttribute("user") == null) return null;
		else return  (UserDO)request.getSession().getAttribute("user");
	}

	public static UserDO getUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof String)//not logged in and is anonymous string 
			return null;
		else 
			return (UserDO)principal;
	}

	private static UserDO getGuestUser(){
		UserDO guestUser = new UserDO();
		guestUser.setFirstname("Guest");
		return guestUser;
	}

	//TODO put user in session in login
	public static void setUserToSession(HttpServletRequest request){
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof String)//not logged in and is anonymous string 
			request.getSession().setAttribute("user", null);
		else 
			request.getSession().setAttribute("user", principal);//is of type UserDO
		
	}

}
