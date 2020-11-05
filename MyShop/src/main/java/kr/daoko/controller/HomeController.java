package kr.daoko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// 濡쒓렇�씤 �럹�씠吏� 異쒕젰
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLogin() {
		logger.info("from HomeController: getLogin()");
		
		return "login";
	}
	
	// 硫붿씤 �럹�씠吏� 異쒕젰
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String getMain() {
		logger.info("from HomeController: getMain()");
		
		return "main";
	}
}