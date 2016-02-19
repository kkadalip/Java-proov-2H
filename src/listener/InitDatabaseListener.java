package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//import dao.SetupDao;

public class InitDatabaseListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//SetupDao setupDao = new SetupDao();
		//setupDao.createSchema();
		//setupDao.insertSampleData();
		System.out.println("[InitDatabaseListener] contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("[InitDatabaseListener] contextDestroyed");
	}

}
