import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        //Player has an option to play again
        boolean playAgain = true;

        //Keeping track of rounds and total score
        int roundNumber = 0;
        int totalScore = 0;

        while (playAgain) {

        roundNumber++;

            //setting the max number of guesses allowed and keeping track of many guesses the player has made
            int maxNumber;
            int maxAttempts;
            int attempts = 0;
            boolean won = false;
            String difficultyName = "";
            int baseScore;


            System.out.println("\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2");
            System.out.println("     NUMBER GUESSING GAME");
            System.out.println("\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2\uD83C\uDFB2");
            System.out.println();
            System.out.println("      CHOOSE YOUR DIFFICULTY: ");

            System.out.println("1. Easy Mode \uD83C\uDF88");
            System.out.println("2. Medium Mode  ⚖\uFE0F ");
            System.out.println("3. Hard Mode \uD83C\uDF36\uFE0F");
            System.out.println("Enter Your Choice: ");

            int difficulty = scanner.nextInt();

            //Choice of each level of mode
            switch (difficulty) {
                case 1:
                    maxNumber = 50;
                    maxAttempts = 15;
                    difficultyName = "Easy";
                    baseScore = 100;
                    break;
                case 2:
                    maxNumber = 100;
                    maxAttempts = 10;
                    difficultyName = "Medium";
                    baseScore = 200;
                    break;
                case 3:
                    maxNumber = 200;
                    maxAttempts = 7;
                    difficultyName = "Hard";
                    baseScore = 300;
                    break;

                default:
                    System.out.println("Invalid choice. Medium difficulty selected.");
                    maxNumber = 100;
                    maxAttempts = 10;
                    difficultyName = "Medium";
                    baseScore = 200;

            }
            //producing a random number between 1 -100
            int secretNumber = random.nextInt(maxNumber) + 1;

            //Telling the player about the game
            System.out.println();
            System.out.println("\uD83C\uDFAE══════════════════════════════════\uD83C\uDFAE");
            System.out.println("           GAME STARTED!!!\uD83C\uDFC1");
            System.out.println("\uD83C\uDFAE══════════════════════════════════\uD83C\uDFAE");
            System.out.println();
            System.out.println("Round: "+roundNumber);
            System.out.println("Difficulty : " + difficultyName);
            System.out.println("I'm thinking of a number between 1 and " +maxNumber + ".");
            System.out.println("You have " +maxAttempts+ " attempts.");

            //Continuing the game while player has attempts left
            while (attempts < maxAttempts) {
                System.out.println();
                System.out.println("Enter your guess\uD83C\uDFAF: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("INVALID INPUT ❌ ");
                    System.out.println("Please enter a whole number between 1 and " +maxNumber+ ".");
                    scanner.next();
                    continue;
                }

                //Players should only guess between set numbers
                int guess = scanner.nextInt();

                if (guess < 1 || guess > maxNumber) {
                    System.out.println("Please enter a number between 1 and " +maxNumber);
                    continue;
                }
                attempts++;

                //Comparing the players guess with secret number
                if (guess > secretNumber) {
                    System.out.println("Too High!");
                } else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Correct!!!");
                    won = true;
                    break;
                }

                //Showing number of attempts used and remaining
                System.out.println("Attempts used\uD83D\uDD0B: " +attempts+ "/" + maxAttempts);
                System.out.println("Attempts remaining⏳: " + (maxAttempts - attempts));
                System.out.println();
            }

            if (won) {

                int score = baseScore + ((maxAttempts - attempts) * 10);
            totalScore +=score;

                //Deciding the rating
                String rating;

                if (score >= 350) {
                    rating = " AMAZING!!!\uD83C\uDFC6";
                }
                else if (score >=250) {
                    rating = "EXCELENT!!\uD83D\uDD25";
                }
                else if (score >=150){
                    rating = "GOOD JOB!⭐";
                }
                else{
                    rating = "KEEP TRYING!\uD83D\uDC4D";
                }


                //Deciding the attempt or attempts state
                String attemptText;

                if (attempts ==1) {
                    attemptText = "attempt";
                }
                else {
                    attemptText = "attempts";
                }

                System.out.println();
                System.out.println("\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
                System.out.println("  CONGRATULATIONS!!! YOU WON!!!\uD83C\uDFC6");
                System.out.println("\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89\uD83C\uDF89");
                System.out.println("You won in " +attempts+ " " +attemptText+ "!");
                System.out.println("Round " +roundNumber+ "- guessed in " +attempts+ " " +attemptText+ "\uD83D\uDCCB");
                System.out.println(" Your score: " +score+ "points!!!\uD83C\uDF89");
                System.out.println();
                System.out.println("Performance: "+rating);

                System.out.println("Total Score: " + totalScore+ "points\uD83D\uDCB0 ");

            } else {
                System.out.println("\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80");
                System.out.println("    YOU LOST!");
                System.out.println("\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80\uD83D\uDC80");
                System.out.println("The number was: " + secretNumber);
                System.out.println("You guessed it in " +attempts+ " attempts!\uD83D\uDCCA");
                System.out.println("Score earned: 0 points.");



            }
            System.out.println();
            System.out.println("Would you like to play again? (yes✅/no ❌): ");

            String answer = scanner.next();

            if(answer.equalsIgnoreCase("no")) {
                playAgain = false;
            }
            System.out.println("Thank you for playing!\uD83D\uDE0A\uD83D\uDE0A\uD83D\uDE0A");
        }
    }
}