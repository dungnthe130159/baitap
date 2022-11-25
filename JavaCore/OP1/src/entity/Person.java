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
public class Person {

    public String name;
    public String gender;
    public String address;
    public int dob;

    public Person() {
    }

    public Person(String name, String gender, String address, int dob) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten");
        this.name = sc.nextLine();
        System.out.println("Nhap gioi tinh");
        this.gender = sc.nextLine();
        System.out.println("Nhap dia chi");
        this.address = sc.nextLine();
        System.out.println("Nhap ngay sinh");
        this.dob = sc.nextInt();
    }

    public void xuat() {

        System.out.println("\nThong tin Person");
        System.out.println("\nHo va ten :" + this.name + "\nGioi tinh :" + this.gender + "\nDia chi :" + this.address + "\nNgay sinh :" + this.dob);

    }
}
