import java.text.DecimalFormat;
import java.util.Scanner;

public class JavaMenuPrograms {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        int selectedOption;
        do {
            System.out.println("\n===== MIDTERM ACTIVITY 3 =====");
            System.out.println(" 1. Vowel / Consonant        17. Sum of squares");
            System.out.println(" 2. Date in words            18. Sum 1 to n");
            System.out.println(" 3. Temperature (ICE/WATER)  19. Reverse a number");
            System.out.println(" 4. Aircraft label           20. Sum of powers");
            System.out.println(" 5. Ship class               21. Right triangle (*)");
            System.out.println(" 6. Earthquake damage        22. Floyd's triangle (0/1)");
            System.out.println(" 7. Number to words          23. Odd pyramid (*)");
            System.out.println(" 8. Roman numerals           24. Pyramid, repeated number");
            System.out.println(" 9. Tuition fee              25. Pyramid (*)");
            System.out.println("10. Percentile to grade      26. Pyramid, counting numbers");
            System.out.println("11. Squares table            27. Right triangle, counting");
            System.out.println("12. Sequence 1,5,2,4...      28. Right triangle, repeated");
            System.out.println("13. Sequence 5,1,4,2...      29. Right triangle, 1..i");
            System.out.println("14. Factorial                30. Diamond");
            System.out.println("15. Fibonacci                31. Number pyramid 1 2 1");
            System.out.println("16. Power");
            System.out.println(" 0. Exit");
            selectedOption = getNumberBetween("Enter program number: ", 0, 31);
            System.out.println();
            executeProgram(selectedOption);
        } while (selectedOption != 0);
        System.out.println("Goodbye!");
    }

    static void executeProgram(int selectedOption) {
        switch (selectedOption) {
            case 1: letterType(); break;
            case 2: dateDisplay(); break;
            case 3: temperatureState(); break;
            case 4: aircraftType(); break;
            case 5: shipType(); break;
            case 6: earthquakeImpact(); break;
            case 7: numberWords(); break;
            case 8: romanNumber(); break;
            case 9: tuitionPayment(); break;
            case 10: gradeEquivalent(); break;
            case 11: squaresTable(); break;
            case 12: pairedSequence(); break;
            case 13: reversePairedSequence(); break;
            case 14: factorialValues(); break;
            case 15: fibonacciSeries(); break;
            case 16: powerValues(); break;
            case 17: sumOfSquares(); break;
            case 18: sumFromOne(); break;
            case 19: reverseNumber(); break;
            case 20: sumOfPowers(); break;
            case 21: starTriangle(); break;
            case 22: binaryTriangle(); break;
            case 23: oddStarPyramid(); break;
            case 24: repeatedNumberPyramid(); break;
            case 25: starPyramid(); break;
            case 26: countingNumberPyramid(); break;
            case 27: countingNumberTriangle(); break;
            case 28: repeatedNumberTriangle(); break;
            case 29: ascendingNumberTriangle(); break;
            case 30: diamondPattern(); break;
            case 31: numberMirrorPyramid(); break;
            default: break;
        }
    }

    static String getText(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine().trim();
    }

    static int getWholeNumber(String prompt) {
        while (true) {
            String s = getText(prompt).replace(",", "");
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    static int getNumberBetween(String prompt, int min, int max) {
        while (true) {
            int n = getWholeNumber(prompt);
            if (n >= min && n <= max) {
                return n;
            }
            System.out.println("Please enter a number from " + min + " to " + max + ".");
        }
    }

    static double getDecimalNumber(String prompt) {
        while (true) {
            String s = getText(prompt).replace(",", "");
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    static char getLetter(String prompt) {
        while (true) {
            String s = getText(prompt);
            if (s.length() == 1 && Character.isLetter(s.charAt(0))) {
                return s.charAt(0);
            }
            System.out.println("Please enter a single letter.");
        }
    }

    static int getRowCount() {
        return getNumberBetween("Number of rows: ", 1, 30);
    }

    static String repeatText(String s, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    static void letterType() {
        char c = Character.toUpperCase(getLetter("Enter a letter: "));
        System.out.println("Solution 1 (if / else if / else): " + checkVowelIf(c));
        System.out.println("Solution 2 (switch / case):       " + checkVowelSwitch(c));
    }

    static String checkVowelIf(char c) {
        if (c == 'A') {
            return "VOWEL";
        } else if (c == 'E') {
            return "VOWEL";
        } else if (c == 'I') {
            return "VOWEL";
        } else if (c == 'O') {
            return "VOWEL";
        } else if (c == 'U') {
            return "VOWEL";
        } else {
            return "CONSONANT";
        }
    }

    static String checkVowelSwitch(char c) {
        switch (c) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return "VOWEL";
            default:
                return "CONSONANT";
        }
    }

    static void dateDisplay() {
        int month, day, year;
        while (true) {
            String[] parts = getText("Enter date as month day year (e.g. 2 26 1986): ").split("\\s+");
            try {
                if (parts.length != 3) {
                    throw new NumberFormatException();
                }
                month = Integer.parseInt(parts[0]);
                day = Integer.parseInt(parts[1]);
                year = Integer.parseInt(parts[2]);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid format. Type three whole numbers separated by spaces.");
            }
        }
        if (month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("Invalid date.");
            return;
        }
        System.out.println("Solution 1 (if / else if): " + getMonthIf(month) + " " + day + ", " + year);
        System.out.println("Solution 2 (switch):       " + getMonthSwitch(month) + " " + day + ", " + year);
    }

    static String getMonthIf(int m) {
        if (m == 1) {
            return "January";
        } else if (m == 2) {
            return "February";
        } else if (m == 3) {
            return "March";
        } else if (m == 4) {
            return "April";
        } else if (m == 5) {
            return "May";
        } else if (m == 6) {
            return "June";
        } else if (m == 7) {
            return "July";
        } else if (m == 8) {
            return "August";
        } else if (m == 9) {
            return "September";
        } else if (m == 10) {
            return "October";
        } else if (m == 11) {
            return "November";
        } else {
            return "December";
        }
    }

    static String getMonthSwitch(int m) {
        switch (m) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            default: return "December";
        }
    }

    static void temperatureState() {
        double temp = getDecimalNumber("Enter temp: ");
        if (temp < 0) {
            System.out.println("ICE");
        } else if (temp <= 100) {
            System.out.println("WATER");
        } else {
            System.out.println("STEAM");
        }
    }

    static void aircraftType() {
        double speed = getDecimalNumber("Observed speed (km/h): ");
        double length = getDecimalNumber("Estimated length (m): ");
        if (speed > 1100 && length > 52) {
            System.out.println("Civilian aircraft");
        } else if (speed >= 500) {
            System.out.println("Military aircraft");
        } else {
            System.out.println("It's a bird");
        }
    }

    static void shipType() {
        char id = getLetter("Enter class ID (B, C, D, F): ");
        System.out.println("Solution 1 (if / else if / else): " + getShipIf(id));
        System.out.println("Solution 2 (switch / case):       " + getShipSwitch(id));
    }

    static String getShipIf(char id) {
        if (id == 'B' || id == 'b') {
            return "Battleship";
        } else if (id == 'C' || id == 'c') {
            return "Cruiser";
        } else if (id == 'D' || id == 'd') {
            return "Destroyer";
        } else if (id == 'F' || id == 'f') {
            return "Frigate";
        } else {
            return "Unknown class ID";
        }
    }

    static String getShipSwitch(char id) {
        switch (id) {
            case 'B':
            case 'b':
                return "Battleship";
            case 'C':
            case 'c':
                return "Cruiser";
            case 'D':
            case 'd':
                return "Destroyer";
            case 'F':
            case 'f':
                return "Frigate";
            default:
                return "Unknown class ID";
        }
    }

    static void earthquakeImpact() {
        double n = getDecimalNumber("Enter Richter scale value: ");
        if (n < 5.0) {
            System.out.println("Little or no damage");
        } else if (n < 5.5) {
            System.out.println("Some damage");
        } else if (n < 6.5) {
            System.out.println("Serious damage");
        } else if (n < 7.5) {
            System.out.println("Disaster");
        } else {
            System.out.println("Catastrophe");
        }
    }

    static final String[] ONES = {"", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"};
    static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"};

    static void numberWords() {
        int n = getNumberBetween("Enter a number (0-3000): ", 0, 3000);
        System.out.println(convertNumberToWords(n));
    }

    static String convertNumberToWords(int n) {
        if (n == 0) {
            return "zero";
        }
        StringBuilder sb = new StringBuilder();
        int thousands = n / 1000;
        int hundreds = (n % 1000) / 100;
        int rest = n % 100;
        if (thousands > 0) {
            sb.append(ONES[thousands]).append(" thousand ");
        }
        if (hundreds > 0) {
            sb.append(ONES[hundreds]).append(" hundred ");
        }
        if (rest > 0) {
            if (rest < 20) {
                sb.append(ONES[rest]);
            } else {
                sb.append(TENS[rest / 10]);
                if (rest % 10 > 0) {
                    sb.append(" ").append(ONES[rest % 10]);
                }
            }
        }
        return sb.toString().trim();
    }

    static void romanNumber() {
        int n = getNumberBetween("Enter a number (1-3000): ", 1, 3000);
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (n >= values[i]) {
                roman.append(symbols[i]);
                n -= values[i];
            }
        }
        System.out.println(roman);
    }

    static void tuitionPayment() {
        double fee = getDecimalNumber("Enter tuition fee: ");
        System.out.println("(Press 1 for Cash, 2 for Two-Installment, 3 for Three-Installment)");
        int plan = getNumberBetween("Enter mode of payment: ", 1, 3);
        double total;
        switch (plan) {
            case 1:
                total = fee - fee * 0.10;
                break;
            case 2:
                total = fee - fee * 0.05;
                break;
            default:
                total = fee + fee * 0.10;
        }
        DecimalFormat df = new DecimalFormat("#,##0.##");
        System.out.println("Your total tuition fee is: " + df.format(total));
    }

    static void gradeEquivalent() {
        double p = getDecimalNumber("Enter grade (percentile): ");
        String grade;
        if (p >= 98 && p <= 100) {
            grade = "1.00";
        } else if (p >= 95 && p < 98) {
            grade = "1.25";
        } else if (p >= 92 && p < 95) {
            grade = "1.50";
        } else if (p >= 89 && p < 92) {
            grade = "1.75";
        } else if (p >= 85 && p < 89) {
            grade = "2.00";
        } else if (p >= 82 && p < 85) {
            grade = "2.25";
        } else if (p >= 80 && p < 82) {
            grade = "2.50";
        } else if (p >= 77 && p < 80) {
            grade = "2.75";
        } else if (p >= 75 && p < 77) {
            grade = "3.00";
        } else {
            grade = "Out-of-Range";
        }
        System.out.println("Grade equivalent: " + grade);
    }

    static void squaresTable() {
        System.out.println("Solution 1 - for loop");
        System.out.println("Sequence nos.\tSquared");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "\t\t" + (i * i));
        }

        System.out.println("\nSolution 2 - while loop");
        System.out.println("Sequence nos.\tSquared");
        int n = 1;
        while (n <= 5) {
            System.out.println(n + "\t\t" + (n * n));
            n++;
        }

        System.out.println("\nSolution 3 - do while loop");
        System.out.println("Sequence nos.\tSquared");
        int k = 1;
        do {
            System.out.println(k + "\t\t" + (k * k));
            k++;
        } while (k <= 5);
    }

    static void pairedSequence() {
        System.out.print("Solution 1 - for:      ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + ", " + (6 - i));
            if (i < 5) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Solution 2 - while:    ");
        int n = 1;
        while (n <= 5) {
            System.out.print(n + ", " + (6 - n));
            if (n < 5) {
                System.out.print(", ");
            }
            n++;
        }
        System.out.println();

        System.out.print("Solution 3 - do while: ");
        int k = 1;
        do {
            System.out.print(k + ", " + (6 - k));
            if (k < 5) {
                System.out.print(", ");
            }
            k++;
        } while (k <= 5);
        System.out.println();
    }

    static void reversePairedSequence() {
        System.out.print("Solution 1 - for:      ");
        for (int i = 1; i <= 5; i++) {
            System.out.print((6 - i) + ", " + i);
            if (i < 5) {
                System.out.print(", ");
            }
        }
        System.out.println();

        System.out.print("Solution 2 - while:    ");
        int n = 1;
        while (n <= 5) {
            System.out.print((6 - n) + ", " + n);
            if (n < 5) {
                System.out.print(", ");
            }
            n++;
        }
        System.out.println();

        System.out.print("Solution 3 - do while: ");
        int k = 1;
        do {
            System.out.print((6 - k) + ", " + k);
            if (k < 5) {
                System.out.print(", ");
            }
            k++;
        } while (k <= 5);
        System.out.println();
    }

    static void factorialValues() {
        int n = getNumberBetween("Enter a no.: ", 0, 20);

        long r1 = 1;
        for (int i = 1; i <= n; i++) {
            r1 *= i;
        }

        long r2 = 1;
        int j = 1;
        while (j <= n) {
            r2 *= j;
            j++;
        }

        long r3 = 1;
        int k = 1;
        do {
            r3 *= k;
            k++;
        } while (k <= n);

        System.out.println("Solution 1 - for:      Factorial value: " + r1);
        System.out.println("Solution 2 - while:    Factorial value: " + r2);
        System.out.println("Solution 3 - do while: Factorial value: " + r3);

        StringBuilder expr = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            expr.append("*").append(i);
        }
        System.out.println("(The computation is: " + expr + "=" + r1 + ")");
    }

    static void fibonacciSeries() {
        int n = getNumberBetween("Enter a no.: ", 1, 90);

        System.out.print("Solution 1 - for:      ");
        long a = 1, b = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
        }
        System.out.println();

        System.out.print("Solution 2 - while:    ");
        a = 1;
        b = 1;
        int j = 1;
        while (j <= n) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            j++;
        }
        System.out.println();

        System.out.print("Solution 3 - do while: ");
        a = 1;
        b = 1;
        int k = 1;
        do {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
            k++;
        } while (k <= n);
        System.out.println();
    }

    static void powerValues() {
        int base = getWholeNumber("Enter base no.: ");
        int exp = getNumberBetween("Enter exponent no.: ", 0, 62);
        if (Math.pow(Math.abs((double) base), exp) > 9.0e18) {
            System.out.println("Result is too large to compute.");
            return;
        }

        long r1 = 1;
        for (int i = 1; i <= exp; i++) {
            r1 *= base;
        }

        long r2 = 1;
        int j = 1;
        while (j <= exp) {
            r2 *= base;
            j++;
        }

        long r3 = 1;
        int k = 1;
        if (exp > 0) {
            do {
                r3 *= base;
                k++;
            } while (k <= exp);
        }

        System.out.println("Solution 1 - for:      Power value: " + r1);
        System.out.println("Solution 2 - while:    Power value: " + r2);
        System.out.println("Solution 3 - do while: Power value: " + r3);

        StringBuilder expr = new StringBuilder();
        if (exp == 0) {
            expr.append("1");
        } else {
            for (int i = 1; i <= exp; i++) {
                expr.append(base);
                if (i < exp) {
                    expr.append(" * ");
                }
            }
        }
        System.out.println("(The computation is: " + base + "^" + exp + " = " + expr + " = " + r1 + ")");
    }

    static void sumOfSquares() {
        int n = getNumberBetween("Enter n: ", 1, 1000000);

        long s1 = 0;
        for (int i = 1; i <= n; i++) {
            s1 += (long) i * i;
        }

        long s2 = 0;
        int j = 1;
        while (j <= n) {
            s2 += (long) j * j;
            j++;
        }

        long s3 = 0;
        int k = 1;
        do {
            s3 += (long) k * k;
            k++;
        } while (k <= n);

        System.out.println("Solution 1 - for:      " + s1);
        System.out.println("Solution 2 - while:    " + s2);
        System.out.println("Solution 3 - do while: " + s3);
    }

    static void sumFromOne() {
        int n = getNumberBetween("Enter n: ", 1, 1000000);

        long s1 = 0;
        for (int i = 1; i <= n; i++) {
            s1 += i;
        }

        long s2 = 0;
        int j = 1;
        while (j <= n) {
            s2 += j;
            j++;
        }

        long s3 = 0;
        int k = 1;
        do {
            s3 += k;
            k++;
        } while (k <= n);

        System.out.println("Solution 1 - for:      " + s1);
        System.out.println("Solution 2 - while:    " + s2);
        System.out.println("Solution 3 - do while: " + s3);
    }

    static void reverseNumber() {
        long original = getNumberBetween("Enter a number: ", 0, Integer.MAX_VALUE);

        long n = original;
        long r1 = 0;
        for (; n > 0; n /= 10) {
            r1 = r1 * 10 + n % 10;
        }

        n = original;
        long r2 = 0;
        while (n > 0) {
            r2 = r2 * 10 + n % 10;
            n /= 10;
        }

        n = original;
        long r3 = 0;
        do {
            r3 = r3 * 10 + n % 10;
            n /= 10;
        } while (n > 0);

        System.out.println("Solution 1 - for:      Reverse number: " + r1);
        System.out.println("Solution 2 - while:    Reverse number: " + r2);
        System.out.println("Solution 3 - do while: Reverse number: " + r3);
    }

    static long calculatePower(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    static void sumOfPowers() {
        int n = getNumberBetween("Enter n (1-15): ", 1, 15);

        long s1 = 0;
        for (int i = 1; i <= n; i++) {
            s1 += calculatePower(i, i);
        }

        long s2 = 0;
        int j = 1;
        while (j <= n) {
            s2 += calculatePower(j, j);
            j++;
        }

        long s3 = 0;
        int k = 1;
        do {
            s3 += calculatePower(k, k);
            k++;
        } while (k <= n);

        System.out.println("Solution 1 - for:      " + s1);
        System.out.println("Solution 2 - while:    " + s2);
        System.out.println("Solution 3 - do while: " + s3);
    }

    static void starTriangle() {
        int n = getRowCount();
        for (int i = 1; i <= n; i++) {
            System.out.println(repeatText("* ", i));
        }
    }

    static void binaryTriangle() {
        int n = getRowCount();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(((i + j) % 2 == 0 ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    static void printStarRow(int n, int i) {
        System.out.println(repeatText(" ", 2 * (n - i)) + repeatText("* ", 2 * i - 1));
    }

    static void oddStarPyramid() {
        int n = getRowCount();
        for (int i = 1; i <= n; i++) {
            printStarRow(n, i);
        }
    }

    static void repeatedNumberPyramid() {
        int n = getRowCount();
        for (int i = 1; i <= n; i++) {
            System.out.println(repeatText(" ", n - i) + repeatText(i + " ", i));
        }
    }

    static void starPyramid() {
        int n = getRowCount();
        for (int i = 1; i <= n; i++) {
            System.out.println(repeatText(" ", n - i) + repeatText("* ", i));
        }
    }

    static void countingNumberPyramid() {
        int n = getRowCount();
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            StringBuilder line = new StringBuilder(repeatText(" ", n - i));
            for (int j = 1; j <= i; j++) {
                line.append(counter++).append(" ");
            }
            System.out.println(line);
        }
    }

    static void countingNumberTriangle() {
        int n = getRowCount();
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter++ + " ");
            }
            System.out.println();
        }
    }

    static void repeatedNumberTriangle() {
        int n = getRowCount();
        for (int i = 1; i <= n; i++) {
            System.out.println(repeatText(i + " ", i));
        }
    }

    static void ascendingNumberTriangle() {
        int n = getRowCount();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void diamondPattern() {
        int n = getNumberBetween("Number of rows (half of the diamond): ", 1, 30);
        for (int i = 1; i <= n; i++) {
            printStarRow(n, i);
        }
        for (int i = n - 1; i >= 1; i--) {
            printStarRow(n, i);
        }
    }

    static void numberMirrorPyramid() {
        int n = getNumberBetween("Number of rows (1-9 looks best): ", 1, 30);
        for (int i = 1; i <= n; i++) {
            StringBuilder line = new StringBuilder(repeatText(" ", 2 * (n - i)));
            for (int j = 1; j <= i; j++) {
                line.append(j).append(" ");
            }
            for (int j = i - 1; j >= 1; j--) {
                line.append(j).append(" ");
            }
            System.out.println(line);
        }
    }
}
