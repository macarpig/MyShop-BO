package kr.daoko.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.daoko.dto.GoodsDTO;
import kr.daoko.dto.MemberDTO;
import kr.daoko.service.GoodsService;

@Controller
@RequestMapping("/goods/*")
public class GoodsController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	GoodsService g_service;
	//모든 상품 조회
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
	
	//상품 등록 처
	@PostMapping("/addwindow")
	public String postGoodsAdd(GoodsDTO dto) throws Exception {
		logger.info("postGoodsAdd()");
		
		g_service.addProduct(dto);
		return "redirect:/goods/manage";
	}
	
	//상품 수정
	@GetMapping("/modifywindow")
		public String getGoodsModify(@RequestParam("gdsCode") String gdsCode, Model model) throws Exception {
			logger.info("getGoodsModify()");

			GoodsDTO goods = g_service.goodsView(gdsCode);
			model.addAttribute("goods",goods);
			
			return "goods/modify";
		}
		
	// 상품 수 처리
	@PostMapping("/modifywindow")
		public String postGoodsModify(GoodsDTO dto) throws Exception {
			logger.info("postGoodsModify()");

			g_service.modifyGoods(dto);
			
			return "redirect:/goods/manage";
		}
}
