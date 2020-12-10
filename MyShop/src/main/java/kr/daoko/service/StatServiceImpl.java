package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.dao.StatDAO;
import kr.daoko.dto.StatChartDTO;
import kr.daoko.dto.StatDTO;


@Service
public class StatServiceImpl implements StatService {
	@Inject
	private StatDAO dao;

	@Override
	public List<StatDTO> listStat(StatDTO stat) throws Exception {
		return dao.listStat(stat);
	}

	@Override
	public List<StatChartDTO> statChart(StatDTO stat) throws Exception {
		return dao.statChart(stat);
	}

	@Override
	public int statMonth() throws Exception {
		return dao.statMonth();
	}

}
