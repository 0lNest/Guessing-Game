
import java.util.Random;
import java.util.Scanner;
public class ONTypeGuessingGame {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Random random = new Random();
int totalGames = 0;
int totalWins = 0;
int totalLosses = 0;
int bestScore = Integer.MAX_VALUE;
int maxAttempts = 10; // Maximum number of attempts allowed per game
System.out.println("Welcome to the Number Guessing Game!");
while (true) {
introduceGame();
boolean hasWon = playGame(random, maxAttempts, scanner);
if (hasWon) {
totalWins++;
} else {
totalLosses++;
}
totalGames++;
if (maxAttempts < bestScore) {
bestScore = maxAttempts;
}
System.out.println("Do you want to play another game? (yes/no)");
String playAgain = scanner.nextLine().toLowerCase();
if (!playAgain.equals("yes")) {
break;
}
}
reportResults(totalGames, totalWins, totalLosses, bestScore);
System.out.println("Thank you for playing!");
scanner.close();
}
private static void introduceGame() {
System.out.println("I'm thinking of a number between 0 and 100. Can you
guess it?");
System.out.println("You have a maximum of 10 attempts.");
}
private static boolean playGame(Random random, int maxAttempts, Scanner
scanner) {
int lowerBound = 0;
int upperBound = 100;
int randomNumber = random.nextInt(upperBound - lowerBound + 1) +
lowerBound;
for (int attempts = 1; attempts <= maxAttempts; attempts++) {
System.out.print("Enter your guess: ");
int userGuess = scanner.nextInt();
scanner.nextLine(); // Consume the newline character.
if (userGuess < randomNumber) {
System.out.println("Higher! Try again.");
} else if (userGuess > randomNumber) {
System.out.println("Lower! Try again.");
} else {
System.out.println("Congratulations! You've guessed the number " +
randomNumber + " in " + attempts + " attempts.");
drawTrophy();
return true;
}
}
System.out.println("Sorry, you've run out of attempts. The number was " +
randomNumber + ". You lose this game.");
return false;
}
private static void reportResults(int totalGames, int totalWins, int
totalLosses, int bestScore) {
System.out.println("Session Summary:");
System.out.println("Total games played: " + totalGames);
System.out.println("Total wins: " + totalWins);
System.out.println("Total losses: " + totalLosses);
System.out.println("Best score (least attempts) in this session: " +
(bestScore == Integer.MAX_VALUE ? "N/A" : bestScore));
}
private static void drawTrophy() {
System.out.println("You win a trophy!");
System.out.println(" ___________");
System.out.println(" '._==_==_==_.'");
System.out.println(" .-\\: /-.");
System.out.println(" | (|:. |) |");
System.out.println(" '-|:. |-'");
System.out.println(" \\::. /");
System.out.println(" '::. .'");
System.out.println(" ) (");
System.out.println(" _.' '._");
System.out.println(" `\"\"\"\"\"\"`");
System.out.println();
}
}
