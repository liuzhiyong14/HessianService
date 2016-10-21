package com.hessian.service.core;

import java.util.HashMap;
import java.util.Map;

import com.caucho.hessian.server.HessianServlet;
import com.hessian.service.client.IServlet;
import com.hessian.service.common.RequestParam;
import com.hessian.service.common.User;

public class ServletImpl extends HessianServlet implements IServlet {

	private static final long serialVersionUID = -7660959102068711894L;

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
