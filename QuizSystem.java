import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizSystem {
    private List<User> users;
    private User currentUser;
    private List<Question> questions;
    private Scanner scanner;

    public QuizSystem() {
        this.users = new ArrayList<>();
        this.questions = loadQuestions();
        this.scanner = new Scanner(System.in);
    }

    private List<Question> loadQuestions() {
        List<Question> questions = new ArrayList<>();
        
        // Math questions
        questions.add(new Question("What is the square of 3?", Arrays.asList("6", "9", "3", "12"), "9", "beginner", "Math"));
        questions.add(new Question("What is 100 divided by 10?", Arrays.asList("10", "5", "20", "50"), "10", "beginner", "Math"));
        questions.add(new Question("What is 7 × 6?", Arrays.asList("42", "36", "48", "40"), "42", "beginner", "Math"));
        questions.add(new Question("What is 2+2?", Arrays.asList("3", "4", "5", "6"), "4", "beginner", "Math"));
        questions.add(new Question("Solve for x: 2x = 10", Arrays.asList("5", "8", "10", "12"), "5", "beginner", "Math"));
        questions.add(new Question("What is 15% of 200?", Arrays.asList("15", "20", "30", "45"), "30", "intermediate", "Math"));
        questions.add(new Question("What is the derivative of x²?", Arrays.asList("x", "2x", "2", "x³/3"), "2x", "intermediate", "Math"));
        questions.add(new Question("What is the result of 2^3 * 3?", Arrays.asList("18", "24", "36", "48"), "24", "intermediate", "Math"));
        questions.add(new Question("What is (5² - 3²)?", Arrays.asList("16", "20", "10", "8"), "16", "intermediate", "Math"));
        questions.add(new Question("What is the cube root of 27?", Arrays.asList("3", "6", "9", "4"), "3", "intermediate", "Math"));
        questions.add(new Question("What is the integral of 1/x?", Arrays.asList("ln(x)", "x²", "1/x²", "eˣ"), "ln(x)", "advanced", "Math"));
        questions.add(new Question("what is root of 169 ?", Arrays.asList("12", "18", "13", "none"), "13", "advanced", "Math"));
        questions.add(new Question("What is the derivative of sin(x)?", Arrays.asList("cos(x)", "-sin(x)", "-cos(x)", "tan(x)"), "cos(x)", "advanced", "Math"));
        questions.add(new Question("What is the integral of cos(x)?", Arrays.asList("sin(x)", "-cos(x)", "cos(x)", "-sin(x)"), "sin(x)", "advanced", "Math"));
        questions.add(new Question("If f(x) = x³, what is f''(x)?", Arrays.asList("6x", "3x²", "2x", "3x"), "6x", "advanced", "Math"));
        
        // Science questions
        questions.add(new Question("What is the chemical symbol for water?", Arrays.asList("H2O", "CO2", "NaCl", "O2"), "H2O", "beginner", "Science"));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("Venus", "Mars", "Jupiter", "Saturn"), "Mars", "beginner", "Science"));
        questions.add(new Question("What gas do plants absorb from the atmosphere?", Arrays.asList("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"), "Carbon Dioxide", "beginner", "Science"));
        questions.add(new Question("How many legs does an insect have?", Arrays.asList("4", "6", "8", "10"), "6", "beginner", "Science"));
        questions.add(new Question("What part of the plant conducts photosynthesis?", Arrays.asList("Root", "Leaf", "Stem", "Flower"), "Leaf", "beginner", "Science"));

        questions.add(new Question("What is the pH value of pure water?", Arrays.asList("5", "7", "8", "10"), "7", "intermediate", "Science"));
        questions.add(new Question("Which gas is most abundant in Earth's atmosphere?", Arrays.asList("Oxygen", "Carbon dioxide", "Nitrogen", "Hydrogen"), "Nitrogen", "intermediate", "Science"));
         questions.add(new Question("What is the chemical formula for table salt?", Arrays.asList("NaCl", "KCl", "H2SO4", "NaOH"), "NaCl", "intermediate", "Science"));
         questions.add(new Question("Which organ in the human body produces insulin?", Arrays.asList("Liver", "Pancreas", "Kidney", "Heart"), "Pancreas", "intermediate", "Science"));
         questions.add(new Question("What type of energy is stored in food?", Arrays.asList("Kinetic", "Thermal", "Chemical", "Electrical"), "Chemical", "intermediate", "Science"));
  
        questions.add(new Question("What is the speed of light in vacuum?", Arrays.asList("300,000 km/s", "150,000 km/s", "500,000 km/s", "1,000,000 km/s"), "300,000 km/s", "advanced", "Science"));
        questions.add(new Question("What is Newton's Second Law of Motion?", Arrays.asList("F = ma", "E = mc²", "F = mv", "V = IR"), "F = ma", "advanced", "Science"));
        questions.add(new Question("Which subatomic particle determines the atomic number of an element?", Arrays.asList("Electron", "Neutron", "Proton", "Quark"), "Proton", "advanced", "Science"));
        questions.add(new Question("What is the unit of electrical resistance?", Arrays.asList("Ampere", "Volt", "Ohm", "Watt"), "Ohm", "advanced", "Science"));

        // History questions
        questions.add(new Question("In which year did World War II end?", Arrays.asList("1943", "1945", "1950", "1939"), "1945", "beginner", "History"));
        questions.add(new Question("Who was the first president of the United States?", Arrays.asList("Thomas Jefferson", "John Adams", "George Washington", "Abraham Lincoln"), "George Washington", "beginner", "History"));
         questions.add(new Question("Who discovered America in 1492?", Arrays.asList("Vasco da Gama", "Christopher Columbus", "Ferdinand Magellan", "Marco Polo"), "Christopher Columbus", "beginner", "History"));
        questions.add(new Question("What structure is the Great Wall located in?", Arrays.asList("India", "Japan", "China", "Egypt"), "China", "beginner", "History"));
        questions.add(new Question("Who was known as the 'Father of India'?", Arrays.asList("Jawaharlal Nehru", "B. R. Ambedkar", "Mahatma Gandhi", "Subhash Chandra Bose"), "Mahatma Gandhi", "beginner", "History"));
        questions.add(new Question("The Industrial Revolution began in which country?", Arrays.asList("France", "Germany", "United States", "Great Britain"), "Great Britain", "intermediate", "History"));
        questions.add(new Question("Which ancient civilization built the pyramids?", Arrays.asList("Greeks", "Romans", "Egyptians", "Mayans"), "Egyptians", "intermediate", "History"));
        questions.add(new Question("Who was the British Prime Minister during most of World War II?", Arrays.asList("Neville Chamberlain", "Winston Churchill", "Clement Attlee", "Tony Blair"), "Winston Churchill", "intermediate", "History"));
       questions.add(new Question("Which empire was ruled by Julius Caesar?", Arrays.asList("Greek", "Roman", "Ottoman", "Byzantine"), "Roman", "intermediate", "History"));
       questions.add(new Question("The Cold War was primarily between which two nations?", Arrays.asList("USA and China", "USA and USSR", "USA and Germany", "USA and Japan"), "USA and USSR", "intermediate", "History"));
       questions.add(new Question("The Treaty of Versailles was signed in which year?", Arrays.asList("1918", "1919", "1920", "1921"), "1919", "advanced", "History"));
       questions.add(new Question("When was the United Nations founded?", Arrays.asList("1919", "1945", "1950", "1939"), "1945", "advanced", "History"));
       questions.add(new Question("Who led the Soviet Union during the Cuban Missile Crisis?", Arrays.asList("Joseph Stalin", "Nikita Khrushchev", "Leonid Brezhnev", "Mikhail Gorbachev"), "Nikita Khrushchev", "advanced", "History"));
