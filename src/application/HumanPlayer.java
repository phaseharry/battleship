package application;
import java.util.HashMap;
import java.util.Scanner; 

public class HumanPlayer implements Player{
	private Scanner input = new Scanner(System.in);
	// TODO: Allow player to select where they want their ships
	@Override
	public void generateShips(char[][] playerBoard, HashMap<Character, Ship> playerShipsList) {
		Battleship b1 = (Battleship) playerShipsList.get('B');
		Carrier c1 = (Carrier) playerShipsList.get('C');
		Destroyer d1 = (Destroyer) playerShipsList.get('D');
		PatrolBoat p1 = (PatrolBoat) playerShipsList.get('P');
		Submarine s1 = (Submarine) playerShipsList.get('S');
		
		// putting b1 (size 4) on row 9 and col 2 -> 5
		for(int c = 2; c < 2 + b1.getSize(); c++) {
			playerBoard[9][c] = b1.getShipID();
		}
		
		// putting c1 (size 5) on col 3 and row 3 -> 7
		for(int r = 3; r < 3 + c1.getSize(); r++) {
			playerBoard[r][3] = c1.getShipID();
		}
		
		// putting d1 (size 3) on col 0 and row 7 -> 9
		for(int r = 7; r < 7 + d1.getSize(); r++) {
			playerBoard[r][0] = d1.getShipID();
		}
		
		// putting p1 (size 2) on row 0 and col 2 -> 3
		for(int c = 2; c < 2 + p1.getSize(); c++) {
			playerBoard[0][c] = p1.getShipID();
		}
		
		// putting s1 (size 3) on row 2 and col 7 -> 9
		for(int c = 7; c < 7 + s1.getSize(); c++) {
			playerBoard[2][c] = s1.getShipID();
		}
		
	}

	/**
	 * Method used to take user input and attack enemy ships
	 * @param enemyShips
	 * @param enemyShipsList
	 * @param rowIdxMap
	 * @param colIdxMap
	 */
	public void bombard(char[][] enemyShips, HashMap<Character, Ship> enemyShipsList, 
			HashMap<Character, Integer> rowIdxMap, HashMap<Integer, Integer> colIdxMap) {
		//TODO: check for out of bound cases so user can re-enter a move
		System.out.println("Enter the row you want to attack: ");
		char row = input.next().charAt(0);
		System.out.println("\nEnter the column you want to attack: ");
		int column = input.nextInt();
		// convert user input into a board index
		int rowIdx = rowIdxMap.get(row), colIdx = colIdxMap.get(column);
		/* 
		 * Cases to check:
		 * 1) empty waters, just change the board from 'E' to 'M'
		 * 2) hit a ship, first get the char and change its hp from its obj and then mark the spot as hit
		 * 3) if a cell is either already 'M' (missed) or 'H' (hit), let user redo move
		 */
		if(enemyShips[rowIdx][colIdx] == 'E') {
			enemyShips[rowIdx][colIdx] = 'M';
		} else if(enemyShips[rowIdx][colIdx] == 'M' || enemyShips[rowIdx][colIdx] == 'H') {
			// REDO move
		} else {
			char shipId = enemyShips[rowIdx][colIdx];
			Ship shipHit = enemyShipsList.get(shipId);
			shipHit.takeHit();
			// TODO: if ship is destroyed, notify user?
			enemyShips[rowIdx][colIdx] = 'H';
		}
	}
}
