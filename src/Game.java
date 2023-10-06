import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Player player1 = new Player('o');
    private Player player2 = new Player('x');
    private Player currentPlayer = player1;
    private ArrayList<Player> players = new ArrayList<>();
    private Board board;

    public Game() {
        players.add(player1);
        players.add(player2);
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
        System.out.println(" Let's go " + player1 + " & " + player2 + "! May the best player win :) \n");
        while (!gameOver() && checkWinner() == null) {
            board.writeOutBoard();
            System.out.println(currentPlayer.getName() + ", ENTER your move." +
                    "\nWrite which column followed by row, ex. A1:");
            String chosenPlacement = sc.nextLine();
            int chosenColumn = (int) (Character.toUpperCase(chosenPlacement.charAt(0)) - 65);
            int chosenRow = Character.getNumericValue(chosenPlacement.charAt(1) - 1);
            if(isValidMove(chosenRow, chosenColumn)) {
                board.setBoardValue(chosenRow, chosenColumn, currentPlayer.getSymbol());
                if (checkWinner() != null) {
                    board.writeOutBoard();
                    System.out.println("CONGRATULATIONS " + checkWinner() + ", you won this round!");
                }
                switchPlayer();
            } else{
                System.out.println(invalidInput());
            }
        }
        System.out.println(" - Game over! - ");
    }

    public Player checkWinner() {
        // Check if there's a winning combo of symbols for all players in the game
        for (Player player : players) {
            char playerSymbol = player.getSymbol();
            int boardSize = board.getRows();

            // Check winning combos in rows and columns
            for (int row = 0; row < boardSize; row++) {
                int countRow = 0;
                int countCol = 0;
                for (int col = 0; col < boardSize; col++) {
                    if (board.getDynamicBoard()[row][col] == playerSymbol) {
                        countRow++;
                    }
                    if (board.getDynamicBoard()[col][row] == playerSymbol) {
                        countCol++;
                    }
                    if (countRow == boardSize || countCol == boardSize) {
                        return player;
                    }
                }
            }

            // Check winning combos in diagonals
            int countDia1 = 0;
            int countDia2 = 0;
            for (int i = 0; i < boardSize; i++) {
                if (board.getDynamicBoard()[i][i] == playerSymbol) {
                    countDia1++;
                }
                if (board.getDynamicBoard()[i][boardSize - 1 - i] == playerSymbol) {
                    countDia2++;
                }
                if (countDia1 == boardSize || countDia2 == boardSize) {
                    return player;
                }
            }
        }
        return null;
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
    public String invalidInput() {
        return "Invalid input, try again.";
    }
    public boolean isValidMove(int row, int col){
        return board.isCellEmpty(row, col);
    }

    public boolean gameOver() {
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.getDynamicBoard()[i][j] == (' ')) {
                    return false;
                }
            }
        }
        return true;
    }

}


// TO DO:
// Check if the chosen box is free !!!!!!
// If invalid input return try again
// Continue with more rounds after ended game, or start new game?
// Check players winning scores

