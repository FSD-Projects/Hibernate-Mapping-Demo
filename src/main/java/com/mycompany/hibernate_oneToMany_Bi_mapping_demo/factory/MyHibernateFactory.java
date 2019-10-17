package com.mycompany.hibernate_oneToMany_Bi_mapping_demo.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_oneToMany_Bi_mapping_demo.model.Course;
import com.mycompany.hibernate_oneToMany_Bi_mapping_demo.model.Instructor;

public class MyHibernateFactory {
	private static SessionFactory factory;
	private static Session session;

	public static Session getMySession() {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();
		session = factory.openSession();
		return session;
	}
}
