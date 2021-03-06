package dao;

import java.sql.*;

import org.apache.commons.dbutils.DbUtils;

public abstract class AbstractDao {
	// http://www.h2database.com/html/faq.html
	public static final String DB_URL = "jdbc:h2:~/test";
	//public static final String DB_URL = "jdbc:h2:file:${user.home}/data/kkadalip/db;"; // A file path that is implicitly relative to the current working directory is not allowed in the database URL "jdbc:h2:file:${user.home}/data/kkadalip/db;". Use an absolute path, ~/name, ./name, or the baseDir setting instead. [90011-191]
	//public static final String DB_URL = "jdbc:h2:file:${user.home}/data/kkadalip/db;shutdown=true;h2.lock_file=false"; // org.h2.jdbc.JdbcSQLException: Unsupported connection setting "SHUTDOWN" [90113-191]
    //public static final String DB_URL = "jdbc:hsqldb:file:${user.home}/data/kkadalip/db;shutdown=true;hsqldb.lock_file=false";
    ////"jdbc:hsqldb:file:${user.home}/data/kkadalip/db;shutdown=true";
    
    private Connection connection;
    protected PreparedStatement pst;
    protected Statement st;
    protected ResultSet rs;

    static {
        try {
            //Class.forName("org.hsqldb.jdbcDriver");
        	Class.forName("org.h2.Driver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, "sa", "");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void closeResources() {
        DbUtils.closeQuietly(rs);
        DbUtils.closeQuietly(pst);
        DbUtils.closeQuietly(st);
        DbUtils.closeQuietly(connection);
    }

    protected void executeQuery(String queryString) {
        try {
             st = getConnection().createStatement();
             st.executeUpdate(queryString);
         } catch (Exception e) {
             throw new RuntimeException(e);
         } finally {
             closeResources();
         }
    }

}
