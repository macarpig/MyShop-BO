package kr.daoko.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.daoko.dto.MemberDTO;
import kr.daoko.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService service;
	
	// 회원관리 페이지 출력
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getList() {
		logger.info("from MemberController: getList()");

		return "member/list";
	}
	
	// 회원정보 수정 페이지 출력
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String getMemberModify(@RequestParam("userId") String userId, Model model) throws Exception {
		logger.info("from MemberController: getMemberModify()");

		MemberDTO member = service.viewMember(userId);
		model.addAttribute("member", member);
		
		return "member/modify";
	}
	
	// 회원정보 수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postMemberModify(MemberDTO dto) throws Exception {
		logger.info("from MemberController: postMemberModify()");

		service.modifyMember(dto);
		
		return "redirect:/member/list";
	}
	
	// 회원정보 삭제 처리
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postMemberDelete(@RequestParam("userId") String userId) throws Exception {
		logger.info("from MemberController: postMemberDelete()");

		service.deleteMember(userId);
		
		return "redirect:/member/list";
	}
	
	// 회원 상세정보 출력
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String getMemberDetail(@RequestParam("userId") String userId, Model model) throws Exception {
		logger.info("from MemberController: postMemberDetail()");

		MemberDTO member = service.viewMember(userId);
		model.addAttribute("member", member);
		
		return "member/detail";
	}
}
