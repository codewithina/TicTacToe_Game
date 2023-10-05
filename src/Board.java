public class Board {
    private int columns;
    private int rows;
    private char[][] dynamicBoard;

    public Board(int rows, int columns) {
        dynamicBoard = new char[rows][columns];
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dynamicBoard[i][j] = ' ';
            }
        }
    }

    public void writeOutBoard() {
        String line = "------".repeat(rows);
        int count = 1;

        //Build more letters depending on size of board
        StringBuilder letters = new StringBuilder("   ");
        for (int i = 0; i < rows; i++) {
            //'A'+i = 65 at first and therefor writes out A
            letters.append((char) ('A' + i)).append("     ");
        }
        System.out.println(letters.toString());

        for (int i = 0; i < rows; i++) {
            System.out.println(line);
            for (int j = 0; j < columns; j++) {
                System.out.print("|" + "  " + dynamicBoard[i][j] + "  ");
            }
            System.out.println("|  " + count++);
        }
        System.out.println(line);
    }
    public void setBoardValue(int row, int column, char value) {
        this.dynamicBoard[row][column] = value;
    }

    public char[][] getDynamicBoard() {
        return dynamicBoard;
    }
}