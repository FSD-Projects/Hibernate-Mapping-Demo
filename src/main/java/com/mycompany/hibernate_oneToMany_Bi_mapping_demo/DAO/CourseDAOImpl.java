package com.mycompany.hibernate_oneToMany_Bi_mapping_demo.DAO;

import static java.lang.System.in;

import java.util.Scanner;

import org.hibernate.Session;

import com.mycompany.hibernate_oneToMany_Bi_mapping_demo.factory.MyHibernateFactory;
import com.mycompany.hibernate_oneToMany_Bi_mapping_demo.model.Course;
import com.mycompany.hibernate_oneToMany_Bi_mapping_demo.model.Instructor;

public class CourseDAOImpl implements CourseDAO {
	Scanner sc = new Scanner(in);
	int id;

	public void createCourseDemo() {
		// TODO Auto-generated method stub
		Session session = MyHibernateFactory.getMySession();
		try {
			System.out.println("2. Creating Course");
			System.out.println("Enter the instructor id: ");
			id = sc.nextInt();
			Instructor instructor = session.get(Instructor.class, id);
			Course course1 = new Course("Air Guitar - The Ultimate Guide");
			Course course2 = new Course("The Pinball Masterclass");
			instructor.add(course1);
			instructor.add(course2);
			session.getTransaction().begin();
			session.save(course1);
			session.save(course2);
			session.getTransaction().commit();
		} finally {
			session.close();
		}
	}

	public void deleteCourseDemo() {
		// TODO Auto-generated method stub

		Session session = MyHibernateFactory.getMySession();
		System.out.println("3. Removing Course");
		System.out.println("Enter the course id to remove: ");
		id = sc.nextInt();
		sc.close();
		Course course = session.get(Course.class, id);
		session.getTransaction().begin();
		session.remove(course);
		session.getTransaction().commit();
		System.out.println("Done!");
	}

	public void createInstructorDemo() {
		// TODO Auto-generated method stub
		System.out.println("1. Creating Instructor");
		Session session = MyHibernateFactory.getMySession();
		System.out.println("Enter first name:");
		String fName = sc.next();
		System.out.println("Enter last name:");
		String lName = sc.next();
		System.out.println("Enter email");
		String email = sc.next();
		Instructor instructor = new Instructor(fName, lName, email);

		session.getTransaction().begin();
		session.save(instructor);

		session.getTransaction().commit();
	}

}
