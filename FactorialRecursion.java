import java.util.Scanner;

/**
 * Program to calculate factorial using recursion
 * Author: Ketaki Waghulde
 */
public class FactorialRecursion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(num);
            System.out.println("Factorial of " + num + " is: " + result);
        }

        sc.close();
    }

    // Recursive method
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}