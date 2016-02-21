package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.SetupDao;
import dao.SetupDaoHibernate;

public class InitDatabaseListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SetupDaoHibernate setupDaoHibernate = new SetupDaoHibernate();

		/*
		SetupDao setupDao = new SetupDao();
		
		setupDao.destroy();
		
		setupDao.createSchema();
		setupDao.insertSampleData();
		*/
		System.out.println("[InitDatabaseListener] contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("[InitDatabaseListener] contextDestroyed");
	}

}
