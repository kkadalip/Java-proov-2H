package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.HibernateUtil;
import dao.SetupDao;
import dao.SetupDaoHibernate;

public class InitDatabaseListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SetupDaoHibernate setupDaoHibernate = new SetupDaoHibernate();
		setupDaoHibernate.insertSampleDataUsers();
		setupDaoHibernate.insertSampleDataSectors();
		//setupDaoHibernate.initFactory();
//		try {
//			setupDaoHibernate.setUp();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
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
