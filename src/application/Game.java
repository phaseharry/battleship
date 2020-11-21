package application;
import java.util.HashMap;

public class Game {
	private final int row = 10, col = 10;
	private final char miss = 'M', hit = 'H', emptyWaters = 'E';
	private char playerShips[][], aiShips[][];
	private HashMap<Character, Ship> aiShipsList, playerShipsList;
	private HashMap<Character, Integer> rowIdxMap;
	private HashMap<Integer, Integer> colIdxMap;
	
	public Game() {
		initInputToIdx();
		playerShips = initBoard();
		aiShips = initBoard();
		aiShipsList = new HashMap<Character, Ship>();
		playerShipsList = new HashMap<Character, Ship>();
		initShips(playerShipsList);
		initShips(aiShipsList);
		BotPlayer bot = new BotPlayer();
		HumanPlayer player = new HumanPlayer();
		bot.generateShips(aiShips, aiShipsList);
		player.generateShips(playerShips, playerShipsList);
	}
	
	/**
	 * Helper method just to determine if either the player's or the bot's ships are all destroyed.
	 * Used to determine when the game is over and determine the winner of the game.
	 * @return true if all ships are destroyed, false otherwise
	 */
	private boolean shipsDestroyed(HashMap<Character, Ship> squadron) {
		boolean allDestroyed = true;
		for(Ship currentShip : squadron.values()) {
			if(currentShip.isDestroyed() == false) allDestroyed = false;
		}
		return allDestroyed;
	}
	
	/**
	 * Maps traditional Battleship board game inputs to row and col indices
	 * Maps the A - J to row index of 0 - 9 (row)
	 * Maps 1 - 10 to 0 - 9 (col)
	 */
	private void initInputToIdx() {
		int startChar = 65, endChar = 74, rowIdx = 0, colIdx = 0;
		for(int row = startChar; row <= endChar; row++) {
			rowIdxMap.put((char)row, rowIdx++);
		}
		for(int col = 1; col <= 10; col++) {
			colIdxMap.put(col, colIdx++);
		}
	}
	
	/**
	 * Initializes an empty unexplored boards for both the player and the A.I
	 * @return 2D matrix of characters
	 */
	private char[][] initBoard() {
		char[][] board = new char[row][col];
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				board[r][c] = emptyWaters;
			}
		}
		return board;
	}
	
	/**
	 * used to initialize both the player and the bot with 1 of each type of ship
	 * @param shipList
	 */
	private void initShips(HashMap<Character, Ship> shipList) {
		Battleship b1 = new Battleship();
		Carrier c1 = new Carrier();
		Destroyer d1 = new Destroyer();
		PatrolBoat p1 = new PatrolBoat();
		Submarine s1 = new Submarine();
		shipList.put(b1.getShipID(), b1);
		shipList.put(c1.getShipID(), c1);
		shipList.put(d1.getShipID(), d1);
		shipList.put(p1.getShipID(), p1);
		shipList.put(s1.getShipID(), s1);
	}
	
	/**
	 * Prints the player's ships for testing purposes
	 */
	public void printPlayerShips() {
		System.out.print("\n");
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				System.out.print(playerShips[r][c] + " ");
			}
			System.out.print("\n");
		}
	}
	
	/**
	 * Prints the AI's ships for testing purposes
	 */
	public void printAiShips() {
		System.out.print("\n");
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < col; c++) {
				System.out.print(aiShips[r][c] + " ");
			}
			System.out.print("\n");
		}
	}
}
