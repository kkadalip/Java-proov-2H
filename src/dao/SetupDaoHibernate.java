package dao;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SetupDaoHibernate extends AbstractDaoHibernate {
	
	public void createSchema() {
//		System.out.println("[SetupDao] createSchema");
//		executeSqlFromFile(getClassPathFile("schema.sql"));
	}

	public void insertSampleData() {
//		System.out.println("[SetupDao] insertSampleData");
//		executeSqlFromFile(getClassPathFile("sample_data.sql"));
	}

	public void destroy() {
//		System.out.println("[SetupDao] destroy");
//		//http://h2database.com/html/grammar.html#drop_all_objects
//		executeQuery("DROP ALL OBJECTS DELETE FILES;"); // without dropping tables use TRUNCATE TABLE, doesn't reset AUTO_INCREMENT counters to zero
//		// ? The command: SHUTDOWN You can execute it using RunScript.execute(jdbc_url, user, password, "classpath:shutdown.sql", "UTF8", false);
//		//executeQuery("DROP SCHEMA PUBLIC CASCADE;");
	}

	private String getClassPathFile(String fileName) {
		return fileName;
//		return getClass().getClassLoader().getResource(fileName).getFile();
//		//return getClass().getResource(fileName).getFile();
	}

	private void executeSqlFromFile(String sqlFilePath) {
//		Project project = new Project();
//		project.init();
//
//		SQLExec e = new SQLExec();
//		e.setProject(project);
//		e.setTaskType("sql");
//		e.setTaskName("sql");
//		e.setSrc(new File(sqlFilePath));
//		//e.setDriver("org.hsqldb.jdbcDriver");
//		e.setDriver("org.h2.Driver");
//		e.setUserid("sa");
//		e.setPassword("");
//		e.setUrl(DB_URL);
//		e.execute();
	}
	
	/*
	protected void setUp() throws Exception {
		// 1. configuring hibernate
		Configuration configuration = new Configuration().configure();

		// 2. create sessionfactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

	}
	*/
	
	// http://hibernate.org/orm/documentation/5.1/
	// http://docs.jboss.org/hibernate/orm/5.1/quickstart/html_single/#hibernate-gsg-tutorial-basic-test
	/*
	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
	*/
	/*
	protected void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
	}
	*/
	
}
