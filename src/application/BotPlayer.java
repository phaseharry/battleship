package application;
import java.util.HashMap;

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

	public void bombard(char playerShips[][], HashMap<Character, Ship> playerShipsList) {}
	
	/**
	 * helper method that returns a random row or random column to place ships in
	 * @return random row or col
	 */
	private int randomRowOrCol() {
		return (int)(Math.random() * ((9 - 0) + 1)) + 0;
	}
}
