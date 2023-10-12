import java.util.ArrayList;
import java.util.Scanner;

/* TODO:
    If invalid input return try again
    Control board size input from user > 3 and less than ?? */

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Player player1 = new Player('o');
    private Player player2 = new Player('x');
    private Player currentPlayer = player1;
    private ArrayList<Player> players = new ArrayList<>();
    private Board board;

    public Game() {
        initGame();
        do {
            runGame();
            resetBoard();
        } while (playAgain());
    }

    // Initializing new game, name players and choose size of board
    public void initGame() {
        System.out.println("°°°°°°°°° N E W   G A M E °°°°°°°°°");
        players.add(player1);
        players.add(player2);
        inputPlayerNames();
        inputBoardSize();
        System.out.println("""
                
                Perfect, here's your board.
                When making a move: remember to write which column followed by row, ex. A1.
                """);
    }

    public void runGame() {
        System.out.println("Let's go " + player1 + " & " + player2 + "! May the best player win :) \n");
        while (!gameOver() && checkWinner() == null) {
            writeOutBoard();
            makeMove();
        }
        System.out.println("\n - Game over! - \n");
    }

    public void inputPlayerNames() {
        for (int i = 1; i < 3; i++) {
            System.out.println("ENTER the name of player " + i + ":");
            String name = sc.nextLine();
            currentPlayer.setName(name);
            switchPlayer();
        }
    }

    public void inputBoardSize() {
        System.out.println("How many rows & columns do you want? ");
        int sizeOfBoard = sc.nextInt();
        board = new Board(sizeOfBoard, sizeOfBoard);
        sc.nextLine();
    }

    public void makeMove() {
        System.out.println(currentPlayer.getName() + ", ENTER your move:");
        String chosenPlacement = sc.nextLine();

        try {
            int chosenColumn = (Character.toUpperCase(chosenPlacement.charAt(0)) - 65);
            int chosenRow = Character.getNumericValue(chosenPlacement.charAt(1) - 1);
            // If the chosen cell is empty, put players symbol in it
            if (isValidMove(chosenRow, chosenColumn)) {
                board.setCellValue(chosenRow, chosenColumn, currentPlayer.getSymbol());
                checkOutcome();
                switchPlayer();
            } else {
                System.out.println("\nThe chosen placement is already taken, please choose an empty one.\n");
            }
        } catch (StringIndexOutOfBoundsException | NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("\nInvalid input. Please enter a valid move in the format 'A1', 'B2', etc.\n");
        }
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

    public void writeOutBoard() {
        board.layout();
    }

    public boolean playAgain() {
        printScoreBoard();
        while (true) {
            System.out.println("Do you want to play another round? yes/no");
            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase("yes")) {
                return true;
            } else if (userInput.equalsIgnoreCase("no")) {
                return false;
            } else {
                invalidInput();
            }
        }
    }

    public void increaseRoundsWon(int playerRoundsWon) {
        checkWinner().setRoundsWon(playerRoundsWon + 1);
    }

    public void printScoreBoard() {
        System.out.println(player1.getName() + " has won " + player1.getRoundsWon() + " rounds.");
        System.out.println(player2.getName() + " has won " + player2.getRoundsWon() + " rounds.\n");
    }


    public void checkOutcome() {
        // If symbol is set check if there's any win before continuing
        if (checkWinner() != null) {
            writeOutBoard();
            System.out.println("CONGRATULATIONS " + checkWinner() + ", you won this round!");
            increaseRoundsWon(checkWinner().getRoundsWon());
        }
        if (gameOver() && checkWinner() == null) {
            writeOutBoard();
            System.out.println("It's a tie! No one wins this round.");
        }
    }

    public void resetBoard() {
        board.defaultCellValue();
    }

    public void invalidInput() {
        System.out.println("\nInvalid input. Please try again.\n");
    }

    public boolean isValidMove(int row, int col) {
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
