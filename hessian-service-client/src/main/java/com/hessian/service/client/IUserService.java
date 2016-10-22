package com.hessian.service.client;

import java.util.Map;

import com.hessian.service.common.RequestParam;
import com.hessian.service.common.User;

public interface IUserService {
	public String hello(String message);

	public Map<String, Object> getById(long id);
	
	public User getUser(RequestParam param);
	
	public void setToken(String token);
	
	public String generatorToken(String userName);  
    
    public boolean validateToken(String token);
}
