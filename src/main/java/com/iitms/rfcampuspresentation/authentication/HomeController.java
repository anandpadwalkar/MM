package com.iitms.rfcampuspresentation.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iitms.rfcampusdata.authentication.entity.TestSession;
import com.iitms.rfcampusdomain.authentication.service.DomainService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private TestSession testSession;
	@Autowired
	private DomainService domainService;
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		// testSession.setUsername("roshan");
		return model;

	}

	@RequestMapping(value = "/admin*", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");
		//sessionUser.setUsername("Updated");
logger.info("Login : " + testSession.getUsername());
		return model;

	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public ModelAndView hi() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", domainService.getMessage());
		model.setViewName("admin");
		//sessionUser.setUsername("Updated");
		return model;

	}
}
