package model;

import java.util.ArrayList;
import java.util.List;

public class UserList {

	List<User> users = new ArrayList<User>();
	int id = 0;

	public UserList() {
		if (users.isEmpty())
			initUsers();
	}

	public void initUsers() {
		Student user1 = new Student(id++, "Marius", "marius", UserType.STUDENT);
		user1.setPicture("‪http://localhost:8080/SchoolManagementSystem/WebContent/images/male_avatar.png");
		user1.setGroup(1);
		user1.setSex(Sex.FEMALE);
		
		User user2 = new User(id++, "admin", "admin", UserType.ADMIN);
		user2.setPicture("‪WebContent/images/admin_avatar.png");
		
		User user3 = new User(id++, "Profesor", "profesor", UserType.TEACHER);
		user3.setPicture("‪http://localhost:8080/SchoolManagementSystem/WebContent/images/profesor_avatar.png");
		
		Student user4 = new Student(id++, "Teo", "teo", UserType.STUDENT);
		user4.setPicture("‪‪http://localhost:8080/SchoolManagementSystem/WebContent/images/female_avatar.png");
		user4.setGroup(1);
		user4.setSex(Sex.FEMALE);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}

	public List<User> getUsers() {
		return users;
	}

	public User login(User user) {
		for (User iterator : users)
			if (iterator.getUsername().equals(user.getUsername()) && iterator.getPassword().equals(user.getPassword()))
				return iterator;
		return null;
	}

	public void add(User user) {
		user.setId(id++);
		users.add(user);
	}

	public User remove(User user) {
		for (User iterator : users)
			if (iterator.getId() == user.getId()) {
				users.remove(iterator);
				return iterator;
			}
		return null;
	}

	public void update(User user) {
		for (User iterator : users)
			if (iterator.getId() == user.getId()) {
				iterator.setUsername(user.getUsername());
				iterator.setPassword(user.getPassword());
				iterator.setType(user.getType());
			}
	}

	public User getUserById(int id) {
		for (User iterator : users)
			if (iterator.getId() == id)
				return iterator;
		return null;

	}

	public User getUserByUsername(String username) {
		for (User iterator : users)
			if (iterator.getUsername().equals(username))
				return iterator;
		return null;

	}

	public List<Student> getStudentsFromSameGroup(User user) {

		Student student = getStudent(user);
		System.out.println("Ce grupa are studentul gasit? " + student.getGroup());
		ArrayList<Student> group = new ArrayList<Student>();
		Student aux;
		for (User iterator : users)
			if (iterator instanceof Student) {
				System.out.println("E vb de instanta");
				aux = (Student) iterator;
				if (aux.getGroup() == student.getGroup() && !aux.getUsername().equals(student.getUsername())) {
					System.out.println("Am gasit studentul din acceasi grupa");
					group.add(aux);
				}
			}
		return group;
	}

	public Student getStudent(User user) {
		for (User iterator : users)
			if (iterator instanceof Student && iterator.getUsername().equals(user.getUsername())) {
				System.out.println("Am gasit studentul");
				return (Student) iterator;
			}
		return new Student();
	}
}
