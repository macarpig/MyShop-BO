package kr.daoko.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.daoko.dto.MemberDTO;
import kr.daoko.dto.OrderStatusDTO;
import kr.daoko.service.GoodsService;
import kr.daoko.service.MemberService;
import kr.daoko.service.OrderService;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Inject
	private OrderService orderService;
	
	@Inject
	private MemberService memberService;
	
	@Inject
	private GoodsService goodsService;
	
	// 濡쒓렇�씤 �럹�씠吏� 異쒕젰
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLogin() {
		logger.info("from HomeController: getLogin()");
		
		return "login";
	}
	
	// 로그인 처리
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postLogin(MemberDTO dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("from HomeController: postLogin()");

		MemberDTO login = memberService.login(dto);
		HttpSession session = req.getSession();
		
		boolean pwMatch = pwEncoder.matches(dto.getUserPw(), login.getUserPw());
		
		if(login != null && pwMatch) {
			session.setAttribute("member", login);
		}
		
		else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/";
		}
		
		return "redirect:/main";
	}
	
	// 로그아웃 처리
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout(HttpSession session) throws Exception {
		logger.info("from HomeController: getLogout()");

		memberService.logout(session);
		
		return "redirect:/";
	}
	
	// 硫붿씤 �럹�씠吏� 異쒕젰
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String getMain(Model model) throws Exception {
		logger.info("from HomeController: getMain()");
		
		int m_count = memberService.memberCount();
		int g_count = goodsService.productCount();
		
		OrderStatusDTO states = orderService.orderStates();
		model.addAttribute("goods", g_count);
		model.addAttribute("states", states);
		model.addAttribute("member", m_count);
		return "main";
	}
}

