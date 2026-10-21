import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class OOPMIDTERMLabActivity6prog6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== CAR RENTAL SYSTEM ===");
        System.out.print("Customer name: ");
        String name = input.nextLine();
        System.out.print("Customer ID: ");
        String id = input.nextLine();
        System.out.print("Driver's license number: ");
        String license = input.nextLine();
        System.out.print("Vehicle type: ");
        String vehicleType = input.nextLine();
        System.out.print("Vehicle model: ");
        String model = input.nextLine();
        System.out.print("Rental rate per day: ");
        double rate = input.nextDouble();
        input.nextLine();
        System.out.print("Pickup date (YYYY-MM-DD): ");
        LocalDate pickupDate = LocalDate.parse(input.nextLine());
        System.out.print("Return date (YYYY-MM-DD): ");
        LocalDate returnDate = LocalDate.parse(input.nextLine());
        long days = ChronoUnit.DAYS.between(pickupDate, returnDate);
        if (days < 1) {
            days = 1;
        }
        System.out.print("Insurance fee: ");
        double insurance = input.nextDouble();
        System.out.print("Fuel charge: ");
        double fuel = input.nextDouble();
        System.out.print("Other charges: ");
        double other = input.nextDouble();
        System.out.print("Discount percentage: ");
        double discountPercent = input.nextDouble();
        System.out.print("Amount paid: ");
        double amountPaid = input.nextDouble();
        double rentalCost = rate * days;
        double subtotal = rentalCost + insurance + fuel + other;
        double discountAmount = subtotal * discountPercent / 100;
        double totalDue = subtotal - discountAmount;
        double difference = amountPaid - totalDue;
        System.out.println("\n============== CAR RENTAL RECEIPT ==============");
        System.out.println("Customer: " + name);
        System.out.println("Customer ID: " + id);
        System.out.println("Driver's License: " + license);
        System.out.println("Vehicle: " + vehicleType + " - " + model);
        System.out.printf("Rate per Day:            %.2f%n", rate);
        System.out.println("Pickup Date: " + pickupDate);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Rental Days: " + days);
        System.out.printf("Rental Cost:             %.2f%n", rentalCost);
        System.out.printf("Insurance Fee:           %.2f%n", insurance);
        System.out.printf("Fuel Charge:             %.2f%n", fuel);
        System.out.printf("Other Charges:           %.2f%n", other);
        System.out.printf("Subtotal:                %.2f%n", subtotal);
        System.out.printf("Discount (%.2f%%):        %.2f%n", discountPercent, discountAmount);
        System.out.printf("Total Amount Due:        %.2f%n", totalDue);
        System.out.printf("Amount Paid:             %.2f%n", amountPaid);
        if (difference >= 0) {
            System.out.printf("Change:                  %.2f%n", difference);
        } else {
            System.out.printf("Remaining Balance:       %.2f%n", -difference);
        }
        System.out.println("================================================");
        input.close();
    }
}