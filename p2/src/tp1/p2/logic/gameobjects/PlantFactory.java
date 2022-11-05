package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.Peashooter;
import tp1.p2.logic.gameobjects.Sunflower;
import tp1.p2.logic.GameWorld;


public abstract class PlantFactory {

	
	/* @formatter:off */
	private static final List<Plant> AVAILABLE_PLANTS = Arrays.asList(
		/*new Sunflower(),
		new Peashooter()*/
	);
	/* @formatter:on */

	public static boolean isValidPlant(String plantName) {
		for (Plant p : AVAILABLE_PLANTS) {
			// TODO add your code here
			p.getDescription();
		}

		return false;
	}
	
	

	/*public static Plant spawnPlant(String plantName, GameWorld game, int col, int row) {
		// TODO add your code here
		Plant plant = new Plant();
		return plant;
	}*/

	public static List<Plant> getAvailablePlants() {
		return Collections.unmodifiableList(AVAILABLE_PLANTS);
	}

	/*
	 * Avoid creating instances of this class
	 */
	protected PlantFactory() {
		
	}
	

}