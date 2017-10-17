/*
 * Power by www.xiaoi.com
 */
package com.eastrobot.service;

import java.net.MalformedURLException;

import org.junit.Test;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date 2017年10月16日 下午6:15:38
 * @version 1.0
 */
public class HelloServiceTests {

	@Test
	public void sayHello() throws MalformedURLException{
		String url = "http://localhost:8080/kbase-hessian/remote/hello";
        HessianProxyFactory factory = new HessianProxyFactory();
        factory.setOverloadEnabled(true);
        HelloService api = (HelloService) factory.create(HelloService.class, url);
  
        System.out.println(api.sayHello());
        System.out.println("---------------------------");
        
        System.out.println(api.sayHi("eko.zhan"));
	}
}
