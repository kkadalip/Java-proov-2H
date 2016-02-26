package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Sector;
//import dao.AbstractDao;
import model.User; // bean

//public class UserDao extends AbstractDao {
//public class UserDao extends AbstractDaoHibernate {
public class UserDao {
	
	// HIBERNATE WAY:
	// NOT USING THIS ANYMORE:
	/*
	public void addUserDetails(String userName) { //, String password, String email, String phone, String city) {
		try {
			// 1. configuring hibernate
			//Configuration configuration = new Configuration().configure();
			// 2. create sessionfactory
			//SessionFactory sessionFactory = configuration.buildSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			// 3. Get Session object
			Session session = sessionFactory.openSession();
			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			User user = new User();
			user.setName(userName);
			//user.setPassword1(password);
			//user.setEmail(email);
			//user.setCity(city);
			//user.setPhone(phone);
			session.save(user);
			transaction.commit(); // session.getTransaction().commit();
			session.close();
			System.out.println("\n\n Details Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}
	*/
	public void addUser(User user) { //, String password, String email, String phone, String city) {
		try {
			System.out.println("[UserDao][addUser]");
			// 1. configuring hibernate
			//Configuration configuration = new Configuration().configure();
			// 2. create sessionfactory
			//SessionFactory sessionFactory = configuration.buildSessionFactory();
			
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			
			// 3. Get Session object
			Session session = sessionFactory.openSession();
			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			//User user = new User();
			//user.setName(userName);
			//user.setPassword1(password);
			//user.setEmail(email);
			//user.setCity(city);
			//user.setPhone(phone);
			session.save(user);
			transaction.commit(); // session.getTransaction().commit();
			session.close();
			System.out.println("\n\n [UserDao][addUser] NEW USER DETAILS ADDED \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}
	
	public User getUserById(Long id){
		System.out.print("[UserDao][findUserById] ID: " + id);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		User resultUser = new User();
		List queryResult = session.createQuery("FROM User U WHERE U.id IS "+id).list(); 
		if(!queryResult.isEmpty()){
			resultUser = (User) queryResult.get(0);
			System.out.println("[SectorDao][findSectorById] FOUND SECTOR, returning: " + resultUser.toString());
		}
		session.close();
		return resultUser;
	}

	public List<User> findAll(){
		// 1. configuring hibernate
		//Configuration configuration = new Configuration().configure();
		// 2. create sessionfactory
		//SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		System.out.println("userdao sessionfactory is: " + sessionFactory);
		// 3. Get Session object
		Session session = sessionFactory.openSession();
		// 4. Starting Transaction
		Transaction transaction = session.beginTransaction();

		List<User> users = new ArrayList<User>();
		//return users;
		//session.save(user);
		
		//transaction.commit(); // why? nothing to commit here, should be last thing before close
		List queryResult = session.createQuery("FROM User").list(); 
		for (Iterator iterator = queryResult.iterator(); iterator.hasNext();){
			User user = (User) iterator.next(); 
			System.out.print("[UserDao][findAll] " + user.toString() ); // User ID: + user.getId() + " Name: " + user.getName());
			//System.out.print("First Name: " + employee.getFirstName()); 
			//System.out.print("  Last Name: " + employee.getLastName()); 
			//System.out.println("  Salary: " + employee.getSalary()); 
			users.add(user);
		}

		//users = session.createCriteria(User.class).list();
		session.close();
		return users;
	}



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

}