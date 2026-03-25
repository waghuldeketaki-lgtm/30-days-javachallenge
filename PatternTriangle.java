public class PatternTriangle {
    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {     // rows
            for (int j = 1; j <= i; j++) { // columns
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}