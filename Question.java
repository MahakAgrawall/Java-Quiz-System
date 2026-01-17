import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private String correctAnswer;
    private String difficultyLevel;
    private String subject;

    public Question(String questionText, List<String> options, 
                   String correctAnswer, String difficultyLevel, String subject) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.difficultyLevel = difficultyLevel;
        this.subject = subject;
    }

    public void displayQuestion() {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(int userChoice) {
        return options.get(userChoice - 1).equals(correctAnswer);
    }

    // Getters
    public String getDifficultyLevel() { return difficultyLevel; }
    public String getSubject() { return subject; }
    public List<String> getOptions() { return options; }
}