public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '~';
            }
        }
    }

    public boolean placeShip(Ship ship, int row, int col, boolean horizontal) {
        if (horizontal) {
            for (int i = 0; i < ship.getSize(); i++) {
                if (col + i >= size || grid[row][col + i] != '~') {
                    return false;
                }
            }
            for (int i = 0; i < ship.getSize(); i++) {
                grid[row][col + i] = 'S';
            }
        } else {
            for (int i = 0; i < ship.getSize(); i++) {
                if (row + i >= size || grid[row + i][col] != '~') {
                    return false;
                }
            }
            for (int i = 0; i < ship.getSize(); i++) {
                grid[row + i][col] = 'S';
            }
        }
        return true;
    }

    public boolean receiveAttack(String coordinate) {
        Coordinate coord = new Coordinate(coordinate);
        if (grid[coord.getRow()][coord.getCol()] == 'S') {
            grid[coord.getRow()][coord.getCol()] = 'X';
            return true;
        } else if (grid[coord.getRow()][coord.getCol()] == '~') {
            grid[coord.getRow()][coord.getCol()] = 'O';
            return false;
        }
        return false;
    }

    public void display(boolean showShips) {
        System.out.print("  ");
        for (char c = 'A'; c < 'A' + size; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < size; j++) {
                if (showShips) {
                    System.out.print(grid[i][j] + " ");
                } else {

                    char cell = grid[i][j];
                    if (cell == 'S') {
                        System.out.print("~ ");
                    } else {
                        System.out.print(cell + " ");
                    }
                }
            }
            System.out.println();
        }
    }


    public int getSize() {
        return size;
    }
}