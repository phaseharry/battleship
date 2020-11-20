package application;
public class Destroyer extends Ship {
	private static final int size = 3;
	private final String name = "Destroyer";
	private final char shipIdentifier = 'D';
	
	/**
	 * Creates an instance of the Destroyer ship
	 */
	public Destroyer() {
		super(size);
	}
	
	/**
	 * Returns the name of the ship (Destroyer class)
	 * @return name of ship
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the Destroyer ship's unique idenitifer to mark the board
	 * @return id of the Destroyer ship
	 */
	public char getShipID() {
		return shipIdentifier;
	}
}
