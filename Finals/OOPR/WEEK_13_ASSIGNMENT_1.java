import java.util.Scanner;

public class WEEK_13_ASSIGNMENT_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num = new int[10];

        System.out.print("Enter ten numbers:\n");
        for (int i = 0; i < num.length; i++) {
            num[i] = scanner.nextInt();
        }

        System.out.print("Here is the list of Even number/s:\n");
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.print(num[i] + " ");
            }
        }
        
        System.out.println();
        scanner.close();
    }
}
