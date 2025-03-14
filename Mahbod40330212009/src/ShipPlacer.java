import java.util.Random;

public class ShipPlacer {
    public static void placeShipRandomly(Board board, Ship ship) {
        Random rand = new Random();
        boolean placed = false;
        while (!placed) {
            int row = rand.nextInt(board.getSize());
            int col = rand.nextInt(board.getSize());
            boolean horizontal = rand.nextBoolean();
            placed = board.placeShip(ship, row, col, horizontal);
        }
    }
}