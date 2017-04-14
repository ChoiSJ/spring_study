package kr.co.jhta.vo;

public class LoginForm {
	
	private String userId;
	private String userPwd;
	private String loginType;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	@Override
	public String toString() {
		return "LoginForm [userId=" + userId + ", userPwd=" + userPwd + ", loginType=" + loginType + "]";
	}
}
