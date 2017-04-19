package kr.co.jhta.vo;

public class SubjectIsPassed {

	private int no;
	private String code;
	private String passedName;

	public SubjectIsPassed() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPassedName() {
		return passedName;
	}

	public void setPassedName(String passedName) {
		this.passedName = passedName;
	}

	public SubjectIsPassed(int no, String code, String passedName) {
		super();
		this.no = no;
		this.code = code;
		this.passedName = passedName;
	}

	@Override
	public String toString() {
		return "SubjectIsPassed [no=" + no + ", code=" + code + ", passedName=" + passedName + "]";
	}

}
