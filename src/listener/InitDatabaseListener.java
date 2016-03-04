package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.HibernateUtil;
import dao.SetupDao;

public class InitDatabaseListener implements ServletContextListener { // class not found?? TODO

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SetupDao setupDao = new SetupDao();
		// setupDao.destroy();
		// setupDao.createSchema();
		//setupDao.insertSampleDataUsers(); // WORKS! Not using anymore. Inserts sample users into database.
		setupDao.insertSampleDataSectors();
		//setupDaoHibernate.initFactory();
		System.out.println("[InitDatabaseListener] contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.getSessionFactory().close(); // closing factory
		System.out.println("[InitDatabaseListener] contextDestroyed");
	}

}
