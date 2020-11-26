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
import kr.daoko.dto.OrderStatusDTO;
import kr.daoko.service.GoodsService;
import kr.daoko.service.MemberService;
import kr.daoko.service.OrderService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private OrderService orderService;
	
	@Inject
	private GoodsService goodsService;
	
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

		MemberDTO member = memberService.viewMember(userId);
		model.addAttribute("member", member);
		
		return "member/modify";
	}
	
	// 회원정보 수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String postMemberModify(MemberDTO dto) throws Exception {
		logger.info("from MemberController: postMemberModify()");

		memberService.modifyMember(dto);
		
		return "redirect:/member/list";
	}
	
	// 회원정보 삭제 처리
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postMemberDelete(@RequestParam("userId") String userId) throws Exception {
		logger.info("from MemberController: postMemberDelete()");

		memberService.deleteMember(userId);
		
		return "redirect:/member/list";
	}
	
	// 회원 상세정보 출력
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String getMemberDetail(@RequestParam("userId") String userId, Model model) throws Exception {
		logger.info("from MemberController: postMemberDetail()");

		MemberDTO member = memberService.viewMember(userId);
		OrderStatusDTO status = orderService.orderStates(userId);
		
		logger.info("주문접수: " + status.getReceipt());
		logger.info("주문처리: " + status.getProcessing());
		logger.info("교환접수: " + status.getExchange());
		logger.info("반품접수: " + status.getRefund());
		logger.info("취소접수: " + status.getCancel());
		
		model.addAttribute("member", member);
		model.addAttribute("status", status);
		
		return "member/detail";
	}
	/*
	//특정 상품구매 회원 출력 
	@GetMapping("/detail")
	public String getDetail(@RequestParam String gdsCode, Model model) throws Exception{
		logger.info("getDetail()");
		GoodsMemberDTO member1 = 
		List<GoodsMemberDTO> member = memberService.goodsMember(gdsCode);
		GoodsDTO goods = goodsService.goodsView(member.getUserId());
		
		model.addAttribute("member", member);
		model.addAttribute("detail", detail);
		model.addAttribute("goods", goods);
		return "member/detail";
	}*/
	
	
}
