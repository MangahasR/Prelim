import java.util.Scanner;

public class BookTrackerActivity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String readerName = "";
        do {
            System.out.print("Please enter your name: ");
            readerName = scanner.nextLine().trim();
            if (readerName.length() == 0) {
                System.out.println("Name cannot be blank\n");
            }
        } while (readerName.isEmpty());
        System.out.println("Welcome " + readerName + "!\n");

        int maxPages = 0;
        while (maxPages <= 0) {
            System.out.print("How many pages does the book have?: ");
            if (scanner.hasNextInt()) {
                maxPages = scanner.nextInt();
                if (maxPages <= 0) {
                    System.out.println("The book must have atleast 1 page.\n");
                }
            } else {
                System.out.println("Enter a valid number.\n");
                scanner.next();
            }
        }

        int completedPages = -1;
        while (completedPages < 0 || completedPages > maxPages) {
            System.out.print("How many pages have you read?: ");
            if (scanner.hasNextInt()) {
                completedPages = scanner.nextInt();
                if (completedPages < 0 || completedPages > maxPages) {
                    System.out.println("Pages read cannot be 0 or more than the limit" + maxPages + ".\n");
                }
            } else {
                System.out.println("ENTER  VALID WHOLE NUMBER.\n");
                scanner.next();
            }
        }

        int totalDaysAllowed = 0;
        while (totalDaysAllowed <= 0) {
            System.out.print("How many total days allotted for borrowing: ");
            if (scanner.hasNextInt()) {
                totalDaysAllowed = scanner.nextInt();
                if (totalDaysAllowed <= 0) {
                    System.out.println("ALLOTTED DAYS MUST BE AT LEAST 1 DAY.\n");
                }
            } else {
                System.out.println("ENTER  VALID WHOLE NUMBER.\n");
                scanner.next();
            }
        }

        int daysSpent = -1;
        while (daysSpent < 0 || daysSpent > totalDaysAllowed) {
            System.out.print("How many days you have been reading: ");
            if (scanner.hasNextInt()) {
                daysSpent = scanner.nextInt();
                if (daysSpent < 0 || daysSpent > totalDaysAllowed) {
                    System.out.println("DAYS READING CANNOT BE LESS THAN 0 OR MORE THAN " + totalDaysAllowed + ".\n");
                }
            } else {
                System.out.println("ENTER  VALID WHOLE NUMBER.\n");
                scanner.next();
            }
        }

        double progressPercent = ((double) completedPages / maxPages) * 100;
        int timeLeft = totalDaysAllowed - daysSpent;
        int remainingPages = maxPages - completedPages;
        
        double dRT = 0.0;
        if (timeLeft > 0) {
            dRT = (int) remainingPages / timeLeft;
        }


        System.out.println();
        System.out.printf("Percentage read: %.2f%%\n", progressPercent);
        System.out.println("Days remaining to return: " + timeLeft + " day(s)");
        System.out.printf("Pages to read every day: %d pages/day\n", (int) Math.ceil(dRT));
        System.out.println();

        if (timeLeft <= 0) {
            System.out.println("Return the book to the store!");
        } else {
            System.out.println("keep reading the due is almost up!");
        }

        scanner.close();
    }
}
