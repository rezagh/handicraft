package com.handicraft.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.servlet.ModelAndView;

import com.handicraft.model.UserDO;
import com.handicraft.service.GenericService;
import com.handicraft.service.UserBiz;
import com.handicraft.util.Codes;
import com.handicraft.util.ControllerUtil;
import com.handicraft.validation.UserRegisterationValidator;

public class UserController extends ParentMultiAction {
	UserBiz userBiz;
	GenericService genericBiz;
	Log log = LogFactory.getLog(UserController.class);

	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response, UserDO user) throws Exception {
		ValidationUtils.invokeValidator(new UserRegisterationValidator(), user, errors);
		if (errors.hasErrors()) {
			return new ModelAndView("register", errors.getModel());
		}
		log.debug("registering user= " + user);
		try{
			userBiz.registerUser(user);
		}catch(DataIntegrityViolationException ee){//username already exist, etc
			ee.printStackTrace();
			return new ModelAndView("register", errors.getModel());//TODO show ui error message
		}
		return new ModelAndView("login");
	}

	public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response, UserDO user) throws Exception {
		UserDO sessionUser = ControllerUtil.getUser();
		
		sessionUser.setFirstname(user.getFirstname());
		sessionUser.setLastname(user.getLastname());
		sessionUser.setAddressLine1(user.getAddressLine1());
		sessionUser.setAddressLine2(user.getAddressLine2());
		sessionUser.setCity(user.getCity());
		sessionUser.setState(user.getState());
		sessionUser.setPostCode(user.getPostCode());
		sessionUser.setCountry(user.getCountry());
		
		Map mapResult = new HashMap();
		try{
			userBiz.updateUser(sessionUser);
			mapResult.put("result", "Added");
		}catch(Exception e ) {
			e.printStackTrace();
			mapResult.put("result", "Failed");
		}
		
		return new ModelAndView("userAccount",mapResult);
	}

	public ModelAndView showUserAccount(HttpServletRequest request, HttpServletResponse response, UserDO user) throws Exception {
		ControllerUtil.addCountiesToSession(request);
		ControllerUtil.setUserToSession(request);
		return new ModelAndView("userAccount");
	}

	//this sends email
	public ModelAndView forgotPassword(HttpServletRequest request, HttpServletResponse response, UserDO user) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		
		String email = request.getParameter("email");
		if(email == null || email.equals("") || !email.contains("@")) {
			//TODO this is a validation no result!
			map.put("result","email error!");
			return new ModelAndView("forgotPass", map);
		}else{//email password here
			//TODO check validity of email fist
			UserDO dbUser = (UserDO)userBiz.loadUserByUsername(email);
			if (dbUser != null) {
				map.put("result","Check Your Email and then login.");
				userBiz.generateAndSendNewPassword(dbUser);
				return new ModelAndView("forgotPass",map);
			}else{
				//TODO no such email
				map.put("result","Check Your Email and then login.");
				return new ModelAndView("forgotPass",map);
			}
		}
	}

	//changing pass needs the current pass
	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String currentPassword = request.getParameter("currentPassword");
		String newPassword = request.getParameter("newPassword");
		
		UserDO user = ControllerUtil.getUser();
		
		UserDetails dbUserDetail = userBiz.loadUserByUsername(user.getUsername());
		
		if(dbUserDetail != null && dbUserDetail.getPassword().equals(currentPassword)) {
			UserDO dbUser = (UserDO)dbUserDetail;
			dbUser.setPassword(newPassword);
			//TODO should we unlock the user here if locked?
			userBiz.changePassword(dbUser);
			return new ModelAndView("login");
		}else{//current pass wrong or other validation errors
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "error");//TODO 
			return new ModelAndView("changePass",map);
		}
	}

	public ModelAndView updateAccount(HttpServletRequest request, HttpServletResponse response, UserDO user) throws Exception {
		return new ModelAndView("user/changePass");
	}

	public ModelAndView showRegisterPage(HttpServletRequest request, HttpServletResponse response, UserDO user) throws Exception {
		ControllerUtil.addCountiesToSession(request);
		return new ModelAndView("register");
	}

	public ModelAndView afterLogin(HttpServletRequest request, HttpServletResponse response, UserDO user) throws Exception {
		ControllerUtil.addCountiesToSession(request);
		ControllerUtil.setUserToSession(request);
		return new ModelAndView(Codes.PAGE_INDEX);
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
}
