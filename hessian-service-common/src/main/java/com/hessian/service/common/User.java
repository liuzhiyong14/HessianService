package com.hessian.service.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{

	private static final long serialVersionUID = -3917557888803445001L;

	private String name;
	
	private int age;
	
	private int sex;
	
	private Long card;

}
