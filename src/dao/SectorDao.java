package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.AbstractDao;
import model.Sector; // bean
import model.User;

public class SectorDao {

	public List<Sector> findAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Sector> sectors = new ArrayList<Sector>();
		List queryResult = session.createQuery("FROM Sector").list(); 
		//List queryResult = session.createQuery("FROM Sector ORDER BY name").list(); // SORTS BY NAME
		for (Iterator iterator = queryResult.iterator(); iterator.hasNext();){
			Sector sector = (Sector) iterator.next(); 
			//System.out.print("[SectorDao][findAll] Sector ID: " + sector.getId() + " Sector Name: " + sector.getName() + " Sector parent sector: " + sector.getParentSector().getName());
			System.out.print("[SectorDao][findAll] Sector: " + sector.toString() ); //+ " Parent sector: " + sector.getParentSector().toString());
			sectors.add(sector);
		}
		//transaction.commit(); // nothing to commit here
		session.close();
		return sectors;
	}

	public List<Sector> findAllLevel0() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Sector> sectors = new ArrayList<Sector>();
		
		List queryResult = session.createQuery("FROM Sector S WHERE S.id = 1").list(); 
		//List queryResult = session.createQuery("FROM Sector ORDER BY name").list(); // SORTS BY NAME
		for (Iterator iterator = queryResult.iterator(); iterator.hasNext();){
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
