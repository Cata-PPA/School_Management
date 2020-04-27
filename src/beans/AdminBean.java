package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.User;
import model.UserList;

@ManagedBean
@ViewScoped
public class AdminBean implements Serializable {

	private static final long serialVersionUID = -7828490240688231419L;

	private UserList users = new UserList();

	private User selectedUser = new User();
	private User user = new User();

	public List<User> getAllUsers() {
		return users.getUsers();
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void insertUser(User user) {
		users.add(user);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User inserted successfully.", ""));

	}

	public void updateUser(User user) {
		User userFromDb = users.getUserById(user.getId());
		userFromDb.setUsername(user.getUsername());
		userFromDb.setPassword(user.getPassword());

		users.update(userFromDb);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User updated successfully.", ""));

	}

	public void deleteUser(User user) {
		users.remove(user);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "User deleted successfully.", ""));
	}
}
