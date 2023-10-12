public class Board {
    private int columns;
    private int rows;
    private char[][] dynamicBoard;

    //Creates a new dynamic board with given size and setting default value and layout
    public Board(int rows, int columns) {
        dynamicBoard = new char[rows][columns];
        this.rows = rows;
        this.columns = columns;
        defaultCellValue();
    }

    public void defaultCellValue(){
        // For every cell on the board fill with default value space
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                dynamicBoard[i][j] = ' ';
            }
        }
    }
    public void layout() {
        // Line that repeats as many times as board rows for dynamic board
        String line = "------".repeat(rows);
        int count = 1;

        //Building letters depending on size of board, ASCII value increases for every loop
        StringBuilder letters = new StringBuilder("   ");
        for (int i = 0; i < rows; i++) {
            letters.append((char) ('A' + i)).append("     ");
        }
        System.out.println(letters);

        // Building line for each row and "walls" in every cell around cell value
        for (int i = 0; i < rows; i++) {
            System.out.println(line);
            for (int j = 0; j < columns; j++) {
                System.out.print("|" + "  " + dynamicBoard[i][j] + "  ");
            }
            // Identify every row with numbers
            System.out.println("|  " + count++);
        }
        System.out.println(line);
    }

    public boolean isCellEmpty(int i, int j) {
        // Check if a specific cell is available for placing symbol
        return dynamicBoard[i][j] == (' ');
    }

    public void setCellValue(int row, int column, char value) {
        this.dynamicBoard[row][column] = value;
    }

    public char[][] getDynamicBoard() {
        return dynamicBoard;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }
}