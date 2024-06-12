package com.example.StudentGradeSystem.service;

import com.example.StudentGradeSystem.model.Student;
import org.springframework.stereotype.Service;

@Service
public class GradeCalculatorService {
    public char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 85) {
            return 'A';
        } else if (averagePercentage >= 75) {
            return 'B';
        } else if (averagePercentage >= 65) {
            return 'C';
        } else if (averagePercentage >= 55) {
            return 'D';
        } else if (averagePercentage >= 45) {
            return 'E';
        } else {
            return 'F';
        }
    }

    public void calculateStudentGrade(Student student) {
        student.calculateTotalMarks();
        student.calculateAveragePercentage();
        student.setGrade(calculateGrade(student.getAveragePercentage()));
    }
}
