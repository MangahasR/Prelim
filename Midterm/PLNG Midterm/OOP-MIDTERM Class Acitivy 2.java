import java.util.Scanner;

class NewClass1 {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);

        System.out.print("Enter total number of pages of a book: ");
        int totalPages = user.nextInt();
        System.out.print("How many pages have been read?: ");
        int pagesRead = user.nextInt();
        System.out.print("How many days have you been reading?: ");
        int daysReading = user.nextInt();
        System.out.print("How many days were allocated for borrowing the book?: ");
        int daysAllocated = user.nextInt();

        double percentageRead = (double) pagesRead / totalPages * 100;
        int daysRemaining = daysAllocated - daysReading;
        int pagesLeft = totalPages - pagesRead;

        System.out.println();
        System.out.printf("1. Percentage read: %.2f%%%n", percentageRead);
        System.out.println("2. Days remaining to return: " + daysRemaining + " day(s)");

        if (daysRemaining > 0) {
            double pagesPerDay = (double) pagesLeft / daysRemaining;
            System.out.printf("3. Pages to read every day: %.2f pages/day%n", pagesPerDay);
        } else {
            System.out.println("3. Pages to read every day: Cannot calculate (no days remaining)");
        }

        if (daysRemaining < 0) {
            System.out.println("OVERDUE!");
        } else if (daysRemaining == 0) {
            System.out.println("RETURN THE BOOK!");
        } else {
            System.out.println("KEEP READING!");
        }

        user.close();
    }
}
