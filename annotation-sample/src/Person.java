@ToString
public class Person {
	
	@ToString
	private String userid;
	@ToString
	private String password;
	@ToString(include=true)
	private String username;
	
	public Person() {}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
