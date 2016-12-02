package com.hessian.service.autowired;

import org.springframework.stereotype.Service;

@Service("userDaoB")
public class UserDaoB implements IUserDao {

	@Override
	public String getUserName() {
		return "bbbbb";
	}

}
