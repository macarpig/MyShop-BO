package kr.daoko.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;
import kr.daoko.dto.OrderDetailDTO;
import kr.daoko.service.MemberService;
import kr.daoko.service.OrderService;

@Controller
@RequestMapping("/order/*")
public class OrderController {

	@Inject
	private MemberService memberService;
	@Inject
	private OrderService orderService;
	
	@GetMapping("/inquiry")
	public String getInquiry() {
		return "order/inquiry";
	}
	
	@GetMapping("/detail")
	public String getDetail(@RequestParam String orderId, Model model) throws Exception{
		OrderDTO order = orderService.orderInfo(orderId);
		List<OrderDetailDTO> detail = orderService.orderDetail(orderId);
		MemberDTO member = memberService.memberInfo(order.getUserId());
		
		model.addAttribute("order", order);
		model.addAttribute("detail", detail);
		model.addAttribute("member", member);
		return "order/detail";
	}
}
