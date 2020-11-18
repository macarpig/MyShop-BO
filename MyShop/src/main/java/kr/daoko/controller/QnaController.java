package kr.daoko.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.daoko.service.QnaService;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Inject
	private QnaService service;
	
	//
}
