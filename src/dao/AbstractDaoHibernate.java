package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.User;

import org.hibernate.cfg.Configuration;

public abstract class AbstractDaoHibernate {
	// private or protected
	// 1. configuring hibernate
	static Configuration configuration; //in setupdao:    = new Configuration().configure();
	// 2. create sessionfactory
	static SessionFactory sessionFactory; //= configuration.buildSessionFactory();

	static void initFactory() { // protected
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
