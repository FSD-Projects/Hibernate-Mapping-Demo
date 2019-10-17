package com.mycompany.hibernate_oneToMany_Bi_mapping_demo;

import com.mycompany.hibernate_oneToMany_Bi_mapping_demo.DAO.CourseDAO;
import com.mycompany.hibernate_oneToMany_Bi_mapping_demo.DAO.CourseDAOImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			CourseDAO dao = new CourseDAOImpl();

			// Creating instructor record
			dao.createInstructorDemo();

			// Creating new course
			// dao.createCourseDemo();

			// Removing course
			// dao.deleteCourseDemo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
