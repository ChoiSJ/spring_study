package kr.co.jhta.vo;

public class BoardView {
	
	private int no;
	private int bno;
	private String userId;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BoardView [no=" + no + ", bno=" + bno + ", userId=" + userId + "]";
	}
	
}
