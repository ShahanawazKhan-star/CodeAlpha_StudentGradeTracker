package com.codealpha.grade;
import java.util.ArrayList;

public class GradeTracker {

    private final ArrayList<Student> students;
    private int nextStudentId;

    public GradeTracker() {
        students = new ArrayList<>();
        nextStudentId = 1;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public int generateStudentId() {
        return nextStudentId++;
    }
    public Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public boolean updateStudentName(int id, String newName) {
        Student student = findStudentById(id);
        if (student == null) {
            return false;
        }
        student.setName(newName);
        return true;
    }
    public boolean deleteStudent(int id) {
        Student student = findStudentById(id);
        if (student == null) {
            return false;
        }
        students.remove(student);
        return true;
    }

    public void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            System.out.println("----------------------------");
            System.out.println("ID      : " + student.getId());
            System.out.println("Name    : " + student.getName());
            System.out.println("Marks   : " + student.getMarks());
            System.out.println("Average : " + student.calculateAverage());
            System.out.println("Grade   : " + student.calculateGrade());
            System.out.println("Highest : " + student.getHighestMark());
            System.out.println("Lowest  : " + student.getLowestMark());
        }
        System.out.println("----------------------------");
    }

    public void showStudentRanking() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        ArrayList<Student> ranking = new ArrayList<>(students);
        ranking.sort((s1, s2) -> Double.compare(s2.calculateAverage(), s1.calculateAverage()));

        System.out.println("\n===== Student Ranking =====");
        int rank = 1;
        for (Student student : ranking) {
            System.out.println("----------------------------");
            System.out.println("Rank    : " + rank);
            System.out.println("ID      : " + student.getId());
            System.out.println("Name    : " + student.getName());
            System.out.println("Average : " + student.calculateAverage());
            System.out.println("Grade   : " + student.calculateGrade());
            rank++;
        }
        System.out.println("----------------------------");
    }

}
