import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Day16FileHandling {
    public static void main(String[] args) {

        try {
            // 1. Create File
            File file = new File("sample.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            // 2. Write to File
            FileWriter writer = new FileWriter("sample.txt");
            writer.write("Hello, this is Day 16 of Java Challenge!\n");
            writer.write("Learning File Handling in Java.");
            writer.close();
            System.out.println("Data written to file.");

            // 3. Read from File
            FileReader reader = new FileReader("sample.txt");
            int ch;

            System.out.println("\nReading file content:");
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}