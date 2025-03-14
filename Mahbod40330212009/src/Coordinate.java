public class Coordinate {
    private int row;
    private int col;

    public Coordinate(String input) {
        this.row = input.charAt(1) - '0';
        this.col = input.charAt(0) - 'A';
    }

    public boolean isValid() {
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}