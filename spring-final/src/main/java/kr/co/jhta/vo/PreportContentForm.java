package kr.co.jhta.vo;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import kr.co.jhta.vo.stu.Student;

public class PreportContentForm {
	
	@NotNull
	private int no;
	@NotNull
	private int pfNo;
	private Student student;
	@NotNull
	private String title;
	@NotNull
	private String content;
	private MultipartFile file;
	private String filename;
	private int eno;
	private int rno;
	
	public PreportContentForm() {
		
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPfNo() {
		return pfNo;
	}
	public void setPfNo(int pfNo) {
		this.pfNo = pfNo;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	
}
