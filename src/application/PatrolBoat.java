package application;
public class PatrolBoat extends Ship {
	private static final int size = 2;
	private final String name = "Patrol Boat";
	private final char shipIdentifier = 'P';
	
	/**
	 * Creates an instance of the Patrol Boat
	 */
	public PatrolBoat() {
		super(size);
	}
	
	/**
	 * Returns the name of the ship (Patrol Boat class)
	 * @return name of ship
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the Patrol Boat's unique idenitifer to mark the board
	 * @return id of the Patrol Boat
	 */
	public char getShipID() {
		return shipIdentifier;
	}
}
