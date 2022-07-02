// Homework 1: Cash Registar Problem
// Course: CIS357
// Due Date: 7/5/2022
// Name: Christian Jaquith
// GitHub: xxx
// Instructor: Il-Hyung Cho
// Program Description: This program simulates a cash registar at a grocery store.
import java.util.Scanner;
import java.lang.Math;

/** Javadoc commenets for CashRegistar.java */
public class CashRegistar {
    public static void main(String[] args) {
        System.out.println("Enter product code: ");

        int[] itemArray = new int[10];
        itemArray[0] = 1;
        itemArray[1] = 2;
        itemArray[2] = 3;
        itemArray[3] = 4;
        itemArray[4] = 5;
        itemArray[5] = 6;
        itemArray[6] = 7;
        itemArray[7] = 8;
        itemArray[8] = 9;
        itemArray[9] = 10;

        Scanner input = new Scanner(System.in);
        // Decides what gets printed based off of input from user
        if (input.nextInt() == itemArray[0]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[1]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[2]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[3]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[4]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[5]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[6]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[7]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[8]) {
            System.out.println("Enter item name: ");
        } else if (input.nextInt() == itemArray[9]) {
            System.out.println("Enter item name: ");
        } else {
            getReceipt();
        }
    }
    public static void getReceipt() {
        System.out.print("receipt");
    }
}
