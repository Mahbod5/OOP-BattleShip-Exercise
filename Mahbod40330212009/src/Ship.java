public class Ship {
    private String name;
    private int size;
    private int health;

    public Ship(String name, int size) {
        this.name = name;
        this.size = size;
        this.health = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isSunk() {
        return health <= 0;
    }

    public void takeDamage() {
        health--;
    }
}