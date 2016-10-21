package com.hessian.service.common;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestParam implements Serializable{
	private static final long serialVersionUID = 1455957415103764408L;
	private String name;
	private long card;
}
