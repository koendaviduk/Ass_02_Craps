import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        do {
            int sum = rollDice(random);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("You crapped out with a sum of " + sum);
            } else if (sum == 7 || sum == 11) {
                System.out.println("You won with a natural roll of " + sum);
            } else {
                System.out.println("The point is now " + sum);
                int point = sum;
                boolean continueRolling = true;

                while (continueRolling) {
                    int nextSum = rollDice(random);
                    System.out.println("Rolling... " + nextSum);

                    if (nextSum == 7) {
                        System.out.println("You got a seven and lost.");
                        break;
                    } else if (nextSum == point) {
                        System.out.println("You made the point and won!");
                        break;
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));
    }

    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("You rolled " + die1 + " and " + die2 + " - Total: " + sum);
        return sum;
    }
}


