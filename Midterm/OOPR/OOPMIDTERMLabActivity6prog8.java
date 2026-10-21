import java.util.Scanner;

public class OOPMIDTERMLabActivity6prog8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== FLOWER RESERVATION SYSTEM ===");
        System.out.print("Customer name: ");
        String name = input.nextLine();
        System.out.print("Customer ID: ");
        String id = input.nextLine();
        System.out.print("Contact number: ");
        String contact = input.nextLine();
        System.out.print("Flower type: ");
        String flowerType = input.nextLine();
        System.out.print("Arrangement type: ");
        String arrangement = input.nextLine();
        System.out.print("Price per arrangement: ");
        double price = input.nextDouble();
        System.out.print("Quantity: ");
        int quantity = input.nextInt();
        input.nextLine();
        System.out.print("Reservation date (YYYY-MM-DD): ");
        String reservationDate = input.nextLine();
        System.out.print("Pickup/delivery date (YYYY-MM-DD): ");
        String pickupDate = input.nextLine();
        System.out.print("Delivery fee: ");
        double delivery = input.nextDouble();
        System.out.print("Customization fee: ");
        double customization = input.nextDouble();
        System.out.print("Other charges: ");
        double other = input.nextDouble();
        System.out.print("Discount percentage: ");
        double discountPercent = input.nextDouble();
        System.out.print("Down payment: ");
        double downPayment = input.nextDouble();
        double reservationCost = price * quantity;
        double subtotal = reservationCost + delivery + customization + other;
        double discountAmount = subtotal * discountPercent / 100;
        double totalBill = subtotal - discountAmount;
        double balance = totalBill - downPayment;
        System.out.println("\n========== FLOWER RESERVATION RECEIPT ==========");
        System.out.println("Customer: " + name);
        System.out.println("Customer ID: " + id);
        System.out.println("Contact Number: " + contact);
        System.out.println("Flower Type: " + flowerType);
        System.out.println("Arrangement Type: " + arrangement);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Price per Arrangement:       %.2f%n", price);
        System.out.printf("Reservation Cost:            %.2f%n", reservationCost);
        System.out.println("Reservation Date: " + reservationDate);
        System.out.println("Pickup/Delivery Date: " + pickupDate);
        System.out.printf("Delivery Fee:                %.2f%n", delivery);
        System.out.printf("Customization Fee:           %.2f%n", customization);
        System.out.printf("Other Charges:               %.2f%n", other);
        System.out.printf("Subtotal:                    %.2f%n", subtotal);
        System.out.printf("Discount (%.2f%%):            %.2f%n", discountPercent, discountAmount);
        System.out.printf("Total Bill:                  %.2f%n", totalBill);
        System.out.printf("Down Payment:                %.2f%n", downPayment);
        if (balance >= 0) {
            System.out.printf("Remaining Balance:           %.2f%n", balance);
        } else {
            System.out.printf("Overpayment:                 %.2f%n", -balance);
        }
        System.out.println("================================================");
        input.close();
    }
}