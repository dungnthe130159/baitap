/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import static java.lang.System.in;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author D
 */
public class Validation {

    static Scanner sc = new Scanner(System.in);

    public static int checkInputLimit(int a, int b) {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < a || result > b) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("enter a number from " + a + " to " + b);
                System.out.println("enter again");
            }
        }
    }

    public static String checkString() {
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Empty");
                System.out.println("Enter again");
            } else {
                return result;
            }
        }
    }

    public static boolean checkYN() {
        while (true) {
            String result = checkString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Enter Y or N");
            System.out.println("enter again");
        }
    }

    public static String checkCourse() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String course = checkString();
            if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase(".Net")
                    || course.equalsIgnoreCase("C/c++")) {
                return course;
            }
            System.err.println("There are only three course : Java,.Net,C/C++");
            System.out.println("Enter agian");
        }
    }
}
