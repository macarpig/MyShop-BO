package kr.daoko.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.daoko.dto.GoodsDTO;
import kr.daoko.service.GoodsService;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	GoodsService g_service;
	@GetMapping("/manage")
	public String getManage() {
		logger.info("getGoodsManage()");
		return "goods/manage";
	}
	//상품 등록 창
	
	@GetMapping("/addwindow")
	public String getAddWindow(Model model) throws Exception {
		logger.info("getGoodsaddWindow()");
		return "goods/add";
	}
	//상품 등록
	@PostMapping("/addwindow")
	public String postGoodsAdd(GoodsDTO dto) throws Exception {
		logger.info("postGoodsAdd()");
		
		g_service.add(dto);
		return "redirect:/goods/manage";
	}
}
