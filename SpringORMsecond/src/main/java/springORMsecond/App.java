package springORMsecond;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.StudentDao;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		/// System.out.println(context);
		StudentDao stdao = context.getBean("stdao", StudentDao.class);

		// System.out.println(stdao);

		// -------insert new Data---------
		/*
		 * Student s = new Student(); s.setName("bimal"); s.setAddress("palpa");
		 * s.setSalary(45000); boolean status = stdao.save(s);
		 * 
		 * if(status) { System.out.println("Insert Sucessed"); }
		 */

		// --------------read all data----------------

		/*
		 * List<Student> list = stdao.getAllStudent(); for(Student s: list) {
		 * System.out.println("Id: "+s.getId());
		 * System.out.println("Name: "+s.getName());
		 * System.out.println("Address: "+s.getAddress());
		 * System.out.println("Salary: "+s.getSalary());
		 * System.out.println("----------------"); }
		 */

		// -----------read by id---------------
		/*
		 * Student s = stdao.getStudent(3); System.out.println("Id: " + s.getId());
		 * System.out.println("Name: " + s.getName()); System.out.println("Address: " +
		 * s.getAddress()); System.out.println("Salary: " + s.getSalary());
		 */
		
		//-----------update data---------------
		
		/*
		 * Student s = new Student(); s.setId(3); s.setName("sapana");
		 * s.setAddress("Dang Update"); s.setSalary(45000); String status =
		 * stdao.update(s); System.out.println(status);
		 */
		
		//----------delete data ------------------
		
		String status = stdao.delete(3);
		System.out.print(status);

	}
}
