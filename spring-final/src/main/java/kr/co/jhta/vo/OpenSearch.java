package kr.co.jhta.vo;

public class OpenSearch {

	private int pageNo = 1; //현재 페이지 번호  페이지번호가 없으면 무조건 1번이 들어감.
	private String opt;	//검색옵션
	private String keyword;	//검색키워드
	private int beginIndex; //조회시작번호
	private int endIndex;	//조회 번호 끝
	private int display;	//화면에 표시되는 갯수
	
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getOpt() {
		return opt;
	}
	public void setOpt(String opt) {
		this.opt = opt;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	
	
	
	
}
