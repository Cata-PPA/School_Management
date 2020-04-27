package model;

public class Teacher extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -832578238870919551L;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(int id, String username, String password, UserType type) {
		super(id, username, password, type);
		// TODO Auto-generated constructor stub
	}

	public Teacher(String username, String password, UserType type, int id, String picture) {
		super(username, password, type, id, picture);
		// TODO Auto-generated constructor stub
	}

	public Teacher(String username, String password, UserType type, String email, Sex sex, String firstname,
			String lastname, int id, String picture) {
		super(username, password, type, email, sex, firstname, lastname, id, picture);
		// TODO Auto-generated constructor stub
	}

}
