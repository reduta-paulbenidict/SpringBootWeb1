package com.pup.taguig.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pup.taguig.app.model.Student;

@SpringBootApplication
public class SpringBootWeb1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeb1Application.class, args);
//		System.out.println("Hello Love");
		
//		User user = new User();
////		user.setFirstName("Althea");
////		user.setLastName("Gulles");
////		user.setAge(1);	
//		User user = new User("Althea", "Gulles", 0);
//		System.out.println(user.toString());
//		
		
//Calculator
//	Calculator calculator = new Calculator(10, 100);		
//		System.out.println(calculator.add());
//		System.out.println(calculator.subtract());
//		System.out.println(calculator.multiply());
// 		System.out.println(calculator.divide());
		

//student
		List<Student> students = new ArrayList<>();
//		Student st1 = new Student((long) 1, "Althea", "Gulles", 80, 90);
//		Student st2 = new Student((long) 2, "John", "Doe", 60, 70);
//		Student st3 = new Student((long) 3, "Joseph", "Smith", 85, 95);
//		Student st4 = new Student((long) 4,  "Asaph", "Johnson", 99, 70);
//		Student st5 = new Student((long) 5, "Alice", "Williams", 90, 100);
//		
//		students.add(st1);
//		students.add(st2);
//		students.add(st3);
//		students.add(st4);
//		students.add(st5);
		
//	students.add(new Student("Bob", "Brown", 70, 80));

		for(Student student : students) {
			System.out.println(student.getFirstName() + " " 
			+ student.getLastName() + " - " 
			+ student.compute() + " - " 
			+ student.evaluate());
		}
		
	}

}
