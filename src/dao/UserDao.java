package dao;

//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

//import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;

//import model.Sector;
//import dao.AbstractDao;
import model.User; // bean

public class UserDao { // extends AbstractDao {

	// READ THIS http://www.coderanch.com/t/434465/Servlets/java/request-Response-object-web-application
	public boolean addUser(User user) {
		try {
			System.out.println("[UserDao][addUser]");
			// (1. configuring hibernate &) 2. create sessionfactory
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			// 3. Get Session object
			Session session = sessionFactory.openSession();
			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			session.save(user); // TODO FIX UserDao][addUser] error 1 A different object with the same identifier value was already associated with the session : [model.Sector#39]
			transaction.commit(); // session.getTransaction().commit();
			session.close();
			System.out.println("\n\n [UserDao][addUser] NEW USER DETAILS ADDED \n");
			return true;
		} catch (HibernateException e) {
			System.out.println("[UserDao][addUser] error 1 " + e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public User getUserById(Long id){
		System.out.print("[UserDao][findUserById] ID: " + id);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession(); //sessionFactory.getCurrentSession();
		session.beginTransaction();
		User resultUser = session.get(User.class, id); // http://www.mkyong.com/hibernate/different-between-session-get-and-session-load/
		session.close();
		return resultUser;
	}
	
	public List<User> getAllUsers(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> users = session.createCriteria(User.class).list(); // .addOrder(Order.asc("name")).list(); 
		//List queryResult = session.createQuery("FROM User").list(); 
//		for (Iterator iterator = queryResult.iterator(); iterator.hasNext();){
//			User user = (User) iterator.next(); 
//			System.out.print("[UserDao][findAll] " + user.toString() ); // User ID: + user.getId() + " Name: " + user.getName());
//			users.add(user);
//		}
		//users = session.createCriteria(User.class).list();
		session.close();
		return users;
	}

	public void updateUser(User user) { //, String password, String email, String phone, String city) {
		try {
			System.out.println("[UserDao][addUser]");
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			// 3. Get Session object
			Session session = sessionFactory.openSession();
			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(user); //.update(user);
			transaction.commit(); // session.getTransaction().commit();
			session.close();
			System.out.println("\n\n [UserDao][addUser] NEW USER DETAILS ADDED \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("[UserDao] error2");
		}
	}


}










// List<User> list = sessionFactory.getCurrentSession().createQuery("from User where id = 1").list();
// return (list.isEmpty() ? null : list.get(0));
/*
	public User getUserByIdOld(Long id){
		System.out.print("[UserDao][findUserById] ID: " + id);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<User> list = session.createQuery("from User where id = "+id).list();
		//User queryResult = (User) session.createQuery("FROM User U WHERE U.id IS "+id).uniqueResult();
		session.close();
		return (list.isEmpty() ? null : list.get(0));
//		if(list.isEmpty()){
//			return null;
//		}else{
//			return list.get(0);
//		}
		// Query query = this.session.createQuery("select p from Person as p where p.address=:address")
        //query.setParameter("address",address); 
	}
*/

// NON HIBERNATE STUFF:
/*
public List<User> findAll2() throws SQLException{
	List<User> users = new ArrayList<User>();
	try {
		st = getConnection().createStatement();
		rs = st.executeQuery("SELECT * FROM user");
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt(1)); // id
			user.setName(rs.getString(2)); // name
			//user.setCode(rs.getString(3)); // code
			users.add(user);
		}
	} finally {
		closeResources();
	}
	return users;
}

public void addUnit(User user) throws SQLException{
	//int unitId = unit.getId();
	String unitName = user.getName();
	//String unitCode = unit.getCode();
	String query = "INSERT INTO user VALUES(NEXT VALUE FOR seq1,'"+unitName+"');"; //+"','"+unitCode+"');";
	try {
		st = getConnection().createStatement();
		rs = st.executeQuery(query);
	} finally {
		closeResources();
	}
}

public List<User> searchUnitsByName(String searchName) throws SQLException{
	List<User> users = new ArrayList<User>();
	try {
		pst = getConnection().prepareStatement("SELECT * FROM user WHERE LOWER(name) LIKE ?");
		pst.setString(1, "%" + searchName.toLowerCase() + "%");
		rs = pst.executeQuery();
		while(rs.next()){
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			//unit.setCode(rs.getString(3));
			users.add(user);
		}
	} finally {
		closeResources();
	}
	return users;
}

public void deleteAll() throws SQLException{
	try {
		st = getConnection().createStatement();
		rs = st.executeQuery("TRUNCATE TABLE user;");
	} finally {
		closeResources();
	}
}

public void deleteByID(int id) throws SQLException{
	try {
		pst = getConnection().prepareStatement("DELETE FROM user WHERE id = ?;");
		pst.setInt(1, id);
		pst.execute();
	} finally {
		closeResources();
	}
}
 */