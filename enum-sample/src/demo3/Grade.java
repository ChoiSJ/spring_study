package demo3;

public enum Grade {
	
	A(4), B(3), C(2), D(1), F(0);
	
	private int point;
	
	Grade(int point) {
		this.point = point;
	}
	
	public int getPoint() {
		return point;
	}
}
