package model;

public class Grade {

	private String subject;
	private Teacher teacher;
	private Student student;
	private int mark;
	private String comment;

	public Grade(String subject, Teacher teacher, Student student, int mark, String comment) {
		super();
		this.subject = subject;
		this.teacher = teacher;
		this.student = student;
		this.mark = mark;
		this.comment=comment;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
