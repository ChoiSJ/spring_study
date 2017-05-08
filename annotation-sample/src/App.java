
public class App {
	
	public static void main(String[] args) {
		
		Person p = new Person();
		p.setUserid("hong");
		p.setPassword("zxcv1234");
		p.setUsername("홍진호");
		
		System.out.println(ToStrings.toString(p));
		
		HomeController c = new HomeController();
		Mappings.processMapping(c);
	}
}
