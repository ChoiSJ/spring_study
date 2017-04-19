package kr.co.jhta.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.board.BoardDao;
import kr.co.jhta.vo.Board;
import kr.co.jhta.vo.BoardView;
import kr.co.jhta.vo.SearchForm;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public void addNoticeBoard(Board board) {
		boardDao.addNoticeBoard(board);
		
	}

	@Override
	public int searchBoardCount(SearchForm searchForm) {
		return boardDao.searchBoardCount(searchForm);
	}

	@Override
	public List<Board> searchBoard(SearchForm searchForm) {
		return boardDao.searchBoard(searchForm);
	}

	@Override
	public void deleteBoardByNo(int no) {

		boardDao.deleteBoardByNo(no);
	}

	@Override
	public Board getBoard(int no) {
		return boardDao.getBoard(no);
	}

	@Override
	public void updateBoard(Map<String, Object> map) {
		boardDao.updateBoard(map);
		
	}

	@Override
	public void updateBoardByViewUser(HashMap<String, Object> map) {
		boardDao.updateBoardByViewUser(map);
		
	}

	@Override
	public void updateCount(int bno) {
		boardDao.updateCount(bno);
		
	}

	@Override
	public void addBoardView(BoardView view) {
		boardDao.addBoardView(view);
		
	}

	@Override
	public List<BoardView> getBoardViewUser(int bno) {
		return boardDao.getBoardViewUser(bno);
	}

	@Override
	public List<Board> serachBoardByType(String boardType) {

		return boardDao.serachBoardByType(boardType);
	}

	@Override
	public void deleteView(int no) {
		boardDao.deleteView(no);
		
	}

	@Override
	public void addProfBoard(Board board) {
		boardDao.addProfBoard(board);
		
	}

	
}
