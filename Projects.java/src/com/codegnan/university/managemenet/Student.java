package com.codegnan.university.managemenet;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Course> enrolledCourse;
	
	public Student(String name) {
		this.name = name;
		this.enrolledCourse =new ArrayList<>();
	}
	public void enrolledCourse(Course course) {
		if (!enrolledCourse.contains(course)) {
			enrolledCourse.add(course);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getEnrolledCourse() {
		return enrolledCourse;
	}

	public void setEnrolledCourse(List<Course> enrolledCourse) {
		this.enrolledCourse = enrolledCourse;
	}

	@Override
	public String toString() {
		return name;
	}
	

}
