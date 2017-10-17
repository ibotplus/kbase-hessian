## Spring 与 Hessian 整合
	demo采用的框架版本较高，jdk8, servlet-3.1, spring-5.0.0.RELEASE, Hessian-4.0.38, tomcat-8.5.23，详见pom.xml
	
### web.xml中的配置
	<servlet>
		<servlet-name>remote</servlet-name>
		<!-- 使用Spring的代理Servlet -->
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>namespace</param-name>
			<param-value>classes/remote-servlet</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>remote</servlet-name>
		<url-pattern>/remote/*</url-pattern>
	</servlet-mapping>
	
### remote-servlet.xml 配置
	<beans>  
	    <!-- 接口的具体实现类 -->  
	    <bean id="helloService" class="com.eastrobot.service.HelloServiceImpl" />  
	    <!-- 使用Spring的HessianServie做代理 -->  
	    <bean name="/hello" class="org.springframework.remoting.caucho.HessianServiceExporter">  
	        <!-- service引用具体的实现实体Bean-->  
	        <property name="service" ref="helloService" />
	        <property name="serviceInterface" value="com.eastrobot.service.HelloService" />  
	    </bean>  
	      
	    <!-- 可以配置多个HessianServiceExporter代理Bean -->  
	</beans>
	
### 测试用例
	com.eastrobot.service.HelloServiceTests
	
	访问地址：http://localhost:8080/kbase-hessian/remote/hello
	
### 遇到的报错
* org.springframework.web.util.NestedServletException: Hessian skeleton invocation failed; nested exception is java.io.IOException: Expected 'H'/'C' (Hessian 2.0) or 'c' (Hessian 1.0) in hessian input at -1

	**解决方法**：查阅很多资料后，mvn 重新 clean package 后就好了
	
### 参考文档

http://hessian.caucho.com/doc/hessian-overview.xtp#HessianClient

http://blog.csdn.net/dengdaixing/article/details/52250853

http://www.cnblogs.com/yeahwell/p/4684492.html

http://lavasoft.blog.51cto.com/62575/191889/

### Hessian使用过程中可能遇到的问题
* 实体类需要实现 Serializable 接口
* 复杂对象的传输效率问题
