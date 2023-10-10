public class Player {
    private String name;
    private char symbol;
    private int roundsWon = 0;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }
    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
