package dao;

import java.util.List;

import springORMsecond.Student;

public interface StudentDao {
	
	public boolean save(Student s);
	
	public List<Student> getAllStudent();
	
	public Student getStudent(int id);
	
	public String update(Student s);
	
	public String delete(int id);
	

}
