package com.hessian.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hessian.service.autowired.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public class UserTestService {

	@Autowired
	private IUserDao userDaoA;
	
	@Autowired
	private IUserDao userDaoB;
	
	
	@Test
	public void getUser(){
		System.out.println(userDaoA.getUserName());
		System.out.println(userDaoB.getUserName());
	}
}
