package springORMsecond;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableTransactionManagement
public class Config {

	// ------------DataSource-----------
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springorm");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	// -----------LocalSessionFactoryBean----------
	@Bean
	public LocalSessionFactoryBean factory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.setAnnotatedClasses(springORMsecond.Student.class);
		return sessionFactoryBean;
	}

	// ----------HibernateTemplate-----------
	@Bean
	public HibernateTemplate template() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setCheckWriteOperations(false); 
		hibernateTemplate.setSessionFactory(factory().getObject());
		return hibernateTemplate;
	}

	
	@Bean
	public dao.StudentDaoImplements stdao() {
		dao.StudentDaoImplements studentDao = new dao.StudentDaoImplements();
		studentDao.setTemplate(template());
		return studentDao;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(factory().getObject());
		return transactionManager;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}
}
