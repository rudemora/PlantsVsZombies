package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import tp1.p2.logic.GameWorld;


import tp1.p2.control.exceptions.GameException;

public class ZombieFactory {

	/* @formatter:off */
	public static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
		new ZombieComun(),
		new BucketHead(),
		new Sporty(),
		new ExplosiveZombie()
	);
	/* @formatter:on */

	public static boolean isValidZombie(int zombieIdx) {
		return zombieIdx >= 0 && zombieIdx < AVAILABLE_ZOMBIES.size();
	}

	public static Zombie spawnZombie(int zombieIdx, GameWorld game, int col, int row) throws GameException  {
		if (!isValidZombie(zombieIdx)) {
			throw new GameException(Messages.INVALID_GAME_OBJECT);
			//return null;
		}
		else {
			Zombie zombieType = AVAILABLE_ZOMBIES.get(zombieIdx);
			Zombie zombie = zombieType.create(game, col, row);
			return zombie;
		}
	}

	public static List<Zombie> getAvailableZombies() {
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}

	/*
	 * Avoid creating instances of this class
	 */
	
}