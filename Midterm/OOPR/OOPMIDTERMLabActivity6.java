import java.util.ArrayList;
import java.util.Scanner;

public class CampusPrograms {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            try {
                System.out.println("\n===== MAIN MENU =====");
                System.out.println("1. Banking Program");
                System.out.println("2. Hospital Database Program");
                System.out.println("3. University Hierarchy Program");
                System.out.println("4. Exit Application");
                System.out.print("Select which program to run: ");

                option = input.nextInt();

                switch (option) {
                    case 1:
                        runBanking();
                        break;
                    case 2:
                        runHospital();
                        break;
                    case 3:
                        runUniversity();
                        break;
                    case 4:
                        System.out.println("Exiting application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.");
                }
            } catch (Exception error) {
                System.out.println("Error: Invalid input. Please enter a number.");
                input.nextLine();
                option = 0;
            }
        } while (option != 4);
    }

    public static void runBanking() {
        int choice = 0;
        double funds = 0;
        boolean hasBalance = false;

        do {
            try {
                if (!hasBalance) {
                    System.out.print("Enter your initial balance: ");
                    funds = input.nextDouble();
                    hasBalance = true;
                }

                System.out.println("\n--- Banking Menu ---");
                System.out.println("1. Withdraw Amount");
                System.out.println("2. Deposit Amount");
                System.out.println("3. Back to Main Menu");
                System.out.println("4. Re-enter Initial Balance");
                System.out.print("Enter your choice: ");

                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        funds = takeMoney(funds);
                        break;
                    case 2:
                        funds = addMoney(funds);
                        break;
                    case 3:
                        System.out.println("Returning to main menu...");
                        break;
                    case 4:
                        System.out.println("Resetting balance. Please wait.");

                        int waitTime = (int) (Math.random() * 5) + 2;

                        for (int seconds = waitTime; seconds > 0; seconds--) {
                            System.out.println("Please wait " + seconds + " seconds...");
                            Thread.sleep(1000);
                        }

                        System.out.println("Balance reset successful.");
                        hasBalance = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception error) {
                System.out.println("Error: Invalid input. Numeric values only.");
                input.nextLine();
                choice = 0;
            }
        } while (choice != 3);
    }

    public static double takeMoney(double funds) {
        System.out.print("How much do you want to withdraw?\nAmount: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
        } else if (amount > funds) {
            System.out.println("Error: Insufficient funds.");
        } else {
            funds -= amount;
            System.out.println("Your new balance is: " + funds);
        }

        return funds;
    }

    public static double addMoney(double funds) {
        System.out.print("How much do you want to deposit?\nAmount: ");
        double amount = input.nextDouble();

        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
        } else {
            funds += amount;
            System.out.println("Your new balance is: " + funds);
        }

        return funds;
    }

    static class AdmissionDate {
        int day;
        int month;
        int year;

        public AdmissionDate(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public String toString() {
            return day + "/" + month + "/" + year;
        }
    }

    static class HospitalPatient {
        String patientName;
        AdmissionDate admission;
        String diagnosis;
        AdmissionDate discharge;

        public void enterDetails() {
            System.out.print("Enter Patient Name: ");
            input.nextLine();
            patientName = input.nextLine();

            System.out.println("Enter Date of Admission:");
            System.out.print("Day (DD): ");
            int firstDay = input.nextInt();

            System.out.print("Month (MM): ");
            int firstMonth = input.nextInt();

            System.out.print("Year (YYYY): ");
            int firstYear = input.nextInt();

            admission = new AdmissionDate(firstDay, firstMonth, firstYear);

            System.out.print("Enter Disease/Diagnosis: ");
            input.nextLine();
            diagnosis = input.nextLine();

            System.out.println("Enter Date of Discharge:");
            System.out.print("Day (DD): ");
            int lastDay = input.nextInt();

            System.out.print("Month (MM): ");
            int lastMonth = input.nextInt();

            System.out.print("Year (YYYY): ");
            int lastYear = input.nextInt();

            discharge = new AdmissionDate(lastDay, lastMonth, lastYear);
        }

        public void showDetails() {
            System.out.println("Name: " + patientName);
            System.out.println("Admitted On: " + admission);
            System.out.println("Disease: " + diagnosis);
            System.out.println("Discharged On: " + discharge);
        }
    }

    static class PatientRecord extends HospitalPatient {
        int patientAge;

        @Override
        public void enterDetails() {
            super.enterDetails();
            System.out.print("Enter Patient Age: ");
            patientAge = input.nextInt();
        }

        @Override
        public void showDetails() {
            super.showDetails();
            System.out.println("Age: " + patientAge + " years old");
            System.out.println("---------------------------------------");
        }
    }

    public static void runHospital() {
        ArrayList<PatientRecord> records = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== HOSPITAL INDOOR PATIENT DATABASE =====");
            System.out.println("1. Add New Patient Records");
            System.out.println("2. Display All Patients");
            System.out.println("3. List Pediatric Patients (Age < 12)");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            try {
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("How many patient records do you want to add? ");
                        int total = input.nextInt();

                        for (int index = 0; index < total; index++) {
                            System.out.println("\n--- Patient #" + (index + 1) + " ---");

                            PatientRecord record = new PatientRecord();
                            record.enterDetails();
                            records.add(record);
                        }
                        break;

                    case 2:
                        if (records.isEmpty()) {
                            System.out.println("The database is currently empty.");
                        } else {
                            System.out.println("\n===== ALL PATIENT RECORDS =====");

                            for (PatientRecord record : records) {
                                record.showDetails();
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n===== PEDIATRIC PATIENTS (UNDER 12) =====");

                        boolean found = false;

                        for (PatientRecord record : records) {
                            if (record.patientAge < 12) {
                                record.showDetails();
                                found = true;
                            }
                        }

                        if (!found) {
                            System.out.println("No pediatric patients found.");
                        }
                        break;

                    case 4:
                        System.out.println("Returning to main menu...");
                        break;

                    default:
                        System.out.println("Invalid input. Please choose a valid option.");
                }
            } catch (Exception error) {
                System.out.println("Error: Invalid input. Please enter a number.");
                input.nextLine();
                choice = 0;
            }
        } while (choice != 4);
    }

    public static void runUniversity() {
        class FacultyMember {
            private String fullName;
            private double monthlySalary;

            public FacultyMember(String fullName, double monthlySalary) {
                this.fullName = fullName;
                this.monthlySalary = monthlySalary;
            }

            public String getFullName() {
                return fullName;
            }

            public double getMonthlySalary() {
                return monthlySalary;
            }
        }

        class DepartmentDean extends FacultyMember {
            private String departmentName;

            public DepartmentDean(String fullName, double monthlySalary,
                                  String departmentName) {
                super(fullName, monthlySalary);
                this.departmentName = departmentName;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            protected String getDetails() {
                return "Name: " + getFullName() + "\n"
                    + "Department: " + departmentName + "\n"
                    + "Salary: " + (int) getMonthlySalary();
            }

            @Override
            public String toString() {
                return "Status\n"
                    + "Rank: Dean\n"
                    + getDetails();
            }
        }

        class UniversityExecutive extends DepartmentDean {
            public UniversityExecutive(String fullName, double monthlySalary,
                                       String departmentName) {
                super(fullName, monthlySalary, departmentName);
            }

            @Override
            public String toString() {
                return "Status\n"
                    + "Rank: Executive\n"
                    + getDetails();
            }
        }

        int choice;

        do {
            System.out.println("\n--- University Ranking Menu ---");
            System.out.println("1. Enter and Display Dean and Executive Details");
            System.out.println("2. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("\n--- Enter Dean Details ---");
                        System.out.print("Name: ");
                        String deanName = input.nextLine();

                        System.out.print("Department: ");
                        String deanDepartment = input.nextLine();

                        System.out.print("Salary: ");
                        double deanSalary = input.nextDouble();
                        input.nextLine();

                        System.out.println("\n--- Enter Executive Details ---");
                        System.out.print("Name: ");
                        String executiveName = input.nextLine();

                        System.out.print("Department: ");
                        String executiveDepartment = input.nextLine();

                        System.out.print("Salary: ");
                        double executiveSalary = input.nextDouble();
                        input.nextLine();

                        DepartmentDean dean = new DepartmentDean(
                            deanName, deanSalary, deanDepartment
                        );

                        UniversityExecutive executive = new UniversityExecutive(
                            executiveName, executiveSalary, executiveDepartment
                        );

                        System.out.println();
                        System.out.println(dean);
                        System.out.println("----------------------------------------");
                        System.out.println(executive);
                        break;

                    case 2:
                        System.out.println("Returning to main menu...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception error) {
                System.out.println("Error: Invalid input. Please enter valid values.");
                input.nextLine();
                choice = 0;
            }
        } while (choice != 2);
    }
}