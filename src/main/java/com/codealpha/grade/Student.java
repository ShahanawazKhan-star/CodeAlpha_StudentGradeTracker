package com.codealpha.grade;
import java.util.ArrayList;

public class Student {
    private int id;
    private String name;
    private ArrayList<Double> marks;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public void addMark(double mark) {
        if (mark < 0 || mark > 100) {
            System.out.println(
                    "Invalid mark! Mark must be between 0 and 100."
            );
            return;
        }
        marks.add(mark);
    }
    public double calculateAverage() {
        if (marks.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total / marks.size();
    }

    public double getHighestMark() {
        if (marks.isEmpty()) {
            return 0;
        }
        double highest = marks.get(0);
        for (double mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
        }
        return highest;
    }
    public double getLowestMark() {
        if (marks.isEmpty()) {
            return 0;
        }
        double lowest = marks.get(0);
        for (double mark : marks) {
            if (mark < lowest) {
                lowest = mark;
            }
        }
        return lowest;
    }

    public String calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getMarks() {
        return marks;
    }
}