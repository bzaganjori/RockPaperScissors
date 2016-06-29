import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    
    static int compWins = 0;
    static int playerWins = 0;
    
    private static int generateTurn() {
        return new Random().nextInt(3 - 1 + 1) + 1;
    }
    
    private static void wins() {
        System.out.println("Comp: " + compWins + "|| Player: " + playerWins);
    }
    
    private static void compare(int user) {
        int comp = generateTurn();
        
        if (comp == user)
            System.out.println("Tie.");
        else if (comp == 2 && user == 1) {
            System.out.println("Computer wins with paper.");
            compWins++;
        } else if (comp == 3 && user == 2) {
            System.out.println("Computer wins with scissors.");
            compWins++;
        } else if (comp == 1 && user == 3) {
            System.out.println("Computer wins with rock.");
            compWins++;
        } else if (comp == 1) {
            System.out.println("Computer loses with rock.");
            playerWins++;
        } else if (comp == 2) {
            System.out.println("Computer loses with paper.");
            playerWins++;
        } else if (comp == 3) {
            System.out.println("Computer loses with scissors.");
            playerWins++;
        }
    }
    
    private static boolean checkInput(int number) {
        if (number < 0 || number > 3) return false;
        return true;
    }
    
    private static void checkLoop(int value, Scanner reader) {
        while (!checkInput(value))   {
            System.out.println("Please provide valid input.");
            System.out.print("Input: ");
            value = reader.nextInt();
        }    
    }
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Rock, Paper & Scissors!");
        System.out.println("#######################");
        System.out.println("1 - Rock");
        System.out.println("2 - Paper");
        System.out.println("3 - Scissor");
        System.out.println("0 - Exit");
        System.out.print("Input: ");
        
        int value = reader.nextInt();
        checkLoop(value, reader);
        
        while (value > 0) {
            compare(value);
            wins();
            System.out.println("#######################");
            System.out.print("Input: ");
            value = reader.nextInt();
            checkLoop(value, reader);
        }
        
        System.out.println("Thank you for playing.");
        System.out.println("#######################");
    }
}
