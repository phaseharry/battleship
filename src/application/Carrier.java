package application;
public class Carrier extends Ship {
	private static final int size = 5;
	private final String name = "Carrier";
	private final char shipIdentifier = 'C';
	
	/**
	 * Creates an instance of the Carrier ship
	 */
	public Carrier() {
		super(size);
	}
	
	/**
	 * Returns the name of the ship (Carrier class)
	 * @return name of ship
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the Carrier ship's unique idenitifer to mark the board
	 * @return id of the Carrier ship
	 */
	public char getShipID() {
		return shipIdentifier;
	}
}
