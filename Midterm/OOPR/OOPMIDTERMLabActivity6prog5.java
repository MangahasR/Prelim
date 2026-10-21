import java.util.Scanner;

public class OOPMIDTERMLabActivity6prog5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== RESERVATION AND BILLING SYSTEM ===");
        System.out.print("Customer name: ");
        String name = input.nextLine();
        System.out.print("Customer ID: ");
        String id = input.nextLine();
        System.out.print("Reservation type (Room/Cottage/Table): ");
        String type = input.nextLine();
        System.out.print("Number of days or hours reserved: ");
        double duration = input.nextDouble();
        System.out.print("Rate per day or hour: ");
        double rate = input.nextDouble();
        System.out.print("Food charges: ");
        double food = input.nextDouble();
        System.out.print("Service charges: ");
        double service = input.nextDouble();
        System.out.print("Other charges: ");
        double other = input.nextDouble();
        System.out.print("Discount percentage: ");
        double discountPercent = input.nextDouble();
        System.out.print("Down payment: ");
        double downPayment = input.nextDouble();
        double reservationCost = duration * rate;
        double subtotal = reservationCost + food + service + other;
        double discountAmount = subtotal * discountPercent / 100;
        double totalBill = subtotal - discountAmount;
        double balance = totalBill - downPayment;
        System.out.println("\n============= RESERVATION BILL =============");
        System.out.println("Customer: " + name);
        System.out.println("Customer ID: " + id);
        System.out.println("Reservation Type: " + type);
        System.out.println("Duration: " + duration);
        System.out.printf("Rate:                    %.2f%n", rate);
        System.out.printf("Reservation Cost:        %.2f%n", reservationCost);
        System.out.printf("Food Charges:            %.2f%n", food);
        System.out.printf("Service Charges:         %.2f%n", service);
        System.out.printf("Other Charges:           %.2f%n", other);
        System.out.printf("Subtotal:                %.2f%n", subtotal);
        System.out.printf("Discount (%.2f%%):        %.2f%n", discountPercent, discountAmount);
        System.out.printf("Total Bill:              %.2f%n", totalBill);
        System.out.printf("Down Payment:            %.2f%n", downPayment);
        if (balance >= 0) {
            System.out.printf("Remaining Balance:       %.2f%n", balance);
        } else {
            System.out.printf("Overpayment:             %.2f%n", -balance);
        }
        System.out.println("=============================================");
        input.close();
    }
}
