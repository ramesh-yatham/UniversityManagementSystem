package com.codegnan.university.managemenet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.codegnan.university.exception.CourseNotFoundException;
import com.codegnan.university.exception.ProfessorNotFoundException;
import com.codegnan.university.exception.StudentNotFoundException;

public class UniversityManagement {
  private List<Student>students;	//List to hold Students
  private List<Professor>professors;
  private List<Course>courses;
  
  
  public UniversityManagement() {
	  students = new ArrayList<>();
	  professors = new ArrayList<>();
	  courses = new ArrayList<>();
  }
  
  
  public void addStudent(String name) {
	  students.add(new Student(name));
	  }
  
  public void addProfessor(String name) {
	  professors.add(new Professor(name));
	  }
  
  public void addCourse(String title) {
	  courses.add(new Course(title));
	  }
  
  //method to entroll a student in course.
  
  public void enrollStudentInCourse(String studentName, String courseTitle  ) throws StudentNotFoundException, CourseNotFoundException {
	  
	 Student student = findStudentByName(studentName);//helper method to find the student by name
	 Course course =findCourseByTitle(courseTitle);
	   if(student==null) {
		   throw new StudentNotFoundException("Student" + studentName +"not found");
	   }
	   if(course==null) {
		   throw new CourseNotFoundException("Course" + courseTitle+"Not Found");
	   }
	   student.enrolledCourse(course);
	  
  }
  public void assignCourseToProfessor(String professorName, String courseTitle) throws ProfessorNotFoundException, CourseNotFoundException {
	  Professor professor =findProfessorByName(professorName);
	  Course course =findCourseByTitle(courseTitle);
	  if(professor==null) {
		  throw new ProfessorNotFoundException("professor"+ professorName +"Not found");
	  }
	  if(course==null) {
		  throw new CourseNotFoundException("Course" + courseTitle+"Not Found");
	  }
	  professor.assignCourse(course);
  }
  
  
  public void listStudent() {
	  if(students.isEmpty()) {
		  System.out.println("No Students are available");
	  } else {
		  System.out.println("List of students");
		  for (Student student:students) {
			  System.out.println(student);
		  }
	  }
  }
  
  public void listProfessor() {
	  if (professors.isEmpty()) {
		  System.out.println("No Professor are available");
	  } else {
		  System.out.println("List of professor");
		  for (Professor professor:professors) {
			  System.out.println(professor);
		  }
		  
	  }
  }
  
  public void listCourse() {
	  if(courses.isEmpty()) {
		  System.out.println("Course are not available now");
	  } else {
		  System.out.println("List of Course");
		  for(Course course:courses) {
			  System.out.println(course);
		  }
	  }
  }
  
  public void displayStudentCourse(String studentName)throws StudentNotFoundException {
	  Student student =findStudentByName(studentName);
	  
	  if(student==null) {
		  throw new StudentNotFoundException("Student"+studentName+ "not Found");
		 
	  }
	  System.out.println("Course for Student : "+studentName);
	  for (Course course:student.getEnrolledCourse()) {
		  System.out.println(course);
	  }
  }
  
  public void displayProfessorCourse(String professorName) throws ProfessorNotFoundException{
	  Professor professor =findProfessorByName(professorName);
	  
	  if(professor==null) {
		  throw new ProfessorNotFoundException("Professor"+professorName+"Not Found");
		  
	  }
	  System.out.println("Courses assinged for professor:"+professorName);
	  for (Course course:professor.getAssignedCourses()) {
		  System.out.println(course);
	  }
  }
  public Student findStudentByName(String name) {
	  for(Student student:students) {
		  if(student.getName().equalsIgnoreCase(name)) {
			  return student;
		  }
	  }
	  return null;
  }
  public Professor findProfessorByName(String name) {
	  for(Professor professor:professors) {
		  if(professor.getName().equalsIgnoreCase(name)) {
			  return professor;
		  }
	  }
	  return null;
  }
  public Course findCourseByTitle(String title) {
	  for (Course course:courses) {
		  if(course.getTitle().equalsIgnoreCase(title)) {
			  return course;
		  }
	  }
	  return null;
  }
  
  
  


	public static void main(String[] args) {
		UniversityManagement management =new UniversityManagement();
		Scanner scanner = new Scanner(System.in);
		
		
		boolean running = true;
		while (running) {
			
			System.out.println("||==========================================||");
			System.out.println("   University Managment System    ");
			System.out.println("||==========================================||");
			System.out.println("||              1. Add Student              ||");
			System.out.println("||              2. Add Professor           ||");
			System.out.println("||              3. Add Courses              ||");
			System.out.println("||              4. Enroll Student in Course ||");
			System.out.println("||              5. Assign Courses to Professor||");
			System.out.println("||              6. List of Students          ||");
			System.out.println("||              7. List of Professors        ||");
			System.out.println("||              8. List Of Courses            ||");
			System.out.println("||              9. Display Student Courses    || ");
			System.out.println("||              10. Display Professor Courses ||");
			System.out.println("||              11. Exit                       ||");
			System.out.println("===================================================");
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			try {
				switch(choice) {
				case 1:
					System.out.print("Enter Student Name : ");
					String studentName=scanner.nextLine();
					management.addStudent(studentName);
					break;
				case 2:
					System.out.print("Enter Professor Name : ");
					String professorName=scanner.nextLine();
					management.addProfessor(professorName);
					break;
				case 3:
					System.out.print("Enter Course Title  : ");
					String courseTitle=scanner.nextLine();
					management.addCourse(courseTitle);
					break;
				case 4:
					System.out.println("Enter Student Name : ");
					String enrolledStudent = scanner.nextLine();
					System.out.println("Enter the Course : ");
					String enrolledCourse =scanner.nextLine();
					try {
						management.enrollStudentInCourse(enrolledStudent, enrolledCourse); // Enroll student in course
					} catch (StudentNotFoundException | CourseNotFoundException e) {
						System.out.println(e.getMessage()); // Handle exception
					}
					break;
				case 5:
					System.out.print("Enter professor name: ");
					String assignProfessor = scanner.nextLine();
					System.out.print("Enter course title: ");
					String assignCourse = scanner.nextLine();
					try {
						management.assignCourseToProfessor(assignProfessor, assignCourse); // Assign course to professor
					} catch (ProfessorNotFoundException | CourseNotFoundException e) {
						System.out.println(e.getMessage()); // Handle exception
					}
					break;
				case 6:
					management.listStudent(); // List all students
					break;
				case 7:
					management.listProfessor(); // List all professors
					break;
				case 8:
					management.listCourse(); // List all courses
					break;
				case 9:
					System.out.print("Enter student name: ");
					String displayStudent = scanner.nextLine();
					try {
						management.displayStudentCourse(displayStudent); // Display courses for a student
					} catch (StudentNotFoundException e) {
						System.out.println(e.getMessage()); // Handle exception
					}
					break;
				case 10:
					System.out.print("Enter professor name: ");
					String displayProfessor = scanner.nextLine();
					try {
						management.displayProfessorCourse(displayProfessor); // Display courses for a professor
					} catch (ProfessorNotFoundException e) {
						System.out.println(e.getMessage()); // Handle exception
					}
					break;
				case 11:
					running = false; // Exit the loop
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid choice. Please enter a number between 1 and 11."); // Handle invalid
																									// input
					break;
				}
			} catch (Exception e) {
				System.out.println("An unexpected error occurred: " + e.getMessage());
			}
		}
		scanner.close(); // Close the scanner
	}
}








