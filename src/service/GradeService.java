package service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import model.Grade;
import model.Sex;
import model.Student;
import model.Teacher;
import model.User;
import model.UserType;

@ManagedBean(name = "gradeService")
@ApplicationScoped
public class GradeService {
	List<Grade> list;

	public GradeService() {
		createGrades();
	}

	public List<Grade> createGrades() {
		list = new ArrayList<Grade>();
		Student user1 = new Student(0, "iulia", "iulia", UserType.STUDENT);
		user1.setPicture("‪http://localhost:8080/SchoolManagementSystem/WebContent/images/stu.jpg");
		user1.setGroup(1);
		user1.setSex(Sex.FEMALE);
		Grade grade = new Grade("UID", new Teacher("prof", "prof", UserType.TEACHER, "teacher@example.com", Sex.MALE,
				"Iulian Viorel", "Popa", getRandomId(), "o poza"), user1, 9, "good");
		list.add(grade);

		return list;
	}

	private int getRandomId() {
		return (int) (Math.random() * 10);
	}

	public List<Grade> getStudentGrades(User user) {
		List<Grade> grades = new ArrayList<Grade>();
		for (Grade grade : list)
			if (grade.getStudent().getUsername().equals(user.getUsername()))
				grades.add(grade);
		return grades;
	}

}
