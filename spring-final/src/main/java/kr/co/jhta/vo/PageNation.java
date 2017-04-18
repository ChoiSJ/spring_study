package kr.co.jhta.vo;

public class PageNation {
	
	private int pagesPerBlock = 5;	// 한 화면에 표시할 내비게이션 갯수
	private int rowsPerPage = 5;	// 한 화면에 표시할 데이터 갯수
	private int totalRows;			// 전체 데이터 갯수
	private int currentPage;		// 현재 페이지 번호
	
	public PageNation(int currentPage, int totalRows) {
		this.currentPage = currentPage;
		this.totalRows = totalRows;
	}
	
	public PageNation(int rowsPerPage, int currentPage, int totalRows) {
		this.rowsPerPage = rowsPerPage;
		this.currentPage = currentPage;
		this.totalRows = totalRows;
	}
	
	// 전체 페이지 갯수 계산: ceil(107/10) -> 11
	public int getTotalPages() {
		return (int) Math.ceil((double) totalRows/rowsPerPage);
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getBeginIndex() {
		return (currentPage - 1) * rowsPerPage + 1;
	}
	public int getEndIndex() {
		return currentPage * rowsPerPage;
	}
	
	public int getTotalBlocks() {
		return (int) Math.ceil((double) getTotalPages()/pagesPerBlock);
	}
	public int getCurrentBlock() {
		return (int) Math.ceil((double) currentPage/pagesPerBlock);
	}
	public int getBeginPage() {
		return (getCurrentBlock() -1) * pagesPerBlock + 1;
	}
	public int getEndPage() {
		int endPage = getCurrentBlock() * pagesPerBlock;
		
		if (getCurrentBlock() == getTotalBlocks()) {
			endPage = getTotalPages();
		}
		
		return endPage;
	}
	
	public int getPrevBlock() {
		return (getCurrentBlock() - 1) * pagesPerBlock;
	}
	public int getNextBlock() {
		return getCurrentBlock() * pagesPerBlock + 1;
	}

	@Override
	public String toString() {
		return "PageNation [pagesPerBlock=" + pagesPerBlock + ", rowsPerPage=" + rowsPerPage + ", totalRows="
				+ totalRows + ", currentPage=" + currentPage + "]";
	}
	
	
}
