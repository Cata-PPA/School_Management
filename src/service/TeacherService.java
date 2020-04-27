package service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Sex;
import model.Teacher;
import model.UserType;

@ManagedBean(name = "teacherService")
@ApplicationScoped
public class TeacherService {

	public List<Teacher> createTeachers() {
		List<Teacher> list = new ArrayList<Teacher>();

		list.add(new Teacher("prof", "prof", UserType.TEACHER, "teacher@example.com", Sex.FEMALE, "Aurelia", "Popescu",
				getRandomId(), "o poza"));
		list.add(new Teacher("profesor", "prof", UserType.TEACHER, "teacher2@example.com", Sex.MALE, "Catalin", "Popa",
				getRandomId(), "o poza"));
		return list;
	}

	private int getRandomId() {
		return (int) (Math.random() * 10);
	}


}