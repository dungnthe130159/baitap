/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import manager.Manager;

/**
 *
 * @author D
 */
public class OP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Student> lst = new ArrayList<>();
            
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            Student std =new Student();
            std.nhap();
            std.xuat();
            
        }
    }
}
