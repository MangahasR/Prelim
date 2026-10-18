package com.mycompany.labactivity1;
import java.util.Scanner;
public class Activity2 {

    public static void main(String[] args) {
        System.out.println("Input your grades Student\n ");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Input your  Java Programming score: ");
        int java = scanner.nextInt();
        
        System.out.print("Enter your C Programing score: ");
        int c = scanner.nextInt();
        
        System.out.print("Enter your Database Handling score: ");
        int data = scanner.nextInt();
       
        double ave = (java + c + data) / 3.0;
        
        if(ave >= 90){
            System.out.print("The average is: " + ave + "Student 'A'");
        } else if (ave >= 80 || ave <= 89){
            System.out.print("The average is:  " + ave + "Student 'B'");
        } else if (ave >= 75 || ave <= 79){
            System.out.print("The average is:  " + ave + "Student 'C'");
        } else if (ave <= 74){
            System.out.print("The average is:  " + ave + "Student 'F'");
        }
        
        

    }
}