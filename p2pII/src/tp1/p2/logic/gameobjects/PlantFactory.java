package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;

public class PlantFactory {

	/* @formatter:off */
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		new Sunflower(),
		new Peashooter(),
		new WallNut(),
		new CherryBomb()
	);
	/* @formatter:on */

	public static boolean isValidPlant(String plantName) {
		for (Plant p : AVAILABLE_PLANTS) {
			if (p.getName().equalsIgnoreCase(plantName)|| p.getSymbol().equalsIgnoreCase(plantName)) {
				return true;
			}
		}
		return false;	
	}

	public static Plant spawnPlant(String plantName, GameWorld game, int col, int row) {
		if (!isValidPlant(plantName)) {
			return null;
		}
		else {
			for (Plant p : AVAILABLE_PLANTS) {
				if (p.getName().equalsIgnoreCase(plantName)|| p.getSymbol().equalsIgnoreCase(plantName)) {
					Plant planta = p.create(game, col, row);
					return planta;
				}
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