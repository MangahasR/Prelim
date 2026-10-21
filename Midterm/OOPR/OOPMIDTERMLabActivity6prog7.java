import java.util.Scanner;

public class OOPMIDTERMLabActivity6prog7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== RESTAURANT ORDERING SYSTEM ===");
        System.out.print("Customer name: ");
        String name = input.nextLine();
        System.out.print("Order type (Dine-In/Takeout): ");
        String orderType = input.nextLine();
        String[] itemNames = new String[3];
        int[] quantities = new int[3];
        double[] prices = new double[3];
        double subtotal = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("\nItem " + (i + 1));
            System.out.print("Item name: ");
            itemNames[i] = input.nextLine();
            System.out.print("Quantity: ");
            quantities[i] = input.nextInt();
            System.out.print("Price per item: ");
            prices[i] = input.nextDouble();
            input.nextLine();
            subtotal += quantities[i] * prices[i];
        }
        System.out.print("Service charge (enter 0 for Takeout): ");
        double serviceCharge = input.nextDouble();
        System.out.print("Packaging fee (enter 0 for Dine-In): ");
        double packagingFee = input.nextDouble();
        System.out.print("Discount percentage: ");
        double discountPercent = input.nextDouble();
        System.out.print("Amount tendered: ");
        double tendered = input.nextDouble();
        double applicableCharge;
        if (orderType.equalsIgnoreCase("Dine-In")) {
            applicableCharge = serviceCharge;
        } else {
            applicableCharge = packagingFee;
        }
        double beforeDiscount = subtotal + applicableCharge;
        double discountAmount = beforeDiscount * discountPercent / 100;
        double amountDue = beforeDiscount - discountAmount;
        double difference = tendered - amountDue;
        System.out.println("\n============= RESTAURANT RECEIPT =============");
        System.out.println("Customer: " + name);
        System.out.println("Order Type: " + orderType);
        System.out.printf("%-20s %8s %12s %12s%n", "Item", "Quantity", "Price", "Total");
        for (int i = 0; i < 3; i++) {
            System.out.printf("%-20s %8d %12.2f %12.2f%n",
                    itemNames[i], quantities[i], prices[i], quantities[i] * prices[i]);
        }
        System.out.printf("Subtotal:                       %.2f%n", subtotal);
        System.out.printf("Service/Packaging Charge:        %.2f%n", applicableCharge);
        System.out.printf("Total Before Discount:           %.2f%n", beforeDiscount);
        System.out.printf("Discount (%.2f%%):                %.2f%n", discountPercent, discountAmount);
        System.out.printf("Total Amount Due:                %.2f%n", amountDue);
        System.out.printf("Amount Tendered:                 %.2f%n", tendered);
        if (difference >= 0) {
            System.out.printf("Change:                          %.2f%n", difference);
        } else {
            System.out.printf("Remaining Balance:               %.2f%n", -difference);
        }
        System.out.println("===============================================");
        input.close();
    }
}