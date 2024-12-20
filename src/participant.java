import java.util.Scanner;

public class participant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] questions = {
                "What is the capital of America?",
                "Which planet is known as the Red Planet?",
                "What is the square root of 24?",
                "What is the king of fruits? ",
                "what is the capital of Andhra pradesh?",
        };

        String[][] options = {
                {"1. Washington Dc", "2. Madrid", "3. Paris", "4. Rome"},
                {"1. Earth", "2. Mars", "3. Jupiter", "4. Venus"},
                {"1. 6", "2. 7", "3. 8", "4. 9"},
                {"1.Apple","2.kiwi","3.mango","4.pineapple"},
                {"1.kolkatha","2.bombay","3.goa","4.Amaravathi"},
        };

        int[] correctAnswers = {1, 2, 3,3,4}; 
        boolean usedLifeline = false;
        // Display quiz rules
        System.out.println("\n--- Quiz Rules ---");
        System.out.println("1. You will be asked a series of questions.");
        System.out.println("2. Each question has 4 options. Choose wisely.");
        System.out.println("3. You have 2 lifelines: 50-50 and Phone a Friend.");
        System.out.println("4. You can use each lifeline only once.");
        System.out.println("5. If you give a wrong answer, you lose and will be awarded the amount you won.");
        System.out.println("Welcome to the Quiz Game!");
        System.out.println("Let's get started!");

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions[i]);
            for (String option : options[i]) {
                System.out.println(option);
            }
            
            System.out.print("Enter your answer (or type 'L' to use lifeline): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("L")) {
                if (usedLifeline) {
                    System.out.println("You have already used the lifeline!");
                } else {
                    usedLifeline = true;
                    System.out.println("Lifeline activated! Two incorrect options are removed.");
                    int correctOption = correctAnswers[i];
                    for (int j = 0; j < options[i].length; j++) {
                        if (j + 2 == correctOption || Math.random() > 0.5) {
                            System.out.println(options[i][j]);
                        }
                    }
                }
                int nextRewardAmount = 2000;

                System.out.println("use Audience pole");
                System.out.print("Enter your answer (or type 'P' to use Audience pole): ");
                String Input = scanner.next();
                if (input.equalsIgnoreCase("p")) { 
                	
                        System.out.println("You have already used the Audience pole");
                    } else {
                        boolean pole = true;
                        System.out.println("Audience pole is Activated for only one  time ");
                        int correctOption = correctAnswers[i];
                        for (int j = 0; j < options[i].length; j++) {
                            if (j + 1 == correctOption || Math.random() > 0.5) {
                                System.out.println(options[i][j]);
                            }
                        }
                    }
               
                
                System.out.print("Enter your answer: ");
                input = scanner.next();
            }

            int answer = Integer.parseInt(input);
            if (answer == correctAnswers[i]) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong! The correct answer was: " + options[i][correctAnswers[i] - 1]);
            }
        }

        System.out.println("\nQuiz over! Thanks for playing.");
        scanner.close();
    }
}

	

