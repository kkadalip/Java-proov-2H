package dao;

//import java.io.File;
//import java.util.HashSet;
//import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

//import org.apache.tools.ant.Project;
//import org.apache.tools.ant.taskdefs.SQLExec;
//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Sector;
import model.User;

public class SetupDao { // extends AbstractDaoHibernate {
	Logger log = LoggerFactory.getLogger(SetupDao.class); // info trace debug warn error
	
	public void insertSampleDataUsers(){
		log.info("[insertSampleDataUsers] START");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(new User("John Smith"));
		session.save(new User("Karl Kadalipp"));
		session.save(new User("Random Blandom"));
		transaction.commit(); // session.getTransaction().commit();
		session.close();
		log.info("[insertSampleDataUsers] END");
	}

	public void insertSampleDataSectors(){
		log.info("[insertSampleDataSectors] START");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		// ATM LEVEL 0 and LEVEL 1 added
		//System.out.println("adding manufacturing");
		Sector s_lvl0_0 = new Sector("Manufacturing");
		//session.save(s_lvl0_0);
		
		//System.out.println("adding Construction mat");
		Sector s_lvl1_group0_0 = new Sector("Construction materials");
		//System.out.println("adding Electronics and opt");
		Sector s_lvl1_group0_1 = new Sector("Electronics and Optics");
		//System.out.println("adding food and beverages");
		Sector s_lvl1_group0_2 = new Sector("Food and Beverage");
		//System.out.println("adding Furniture");
		Sector s_lvl1_group0_3 = new Sector("Furniture");
		Sector s_lvl1_group0_4 = new Sector("Machinery");
		Sector s_lvl1_group0_5 = new Sector("Metalworking");
		Sector s_lvl1_group0_6 = new Sector("Plastic and Rubber");
		Sector s_lvl1_group0_7 = new Sector("Printing");
		Sector s_lvl1_group0_8 = new Sector("Textile and Clothing");
		Sector s_lvl1_group0_9 = new Sector("Wood");
		//session.save(s_lvl1_3);

//		Set<Sector> set_lvl0_0 = new HashSet<Sector>();
		SortedSet<Sector> set_lvl0_group0 = new TreeSet<Sector>();
		set_lvl0_group0.add(s_lvl1_group0_0);
		set_lvl0_group0.add(s_lvl1_group0_1);
		set_lvl0_group0.add(s_lvl1_group0_2);
		set_lvl0_group0.add(s_lvl1_group0_3);
		set_lvl0_group0.add(s_lvl1_group0_4);
		set_lvl0_group0.add(s_lvl1_group0_5);
		set_lvl0_group0.add(s_lvl1_group0_6);
		set_lvl0_group0.add(s_lvl1_group0_7);
		set_lvl0_group0.add(s_lvl1_group0_8);
		set_lvl0_group0.add(s_lvl1_group0_9);
		s_lvl0_0.setChild_sectors(set_lvl0_group0);
		session.save(s_lvl0_0);
		
		Sector s_lvl0_1 = new Sector("Other");
		
		Sector s_lvl1_group1_0 = new Sector("Creative industries");
		Sector s_lvl1_group1_1 = new Sector("Energy technology");
		Sector s_lvl1_group1_2 = new Sector("Environment");
		
//		Set<Sector> set_lvl0_1 = new HashSet<Sector>();
		SortedSet<Sector> set_lvl0_group1 = new TreeSet<Sector>();
		set_lvl0_group1.add(s_lvl1_group1_0);
		set_lvl0_group1.add(s_lvl1_group1_1);
		set_lvl0_group1.add(s_lvl1_group1_2);
		s_lvl0_1.setChild_sectors(set_lvl0_group1);
		session.save(s_lvl0_1);
		
		Sector s_lvl0_2 = new Sector("Service");
		
		Sector s_lvl1_group2_0 = new Sector("Business services");
		Sector s_lvl1_group2_1 = new Sector("Engineering");
		Sector s_lvl1_group2_2 = new Sector("Information Technology and Telecommunications");
		Sector s_lvl1_group2_3 = new Sector("Tourism");
		Sector s_lvl1_group2_4 = new Sector("Translation services");
		Sector s_lvl1_group2_5 = new Sector("Transport and Logistics");

//		Set<Sector> set_lvl0_2 = new HashSet<Sector>();
		SortedSet<Sector> set_lvl0_group2 = new TreeSet<Sector>();
		set_lvl0_group2.add(s_lvl1_group2_0);
		set_lvl0_group2.add(s_lvl1_group2_1);
		set_lvl0_group2.add(s_lvl1_group2_2);
		set_lvl0_group2.add(s_lvl1_group2_3);
		set_lvl0_group2.add(s_lvl1_group2_4);
		set_lvl0_group2.add(s_lvl1_group2_5);
		s_lvl0_2.setChild_sectors(set_lvl0_group2);
		session.save(s_lvl0_2);
		
		// lvl0 lvl1 LEVEL2 STUFF HERE // Sector s_lvl1_group0_2 = new Sector("Food and Beverage"); 
		// Food and Beverage children:
		
		Sector s_lvl2_group0_0 = new Sector("Bakery & confectionery products");
		Sector s_lvl2_group0_1 = new Sector("Beverages");
		Sector s_lvl2_group0_2 = new Sector("Fish & fish products");
		Sector s_lvl2_group0_3 = new Sector("Meat & meat products");
		Sector s_lvl2_group0_4 = new Sector("Milk & dairy products");
		Sector s_lvl2_group0_5 = new Sector("Other");
		Sector s_lvl2_group0_6 = new Sector("Sweets & snack food");
		SortedSet<Sector> set_lvl2_group0 = new TreeSet<Sector>();
		set_lvl2_group0.add(s_lvl2_group0_0);
		set_lvl2_group0.add(s_lvl2_group0_1);
		set_lvl2_group0.add(s_lvl2_group0_2);
		set_lvl2_group0.add(s_lvl2_group0_3);
		set_lvl2_group0.add(s_lvl2_group0_4);
		set_lvl2_group0.add(s_lvl2_group0_5);
		set_lvl2_group0.add(s_lvl2_group0_6);
		s_lvl1_group0_2.setChild_sectors(set_lvl2_group0);
		session.save(s_lvl1_group0_2);
		
		// LEVEL2 // Sector s_lvl1_group0_3 = new Sector("Furniture");
		// creating new sectors that don't exist yet but belong to furniture
		Sector s_lvl2_group1_0 = new Sector("Bathroom/sauna"); 
		Sector s_lvl2_group1_1 = new Sector("Bedroom");
		Sector s_lvl2_group1_2 = new Sector("Children's room");
		Sector s_lvl2_group1_3 = new Sector("Kitchen");
		Sector s_lvl2_group1_4 = new Sector("Living room");
		Sector s_lvl2_group1_5 = new Sector("Office");
		Sector s_lvl2_group1_6 = new Sector("Other (Furniture)");
		Sector s_lvl2_group1_7 = new Sector("Outdoor");
		Sector s_lvl2_group1_8 = new Sector("Project furniture");
		SortedSet<Sector> set_lvl2_group1 = new TreeSet<Sector>(); // creating new collection for furniture (level2)
		set_lvl2_group1.add(s_lvl2_group1_0); // adding children to sorted collection
		set_lvl2_group1.add(s_lvl2_group1_1);
		set_lvl2_group1.add(s_lvl2_group1_2);
		set_lvl2_group1.add(s_lvl2_group1_3);
		set_lvl2_group1.add(s_lvl2_group1_4);
		set_lvl2_group1.add(s_lvl2_group1_5);
		set_lvl2_group1.add(s_lvl2_group1_6);
		set_lvl2_group1.add(s_lvl2_group1_7);
		set_lvl2_group1.add(s_lvl2_group1_8);
		s_lvl1_group0_3.setChild_sectors(set_lvl2_group1); // Adding children to furniture
		session.save(s_lvl1_group0_3); // Saving furniture children
		
		// LEVEL 2 // Sector s_lvl1_group0_4 = new Sector("Machinery");
		Sector s_lvl2_group2_0 = new Sector("Machinery components"); 
		Sector s_lvl2_group2_1 = new Sector("Machinery equipment/tools");
		Sector s_lvl2_group2_2 = new Sector("Manufacture of machinery");
		Sector s_lvl2_group2_3 = new Sector("Maritime");
		Sector s_lvl2_group2_4 = new Sector("Metal structures");
		Sector s_lvl2_group2_5 = new Sector("Other");
		Sector s_lvl2_group2_6 = new Sector("Repair and maintenance service");
		SortedSet<Sector> set_lvl2_group2 = new TreeSet<Sector>();
		set_lvl2_group2.add(s_lvl2_group2_0);
		set_lvl2_group2.add(s_lvl2_group2_1);
		set_lvl2_group2.add(s_lvl2_group2_2);
		set_lvl2_group2.add(s_lvl2_group2_3);
		set_lvl2_group2.add(s_lvl2_group2_4);
		set_lvl2_group2.add(s_lvl2_group2_5);
		set_lvl2_group2.add(s_lvl2_group2_6);
		s_lvl1_group0_4.setChild_sectors(set_lvl2_group2);
		session.save(s_lvl1_group0_4);
		
		// LEVEL 3 // Sector s_lvl2_group2_3 = new Sector("Maritime");
		Sector s_lvl3_group0_0 = new Sector("Aluminium and steel workboats"); 
		Sector s_lvl3_group0_1 = new Sector("Boat/Yacht building");
		Sector s_lvl3_group0_2 = new Sector("Ship repair and conversion");
		SortedSet<Sector> set_lvl3_group0 = new TreeSet<Sector>();
		set_lvl3_group0.add(s_lvl3_group0_0);
		set_lvl3_group0.add(s_lvl3_group0_1);
		set_lvl3_group0.add(s_lvl3_group0_2);
		s_lvl2_group2_3.setChild_sectors(set_lvl3_group0);
		session.save(s_lvl2_group2_3);
		
		// LEVEL 2 // Sector s_lvl1_group0_5 = new Sector("Metalworking");
		Sector s_lvl2_group3_0 = new Sector("Construction of metal structures");
		Sector s_lvl2_group3_1 = new Sector("Houses and buildings");
		Sector s_lvl2_group3_2 = new Sector("Metal products");
		Sector s_lvl2_group3_3 = new Sector("Metal works");
		SortedSet<Sector> set_lvl2_group3 = new TreeSet<Sector>();
		set_lvl2_group3.add(s_lvl2_group3_0);
		set_lvl2_group3.add(s_lvl2_group3_1);
		set_lvl2_group3.add(s_lvl2_group3_2);
		set_lvl2_group3.add(s_lvl2_group3_3);
		s_lvl1_group0_5.setChild_sectors(set_lvl2_group3);
		session.save(s_lvl1_group0_5);
		
		// LEVEL 3 // Sector s_lvl2_group3_3 = new Sector("Metal works");
		Sector s_lvl3_group1_0 = new Sector("CNC-machining");
		Sector s_lvl3_group1_1 = new Sector("Forgings, Fasteners");
		Sector s_lvl3_group1_2 = new Sector("Gas, Plasma, Laser cutting");
		Sector s_lvl3_group1_3 = new Sector("MIG, TIG, Aluminium welding");
		SortedSet<Sector> set_lvl3_group1 = new TreeSet<Sector>();
		set_lvl3_group1.add(s_lvl3_group1_0);
		set_lvl3_group1.add(s_lvl3_group1_1);
		set_lvl3_group1.add(s_lvl3_group1_2);
		set_lvl3_group1.add(s_lvl3_group1_3);
		s_lvl2_group3_3.setChild_sectors(set_lvl3_group1);
		session.save(s_lvl2_group3_3);
		
		// LEVEL 2 // Sector s_lvl1_group0_6 = new Sector("Plastic and Rubber");
		Sector s_lvl2_group4_0 = new Sector("Packaging");
		Sector s_lvl2_group4_1 = new Sector("Plastic goods");
		Sector s_lvl2_group4_2 = new Sector("Plastic processing technology");
		Sector s_lvl2_group4_3 = new Sector("Plastic profiles");
		SortedSet<Sector> set_lvl2_group4 = new TreeSet<Sector>();
		set_lvl2_group4.add(s_lvl2_group4_0);
		set_lvl2_group4.add(s_lvl2_group4_1);
		set_lvl2_group4.add(s_lvl2_group4_2);
		set_lvl2_group4.add(s_lvl2_group4_3);
		s_lvl1_group0_6.setChild_sectors(set_lvl2_group4);
		session.save(s_lvl1_group0_6);
		
		// LEVEL 3 // Sector s_lvl2_group4_2 = new Sector("Plastic processing technology");
		Sector s_lvl3_group2_0 = new Sector("Blowing");
		Sector s_lvl3_group2_1 = new Sector("Moulding");
		Sector s_lvl3_group2_2 = new Sector("Plastics welding and processing");
		SortedSet<Sector> set_lvl3_group2 = new TreeSet<Sector>();
		set_lvl3_group2.add(s_lvl3_group2_0);
		set_lvl3_group2.add(s_lvl3_group2_1);
		set_lvl3_group2.add(s_lvl3_group2_2);
		s_lvl2_group4_2.setChild_sectors(set_lvl3_group2);
		session.save(s_lvl2_group4_2);
		
		// LEVEL 2 // Sector s_lvl1_group0_7 = new Sector("Printing");
		Sector s_lvl2_group5_0 = new Sector("Advertising");
		Sector s_lvl2_group5_1 = new Sector("Book/Periodicals printing");
		Sector s_lvl2_group5_2 = new Sector("Labelling and packaging printing");
		SortedSet<Sector> set_lvl2_group5 = new TreeSet<Sector>();
		set_lvl2_group5.add(s_lvl2_group5_0);
		set_lvl2_group5.add(s_lvl2_group5_1);
		set_lvl2_group5.add(s_lvl2_group5_2);
		s_lvl1_group0_7.setChild_sectors(set_lvl2_group5);
		session.save(s_lvl1_group0_7);
		
		// LEVEL 2 // Sector s_lvl1_group0_8 = new Sector("Textile and Clothing");
		Sector s_lvl2_group6_0 = new Sector("Clothing");
		Sector s_lvl2_group6_1 = new Sector("Textile");
		SortedSet<Sector> set_lvl2_group6 = new TreeSet<Sector>();
		set_lvl2_group6.add(s_lvl2_group6_0);
		set_lvl2_group6.add(s_lvl2_group6_1);
		s_lvl1_group0_8.setChild_sectors(set_lvl2_group6);
		session.save(s_lvl1_group0_8);
		
		// LEVEL 2 // Sector s_lvl1_group0_9 = new Sector("Wood");
		Sector s_lvl2_group7_0 = new Sector("Other (Wood)");
		Sector s_lvl2_group7_1 = new Sector("Wooden building materials");
		Sector s_lvl2_group7_2 = new Sector("Wooden houses");
		SortedSet<Sector> set_lvl2_group7 = new TreeSet<Sector>();
		set_lvl2_group7.add(s_lvl2_group7_0);
		set_lvl2_group7.add(s_lvl2_group7_1);
		set_lvl2_group7.add(s_lvl2_group7_2);
		s_lvl1_group0_9.setChild_sectors(set_lvl2_group7);
		session.save(s_lvl1_group0_9);
		
		// LEVEL 3 // Sector s_lvl1_group2_2 = new Sector("Information Technology and Telecommunications");
		Sector s_lvl3_group3_0 = new Sector("Data processing, Web portals, E-marketing");
		Sector s_lvl3_group3_1 = new Sector("Programming, Consultancy");
		Sector s_lvl3_group3_2 = new Sector("Software, Hardware");
		Sector s_lvl3_group3_3 = new Sector("Telecommunications");
		SortedSet<Sector> set_lvl3_group3 = new TreeSet<Sector>();
		set_lvl3_group3.add(s_lvl3_group3_0);
		set_lvl3_group3.add(s_lvl3_group3_1);
		set_lvl3_group3.add(s_lvl3_group3_2);
		set_lvl3_group3.add(s_lvl3_group3_3);
		s_lvl1_group2_2.setChild_sectors(set_lvl3_group3);
		session.save(s_lvl1_group2_2);
		
		// LEVEL 3 // Sector s_lvl1_group2_5 = new Sector("Transport and Logistics");
		Sector s_lvl3_group4_0 = new Sector("Air");
		Sector s_lvl3_group4_1 = new Sector("Rail");
		Sector s_lvl3_group4_2 = new Sector("Road");
		Sector s_lvl3_group4_3 = new Sector("Water");
		SortedSet<Sector> set_lvl3_group4 = new TreeSet<Sector>();
		set_lvl3_group4.add(s_lvl3_group4_0);
		set_lvl3_group4.add(s_lvl3_group4_1);
		set_lvl3_group4.add(s_lvl3_group4_2);
		set_lvl3_group4.add(s_lvl3_group4_3);
		s_lvl1_group2_5.setChild_sectors(set_lvl3_group4);
		session.save(s_lvl1_group2_5);
		
		transaction.commit(); // session.getTransaction().commit();
		session.close();
		log.info("[insertSampleDataSectors] END");
	}
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

//public void createSchema() {
	//		System.out.println("[SetupDao] createSchema");
	//		executeSqlFromFile(getClassPathFile("schema.sql"));
//}

//public void insertSampleData() {
	//		System.out.println("[SetupDao] insertSampleData");
	//		executeSqlFromFile(getClassPathFile("sample_data.sql"));
//}

//public void destroy() {
	//		System.out.println("[SetupDao] destroy");
	//		//http://h2database.com/html/grammar.html#drop_all_objects
	//		executeQuery("DROP ALL OBJECTS DELETE FILES;"); // without dropping tables use TRUNCATE TABLE, doesn't reset AUTO_INCREMENT counters to zero
	//		// ? The command: SHUTDOWN You can execute it using RunScript.execute(jdbc_url, user, password, "classpath:shutdown.sql", "UTF8", false);
	//		//executeQuery("DROP SCHEMA PUBLIC CASCADE;");
//}

//private String getClassPathFile(String fileName) {
//	return fileName;
	//		return getClass().getClassLoader().getResource(fileName).getFile();
	//		//return getClass().getResource(fileName).getFile();
//}

//private void executeSqlFromFile(String sqlFilePath) {
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
//}

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
