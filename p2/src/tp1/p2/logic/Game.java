package tp1.p2.logic;
import tp1.p2.control.Level;
import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Plant; //añadido para que addplant funcione

public class Game implements GameStatus, GameWorld {
	private GameObjectContainer lista;
	
    public static final int INITIAL_SUNCOINS = 50;
    public static final int CYCLE = 0;
    
    protected static boolean playerQuits;
    
    public Game (long seed, Level level) {//FALTA POR HACER
    	playerQuits=false;
    	lista = new GameObjectContainer();
    }
    public boolean execute (Command command) {//FALTA POR HACER
    	
    	return command.execute(this).draw();
    }
    public boolean isFinished() {
    	return false;
    }
    public boolean isPlayerQuits() {
    	return playerQuits;
    }
    public int getCycle() {
    	return CYCLE;
    }
    public int getSuncoins() {
    	return INITIAL_SUNCOINS;
    }
    public String positionToString(int x, int y) {
		return "aaa";
	}
    public ExecutionResult update() {
    	return new ExecutionResult(true);
    }
    
    public void playerQuits() {
    	playerQuits = true;
    }
    
    public void addGameObject(GameObject object) {
    	lista.add(object);
    }
    //...
}