package com.hessian.service.autowired;

import org.springframework.stereotype.Service;

@Service("userDaoA")
public class UserDaoA implements IUserDao {

	@Override
	public String getUserName() {
		return "aaaaa";
	}

}
