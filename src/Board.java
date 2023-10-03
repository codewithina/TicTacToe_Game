public class Board {
    char[][] threeRowBoard = new char[3][3];

/*  IF THE PLAYER CAN CHOOSE BOARD, open this up

    char[][] fourRowBoard = new char[4][4];
    char[][] fiveRowBoard = new char[5][5];

 */

    public Board(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                threeRowBoard[i][j] = ' ';
            }
        }
    }

    public void writeOutBoard(){
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|  " + threeRowBoard[i][j] + "  ");
            }
            System.out.println("|");
        }
        System.out.println("-------------------");

    }
}
