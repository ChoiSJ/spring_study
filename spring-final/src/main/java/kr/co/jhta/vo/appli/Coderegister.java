package kr.co.jhta.vo.appli;

public class Coderegister {
	
	private String name;
	private String code;
	private String preCode;
	
	public Coderegister() {
		
	}
	
	public Coderegister(String name, String code, String preCode) {
		super();
		this.name = name;
		this.code = code;
		this.preCode = preCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPreCode() {
		return preCode;
	}
	public void setPreCode(String preCode) {
		this.preCode = preCode;
	}
	
}
