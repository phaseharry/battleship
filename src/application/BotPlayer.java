package application;
import java.util.HashMap;
import java.util.ArrayList;

public class BotPlayer implements Player{
	
	public void generateShips(char botShips[][], HashMap<Character, Ship> botShipsList) {
		Battleship b1 = (Battleship) botShipsList.get('B');
		Carrier c1 = (Carrier) botShipsList.get('C');
		Destroyer d1 = (Destroyer) botShipsList.get('D');
		PatrolBoat p1 = (PatrolBoat) botShipsList.get('P');
		Submarine s1 = (Submarine) botShipsList.get('S');
		
		// putting b1 (size 4) on row 9 and col 2 -> 5
		for(int c = 2; c < 2 + b1.getSize(); c++) {
			botShips[9][c] = b1.getShipID();
		}
		
		// putting c1 (size 5) on col 3 and row 3 -> 7
		for(int r = 3; r < 3 + c1.getSize(); r++) {
			botShips[r][3] = c1.getShipID();
		}
		
		// putting d1 (size 3) on col 0 and row 7 -> 9
		for(int r = 7; r < 7 + d1.getSize(); r++) {
			botShips[r][0] = d1.getShipID();
		}
		
		// putting p1 (size 2) on row 0 and col 2 -> 3
		for(int c = 2; c < 2 + p1.getSize(); c++) {
			botShips[0][c] = p1.getShipID();
		}
		
		// putting s1 (size 3) on row 2 and col 7 -> 9
		for(int c = 7; c < 7 + s1.getSize(); c++) {
			botShips[2][c] = s1.getShipID();
		}
	}
	
	/**
	 * Method used by the bot to decide where to attack
	 * @param playerShips
	 * @param playerShipsList
	 */
	public void bombard(char playerShips[][], HashMap<Character, Ship> playerShipsList) {
		Integer[] coordinates = getRandomMove(playerShips);
		int row = coordinates[0], col = coordinates[1];
		// if the attacked spot is empty, mark it as a miss
		// else, decrement the ships hp and mark it as 'H'
		if(playerShips[row][col] == 'E') {
			playerShips[row][col] = 'M';
		} else {
			char shipType = playerShips[row][col];
			playerShipsList.get(shipType).takeHit();
			playerShips[row][col] = 'H';
		}
	}
	
	/**
	 * Used to generate a random attack move
	 * @param playerShips
	 * @return
	 */
	public Integer[] getRandomMove(char playerShips[][]) {
		ArrayList<Integer[]> possibleMoves = getPossibleMoves(playerShips);
		int maxIdx = possibleMoves.size() - 1;
		int range = maxIdx + 1; 
		int idx = (int)(Math.random() * range);
		return possibleMoves.get(idx);
	}
	
	/**
	 * Helper method used to generate possible moves by checking for all spots that's has not been attacked before 
	 * either M (miss) or H (hit)
	 * @param playerShips
	 * @return an array list with arrays as element [row, col] for the attack
	 */
	public ArrayList<Integer[]> getPossibleMoves(char playerShips[][]){
		ArrayList<Integer[]> possibleMoves = new ArrayList<Integer[]>();
		for(int row = 0; row < playerShips.length; row++) {
			for(int col = 0; col < playerShips[row].length; col++) {
				if(playerShips[row][col] != 'M' || playerShips[row][col] != 'H') {
					Integer[] possibleAttack = new Integer[2];
					possibleAttack[0] = row; 
					possibleAttack[1] = col;
					possibleMoves.add(possibleAttack);
				}
			}
		}
		return possibleMoves;
	}
	
	
	/**
	 * helper method that returns a random row or random column to place ships in
	 * @return random row or col
	 */
	private int randomRowOrCol() {
		return (int)(Math.random() * ((9 - 0) + 1)) + 0;
	}
}
