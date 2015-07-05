package app.form;

import org.hibernate.validator.constraints.NotEmpty;

public class UsersForm {
	@NotEmpty(message="{NotEmpty.UsersForm.userid}")
	private String userid;
	@NotEmpty(message="{NotEmpty.UsersForm.password}")
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
