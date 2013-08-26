package com.programeric;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.programeric.HomeController;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
	
	@Mock Person person;
	
	@InjectMocks HomeController controller = new HomeController();

	@Test
	public void testController() {
		
		
		ModelAndView mav = controller.home();
		
		assertEquals("home", mav.getViewName());
		assertEquals("All systems optimal.", mav.getModel().get("message"));
	}
}
