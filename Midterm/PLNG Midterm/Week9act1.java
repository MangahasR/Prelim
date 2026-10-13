import java.util.Scanner;

public class Week9act1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        int count = 0;
        while (count < 5) {
            System.out.println(name);
            count++;
        }
        
        scanner.close();
    }
}
