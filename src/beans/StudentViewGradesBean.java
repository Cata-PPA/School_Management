package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Grade;
import model.User;
import service.GradeService;

@ManagedBean(name = "studentViewGrades")
@ViewScoped
public class StudentViewGradesBean implements Serializable {
	GradeService service = new GradeService();

	public List<Grade> getStudentGrades(User user) {
		// User user=LoginBean.userfromDB;

		return service.getStudentGrades(user);

	}
}