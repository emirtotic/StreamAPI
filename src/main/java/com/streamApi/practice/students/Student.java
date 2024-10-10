package com.streamApi.practice.students;

public class Student {
    private String name;
    private int age;
    private double gpa;
    private String major;
    private int year; // 1 za prvu godinu, 2 za drugu, itd.

    public Student(String name, int age, double gpa, String major, int year) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.major = major;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                ", major='" + major + '\'' +
                ", year=" + year +
                '}';
    }
}
