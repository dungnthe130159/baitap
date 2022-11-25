/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;

/**
 *
 * @author D
 */
public class Student extends Person {

    public String code;
    public Float medium;
    public String email;

    public Student() {
    }

    public Student(String code, Float middle, String email, String name, String gender, String address, int dob) {
        super(name, gender, address, dob);
        this.code = code;
        this.medium = middle;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getMiddle() {
        return medium;
    }

    public void setMiddle(Float middle) {
        this.medium = middle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma so sinh vien");
        this.code = sc.nextLine();
        System.out.println("Nhap diem trung binh");
        this.medium = Float.parseFloat(sc.nextLine());
        System.out.println("Nhap email");
        this.email = sc.nextLine();
    }

    @Override
    public void xuat() {
        super.xuat();        
        System.out.println("\nMa so sinh vien :" + this.code + "\nDiem Tb :" + this.medium + "\nEmail :" + this.email);

    }

    @Override
    public String toString() {
        return "Student{" + "\nMa so sinh vien :" + this.code + "\nDiem Tb :" + this.medium + "\nEmail :" + this.email+ '}';
    }
    
}
