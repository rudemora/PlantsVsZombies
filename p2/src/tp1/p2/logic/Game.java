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
    public static final int INITIAL_CYCLE = 0;
    
    protected static boolean playerQuits;
    
    protected Level level;
    protected long seed;
    protected int cycle;
    protected int remainingZombies;
    protected int sunCoins;
    
    public Game (long s, Level l) {//FALTA POR HACER
    	playerQuits=false;
    	lista = new GameObjectContainer();
    	this.seed = s;
    	this.level = l;
    	cycle = INITIAL_CYCLE;
    	remainingZombies = l.getNumberOfZombies();
    	sunCoins = INITIAL_SUNCOINS;
    	
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
    	return cycle;
    }
    
    public void addCycle() {
    	cycle = cycle + 1;
    }
    
    public int getSuncoins() {
    	return sunCoins;
    }
    
    public int getRemainingZombies() {
    	return remainingZombies;
    }
    
    public ExecutionResult update() {
    	return new ExecutionResult(true);
    }
    
    public void playerQuits() {
    	playerQuits = true;
    }
    
    public void addObject(GameObject object) {
    	if(object.canAdd()) {
    		this.addGameObject(object);
    		this.addCycle();
    		this.consumeCoins(object);
    	}
    	
    	
    }
    
    public void addGameObject(GameObject object) {
    	
    	lista.addObject(object);
    	
    }
    
    public int consumeCoins(GameObject object) {
    	
    	int coste = object.getCost();
    	this.sunCoins = this.sunCoins-coste;
    	return this.sunCoins;
    }
    public boolean isPositionEmpty(int x, int y) {
    	return lista.isPositionEmpty(x, y);
    }
    public String positionToString(int col, int row) {
		String escribe= "";
		if(!lista.isPositionEmpty(col, row)) {
			int endurance = lista.getEndurance(col, row);
			String icon= lista.getSymbol(col,row);
			return Messages.GAME_OBJECT_STATUS.formatted(icon,endurance);
			
		}
		
		return escribe;
	}
    

    
    //...
}