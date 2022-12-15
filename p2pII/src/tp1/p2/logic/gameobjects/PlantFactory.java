package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.control.exceptions.CommandExecuteException;
import tp1.p2.control.exceptions.GameException;

import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class PlantFactory {

	/* @formatter:off */
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		new Sunflower(),
		new Peashooter(),
		new WallNut(),
		new CherryBomb()
	);
	/* @formatter:on */

	public static void isValidPlant(String plantName) throws GameException{
		boolean ok=true;
		for (Plant p : AVAILABLE_PLANTS) {
			if (p.getName().equalsIgnoreCase(plantName)|| p.getSymbol().equalsIgnoreCase(plantName)) {
				ok=false;
			}
		}
		if(ok) {
			throw new CommandExecuteException(Messages.INVALID_GAME_OBJECT); //No se que tipo de excecpion tiene que ser esta
		}
	}

	public static Plant spawnPlant(String plantName, GameWorld game, int col, int row) throws GameException {
		
			isValidPlant(plantName);
			for (Plant p : AVAILABLE_PLANTS) {
				if (p.getName().equalsIgnoreCase(plantName)|| p.getSymbol().equalsIgnoreCase(plantName)) {
					Plant planta = p.create(game, col, row);
					return planta;
				}
			}
			return null;
	}
		
	public static Iterable<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}

	/*
	 * Avoid creating instances of this class
	 */
	
}