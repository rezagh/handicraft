package com.handicraft.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.handicraft.model.UserDO;
import com.handicraft.util.CartHelper;
import com.handicraft.util.ControllerUtil;

public class ParentMultiAction extends MultiActionController{
	BindingResult errors; //Declaring errors as instance variable to catch error
	Log log = LogFactory.getLog(ParentMultiAction.class);
	
	

	
	@Override
	protected void bind(HttpServletRequest request, Object command) throws Exception {
		ServletRequestDataBinder binder = createBinder(request, command);
		binder.bind(request);
		errors = binder.getBindingResult();
	}

	/**
	 * returns the logged in user or null if the user is not logged in.
	 * 
	 * @param request
	 * @return the logged in user
	 */
	public UserDO getUser(HttpServletRequest request){
		if (request.getUserPrincipal() != null){//user registered
			  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			  UserDO u = (UserDO) principal;
			  return u;
		}else return null;
	}


}
