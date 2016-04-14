package edu.neu.cloudaddy.interceptors;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SourceServerAddressInteceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("SourceServerAddressInterceptor: REQUEST Intercepted for URI: "
				+ request.getRequestURI() +"SERVER_ADDRESS: "+ InetAddress.getLocalHost().getHostAddress());
		request.setAttribute("SERVER_ADDRESS", InetAddress.getLocalHost().getHostAddress());
		return true;
	}
}
