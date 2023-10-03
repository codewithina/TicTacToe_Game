import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("""
                °°°°°° T I C   T A C   T O E °°°°°°
                 Welcome to a game of tic tac toe.
                          - Good luck! -
                           
                 Please enter your choice:
                  [1] Start new game
                  [2] Read the rules
                  [3] Quit""");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                startGame();
                System.out.println("hej");
                break;
            case 2:
                readRules();
                break;
            case 3:
                return;
        }

    }
    private static void startGame(){
        System.out.println(" ENTER the name of player 1: ");
        String name = sc.nextLine();
        Player player1 = new Player(name, 'O');
        System.out.println(" ENTER the name of player 2: ");
        String name2 = sc.nextLine();
        Player player2 = new Player(name2, 'X');
        Board board = new Board();
        Game game = new Game(player1, player2, board);
        game.toString();
        System.out.println(" START by pressing any button!");
        sc.nextLine();
    }
    private static void readRules(){
        System.out.println("You and a friend are X and O. You " +
                "\ntake turns putting your marks in " +
                "\nany empty square and first player " +
                "\nto get 3 of her marks in a row \nwins the game. This could either " +
                "\nbe up, down, across, or diagonally. " +
                "\nWhen all 9 squares are full, the " +
                "\ngame is over and it's a draw..");
    }
}