import java.util.*;

class Player {

    int numberOfMoves;
    private int currentPosition;

    public Player() {
        this.currentPosition = 0;
		this.numberOfMoves = 0;
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
		boardConfig.put( 2,23);
		boardConfig.put( 6,29);
		boardConfig.put( 6,29);
		boardConfig.put(22,41);
		boardConfig.put(28,77);
		boardConfig.put(30,32);
		boardConfig.put(44,58);
		boardConfig.put(54,69);
		boardConfig.put(99,26);
		boardConfig.put(70,90);
		boardConfig.put(80,83);
		boardConfig.put(87,93);
	}

	public static boolean movePlayer(Player currPlayer){
		boolean isLadder = false;
		int currentPosition = currPlayer.getCurrentPosition();
		if(boardConfig.containsKey(currentPosition)){
			int finalPosition = boardConfig.get(currentPosition);
			if(finalPosition>currentPosition)
			{
				System.out.println("Ladder found");
				isLadder = true;
			}
			else{
				System.out.println("Snake found");
			}
			if(finalPosition<=100)
				currPlayer.setCurrentPosition(finalPosition);
		}
		return isLadder;
	}

	public static void main(String[] args) {
		Player P1 = new Player();
		Player P2 = new Player();
		
		Player currPlayer;
		int player = 1;
		System.out.println("Player's initial position: " + P1.getCurrentPosition());
		int numberOfMoves = 0;
		while(P1.getCurrentPosition()<100 && P2.getCurrentPosition()<100)
		{
			currPlayer = player == 1 ? P1 : P2;
			currPlayer.numberOfMoves++;
			int move = currPlayer.rollDice();
			System.out.println("Dice roll: "+move);
			if(currPlayer.getCurrentPosition()+move<=100)
				currPlayer.setCurrentPosition(currPlayer.getCurrentPosition()+move);
			System.out.println("Player's moved position: " + currPlayer.getCurrentPosition());
			boolean isLadder = movePlayer(currPlayer);
			System.out.println("Player " +player+"'s final position: " + currPlayer.getCurrentPosition());
			if(!isLadder)
				player = player == 1 ? 2 : 1;
		}
		player = player == 1 ? 2 : 1;		
		currPlayer = player == 1 ? P1 : P2;
		System.out.println("Winner: Player "+ player +".\nGame completed in "+currPlayer.numberOfMoves+" moves.");
	}
}