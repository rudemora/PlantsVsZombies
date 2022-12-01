package tp1.p2.logic;

import java.util.Random;


import tp1.p2.logic.gameobjects.Sun;


public class SunsManager {

	private static final int COOLDOWN_RANDOM_SUN = 5;

	private GameWorld game;

	private Random rand;

	private int cooldown;


	
	
	protected SunsManager(GameWorld game, Random rand) {
		this.game = game;
		this.rand = rand;
		this.cooldown = COOLDOWN_RANDOM_SUN;
		Sun sun = new Sun();
		sun.setInitialgeneratedSuns();
	}

	protected int getGeneratedSuns() {
		Sun  sun = new Sun();
		return sun.getGeneratedSuns();
	}

	//HACER EL CAUGHTSUNS

	protected void update() {
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

	protected void addSun() {
		int columna = getRandomInt(GameWorld.NUM_COLS);
		int fila = getRandomInt(GameWorld.NUM_ROWS);
		Sun s = new Sun();
		Sun sun = s.create(game, columna, fila);
		game.addGameItem(sun);		
	}

}

