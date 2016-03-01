package dao;

//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

//import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import controller.Default;
//import model.Sector;
//import dao.AbstractDao;
import model.User; // bean

public class UserDao { // extends AbstractDao {
	Logger log = LoggerFactory.getLogger(UserDao.class); // info trace debug warn error
	
	// READ THIS http://www.coderanch.com/t/434465/Servlets/java/request-Response-object-web-application
	public boolean addUser(User user) { // TODO FIX?
		// (1. configuring hibernate & 2. create sessionfactory) 3. Get Session object
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		log.info("[addUser]");
		try {
			// 4. Starting Transaction
			transaction = session.beginTransaction();
			session.save(user); // TODO FIX UserDao][addUser] error 1 A different object with the same identifier value was already associated with the session : [model.Sector#39]
			transaction.commit(); // session.getTransaction().commit();
			log.debug("[addUser] NEW USER DETAILS ADDED SUCCESSFULLY!");
			return true;
		} catch (HibernateException e) {
			log.error("[addUser] adding user failed", e); //e.printStackTrace(); // System.out.println("[UserDao][addUser] error 1 " + e.getMessage());
			transaction.rollback();
			return false;
		} finally {
            session.close();
        }
	}
	
	public User getUserById(Long id){
		log.info("[getUserById] ID: {}", id);
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			User resultUser = session.get(User.class, id); // http://www.mkyong.com/hibernate/different-between-session-get-and-session-load/
			return resultUser;
		} catch (HibernateException e) {
			log.error("[getUserById] getting user by ID failed!", e);
			return null;
		} finally {
			session.close();
		}
	}
	
	public List<User> getAllUsers(){
		log.info("[getAllUsers]");
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			@SuppressWarnings("unchecked")
			List<User> users = session.createCriteria(User.class).list(); // .addOrder(Order.asc("name")).list(); 
			//List queryResult = session.createQuery("FROM User").list(); 
			//for (Iterator iterator = queryResult.iterator(); iterator.hasNext();){
			//	User user = (User) iterator.next(); 
			//	System.out.print("[UserDao][findAll] " + user.toString() ); // User ID: + user.getId() + " Name: " + user.getName());
			//	users.add(user);
			//}
			//users = session.createCriteria(User.class).list();
			return users;
		} catch (HibernateException e) {
			log.error("[getAllUsers] getting all users failed!", e);
			return null;
		} finally {
			session.close();
		}
	}

	public boolean updateUser(User user) { //, String password, String email, String phone, String city) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(user); //.update(user); // org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session : [model.Sector#39]
			transaction.commit(); // session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			log.error("[updateUser] updating user failed!", e);
			return false;
		} finally {
			session.close();
		}	
	}
}















//sessionFactory.getCurrentSession();

//(1. configuring hibernate &) 2. create sessionfactory
//SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

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