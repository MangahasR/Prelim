package com.mycompany.week5assno2;
import java.util.Scanner;

public class Mangahas {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        int highest = num1;

        if (num2 > highest) {
            highest = num2;
        }

        if (num3 > highest) {
            highest = num3;
        }

        System.out.println("The highest number is " + highest);

        sc.close();
    }
}