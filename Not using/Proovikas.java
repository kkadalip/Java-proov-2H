import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration;  
import org.hibernate.service.ServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.User;  

public class Proovikas {  

	public static void main(String[] args) {  

		Configuration conf = new Configuration();  
		conf.configure(); // conf.configure("/resources/hibernate.cfg.xml");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		SessionFactory sf = conf.buildSessionFactory(sr);  

		User user1 = new User();  
		user1.setName("Alala");  
		//user1.setUserMessage("Hello world");  

		User user2 = new User();  
		user2.setName("Ololo");  
		//user2.setUserMessage("Hello world2");  

		Session session = sf.openSession();  
		session.beginTransaction();  
		
		//saving objects to session  
		session.save(user1);  
		session.save(user2);  
		session.getTransaction().commit();  
		session.close();  

	}  

}