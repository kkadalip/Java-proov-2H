package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.User;

public class HibernateUtil {
	// http://stackoverflow.com/questions/32405031/hibernate-5-org-hibernate-mappingexception-unknown-entity
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			//            // Create the SessionFactory from hibernate.cfg.xml
			//            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder() .configure("hibernate.cfg.xml").build();
			//            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			//            return metadata.getSessionFactoryBuilder().build();
			System.out.println("hibernateutil");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("hibernateutil sessionfactory is " + sessionFactory);
			return sessionFactory;
		} 
		//catch (Throwable ex) {
		catch (HibernateException ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
//			throw new ExceptionInInitializerError(ex);
			throw new HibernateException(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}

//Configuration conf = new Configuration();  
//conf.configure(); // conf.configure("/resources/hibernate.cfg.xml");
//ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
//SessionFactory sf = conf.buildSessionFactory(sr);  
//
//User user1 = new User();  
//user1.setName("Alala");  
////user1.setUserMessage("Hello world");  
//
//User user2 = new User();  
//user2.setName("Ololo");  
////user2.setUserMessage("Hello world2");  
//
//Session session = sf.openSession();  
//session.beginTransaction();  
//
////saving objects to session  
//session.save(user1);  
//session.save(user2);  
//session.getTransaction().commit();  
//session.close();  