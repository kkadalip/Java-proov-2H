package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.HibernateUtil;
import dao.SetupDaoOld;
import dao.SetupDao;

public class InitDatabaseListener implements ServletContextListener { // class not found?? TODO

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SetupDao setupDaoHibernate = new SetupDao();
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
		HibernateUtil.getSessionFactory().close(); // closing factory
		System.out.println("[InitDatabaseListener] contextDestroyed");
	}

}
