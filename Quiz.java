import java.util.List;
import java.util.Scanner;

public class Quiz {
    private String subject;
    private String difficultyLevel;
    private List<Question> questions;
    private int timeLimit; // in seconds
    private int score;
    private Scanner scanner;

    public Quiz(String subject, String difficultyLevel, 
               List<Question> questions, int timeLimit) {
        this.subject = subject;
        this.difficultyLevel = difficultyLevel;
        this.questions = questions;
        this.timeLimit = timeLimit;
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        System.out.println("\nStarting " + subject + " quiz (" + difficultyLevel + " level)");
        System.out.println("You have " + timeLimit/60 + " minutes to complete the quiz.");
        
        long startTime = System.currentTimeMillis();
        score = 0;
        
        for (Question question : questions) {
            if (isTimeUp(startTime)) {
                System.out.println("\nTime's up! Quiz automatically submitted.");
                break;
            }
            
            question.displayQuestion();
            if (getUserAnswer(question)) {
                score++;
            }
        }
        
        displayResult();
    }

    private boolean isTimeUp(long startTime) {
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        return elapsedTime >= timeLimit;
    }

    private boolean getUserAnswer(Question question) {
        System.out.print("Your answer (1-" + question.getOptions().size() + "): ");
        try {
            int userChoice = scanner.nextInt();
            if (userChoice < 1 || userChoice > question.getOptions().size()) {
                System.out.println("Invalid choice. Please try again.");
                return getUserAnswer(question);
            }
            return question.checkAnswer(userChoice);
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            System.out.println("Please enter a valid number.");
            return getUserAnswer(question);
        }
    }

    private void displayResult() {
        System.out.println("\nQuiz completed! Your score: " + score + "/" + questions.size());
    }
}