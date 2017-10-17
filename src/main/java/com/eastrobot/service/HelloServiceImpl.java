/*
 * Power by www.xiaoi.com
 */
package com.eastrobot.service;

import com.caucho.hessian.server.HessianServlet;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date 2017年10月16日 下午4:54:49
 * @version 1.0
 */
public class HelloServiceImpl extends HessianServlet implements HelloService {

	public String sayHello() {
		return "Hello World";
	}
	
	public String sayHi(String username){
		return "Hi " + username;
	}

}
