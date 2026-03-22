import java.util.Scanner;

/**
 * Program to calculate factorial using loop
 * Author: Ketaki Waghulde
 */
public class FactorialLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = calculateFactorial(num);
            System.out.println("Factorial of " + num + " is: " + result);
        }

        sc.close();
    }

    // Method to calculate factorial using loop
    public static long calculateFactorial(int n) {
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}