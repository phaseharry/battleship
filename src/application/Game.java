package application;
import java.util.HashMap;

public class Game {
	private final int row = 10, col = 10;
	private final char miss = 'M', hit = 'H', emptyWaters = 'E';
	private char playerShips[][], aiShips[][];
	private HashMap<Character, Ship> aiShipsList, playerShipsList;
	private HashMap<Character, Integer> rowIdxMap;
	private HashMap<Integer, Integer> colIdxMap;
	private HumanPlayer player;
	private BotPlayer bot;
	private boolean gameOver;
	public Game() {
		playerShips = initBoard();
		aiShips = initBoard();
		aiShipsList = new HashMap<Character, Ship>();
		playerShipsList = new HashMap<Character, Ship>();
		initShips(playerShipsList);
		initShips(aiShipsList);
		bot = new BotPlayer();
		player = new HumanPlayer();
		bot.generateShips(aiShips, aiShipsList);
		player.generateShips(playerShips, playerShipsList);
		gameOver = false;
	}
	
	/**
	 * returns the player's board
	 * @return
	 */
	public char[][] playerBoard(){
		return playerShips;
	}
	/**
	 * Initiates a turn. User will input the row or col they want to attack & then ai will randomly attack a spot on the player's board
	 * @param row
	 * @param col
	 */
	public void runIteration(int row, int col) {
		player.bombard(aiShips, aiShipsList, row, col);
		if(shipsDestroyed(aiShipsList)) {
			gameOver = true;
			return;
		}
		bot.bombard(playerShips, playerShipsList);
		if(shipsDestroyed(playerShipsList)) {
			gameOver = true;
			return;
		}
	}
	
	/**
	 * Used to determine if the game is over or not
	 * @return gameOver
	 */
	public boolean gameOver() {
		return gameOver;
	}
	
	/**
	 * Used to determibe if the player one. Used together win the gameOver function.
	 * If gameOver() && playerWon() is true then player won. If gameOver() is true but playerWon() is false then the AI won
	 * @return
	 */
	public boolean playerWon() {
		if(shipsDestroyed(aiShipsList)) return true;
		return false;
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
	 * Prints the row and column maps for testing purposes
	 */
	public void printRowAndColMapIdx() {
		System.out.print("Row to idx map\n");
		for(Character key : rowIdxMap.keySet()) {
			Integer rowVal = rowIdxMap.get(key);
			System.out.print(key + ": " + rowVal + "\n");
		}
		System.out.print("\nCol to idx map\n");
		for(Integer key : colIdxMap.keySet()) {
			Integer colVal = colIdxMap.get(key);
			System.out.print(key + ": " + colVal + "\n");
		}
	}
	
	/**
	 * Prints the player's ships for testing purposes
	 */
	public void printPlayerShips() {
		System.out.print("\n");
		int charCode = 65;
		System.out.print("  ");
		for(int c = 1; c <= 10; c++) {
			System.out.print(c + " ");
		}
		System.out.print("\n");
		for(int r = 0; r < row; r++) {
			System.out.print((char)charCode + " ");
			charCode++;
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
		int charCode = 65;
		System.out.print("  ");
		for(int c = 1; c <= 10; c++) {
			System.out.print(c + " ");
		}
		System.out.print("\n");
		for(int r = 0; r < row; r++) {
			System.out.print((char)charCode + " ");
			charCode++;
			for(int c = 0; c < col; c++) {
				System.out.print(aiShips[r][c] + " ");
			}
			System.out.print("\n");
		}
	}
}
