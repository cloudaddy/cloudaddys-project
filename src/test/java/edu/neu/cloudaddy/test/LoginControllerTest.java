package edu.neu.cloudaddy.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import edu.neu.cloudaddy.controllers.LoginController;

public class LoginControllerTest {
	
	@After
	public void afterTest(){
		System.out.println("After supplier service Test");
	}
	
	@Test
	public void TestLoginController() throws Exception {
			assertEquals("login", LoginController.login());
	}
	
}
