/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author D
 */
public class StudentManagement {

    Scanner sc = new Scanner(System.in);

    public static void createStudent(int count, List<Student> lst) {
        if (count > 10) {
            System.out.println("Do you want continue / Yes or No");
            if (!Validation.checkYN()) {
                return;
            }
        }
        while (true) {
            System.out.println("Enter ID");
            String id = Validation.checkString();
            System.out.println("Enter Name");
            String name = Validation.checkString();
            System.out.println("Semester");
            String semester = Validation.checkString();
            System.out.println("Course");
            String course = Validation.checkCourse();
            Student std = new Student(id, name, semester, course);
            lst.add(std);
            System.out.println("Add student success.");
            System.out.println(std.toString());
            return;
        }

    }

    public static void findSort(ArrayList<Student> lst) {
        if (lst.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        ArrayList<Student> FindListByName = FindListByName(lst);
        if (FindListByName.isEmpty()) {
            System.out.println("Not exist");
        } else {
            FindListByName.stream().sorted(Comparator.comparing(Student::getStudentName))
                    .collect(Collectors.toList());
            for (Student student : lst) {
                System.out.println("check" + lst.toString());
            }
            System.out.println(FindListByName);

        }
    }

    public static ArrayList<Student> FindListByName(ArrayList<Student> lst) {
        ArrayList<Student> FindListByName = new ArrayList<>();
        System.out.println("Enter name to search");
        String name = Validation.checkString();
        for (Student student : lst) {
            if (student.getStudentName().contains(name)) {
                FindListByName.add(student);
            }
        }
        return FindListByName;
    }

}
