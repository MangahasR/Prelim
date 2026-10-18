import java.util.Scanner;
public class EvenOddCheck {
    public static void main(String[] args) {
        int number; 
        Scanner user = new Scanner(System.in);
        System.out.print("Enter a number: ");
        number = user.nextInt();  


        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}