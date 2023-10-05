public class Player {
    private String name;
    private char symbol;
    private int roundsWon;

    public Player (String name, char symbol){
        this.name=name;
        this.symbol=symbol;
    }
    public Player (char symbol){
        this.symbol=symbol;
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

    @Override
    public String toString() {
        return this.name;
    }
}
