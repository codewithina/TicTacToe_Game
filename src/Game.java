import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Player player1;
    private Player player2;
    private Board board;

    public Game() {
        initGame();
        runGame();
    }

    public void initGame() {
        System.out.println("°°°°°°°°° N E W   G A M E °°°°°°°°°");
        System.out.println(" ENTER the name of player 1: ");
        String name = sc.nextLine();
        this.player1 = new Player(name, 'O');

        System.out.println(" ENTER the name of player 2: ");
        String name2 = sc.nextLine();
        this.player2 = new Player(name2, 'X');

        System.out.println(" How many rows & columns do you want, 3, 4 or 5? ");
        int sizeOfBoard = sc.nextInt();
        this.board = new Board(sizeOfBoard, sizeOfBoard);
        sc.nextLine();
        System.out.println(" Start by pressing ENTER!");
        sc.nextLine();
    }

    public void runGame() {
        System.out.println("Let's go, " + player1.getName() + " is the first one out.");
        board.writeOutBoard();
        System.out.println("Where do you want to place your mark?");
        //p1 place your stone
        //checkWinner();
        //read and write out placement
        //p2 place your stone
        //when a number is used already?
        //if invalid input (null or wrong sign)
        //stop after 3 rounds each, or continue by "moving" your stone
    }

    public void placeMark(Player player) {
    }

    public void checkWinner() {
        //check if saved input fr. user is placed in a row
        // ex. 1 2 3
        //     4 5 6
        //     7 8 9
        // placement 1, 5, 9 in a row is a win

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

            }
        }
    }

    public void takeTurns() {

    }

}
