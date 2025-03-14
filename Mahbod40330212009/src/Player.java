import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private Board board;
    private List<Ship> ships;
    private int placementMode;

    public Player(String name, int placementMode) {
        this.name = name;
        this.board = new Board(10);
        this.ships = new ArrayList<>();
        this.placementMode = placementMode;
        initializeShips();
    }

    private void initializeShips() {
        ships.add(new Ship("Aircraft Carrier", 5));
        ships.add(new Ship("Battleship", 4));
        ships.add(new Ship("Submarine", 3));
        ships.add(new Ship("Patrol Boat", 2));

        if (placementMode == 1) {
            placeShipsManually();
        } else {
            placeShipsRandomly();
        }
    }

    private void placeShipsManually() {
        Scanner scanner = new Scanner(System.in);
        for (Ship ship : ships) {
            board.display(true);
            System.out.println("Place your " + ship.getName() + " (size " + ship.getSize() + ")");
            System.out.println("Enter starting coordinate (e.g., A0):");
            String coord = scanner.next();
            System.out.println("Place horizontally? (yes/no):");
            boolean horizontal = scanner.next().equalsIgnoreCase("yes");

            Coordinate coordinate = new Coordinate(coord);
            if (!board.placeShip(ship, coordinate.getRow(), coordinate.getCol(), horizontal)) {
                System.out.println("Invalid placement. Try again.");
                placeShipsManually();
                return;
            }
        }
    }

    private void placeShipsRandomly() {
        for (Ship ship : ships) {
            ShipPlacer.placeShipRandomly(board, ship);
        }
    }

    public String getName() {
        return name;
    }

    public Board getBoard() {
        return board;
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }

    public String makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter target coordinates (e.g., A0):");
        return scanner.next();
    }
}