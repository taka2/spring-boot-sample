package web;

import org.hibernate.validator.constraints.NotEmpty;

public class UsersForm {
	@NotEmpty(message="ユーザIDは必須です")
	private String userid;
	@NotEmpty(message="パスワードは必須です")
	private String password;
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
}
