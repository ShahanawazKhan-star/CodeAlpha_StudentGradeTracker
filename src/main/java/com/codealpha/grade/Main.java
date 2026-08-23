package com.codealpha.grade;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GradeTracker tracker = new GradeTracker();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Student Ranking");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            // Validate menu input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ================= ADD STUDENT =================
                case 1:

                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    int studentId = tracker.generateStudentId();

                    Student student = new Student(studentId, name);

                    System.out.println("Enter 5 marks:");

                    int markCount = 0;

                    while (markCount < 5) {

                        System.out.print(
                                "Enter mark " + (markCount + 1) + ": "
                        );

                        if (!scanner.hasNextDouble()) {
                            System.out.println(
                                    "Invalid input! Please enter a number."
                            );
                            scanner.nextLine();
                            continue;
                        }

                        double mark = scanner.nextDouble();

                        if (mark < 0 || mark > 100) {
                            System.out.println(
                                    "Invalid mark! Please enter a value between 0 and 100."
                            );
                            continue;
                        }

                        student.addMark(mark);
                        markCount++;
                    }

                    scanner.nextLine();

                    tracker.addStudent(student);

                    System.out.println("Student added successfully.");

                    break;

                // ================= VIEW ALL STUDENTS =================
                case 2:

                    tracker.showAllStudents();

                    break;

                // ================= SEARCH STUDENT =================
                case 3:

                    System.out.print("Enter student ID: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );
                        scanner.nextLine();
                        break;
                    }

                    int id = scanner.nextInt();

                    Student foundStudent =
                            tracker.findStudentById(id);

                    if (foundStudent == null) {

                        System.out.println("Student not found.");

                    } else {

                        System.out.println("----------------------------");
                        System.out.println(
                                "ID      : " + foundStudent.getId()
                        );
                        System.out.println(
                                "Name    : " + foundStudent.getName()
                        );
                        System.out.println(
                                "Marks   : " + foundStudent.getMarks()
                        );
                        System.out.println(
                                "Average : "
                                        + foundStudent.calculateAverage()
                        );
                        System.out.println(
                                "Grade   : "
                                        + foundStudent.calculateGrade()
                        );
                        System.out.println(
                                "Highest : "
                                        + foundStudent.getHighestMark()
                        );
                        System.out.println(
                                "Lowest  : "
                                        + foundStudent.getLowestMark()
                        );
                        System.out.println("----------------------------");
                    }

                    break;

                // ================= UPDATE STUDENT =================
                case 4:

                    System.out.print("Enter student ID to update: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );
                        scanner.nextLine();
                        break;
                    }

                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    Student studentToUpdate =
                            tracker.findStudentById(updateId);

                    if (studentToUpdate == null) {

                        System.out.println("Student not found.");

                    } else {

                        System.out.print("Enter new student name: ");
                        String newName = scanner.nextLine();

                        boolean updated =
                                tracker.updateStudentName(
                                        updateId,
                                        newName
                                );

                        if (updated) {
                            System.out.println(
                                    "Student updated successfully."
                            );
                        }
                    }

                    break;

                // ================= DELETE STUDENT =================
                case 5:

                    System.out.print("Enter student ID to delete: ");

                    if (!scanner.hasNextInt()) {
                        System.out.println(
                                "Invalid ID! Please enter a number."
                        );
                        scanner.nextLine();
                        break;
                    }

                    int deleteId = scanner.nextInt();

                    boolean deleted =
                            tracker.deleteStudent(deleteId);

                    if (deleted) {
                        System.out.println(
                                "Student deleted successfully."
                        );
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                // ================= RANKING =================
                case 6:

                    tracker.showStudentRanking();

                    break;

                // ================= EXIT =================
                case 7:

                    running = false;

                    System.out.println(
                            "Thank you for using Student Grade Tracker."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please enter 1-7."
                    );
            }
        }

        scanner.close();
    }
}