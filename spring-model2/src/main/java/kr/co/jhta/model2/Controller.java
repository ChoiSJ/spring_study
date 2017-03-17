package kr.co.jhta.model2;

import javax.servlet.http.HttpServletRequest;

/**
 * 클라이언트의 요청처리를 담당하는 컨트롤러 클래스는 반드시 이 인터페이스를 구현해서 작성한다.
 * @author JHTA
 *
 */
public interface Controller {
	
	/**
	 * 클라이언트의 요청을 처리하는 메소드다.
	 * @param req 클라이언트가 서버로 전송한 요청 메세지를 담고 있는 HttpServletRequest 객체다.
	 * @return 클라이언트의 요청처리가 완료된 후 이동할 URL 이다.
	 * @throws Exception
	 */
	String exec(HttpServletRequest req) throws Exception;
}
