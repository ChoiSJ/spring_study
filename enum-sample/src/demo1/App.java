package demo1;

public class App {
	
	public static void display(int season) {
		if (Season.SPRING == season) {
			System.out.println("소풍가자");
		} else if (Season.SUMMER == season) {
			System.out.println("바다가자");
		} else if (Season.FALL == season) {
			System.out.println("단풍가자");
		} else if (Season.WINTER == season) {
			System.out.println("스키가자");
		}
	}
	
	public static void main(String[] args) {
		display(Season.SPRING);
		display(Season.WINTER);
		
		display(2);
		display(10);
	}
}
