import java.util.Scanner;

public class Week9act2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter a number from 1-10: ");
            
            String input = scanner.nextLine();
            int number;
            
            try {
                number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                number = -1;
            }
            
            if (number == 1) {
                System.out.println("One");
            } else if (number == 2) {
                System.out.println("Two");
            } else if (number == 3) {
                System.out.println("Three");
            } else if (number == 4) {
                System.out.println("Four");
            } else if (number == 5) {
                System.out.println("Five");
            } else if (number == 6) {
                System.out.println("Six");
            } else if (number == 7) {
                System.out.println("Seven");
            } else if (number == 8) {
                System.out.println("Eight");
            } else if (number == 9) {
                System.out.println("Nine");
            } else if (number == 10) {
                System.out.println("Ten");
            } else {
                System.out.println("Invalid Number");
            }
            
            System.out.print("Again? y/n: ");
            String again = scanner.nextLine();
            
            if (again.equalsIgnoreCase("n")) {
                System.out.println("Exiting.....");
                break;
            }
        }
        
        scanner.close();
    }
}
