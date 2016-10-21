package com.hessian.service.core;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hessian.service.client.IUserService;
import com.hessian.service.common.RequestParam;
import com.hessian.service.common.User;


@Service("userService")
public class UserServiceImpl implements IUserService {

	@Override
	public String hello(String message) {
		return "hello," + message;
	}

	@Override
	public Map<String, Object> getById(long id) {
		if (id <= 0) {
			return null;
		}

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("id", id);
		result.put("name", "四哥");
		result.put("position", "万达");
		return result;
	}
	
	@Override
	public User getUser(RequestParam param){
		
		if(param==null){
			return null;
		}
		
		User user = new User();
		user.setName(param.getName());
		user.setAge(18);
		user.setSex(1);
		user.setCard(param.getCard());
		
		return user;
	}
}
