import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Player player1 = new Player('o');
    private Player player2 = new Player('x');
    private Player currentPlayer = player1;
    private Board board;

    public Game() {
        initGame();
        runGame();
    }

    public void initGame() {
        System.out.println("°°°°°°°°° N E W   G A M E °°°°°°°°°");
        System.out.println(" ENTER the name of player 1: ");
        String name = sc.nextLine();
        this.player1.setName(name);

        System.out.println(" ENTER the name of player 2: ");
        String name2 = sc.nextLine();
        this.player2.setName(name2);

        System.out.println(" How many rows & columns do you want, 3, 4 or 5? ");
        int sizeOfBoard = sc.nextInt();
        this.board = new Board(sizeOfBoard, sizeOfBoard);
        sc.nextLine();
        System.out.println(" Start by pressing ENTER!");
        sc.nextLine();
    }

    public void runGame() {
        System.out.println("Let's go, good luck with the game!\n");
        while (true) {
            board.writeOutBoard();
            System.out.println(currentPlayer.getName() + ", ENTER your move." +
                    "\nWrite which column followed by row, ex. A1:");
            String chosenPlacement = sc.nextLine();
            //make sure column is uppercase character and then convert to ASCII-value and convert to int
            int chosenColumn = (int) (Character.toUpperCase(chosenPlacement.charAt(0)) - 65);
            int chosenRow = Character.getNumericValue(chosenPlacement.charAt(1) - 1);
            board.setBoardValue(chosenRow, chosenColumn, currentPlayer.getSymbol());
            switchPlayer();
        }


        //1. check if the chosen box is free
        //2. checkWinner();
        //3. read and write out placement
        //4. gameOver or new loop
        //p2 place your stone
        //when a number is used already?
        //if invalid input (null or wrong sign)
        //stop after 3 rounds each, or continue by "moving" your stone
    }

    public void makeMove() {

    }

    public void checkWinner() {
        //loop through all winning combinations
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

            }
        }
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean gameOver() {
        return false;
    }

}
