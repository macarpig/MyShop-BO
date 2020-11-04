package kr.daoko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 회원관리 페이지 출력
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList() {
		logger.info("from MemberController: getList()");

		return "member/list";
	}
}
