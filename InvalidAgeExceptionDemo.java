// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Main Class
public class InvalidAgeExceptionDemo {

    // Method to check age
    static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("❌ Age must be 18 or above!");
        } else {
            System.out.println("✅ Eligible to vote!");
        }
    }

    public static void main(String[] args) {
        int age = 16; // Change value to test

        try {
            checkAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("Program Ended...");
    }
}
