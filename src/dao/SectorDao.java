package dao;

//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.springframework.transaction.annotation.Transactional;

import model.Sector; // bean
//import model.User;
//import model.User;

public class SectorDao {
	
	public Sector getSectorById(Long id){
		System.out.print("[SectorDao][findSectorById] ID: " + id);
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Sector resultSector = session.get(Sector.class, id);
//		Sector resultSector = new Sector();
//		List queryResult = session.createQuery("FROM Sector S WHERE S.id IS "+id).list(); 
//		if(!queryResult.isEmpty()){
//			resultSector = (Sector) queryResult.get(0);
//			System.out.println("[SectorDao][findSectorById] FOUND SECTOR, returning: " + resultSector.toString());
//		}
		session.close();
		return resultSector;
	}

	public List<Sector> getAllSectors() {
		System.out.print("[SectorDao][findAll] START");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Sector> sectors = session.createCriteria(Sector.class).list();
		//Transaction transaction = session.beginTransaction();
//		List<Sector> sectors = new ArrayList<Sector>();
//		List queryResult = session.createQuery("FROM Sector").list(); 
//		//List queryResult = session.createQuery("FROM Sector ORDER BY name").list(); // SORTS BY NAME
//		for (Iterator iterator = queryResult.iterator(); iterator.hasNext();){
//			Sector sector = (Sector) iterator.next(); 
//			//System.out.print("[SectorDao][findAll] Sector ID: " + sector.getId() + " Sector Name: " + sector.getName() + " Sector parent sector: " + sector.getParentSector().getName());
//			System.out.print("[SectorDao][findAll] Sector: " + sector.toString() ); //+ " Parent sector: " + sector.getParentSector().toString());
//			sectors.add(sector);
//		}
		//transaction.commit(); // nothing to commit here
		session.close();
		return sectors;
	}

	// FIND ALL ROOT SECTORS
	public List<Sector> findAllLevel0() {
		System.out.print("[SectorDao][findAllLevel0] START");
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		//Transaction transaction = session.beginTransaction();
		List<Sector> sectors = new ArrayList<Sector>();
		// https://docs.jboss.org/hibernate/orm/3.3/reference/en/html/queryhql.html
		@SuppressWarnings("unchecked")
		List<Sector> queryResult = session.createQuery("FROM Sector S WHERE sector_id IS NULL").list(); // GETS ME ROOT ELEMENTS because fk join column is null
		//List queryResult = session.createQuery("FROM Sector ORDER BY name").list(); // SORTS BY NAME
		for (Iterator<Sector> iterator = queryResult.iterator(); iterator.hasNext();){
			Sector sector = (Sector) iterator.next();
			//System.out.print("[SectorDao][findAll] Sector ID: " + sector.getId() + " Sector Name: " + sector.getName() + " Sector parent sector: " + sector.getParentSector().getName());
			
			System.out.print("[SectorDao][findAllLevel0] Sector: " + sector.toString() ); //+ " Parent sector: " + sector.getParentSector().toString());
			sectors.add(sector);
		}
		//transaction.commit(); // nothing to commit here
		session.close();
		return sectors;
	}

}
