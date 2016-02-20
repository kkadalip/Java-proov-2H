package dao;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.AbstractDao;
import model.User; // bean
 
public class UserDAO extends AbstractDao {
 
    public void addUserDetails(String userName) { //, String password, String email, String phone, String city) {
        try {
            // 1. configuring hibernate
            Configuration configuration = new Configuration().configure();
 
            // 2. create sessionfactory
            SessionFactory sessionFactory = configuration.buildSessionFactory();
 
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
            transaction.commit();
            System.out.println("\n\n Details Added \n");
 
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
 
    }
 
    
    
	public List<User> findAll() throws SQLException{
		List<User> users = new ArrayList<User>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit");
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
    
    
}