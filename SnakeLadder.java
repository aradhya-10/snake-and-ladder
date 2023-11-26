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
	public static Map<Integer, Integer> boardConfig;
	static{
		boardConfig =  new HashMap<>();
		boardConfig.put(97,86);
		boardConfig.put(89,67);
		boardConfig.put(76,63);
		boardConfig.put(72,12);
		boardConfig.put(99,26);
		boardConfig.put(66,24);
		boardConfig.put(59,46);
		boardConfig.put(50,34);
		boardConfig.put(39, 3);
		boardConfig.put(27, 7);
		boardConfig.put(2 ,23);
		boardConfig.put(6 ,29);
		boardConfig.put(6 ,29);
		boardConfig.put(22,41);
		boardConfig.put(28,77);
		boardConfig.put(30,32);
		boardConfig.put(44,58);
		boardConfig.put(54,69);
		boardConfig.put(99,26);
		boardConfig.put( 6,29);
		boardConfig.put(70,90);
		boardConfig.put(80,83);
		boardConfig.put(87,93);
	}

	public static int movePlayer(int currentPosition){
		if(boardConfig.containsKey(currentPosition)){
			int finalPosition = boardConfig.get(currentPosition);
			System.out.println(finalPosition>currentPosition?"Ladder":"Snake");
			return finalPosition;
		}
		return currentPosition;
	}

	public static void main(String[] args) {
		Player P1 = new Player();
		System.out.println("Player's initial position: " + P1.getCurrentPosition());
		int move = P1.rollDice();
		System.out.println("Dice roll: "+move);
		P1.setCurrentPosition(P1.getCurrentPosition()+move);
		System.out.println("Player's moved position: " + P1.getCurrentPosition());
		P1.setCurrentPosition(movePlayer(P1.getCurrentPosition()));
		System.out.println("Player's final position: " + P1.getCurrentPosition());
	}
}
