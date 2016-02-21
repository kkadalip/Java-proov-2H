package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbutils.DbUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;

public class SetupDao extends AbstractDao {

	public void createSchema() {
		System.out.println("[SetupDao] createSchema");
		executeSqlFromFile(getClassPathFile("schema.sql"));
	}

	public void insertSampleData() {
		System.out.println("[SetupDao] insertSampleData");
		executeSqlFromFile(getClassPathFile("sample_data.sql"));
	}

	public void destroy() {
		System.out.println("[SetupDao] destroy");
		//http://h2database.com/html/grammar.html#drop_all_objects
		executeQuery("DROP ALL OBJECTS DELETE FILES;"); // without dropping tables use TRUNCATE TABLE, doesn't reset AUTO_INCREMENT counters to zero
		// ? The command: SHUTDOWN You can execute it using RunScript.execute(jdbc_url, user, password, "classpath:shutdown.sql", "UTF8", false);
		//executeQuery("DROP SCHEMA PUBLIC CASCADE;");
	}

	private String getClassPathFile(String fileName) {
		return getClass().getClassLoader().getResource(fileName).getFile();
		//return getClass().getResource(fileName).getFile();
	}

	private void executeSqlFromFile(String sqlFilePath) {
		Project project = new Project();
		project.init();

		SQLExec e = new SQLExec();
		e.setProject(project);
		e.setTaskType("sql");
		e.setTaskName("sql");
		e.setSrc(new File(sqlFilePath));
		//e.setDriver("org.hsqldb.jdbcDriver");
		e.setDriver("org.h2.Driver");
		e.setUserid("sa");
		e.setPassword("");
		e.setUrl(DB_URL);
		e.execute();
	}
}
