package kr.co.jhta.vo;

public class SearchForm {
	private int pageNo = 1;
	private String searchType;
	private String keyword;
	private int beginIndex;
	private int endIndex;
	private int display;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
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
	@Override
	public String toString() {
		return "SearchForm [pageNo=" + pageNo + ", searchType=" + searchType + ", keyword=" + keyword + ", beginIndex="
				+ beginIndex + ", endIndex=" + endIndex + ", display=" + display + "]";
	}
	
	
}
