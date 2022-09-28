package tp1.p1.logic;

import java.util.Random;

import tp1.p1.control.Level;


public class Game {
	
	public static int NUM_COLS = 8;
	public static int NUM_ROWS = 4;
	
	private long seed;
	private Level level;
	
	public Game (long s, Level l) {
		this.seed = s;
		this.level = l;
	}
	
	private Random rand;
	
	private void update() {
		
	}
	
	public String positionToString(int col, int row) {
		return  ("col"); // hacer la función
	}
	

}
