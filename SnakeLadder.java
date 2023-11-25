class Player {

    private int currentPosition;

    public Player() {
        this.currentPosition = 0;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}

public class SnakeLadder {
	public static void main(String[] args) {
		Player P1 = new Player();
		System.out.println("Player's initial position: " + P1.getCurrentPosition());
	}
}
