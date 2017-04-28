package kr.co.jhta.vo.stu;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class StudentForm {
	
	@NotNull
	@Length(max=14, message="000-0000-0000 형식입니다.")
	@Pattern(regexp="\\d{2,3}-\\d{3,4}-\\d{4}", message="올바른 형식을 입력하세요(000-0000-0000)")
	private String phone;
	
	@NotNull
	@Pattern(regexp="[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}", message="올바른 이메일 형식을 입력하세요")
	private String email;
	
	private int zipcode;
	
	@NotNull
	private String addr1;
	
	private String addr2;
	@NotNull
	private String addr3;


	@Length(max=14, message="000-0000-0000 형식입니다.")
	@Pattern(regexp="\\d{2,3}-\\d{3,4}-\\d{4}", message="올바른 형식을 입력하세요(000-0000-0000)")
	private String parentPhone;

	private int no;
	public StudentForm() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	public String getAddr3() {
		return addr3;
	}

	public void setAddr3(String addr3) {
		this.addr3 = addr3;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "StudentForm [phone=" + phone + ", email=" + email + ", zipcode=" + zipcode + ", addr1=" + addr1
				+ ", addr2=" + addr2 + ", addr3=" + addr3 + ", parentPhone=" + parentPhone + ", no=" + no + "]";
	}


	
}
