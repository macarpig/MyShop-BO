package kr.daoko.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderStatusDTO;
import kr.daoko.service.GoodsService;
import kr.daoko.service.MemberService;
import kr.daoko.service.OrderService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private OrderService orderService;
	@Inject
	private MemberService memberservice;
	@Inject
	private GoodsService goodsservice;
	
	// 濡쒓렇�씤 �럹�씠吏� 異쒕젰
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLogin() {
		logger.info("from HomeController: getLogin()");
		
		return "login";
	}
	
	// 硫붿씤 �럹�씠吏� 異쒕젰
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String getMain(Model model) throws Exception {
		logger.info("from HomeController: getMain()");
		
		int m_count = memberservice.memberCount();
		int g_count = goodsservice.productCount();
		
		OrderStatusDTO states = orderService.orderStates();
		model.addAttribute("goods", g_count);
		model.addAttribute("states", states);
		model.addAttribute("member", m_count);
		return "main";
	}
}

