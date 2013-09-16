package com.handicraft.filter;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//http://www.codercorp.com/blog/spring/security-spring/custom-authenticationprocessingfilter-for-spring-security-to-perform-actions-on-login.html
//http://heraclitusonsoftware.wordpress.com/software-development/spring/simple-web-application-with-spring-security-part-9/

public class CustomAuthenticationProcessingFilter extends UsernamePasswordAuthenticationFilter   {
//	Log log = LogFactory.getLog(CustomAuthenticationProcessingFilter.class);
//	
//	@Override
//	protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, 
//														Authentication authResult) throws IOException {
//		super.onSuccessfulAuthentication(request, response, authResult);
//		//request.getSession().setAttribute("myValue", "My value is set");
//	}
//
//	@Override
//	protected void onUnsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
//														AuthenticationException failed)	throws IOException {
//		super.onUnsuccessfulAuthentication(request, response, failed);
//		log.debug("Login FAILURE : " + failed);
//		//TODO do message handling based on different exceptions.
//		request.setAttribute("error", failed);
//	}

}
