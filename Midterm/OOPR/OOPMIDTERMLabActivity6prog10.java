import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class OOPMIDTERMLabActivity6prog10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== PARKING RESERVATION AND BILLING ===");
        System.out.print("Customer name: ");
        String name = input.nextLine();
        System.out.print("Customer ID: ");
        String id = input.nextLine();
        System.out.print("Contact number: ");
        String contact = input.nextLine();
        System.out.print("Vehicle type (Car/Motorcycle): ");
        String vehicleType = input.nextLine();
        System.out.print("Plate number: ");
        String plate = input.nextLine();
        System.out.print("Entry time (HH:MM): ");
        LocalTime entryTime = LocalTime.parse(input.nextLine());
        System.out.print("Exit time (HH:MM): ");
        LocalTime exitTime = LocalTime.parse(input.nextLine());
        long minutes = Duration.between(entryTime, exitTime).toMinutes();
        if (minutes < 0) {
            minutes += 24 * 60;
        }
        long hours = (minutes + 59) / 60;
        System.out.print("Hourly rate: ");
        double hourlyRate = input.nextDouble();
        System.out.print("Reservation fee: ");
        double reservationFee = input.nextDouble();
        System.out.print("Overnight fee: ");
        double overnightFee = input.nextDouble();
        System.out.print("Penalty fee: ");
        double penaltyFee = input.nextDouble();
        System.out.print("Discount percentage: ");
        double discountPercent = input.nextDouble();
        System.out.print("Cash payment: ");
        double cash = input.nextDouble();
        double parkingFee = hours * hourlyRate;
        double subtotal = parkingFee + reservationFee + overnightFee + penaltyFee;
        double discountAmount = subtotal * discountPercent / 100;
        double totalBill = subtotal - discountAmount;
        double difference = cash - totalBill;
        System.out.println("\n================ PARKING RECEIPT ================");
        System.out.println("Customer: " + name);
        System.out.println("Customer ID: " + id);
        System.out.println("Contact Number: " + contact);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Plate Number: " + plate);
        System.out.println("Entry Time: " + entryTime);
        System.out.println("Exit Time: " + exitTime);
        System.out.println("Total Parking Hours: " + hours);
        System.out.printf("Hourly Rate:            %.2f%n", hourlyRate);
        System.out.printf("Parking Fee:            %.2f%n", parkingFee);
        System.out.printf("Reservation Fee:        %.2f%n", reservationFee);
        System.out.printf("Overnight Fee:          %.2f%n", overnightFee);
        System.out.printf("Penalty Fee:            %.2f%n", penaltyFee);
        System.out.printf("Subtotal:               %.2f%n", subtotal);
        System.out.printf("Discount (%.2f%%):       %.2f%n", discountPercent, discountAmount);
        System.out.printf("Total Bill:             %.2f%n", totalBill);
        System.out.printf("Cash Payment:           %.2f%n", cash);
        if (difference >= 0) {
            System.out.printf("Change:                 %.2f%n", difference);
        } else {
            System.out.printf("Remaining Balance:      %.2f%n", -difference);
        }
        System.out.println("==================================================");
        input.close();
    }
}