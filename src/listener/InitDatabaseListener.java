package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.HibernateUtil;
import dao.SectorDao;
import dao.SetupDao;

public class InitDatabaseListener implements ServletContextListener { // class not found?? TODO
	Logger log = LoggerFactory.getLogger(SectorDao.class);
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		SetupDao setupDao = new SetupDao();
		//setupDao.insertSampleDataUsers(); // WORKS! Not using anymore. Inserts sample users into database.
		setupDao.insertSampleDataSectors();
		log.info("[contextInitialized] DONE");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.getSessionFactory().close(); // closing factory
		log.info("[contextDestroyed] DONE");
	}

}



















// setupDao.destroy();
// setupDao.createSchema();
//setupDaoHibernate.initFactory();