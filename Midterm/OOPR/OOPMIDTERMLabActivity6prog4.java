import java.util.Scanner;

public class OOPMIDTERMLabActivity6prog4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== EVENT TICKETING SYSTEM ===");
        System.out.print("Customer name: ");
        String name = input.nextLine();
        System.out.print("Customer ID: ");
        String id = input.nextLine();
        System.out.print("Event name: ");
        String event = input.nextLine();
        System.out.print("Ticket type (Regular/VIP): ");
        String ticketType = input.nextLine();
        System.out.print("Ticket price: ");
        double price = input.nextDouble();
        System.out.print("Number of tickets: ");
        int quantity = input.nextInt();
        System.out.print("Discount percentage: ");
        double discountPercent = input.nextDouble();
        System.out.print("Amount tendered: ");
        double tendered = input.nextDouble();
        double totalCost = price * quantity;
        double discountAmount = totalCost * discountPercent / 100;
        double amountDue = totalCost - discountAmount;
        double difference = tendered - amountDue;
        System.out.println("\n================ EVENT TICKET ================");
        System.out.println("Customer: " + name);
        System.out.println("Customer ID: " + id);
        System.out.println("Event: " + event);
        System.out.println("Ticket Type: " + ticketType);
        System.out.printf("Ticket Price:           %.2f%n", price);
        System.out.println("Number of Tickets: " + quantity);
        System.out.printf("Total Ticket Cost:      %.2f%n", totalCost);
        System.out.printf("Discount (%.2f%%):       %.2f%n", discountPercent, discountAmount);
        System.out.printf("Final Amount Due:       %.2f%n", amountDue);
        System.out.printf("Amount Tendered:        %.2f%n", tendered);
        if (difference >= 0) {
            System.out.printf("Change:                 %.2f%n", difference);
        } else {
            System.out.printf("Remaining Balance:      %.2f%n", -difference);
        }
        System.out.println("==============================================");
        input.close();
    }
}
