
public class HomeController {
	
	@Mapping("/home.do")
	public String home() {
		return null;
	}
	
	@Mapping(value="/list.do")
	public String list() {
		return null;
	}
	
	@Mapping(value={"/detail.do"})
	public String detail() {
		return null;
	}
}
