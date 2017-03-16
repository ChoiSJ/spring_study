package kr.co.jhta;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import kr.co.jhta.dao.BoardDAO;
import kr.co.jhta.vo.Board;

public class App {
	
	public static void main(String[] args) {
		
		String resources = "classpath:/META-INF/spring/app-context.xml";
		GenericXmlApplicationContext container = new GenericXmlApplicationContext(resources);
		BoardDAO dao = container.getBean("boardDao", BoardDAO.class);
		
		//Board board = new Board("테스트", "관리자", "게시판 테스트 중입니다.");
		//dao.addBoard(board);
		List<Board> boardList = dao.getAllBoards();
		System.out.println("게시글 갯수:" + boardList.size());
		container.close();
	}
}
