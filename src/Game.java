public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    public Game(Player player1, Player player2, Board board){
        this.player1=player1;
        this.player2=player2;
        this.board=board;
    }

    public void runGame(){
        //p1 place your stone
        //read and write out placement
        //p2 place your stone
        //when a number is used already?
        //if invalid input (null or wrong sign)
        //stop after 3 rounds each, or continue by "moving" your stone
    }

    public void checkWinner(){
        //check if saved input fr. user is placed in a row
        // ex. 1 2 3
        //     4 5 6
        //     7 8 9
        // placement 1, 5, 9 in a row is a win
    }

}