questions.add(new Question("What major event started on October 29, 1929?", Arrays.asList("World War I", "World War II", "The Great Depression", "The Cold War"), "The Great Depression", "advanced", "History"));

        return questions;
    }

    private List<Question> getQuestionsBySubjectAndLevel(String subject, String level) {
        List<Question> filteredQuestions = new ArrayList<>();
        for (Question q : questions) {
            if (q.getSubject().equals(subject) && q.getDifficultyLevel().equals(level)) {
                filteredQuestions.add(q);
            }
        }
        return filteredQuestions;
    }

    public void run() {
        while (true) {
            System.out.println("\n===== Online Quiz System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Take a Quiz");
            System.out.println("4. View Quiz History");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    startQuiz();
                    break;
                case 4:
                    viewHistory();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        if (findUser(username) != null) {
            System.out.println("Username already exists!");
            return;
        }
        
        User newUser = new User(username);
        users.add(newUser);
        currentUser = newUser;
        System.out.println("Registration successful!");
    }

    private void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        
        User user = findUser(username);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        
        currentUser = user;
        System.out.println("Login successful! Welcome, " + username + "!");
    }

    private User findUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private void startQuiz() {
        if (currentUser == null) {
            System.out.println("Please login first!");
            return;
        }
        
        System.out.println("\nAvailable Subjects:");
        System.out.println("1. Math");
        System.out.println("2. Science");
        System.out.println("3. History");
        
        System.out.print("Select a subject (1-3): ");
        int subjectChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (subjectChoice < 1 || subjectChoice > 3) {
            System.out.println("Invalid choice!");
            return;
        }
        
        String[] subjects = {"Math", "Science", "History"};
        String subject = subjects[subjectChoice - 1];
        
        System.out.println("\nSelect Difficulty Level:");
        System.out.println("1. Beginner");
        System.out.println("2. Intermediate");
        System.out.println("3. Advanced");
        
        System.out.print("Select level (1-3): ");
        int levelChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (levelChoice < 1 || levelChoice > 3) {
            System.out.println("Invalid choice!");
            return;
        }
        
        String[] levels = {"beginner", "intermediate", "advanced"};
        String level = levels[levelChoice - 1];
        
        List<Question> quizQuestions = getQuestionsBySubjectAndLevel(subject, level);
        if (quizQuestions.isEmpty()) {
            System.out.println("No questions available for this selection!");
            return;
        }
        
        // Set time limits (in seconds)
        int timeLimit = switch (level) {
            case "beginner" -> 300;    // 5 minutes
            case "intermediate" -> 240; // 4 minutes
            case "advanced" -> 180;    // 3 minutes
            default -> 300;
        };
        
        Quiz quiz = new Quiz(subject, level, quizQuestions, timeLimit);
        quiz.startQuiz();
        
        // Save result to user history
        currentUser.addQuizResult(subject, level, quizQuestions.size(), quizQuestions.size());
    }

    private void viewHistory() {
        if (currentUser == null) {
            System.out.println("Please login first!");
            return;
        }
        
        currentUser.displayHistory();
    }

    public static void main(String[] args) {
        QuizSystem system = new QuizSystem();
        system.run();
    }
}