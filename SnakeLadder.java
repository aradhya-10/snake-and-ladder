import java.util.*;

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
	
	public int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}

public class SnakeLadder {
	public static void main(String[] args) {
		Player P1 = new Player();
		System.out.println("Player's initial position: " + P1.getCurrentPosition());
		int move = P1.rollDice();
		System.out.println("Dice roll: "+move);
		P1.setCurrentPosition(P1.getCurrentPosition()+move);
		System.out.println("Player's final position: " + P1.getCurrentPosition());
	}
}
