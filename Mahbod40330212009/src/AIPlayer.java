import java.util.Random;

public class AIPlayer extends Player {
    public AIPlayer(String name, int placementMode) {
        super(name, placementMode);
    }

    @Override
    public String makeMove() {
        Random rand = new Random();
        return "" + (char) ('A' + rand.nextInt(10)) + rand.nextInt(10);
    }
}