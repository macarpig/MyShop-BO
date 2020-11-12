package kr.daoko.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderDTO;
import kr.daoko.dto.OrderDetailDTO;
import kr.daoko.dto.OrderStatusDTO;
import kr.daoko.service.MemberService;
import kr.daoko.service.OrderService;

@Controller
@RequestMapping("/order/*")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Inject
	private MemberService memberService;
	@Inject
	private OrderService orderService;
	
	@GetMapping("/inquiry")
	public String getInquiry(Model model) throws Exception {
		logger.info("from OrderController: getInquiry()");

		OrderStatusDTO states = orderService.orderStates();
		model.addAttribute("states", states);
		
		return "order/inquiry";
	}

	@GetMapping("/manage")
	public String getManage() {
		logger.info("from OrderController: getManage()");
				
		return "order/manage";
	}
	
	@GetMapping("/detail")
	public String getDetail(@RequestParam String orderId, Model model) throws Exception{
		logger.info("from OrderController: getDetail()");
		
		OrderDTO order = orderService.orderInfo(orderId);
		List<OrderDetailDTO> detail = orderService.orderDetail(orderId);
		MemberDTO member = memberService.viewMember(order.getUserId());
		
		model.addAttribute("order", order);
		model.addAttribute("detail", detail);
		model.addAttribute("member", member);
		return "order/detail";
	}
	
	@GetMapping("/processing")
	public String getProcessing() {
		logger.info("from OrderController: getProcessing()");
		
		return "order/processing";
	}
	
}
