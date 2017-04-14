package kr.co.jhta.vo;

public class OpenLecturePagination {

	private int pagesPerBlock = 5;	// 한 화면에 표시할 내비게이션 갯수
	private int rowsPerPage = 5;	//한 화면에 표시할 데이터 갯수
	private int totalRows;			//전체 데이터 갯수
	private int currentPage;		//현재 페이지 번호
	
	
	/*
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}
	
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	생성자 매소드 만들기
	 */
	
	public OpenLecturePagination(int currentPage, int totalRows){
		this.currentPage = currentPage;
		this.totalRows = totalRows;
	}
	
	
	
	public OpenLecturePagination(int rowsPerPage, int currentPage, int totalRows){
		this.rowsPerPage = rowsPerPage;
		this.currentPage = currentPage;
		this.totalRows = totalRows;
	}
	
	//시작페이지 계산 하고 반환 
	public int getBeginIndex() {
		return (currentPage - 1) * rowsPerPage + 1;
	}
	public int getEndIndex(){
		return currentPage*rowsPerPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	//전체 페이지 갯수
	//전체 페이지 갯수 계산 하고 반환 : ex) 110/10 의 ceil값은 11 값을 반환
	public int getTotalPages() {
		return (int) Math.ceil((double) totalRows/rowsPerPage);
	}
	//전체 페이지 블록 갯수
	public int getTotalBlocks(){
		return (int) Math.ceil((double) getTotalPages()/pagesPerBlock);
	}
	//현재 페이지 번호
	public int getCurrentBlock(){
		return (int) Math.ceil((double) currentPage/pagesPerBlock);
	}
	//표시할 페이지 시작번호
	public int getBeginPage(){
		return (getCurrentBlock() - 1) * pagesPerBlock + 1;
	}
	//표시할 페이지 끝번호
	public int getEndPage(){
		int endPage = getCurrentBlock() * pagesPerBlock;
		if(getCurrentBlock() == getTotalBlocks()){
			//맨 마지막 페이지 번호
			endPage = getTotalPages();
		}
		
		return endPage;
	}
	//이전 블록의 페이지 번호
	public int getPrevBlock(){
		return (getCurrentBlock() - 1) * pagesPerBlock;
	}
	//다음 블록의 페이지 번호
	public int getNextBlock(){
		return getCurrentBlock() * pagesPerBlock + 1;
	}
	
}
