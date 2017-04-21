package kr.co.jhta.vo.appli;

public class LeaveForm {
	
	private String cCode;
	private String scorePass;
	private int selectSemeter;
	private String reinDate;
	private int reEno;
	private String checkboxTrue;
	private String chageReason;
	
	public LeaveForm() {
	}

	public String getcCode() {
		return cCode;
	}
	public void setcCode(String cCode) {
		this.cCode = cCode;
	}
	public String getScorePass() {
		return scorePass;
	}
	public void setScorePass(String scorePass) {
		this.scorePass = scorePass;
	}
	public int getSelectSemeter() {
		return selectSemeter;
	}
	public void setSelectSemeter(int selectSemeter) {
		this.selectSemeter = selectSemeter;
	}
	public String getReinDate() {
		return reinDate;
	}
	public void setReinDate(String reinDate) {
		this.reinDate = reinDate;
	}

	public int getReEno() {
		return reEno;
	}

	public void setReEno(int reEno) {
		this.reEno = reEno;
	}

	public String getCheckboxTrue() {
		return checkboxTrue;
	}

	public void setCheckboxTrue(String checkboxTrue) {
		this.checkboxTrue = checkboxTrue;
	}

	public String getChageReason() {
		return chageReason;
	}

	public void setChageReason(String chageReason) {
		this.chageReason = chageReason;
	}
	
	
}
