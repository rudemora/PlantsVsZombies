package tp1.p2.logic;

import java.util.Random;

import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Sun;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;

public class SunsManager {

	private static final int COOLDOWN_RANDOM_SUN = 5;

	private GameWorld game;

	private Random rand;

	private int cooldown;

	private int generatedSuns;
	
	
	
	public SunsManager(GameWorld game, Random rand) {
		this.game = game;
		this.rand = rand;
		this.cooldown = COOLDOWN_RANDOM_SUN;
		this.generatedSuns = 0;
		
		
		// TODO add your code here
	}

	

	public int getGeneratedSuns() {
		return this.generatedSuns;
	}

	public void update() {
		if (cooldown == 0) {
			addSun();
			cooldown = COOLDOWN_RANDOM_SUN;
			} 
		else {
			cooldown--;
		}
	}

	private int getRandomInt(int bound) {
		return this.rand.nextInt(bound);
	}

	public void addSun() {
		int columna = getRandomInt(GameWorld.NUM_COLS);
		int fila = getRandomInt(GameWorld.NUM_ROWS);
		Sun s = new Sun();
		Sun sun = s.create(game, columna, fila);
		game.addGameItem(sun);
		generatedSuns = generatedSuns + 1;
		
	}

	
	
}

