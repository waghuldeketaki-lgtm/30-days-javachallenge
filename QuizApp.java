import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    // Constructor
    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Display question
    void display() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // Check answer
    boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Questions
        Question[] quiz = {
            new Question("What is Java?",
                new String[]{"Programming Language", "Car", "Animal", "Game"}, 1),

            new Question("Which keyword is used for inheritance?",
                new String[]{"this", "super", "extends", "implements"}, 3),

            new Question("Which is not a data type?",
                new String[]{"int", "float", "boolean", "string"}, 4)
        };

        int score = 0