package tp1.p2.logic;
import tp1.p2.control.Level;
import tp1.p2.view.Messages;
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
 
    public ExecutionResult update() {
    	return new ExecutionResult(true);
    }
    
    public void playerQuits() {
    	playerQuits = true;
    }
    
    public void addGameObject(GameObject object) {
    	lista.add(object);
    }
    public String positionToString(int col, int row) {
		String escribe= "";
		if(!lista.isPositionEmpty(col, row)) {
			int endurance = lista.endurance(col, row);
			String icon= lista.getsymbol(col,row);
			return Messages.GAME_OBJECT_STATUS.formatted(icon,endurance);
			
		}
		
		return escribe;
	}
    //...
}