package kr.co.jhta.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import kr.co.jhta.vo.Board;

public class BoardDAOImpl implements BoardDAO {
	
	static Logger logger = Logger.getLogger(BoardDAOImpl.class);
	
	private SqlMapClientTemplate template;
	
	public void setTemplate(SqlMapClientTemplate template) {
		this.template = template;
	}
	
	public void addBoard(Board board) {
		logger.debug("start");
		logger.debug("게시글:" + board);
		
		template.insert("addBoard", board);
		
		logger.debug("end");
	}
	
	@SuppressWarnings("unchecked")
	public List<Board> getAllBoards() {
		logger.debug("start");
		
		List<Board> boardList = template.queryForList("getAllBoards");
		
		logger.debug("조회결과:" + boardList);
		logger.info("조회건수:" + boardList.size());
		
		logger.debug("end");
		return boardList;
	}
}
