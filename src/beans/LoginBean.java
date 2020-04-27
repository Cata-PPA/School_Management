package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.User;
import model.UserList;

@SessionScoped
@ManagedBean(name = "loginBean")
public class LoginBean {
	public static User userfromDB= new User();
	private User loginUser = new User();

	private UserList users = new UserList();

	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public String login() {

		userfromDB = users.login(loginUser);

		if (userfromDB == null) {

			return "login.xhtml?faces-redirect=true";
		} else {
			switch (userfromDB.getType()) {
			case ADMIN:
				return "admin.xhtml?faces-redirect=true";

			case STUDENT:

				return "student.xhtml?faces-redirect=true";

			case TEACHER:
				return "teacher.xhtml?faces-redirect=true";
			default:
				return "login.xhtml?faces-redirect=true";
			}

		}
	}

	public String logout() {
		return "login.xhtml?faces-redirect=true";
	}
}
