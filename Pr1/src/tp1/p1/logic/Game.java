package tp1.p1.logic;
//Tiene que conocer a ZombieManager
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
	
	//métodos addPeashooter, addSunflower (col, fila), método reset(inicializa una partida, mirar si es el mismo código que cuando 
	//creamos la partida)
	//creamos metodo update, ejecuta game action y update, tercer y cuarto paso del run
	//podemos poner un método update dentro de sunflower y desde ahí lo hacemos, habrá que recorrer la lista desde ahí, también desde PeashooterList
	//el método update del SunflowerList, hacemos un for para ver cada sunflower, hacemos un update: sf.update, ve si está vivo, sf.get() y sf.setciclos()

}
