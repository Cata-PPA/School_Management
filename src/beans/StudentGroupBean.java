package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Student;
import model.User;
import model.UserList;

@ManagedBean
@ViewScoped
public class StudentGroupBean implements Serializable {

	private static final long serialVersionUID = -7828490240688231419L;

	private UserList users = new UserList();

	private User selectedStudent = new Student();

	public List<Student> getAllStudentsWithSameGroup(User user) {
		//User user=LoginBean.userfromDB;
		System.out.println("sunt in student bean");
		System.out.println("username  " + user.getUsername());
		return users.getStudentsFromSameGroup(user);

	}

	public User getSelectedStudent() {
		return selectedStudent;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

}
