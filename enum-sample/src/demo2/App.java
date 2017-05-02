package demo2;

public class App {
	
	public static void shipping(Cloth cloth) {
		if (Size.SMALL == cloth.getSize()) {
			System.out.println("무료");
		} else if (Size.MEDIUM == cloth.getSize()) {
			System.out.println("1만원");
		} else if (Size.LARGE == cloth.getSize()) {
			System.out.println("100만원");
		}
	}
	
	public static void main(String[] args) {
		
		Cloth shirt = new Cloth("셔츠", Size.LARGE);
		Cloth panth = new Cloth("바지", Size.SMALL);
		
		shipping(shirt);
		shipping(panth);
	}
}
