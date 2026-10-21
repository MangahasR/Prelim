import java.util.Scanner;

public class OOPMIDTERMLabActivity6prog9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== KMART KOREAN NOODLES BILLING ===");
        System.out.print("Customer name: ");
        String name = input.nextLine();
        System.out.print("Customer ID: ");
        String id = input.nextLine();
        System.out.print("Contact number: ");
        String contact = input.nextLine();
        System.out.print("Product name: ");
        String product = input.nextLine();
        System.out.print("Brand: ");
        String brand = input.nextLine();
        System.out.print("Price per pack: ");
        double price = input.nextDouble();
        System.out.print("Quantity: ");
        int quantity = input.nextInt();
        System.out.print("Packaging fee: ");
        double packaging = input.nextDouble();
        System.out.print("Delivery fee: ");
        double delivery = input.nextDouble();
        System.out.print("Discount percentage: ");
        double discountPercent = input.nextDouble();
        System.out.print("Cash payment: ");
        double cash = input.nextDouble();
        double productCost = price * quantity;
        double subtotal = productCost + packaging + delivery;
        double discountAmount = subtotal * discountPercent / 100;
        double totalBill = subtotal - discountAmount;
        double difference = cash - totalBill;
        System.out.println("\n============= KMART PURCHASE RECEIPT =============");
        System.out.println("Customer: " + name);
        System.out.println("Customer ID: " + id);
        System.out.println("Contact Number: " + contact);
        System.out.println("Product: " + product);
        System.out.println("Brand: " + brand);
        System.out.printf("Price per Pack:          %.2f%n", price);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Total Product Cost:      %.2f%n", productCost);
        System.out.printf("Packaging Fee:           %.2f%n", packaging);
        System.out.printf("Delivery Fee:            %.2f%n", delivery);
        System.out.printf("Subtotal:                %.2f%n", subtotal);
        System.out.printf("Discount (%.2f%%):        %.2f%n", discountPercent, discountAmount);
        System.out.printf("Total Bill:              %.2f%n", totalBill);
        System.out.printf("Cash Payment:            %.2f%n", cash);
        if (difference >= 0) {
            System.out.printf("Change:                  %.2f%n", difference);
        } else {
            System.out.printf("Remaining Balance:       %.2f%n", -difference);
        }
        System.out.println("===================================================");
        input.close();
    }
}
