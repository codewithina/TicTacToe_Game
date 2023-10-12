import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("""
                °°°°°° T I C   T A C   T O E °°°°°°
                 Welcome to a game of tic tac toe.
                          - Good luck! -1""");

        while (true) {
            try {
                menuChoices();
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        Game game = new Game();
                        break;
                    case 2:
                        readRules();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please try again.");
                sc.nextLine();
            }
        }

    }

    private static void readRules() {
        System.out.println("""
                °°°°°°°°°°°° R U L E S °°°°°°°°°°°°
                 You and a friend are X and O. You
                 take turns putting your marks in
                 any empty square and first player
                 to get a complete row, column or
                 diagonal with her marks in a row
                 wins the game. This could either
                 be up, down, across, or diagonally.
                 When all squares are full, the
                 game is over and it's a draw.""");
    }

    private static void menuChoices() {
        System.out.println("\n Please enter your choice: \n" +
                " [1] Start new game \n" +
                " [2] Read the rules \n" +
                " [3] Quit");

    }
}