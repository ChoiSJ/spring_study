package kr.co.jhta.vo;

import java.util.List;

public class OpenLectureResult<T> {

	private List<T> data;
	private int rows;
	
	private String message;
	private int code;
	
	/*
	 * ex)
	 *  data: [{}, {}, {}],
	 *  rows: 107,
	 *  message: "데이터 조회완료",
	 *  code:1 
	 */
	
	
	
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
