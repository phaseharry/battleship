package application;

public abstract class Ship {
	private int hp, size;
	private boolean destroyed;
	
	public Ship() {
		size = 5;
		hp = 5;
		destroyed = false;
	}
	
	public Ship(int s) {
		size = s;
		hp = s;
		destroyed = false;
	}
	
	/**
	 * Returns the status of a ship (whether it is destroyed or not)
	 * @return a boolean indicating if the ship is destoryed or not
	 */
	public boolean isDestroyed() {
		return destroyed;
	}
	
	/**
	 * Returns a boolean indicating whether a ship is damaged or not 
	 * @return a boolean inidicating whether the hp is less than its size
	 */
	public boolean isDamaged() {
		return hp < size;
	}
	
	/**
	 * Returns the original size of the ship to determine what class of ship it is
	 * @return size of the ship
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Decrements a ship's health when it takes a hit
	 */
	public void takeHit() {
		hp--;
		if(hp <= 0) destroyed = true;
	}
	
	/**
	 * Abstract method that returns the name of the ship class that inherits this
	 * @return name
	 */
	public abstract String getName();
	
	/**
	 * Abstract method that returns the unique ship class identifier that will be used 
	 * on the board
	 * @return id
	 */
	public abstract char getShipID();
}
