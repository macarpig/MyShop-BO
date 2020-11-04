package kr.daoko.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.daoko.dto.MemberDTO;
import kr.daoko.service.MemberService;

@Controller
@RequestMapping("/api/*")
public class ApiController {
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Inject
	private MemberService memberService;
	
	// 회원 목록
	@ResponseBody
	@RequestMapping(value = "/member/list", produces = "application/json", method = RequestMethod.GET)
	public String getMemberList() throws Exception {
		logger.info("from ApiController: getMemberList()");
		
		List<MemberDTO> list = memberService.listMember();
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		return json;
	}
}
