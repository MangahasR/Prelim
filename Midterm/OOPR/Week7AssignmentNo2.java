import java.util.Scanner;
public class MidtermAss2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a letter: ");
        char letter = scanner.next().charAt(0);
        
        char lowerLetter = Character.toLowerCase(letter);
        
        if (Character.isLetter(lowerLetter)) {
            if (lowerLetter == 'a' || lowerLetter == 'e' || lowerLetter == 'i' || lowerLetter == 'o' || lowerLetter == 'u') {
                System.out.println("Its a vowel!");
            } else {
                System.out.println("Its a consonant!");
            }
        } else {
            System.out.println("INVALID");
        }
    }
}
