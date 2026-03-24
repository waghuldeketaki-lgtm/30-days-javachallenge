import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Calculator ===");

        System.out.print("Enter first number: ");
        double a = sc.nextDouble();

        System.out.print("Enter second number: ");
        double b = sc.nextDouble();

        System.out.println("Choose operation (+, -, *, /): ");
        char op = sc.next().charAt(0);

        double result;

        if (op == '+') {
            result = a + b;
            System.out.println("Result = " + result);

        } else if (op == '-') {
            result = a - b;
            System.out.println("Result = " + result);

        } else if (op == '*') {
            result = a * b;
            System.out.println("Result = " + result);

        } else if (op == '/') {
            if (b != 0) {
                result = a / b;
                System.out.println("Result = " + result);
            } else {
                System.out.println("Cannot divide by zero");
            }

        } else {
            System.out.println("Invalid operator");
        }

        sc.close();
    }
}