package demo2;

public class Cloth {
	
	private String name;
	private Size size;	// enum 타입
	
	public Cloth() {}
	public Cloth(String name, Size size) {
		this.name = name;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
}
