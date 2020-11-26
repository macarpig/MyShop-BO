package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.dao.StatDAO;
import kr.daoko.dto.StatDTO;


@Service
public class StatServiceImpl implements StatService {
	@Inject
	private StatDAO dao;

	@Override
	public List<StatDTO> listStat() throws Exception {
		return dao.listStat();
	}

}
