package kr.co.jhta.dao;

import java.util.List;

import kr.co.jhta.vo.Board;

public interface BoardDAO {
	
	void addBoard(Board board);
	List<Board> getAllBoards();
}
