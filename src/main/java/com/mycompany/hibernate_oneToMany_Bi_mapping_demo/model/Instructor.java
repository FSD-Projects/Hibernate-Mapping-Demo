package com.mycompany.hibernate_oneToMany_Bi_mapping_demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "instructor_data")
public class Instructor {
	@Id
	@Column(name = "instructor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int instructor_id;
	private String firstName;
	private String lastName;
	private String email;
	@OneToMany(mappedBy = "instructor", cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST,
			CascadeType.REFRESH })
	List<Course> courses;

	public void add(Course tempCourse) {
		// TODO Auto-generated method stub
		if (courses == null) {
			courses = new ArrayList<Course>();
		} else {
			courses.add(tempCourse);
			tempCourse.setInstructor(this);
		}
	}

	public Instructor(String fName, String lName, String email) {
		// TODO Auto-generated constructor stub
		firstName = fName;
		lastName = lName;
		this.email = email;
	}
}
