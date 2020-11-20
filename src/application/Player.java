package application;
import java.util.HashMap;

public interface Player {
	public void generateShips(char playerBoard[][], HashMap<Character, Ship> playerShipsList);
	public void bombard(char enemyShips[][], HashMap<Character, Ship> enemyShipsList);
}
