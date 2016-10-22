package com.hessian.service.core;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.hessian.service.client.IUserService;
import com.hessian.service.common.RequestParam;
import com.hessian.service.common.User;


@Service("userService")
public class UserServiceImpl implements IUserService {
	
	private String token;
	Map<String, Date> tokenStore = new ConcurrentHashMap<String, Date>();
	
	@Override
	public void setToken(String token) {
		this.token = token;
	}
	

	@Override
	public String hello(String message) {
		
		if(!this.validateToken(token)){
			return "You do not have permission!";
		}
		
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
	
	/**
	 * 客户端发送请求得到token.
	 * 
	 * @param userName
	 * @return
	 */
	public String generatorToken(String userName) {
		
		if("liuzhiyong14".equals(userName)){
			
			Date time = new Date();
			try {
				byte[] b = (time + userName).getBytes("utf-8");
				String token = DigestUtils.md5DigestAsHex(b);
				tokenStore.put(token, time);// 存储这个时间点的token
				return token;
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return userName;
	}

	/**
	 * 服务器在接收到请求时验证token,并把刚才的Token设置为失效
	 * 
	 * @param token
	 * @return
	 */
	public boolean validateToken(String token) {
		if (tokenStore.containsKey(token)) {
			Date time = tokenStore.get(token);
			Date normal = new Date();
			if (normal.getTime() - time.getTime() > 10 * 1000) {
				// 日志进退时
				return false;
			}
			tokenStore.remove(token);
		} else {
			// 日志，没有权限
			return false;
		}
		return true;
	}
}
