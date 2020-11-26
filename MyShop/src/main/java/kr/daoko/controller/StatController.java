package kr.daoko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stat/*")
public class StatController {
	private static final Logger logger = LoggerFactory.getLogger(StatController.class);


	
	@GetMapping("/manage")
	public String getManage() {
		logger.info("from StatController: getManage()");
		return "/stat/manage";
	}
}
