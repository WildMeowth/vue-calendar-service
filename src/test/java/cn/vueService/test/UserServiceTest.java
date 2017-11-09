package cn.vueService.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wildMeowth.vueService.service.UserService;


public class UserServiceTest {

	ClassPathXmlApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml", "spring-service.xml");
	}
	
	@Test
	public void testpagezcx() {
		UserService service = ctx.getBean("userService",UserService.class);
		
		
	}
	
}
