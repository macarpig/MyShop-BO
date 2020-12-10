package kr.daoko.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.dto.QnaDTO;
import kr.daoko.dto.StatChartDTO;
import kr.daoko.dto.StatDTO;

@Repository
public class StatDAOImpl implements StatDAO {
	@Inject
	private SqlSession sql;
	
	// mapper
	private static String NAMESPACE = "kr.daoko.mapper.statMapper";


	// 매출 목록 조회
	@Override
	public List<StatDTO> listStat(StatDTO stat) throws Exception {
		return sql.selectList(NAMESPACE + ".statList", stat);
	}


	//매출 차트 조회
	@Override
	public List<StatChartDTO> statChart(StatDTO stat) throws Exception {
		return sql.selectList(NAMESPACE + ".statChart", stat);
	}


	@Override
	public int statMonth() throws Exception {
		return sql.selectOne(NAMESPACE + ".statMonth");
	}
}
