package application;

public class Submarine extends Ship {
	private static final int size = 3;
	private final String name = "Submarine";
	private final char shipIdentifier = 'S';
	
	/**
	 * Creates an instance of the Submarine
	 */
	public Submarine() {
		super(size);
	}
	
	/**
	 * Returns the name of the ship (Submarine class)
	 * @return name of ship
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the Submarine ship's unique idenitifer to mark the board
	 * @return id of the Submarine ship
	 */
	public char getShipID() {
		return shipIdentifier;
	}
}
