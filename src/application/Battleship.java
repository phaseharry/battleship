package application;
public class Battleship extends Ship {
	private static final int size = 4;
	private final String name = "Battleship";
	private final char shipIdentifier = 'B';
	
	/**
	 * Creates an instance of the Battleship
	 */
	public Battleship() {
		super(size);
	}
	
	/**
	 * Returns the name of the ship (Battleship class)
	 * @return name of ship
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the Battleship's unique idenitifer to mark the board
	 * @return id of Battleship
	 */
	public char getShipID() {
		return shipIdentifier;
	}
}
