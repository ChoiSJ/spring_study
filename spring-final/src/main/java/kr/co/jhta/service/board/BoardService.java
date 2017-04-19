package kr.co.jhta.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.Board;
import kr.co.jhta.vo.BoardView;
import kr.co.jhta.vo.SearchForm;

public interface BoardService {

	void addNoticeBoard(Board board);

	int searchBoardCount(SearchForm searchForm);

	List<Board> searchBoard(SearchForm searchForm);

	void deleteBoardByNo(int no);

	Board getBoard(int no);

	void updateBoard(Map<String, Object> map);

	void updateBoardByViewUser(HashMap<String, Object> map);

	void updateCount(int bno);

	void addBoardView(BoardView view);

	List<BoardView> getBoardViewUser(int bno);

	List<Board> serachBoardByType(String boardType);

	void deleteView(int no);

	void addProfBoard(Board board);

}
