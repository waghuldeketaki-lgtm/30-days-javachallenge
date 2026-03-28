import java.util.Scanner;

public class Day11_Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int original = num;
        int result = 0;
        int digits = 0;

        // count digits
        int temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        // calculate Armstrong sum
        temp = num;
        while (temp != 0) {
            int digit = temp % 10;
            result += Math.pow(digit, digits);
            temp /= 10;
        }

        if (result == original) {
            System.out.println(original + " is an Armstrong Number");
        } else {
            System.out.println(original + " is NOT an Armstrong Number");
        }

        sc.close();
    }
}