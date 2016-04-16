package edu.neu.cloudaddy.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import edu.neu.cloudaddy.controllers.HomeController;

public class MvcTest {

	
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(new HomeController()).alwaysExpect(
				status().isOk()).build();
	}

	@Test
	public void testController() throws Exception {
			mockMvc
				.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(content().string("home"));
	}
	
}
