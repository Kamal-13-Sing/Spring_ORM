package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import springORMsecond.Student;

public class StudentDaoImplements implements StudentDao {

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	boolean status = false;
	@Transactional
	public boolean save(Student s) {

		template.save(s);
		status = true;
		return status;
	}

	public List<Student> getAllStudent() {

		List<Student> st = template.loadAll(Student.class);
		return st;
	}

	public Student getStudent(int id) {
		Student st = template.get(Student.class, id);
		return st;
	}

	@Transactional
	public String update(Student s) {

		template.update(s);
		return "Update Sucess";
	}

	@Transactional
	public String delete(int id) {

		Student s = template.get(Student.class, id);
		template.delete(s);
		return "delete Sucess";
	}

}
