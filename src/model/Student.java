package model;

public class Student extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8371884225736179671L;
	private int group;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String username, String password, UserType type) {
		super(id, username, password, type);
		// TODO Auto-generated constructor stub
	}

	public Student(String username, String password, UserType type, int id, String picture) {
		super(username, password, type, id, picture);
		// TODO Auto-generated constructor stub
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
}
