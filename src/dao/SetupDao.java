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
		executeSqlFromFile(getClassPathFile("schema.sql"));
	}

	public void createDefaultValues() {
		executeSqlFromFile(getClassPathFile("defaultValues.sql"));
	}

	public void destroy() {
		executeQuery("DROP SCHEMA PUBLIC CASCADE;");
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
