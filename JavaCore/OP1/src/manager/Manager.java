/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Student;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/**
 *
 * @author D
 */
public class Manager {
    
    public static void CreateStudent() {
        
        ArrayList<Student> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten");
        String name = sc.nextLine();
        System.out.println("Nhap gioi tinh");
        String gender = sc.nextLine();
        System.out.println("Nhap dia chi");
        String address = sc.nextLine();
        System.out.println("Nhap ngay sinh");
        int dob =Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ma so sinh vien");
        String code = sc.nextLine();
        System.out.println("Nhap diem trung binh");
        Float medium = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap email");
        String email = sc.nextLine();
        arr.add(new Student(code, medium, email, name, gender, address, dob));
        String str = arr.toString();
        System.out.println(str);
        
    }
    
}
