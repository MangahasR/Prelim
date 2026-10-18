package com.mycompany.labactivity2;
import java.util.Scanner;
public class Asdassa {

    public static void main(String[] args) {
        String choice;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Values: ");
        
        System.out.print("X = ");
        float x = scanner.nextFloat();
        System.out.print("Y = ");
        float y = scanner.nextFloat();
        
        System.out.println("Arithmetic Operations: ");
        double add = x + y;
        
        System.out.println("Addition: x + y ="+ add);
        double sub = x - y;
      
        System.out.println("Subtraction: x - y ="+ sub);
        double mul = x * y;
        System.out.println("Multiplication: x * y ="+ mul);
        double div = x / y;
        System.out.println("Division: x / y =" + div);
        double mod = x % y;
        System.out.println("Modulus: x % y = "+ mod);
        double inc = ++x;
        System.out.println("Increment: x++ ="+ inc);
        double dec = --x;
        System.out.println("Increment: x-- ="+ dec);
        
        System.out.println("Do you want to continue? (YES/NO) :");
        choice = scanner.next();
        }
        while(choice.equalsIgnoreCase("YES"));
    }
}