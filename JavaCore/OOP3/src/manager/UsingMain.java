/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author D
 */
public class UsingMain {

    public static void main(String[] args) {
        StudentManagement mg = new StudentManagement();
        ArrayList<Student> lst = new ArrayList<>();
        Validation vld = new Validation();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            System.out.println("1.Create");
            System.out.println("2.Find and sort");
            System.out.println("3.Update/Delete");
            System.out.println("4.Report");
            System.out.println("4.Exit");
            int choice = vld.checkInputLimit(1, 5);
            switch (choice) {
                case 1: {
                    mg.createStudent(count, lst);                    
                    System.out.println(lst.size());
                    break;
                }
                case 2: {
                    mg.findSort(lst);
                    break;
                }
                case 3: {
                    return;
                }

            }

        }
    }
}
