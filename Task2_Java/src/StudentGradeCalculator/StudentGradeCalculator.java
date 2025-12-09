package StudentGradeCalculator;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of subjects: ");
        int n = sc.nextInt();

        int total = 0;

        // Taking marks for each subject
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter marks of subject " + i + " (out of 100): ");
            int marks = sc.nextInt();
            total += marks;
        }

        // Calculate Average Percentage
        double average = total / (double) n;

        // Grade Calculation
        String grade;
        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Display Results
        System.out.println("\n----- Result -----");
        System.out.println("Total Marks: " + total);
        System.out.println("Average Percentage: " + average + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
