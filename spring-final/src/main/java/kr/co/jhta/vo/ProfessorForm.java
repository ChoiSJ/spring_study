package kr.co.jhta.vo;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class ProfessorForm {
	@Length(max=14, message="000-0000-0000 형식입니다.")
	@Pattern(regexp="\\d{2,3}-\\d{3,4}-\\d{4}", message="올바른 형식을 입력하세요(000-0000-0000)")
	private String phone;
	
	@Pattern(regexp="[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}", message="올바른 이메일 형식을 입력하세요")
	private String email;
	private String addr;
	private String pwd;
	
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "ProfessorForm [phone=" + phone + ", email=" + email + ", addr=" + addr + ", pwd=" + pwd + "]";
	}
	
	
}
