package dao;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import model.Sector;
import model.User;

public class SetupDaoHibernate extends AbstractDaoHibernate {

	public void insertSampleDataUsers(){
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		/*User user = new User();
			user.setName("John Smith");
			session.save(user);*/
		//user.setPassword1(password);
		//user.setEmail(email);
		//user.setCity(city);
		//user.setPhone(phone);
		//session.save(user);
		session.save(new User("John Smith"));
		session.save(new User("Karl Kadalipp"));
		session.save(new User("Random Blandom"));
		transaction.commit(); // session.getTransaction().commit();
		session.close();
		System.out.println("\n\n Details Added \n");
	}

	public void insertSampleDataSectors(){
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		// ATM LEVEL 0 and LEVEL 1 added
		System.out.println("adding manufacturing");
		Sector s_lvl0_0 = new Sector("Manufacturing");
		//session.save(s_lvl0_0);
		
		System.out.println("adding Construction mat");
		Sector s_lvl1_0 = new Sector("Construction materials");
		System.out.println("adding Electronics and opt");
		Sector s_lvl1_1 = new Sector("Electronics and Optics");
		System.out.println("adding food and beverages");
		Sector s_lvl1_2 = new Sector("Food and Beverage");
		System.out.println("adding Machinery");
		Sector s_lvl1_3 = new Sector("Machinery");
		session.save(s_lvl1_3);

		Set<Sector> set_lvl0_0 = new HashSet<Sector>();
		set_lvl0_0.add(s_lvl1_0);
		set_lvl0_0.add(s_lvl1_1);
		set_lvl0_0.add(s_lvl1_2);
		set_lvl0_0.add(s_lvl1_3);
		s_lvl0_0.setChild_sectors(set_lvl0_0);
		session.save(s_lvl0_0);
		
		/*
		System.out.println("adding Construction mat");
		Sector s_lvl1_0 = new Sector("Construction materials",s_lvl0_0);
		session.save(s_lvl1_0);
		System.out.println("adding Electronics and opt");
		Sector s_lvl1_1 = new Sector("Electronics and Optics",s_lvl0_0);
		session.save(s_lvl1_1);
		System.out.println("adding food and beverages");
		Sector s_lvl1_2 = new Sector("Food and Beverage",s_lvl0_0);
		session.save(s_lvl1_2);
		Sector s_lvl1_3 = new Sector("Machinery",s_lvl0_0);
		session.save(s_lvl1_3);
		Sector s_lvl1_4 = new Sector("Metalworking",s_lvl0_0);
		session.save(s_lvl1_4);
		Sector s_lvl1_5 = new Sector("Plastic and Rubber",s_lvl0_0);
		session.save(s_lvl1_5);
		Sector s_lvl1_6 = new Sector("Printing",s_lvl0_0);
		session.save(s_lvl1_6);
		Sector s_lvl1_7 = new Sector("Textile and Clothing",s_lvl0_0);
		session.save(s_lvl1_7);
		Sector s_lvl1_8 = new Sector("Wood",s_lvl0_0);
		session.save(s_lvl1_8);
		
		Sector s_lvl0_1 = new Sector("Other");
		session.save(s_lvl0_1);
		
		Sector s_lvl1_9 = new Sector("Creative industries",s_lvl0_1);
		session.save(s_lvl1_9);
		Sector s_lvl1_10 = new Sector("Energy technology",s_lvl0_1);
		session.save(s_lvl1_10);
		Sector s_lvl1_11 = new Sector("Environment",s_lvl0_1);
		session.save(s_lvl1_11);
		
		Sector s_lvl0_2 = new Sector("Service");
		session.save(s_lvl0_2);
		
		Sector s_lvl1_12 = new Sector("Business services",s_lvl0_2);
		session.save(s_lvl1_12);
		Sector s_lvl1_13 = new Sector("Engineering",s_lvl0_2);
		session.save(s_lvl1_13);
		Sector s_lvl1_14 = new Sector("Information Technology and Telecommunications",s_lvl0_2);
		session.save(s_lvl1_14);
		Sector s_lvl1_15 = new Sector("Tourism",s_lvl0_2);
		session.save(s_lvl1_15);
		Sector s_lvl1_16 = new Sector("Translation services",s_lvl0_2);
		session.save(s_lvl1_16);
		Sector s_lvl1_17 = new Sector("Transport and Logistics",s_lvl0_2);
		session.save(s_lvl1_17);
		*/
		
		
//		Sector sector = new Sector();
//		sector.setName("Business services");
//		session.save(sector);
//		
//		Sector sector2 = new Sector();
//		sector2.setName("Transport and Logistics");
//		session.save(sector2);
//		
//		Sector sector3 = new Sector();
//		sector3.setName("Air");
//		sector3.setParentSector(sector2);
//		session.save(sector3);
		//session.save(new Sector());;
		
		transaction.commit(); // session.getTransaction().commit();
		session.close();
	}

	//protected void setUp() throws Exception {
	//	public void setUp() throws Exception {
	//		System.out.println("sessionfactory is atm " + sessionFactory);
	//		// A SessionFactory is set up once for an application!
	//		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
	//				.configure() // configures settings from hibernate.cfg.xml
	//				.build();
	//		try {
	//			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	//		}
	//		catch (Exception e) {
	//			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
	//			// so destroy it manually.
	//			StandardServiceRegistryBuilder.destroy( registry );
	//		}
	//		System.out.println("sessionfactory is now " + sessionFactory);
	//		
	//		sessionFactory = HibernateUtil.getSessionFactory();
	//		
	//		System.out.println("sessionfactory is now 2 " + sessionFactory);
	//	}

	//	public void initFactory(){
	//		System.out.println("[Class: SetupDaoHibernate] [Method: initFactory]");
	//		try {
	//			// 1. configuring hibernate
	//			//Configuration configuration = new Configuration().configure();
	//			// 2. create sessionfactory
	//			//SessionFactory sessionFactory = configuration.buildSessionFactory();
	//			System.out.println("conf");
	//			configuration = new Configuration().configure();
	//			System.out.println("sess factory");
	//			sessionFactory = configuration.buildSessionFactory();
	//		} catch (HibernateException e) {
	//			System.out.println("[SetupDaoHibernate][initFactory] error:");
	//			System.out.println(e.getMessage());
	//		}
	//		
	//	}

	// http://stackoverflow.com/questions/32405031/hibernate-5-org-hibernate-mappingexception-unknown-entity
	//	public void initFactory(){
	//		// 1. configuring hibernate
	//		Configuration configuration = new Configuration().configure();
	//		// 2. create sessionfactory
	//		sessionFactory = configuration.buildSessionFactory();
	//	}

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
