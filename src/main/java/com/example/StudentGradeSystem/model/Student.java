package com.example.StudentGradeSystem.model;

public class Student {
    private int englishMarks;
    private int mathMarks;
    private int scienceMarks;
    private int totalMarks;
    private double averagePercentage;
    private char grade;

    public void setEnglishMarks(int englishMarks) {
        this.englishMarks = englishMarks;
    }

    public void setMathMarks(int mathMarks) {
        this.mathMarks = mathMarks;
    }

    public void setScienceMarks(int scienceMarks) {
        this.scienceMarks = scienceMarks;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public double getAveragePercentage() {
        return averagePercentage;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public void calculateTotalMarks() {
        totalMarks = englishMarks + mathMarks + scienceMarks;
    }

    public void calculateAveragePercentage() {
        averagePercentage = (double) totalMarks / 3;
    }
}
