import java.util.Scanner;

public class WEEK_13_ASSIGNMENT_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] num = new int[5];

        System.out.print("enter five numbers: ");
        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }

        int highest = num[0];

        for (int i = 1; i < num.length; i++) {
            if (num[i] > highest) {
                highest = num[i];
            }
        }

        System.out.println("the highest is: " + highest);

        System.out.println("the difference from the highest are:");
        for (int i = 0; i < num.length; i++) {
            int difference = highest - num[i];
            System.out.println(highest + " - " + num[i] + " = " + difference);
        }

        scanner.close();
    }
}
