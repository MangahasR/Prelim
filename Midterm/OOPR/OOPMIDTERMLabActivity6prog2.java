import java.util.Scanner;

public class OOPMIDTERMLabActivity6prog2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== STUDENT TUITION BILLING SYSTEM ===");
        System.out.print("Student name: ");
        String name = input.nextLine();
        System.out.print("Student ID: ");
        String id = input.nextLine();
        System.out.print("Course/program: ");
        String course = input.nextLine();
        System.out.print("Year level: ");
        int year = input.nextInt();
        System.out.print("Units enrolled: ");
        int units = input.nextInt();
        System.out.print("Tuition fee per unit: ");
        double feePerUnit = input.nextDouble();
        System.out.print("Miscellaneous fee: ");
        double misc = input.nextDouble();
        System.out.print("Laboratory fee: ");
        double lab = input.nextDouble();
        System.out.print("Library fee: ");
        double library = input.nextDouble();
        System.out.print("Other fees: ");
        double other = input.nextDouble();
        System.out.print("Down payment: ");
        double downPayment = input.nextDouble();
        System.out.print("Scholarship discount amount: ");
        double scholarship = input.nextDouble();
        double tuitionTotal = units * feePerUnit;
        double grossTotal = tuitionTotal + misc + lab + library + other;
        double netTotal = grossTotal - scholarship;
        double balance = netTotal - downPayment;
        System.out.println("\n============= STUDENT TUITION BILL =============");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Course: " + course);
        System.out.println("Year Level: " + year);
        System.out.println("Units Enrolled: " + units);
        System.out.printf("Tuition per Unit:       %.2f%n", feePerUnit);
        System.out.printf("Tuition Fee Total:      %.2f%n", tuitionTotal);
        System.out.printf("Miscellaneous Fee:      %.2f%n", misc);
        System.out.printf("Laboratory Fee:         %.2f%n", lab);
        System.out.printf("Library Fee:            %.2f%n", library);
        System.out.printf("Other Fees:             %.2f%n", other);
        System.out.printf("Gross Total Fee:        %.2f%n", grossTotal);
        System.out.printf("Scholarship Discount:   %.2f%n", scholarship);
        System.out.printf("Net Total Fee:          %.2f%n", netTotal);
        System.out.printf("Down Payment:           %.2f%n", downPayment);
        System.out.printf("Remaining Balance:      %.2f%n", balance);
        System.out.println("================================================");
        input.close();
    }
}
