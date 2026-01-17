import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private List<Map<String, String>> quizHistory;

    public User(String username) {
        this.username = username;
        this.quizHistory = new ArrayList<>();
    }

    public void addQuizResult(String subject, String level, int score, int totalQuestions) {
        Map<String, String> result = new HashMap<>();
        result.put("subject", subject);
        result.put("level", level);
        result.put("score", String.valueOf(score));
        result.put("total", String.valueOf(totalQuestions));
        quizHistory.add(result);
    }

    public void displayHistory() {
        if (quizHistory.isEmpty()) {
            System.out.println("No quiz history available.");
            return;
        }
        
        System.out.println("\n=== " + username + "'s Quiz History ===");
        for (Map<String, String> result : quizHistory) {
            System.out.println(result.get("subject") + " (" + result.get("level") + "): " + 
                               result.get("score") + "/" + result.get("total"));
        }
    }

    public String getUsername() { return username; }
}