package com.example.StudentGradeSystem;

import com.example.StudentGradeSystem.model.Student;
import com.example.StudentGradeSystem.service.GradeCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class StudentGradeSystemApplication implements CommandLineRunner {

	@Autowired
	private GradeCalculatorService gradeCalculatorService;

	public static void main(String[] args) {
		SpringApplication.run(StudentGradeSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		int englishMarks = getValidMarks(scanner, "English");
		int mathMarks = getValidMarks(scanner, "Mathematics");
		int scienceMarks = getValidMarks(scanner, "Science");

		Student student = new Student();
		student.setEnglishMarks(englishMarks);
		student.setMathMarks(mathMarks);
		student.setScienceMarks(scienceMarks);

		gradeCalculatorService.calculateStudentGrade(student);

		System.out.println("Total Marks: " + student.getTotalMarks());
		System.out.println("Average Percentage: " + student.getAveragePercentage() + "%");
		System.out.println("Grade: " + student.getGrade());
	}

	private int getValidMarks(Scanner scanner, String subject) {
		int marks;
		while (true) {
			System.out.print(subject + ": ");
			marks = scanner.nextInt();
			if (marks >= 0 && marks <= 100) {
				break;
			} else {
				System.out.println("Invalid input. Please enter marks between 0 and 100.");
			}
		}
		return marks;
	}
}
