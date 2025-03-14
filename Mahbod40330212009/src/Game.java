import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private boolean isPlayer1Turn;
    private int gameMode;
    private int placementMode;

    public Game(int gameMode, int placementMode) {
        this.gameMode = gameMode;
        this.placementMode = placementMode;
        player1 = new Player("Player 1", placementMode);
        player2 = (gameMode == 1) ? new AIPlayer("AI Player", placementMode) : new Player("Player 2", placementMode);
        isPlayer1Turn = true;
    }

    public void start() {
        boolean playAgain;
        do {
            playGame();
            playAgain = askReplay();
        } while (playAgain);
    }

    private void playGame() {
        while (!player1.allShipsSunk() && !player2.allShipsSunk()) {
            Player currentPlayer = isPlayer1Turn ? player1 : player2;
            Player opponent = isPlayer1Turn ? player2 : player1;

            System.out.println(currentPlayer.getName() + "'s turn:");
            opponent.getBoard().display(false);
            String move = currentPlayer.makeMove();
            boolean hit = opponent.getBoard().receiveAttack(move);
            if (hit) {
                System.out.println("Hit!");
            } else {
                System.out.println("Miss!");
            }

            isPlayer1Turn = !isPlayer1Turn;
        }

        System.out.println((player1.allShipsSunk() ? player2.getName() : player1.getName()) + " wins!");
    }

    private boolean askReplay() {
        System.out.println("Play again? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().equalsIgnoreCase("yes");
    }
}