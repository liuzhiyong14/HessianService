package com.hessian.service.client;

import java.util.Map;

import com.hessian.service.common.RequestParam;
import com.hessian.service.common.User;

public interface IServlet {

	String hello(String message);

	Map<String, Object> getById(long id);
	
	User getUser(RequestParam param);
	
}
