package tp1.p2.logic;
import tp1.p2.control.Level;
import tp1.p2.view.Messages;
import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.Plant; //añadido para que addplant funcione
import java.util.Random;			   //añadido para nuevo atributo
import tp1.p2.logic.ZombiesManager;	   //añadido por nosotros para inicializarlo
import static tp1.p2.view.Messages.error; //error suncoins insuficientes

public class Game implements GameStatus, GameWorld {
	public GameObjectContainer lista;
	
    public static final int INITIAL_SUNCOINS = 50;
    public static final int INITIAL_CYCLE = 0;
    
    protected static boolean playerQuits;
    
    protected Level level;
    protected long seed;
    protected int cycle;
    protected int remainingZombies;
    protected int sunCoins;
    private Random rand;
    private ZombiesManager Zombies;
    
    public Game (long s, Level l) {//FALTA POR HACER
    	playerQuits=false;
    	lista = new GameObjectContainer();
    	this.seed = s;
    	this.level = l;
    	this.rand = new Random(this.seed);
    	this.Zombies= new ZombiesManager(this,level,rand);
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
    
    private void addCycle() {
    	cycle = cycle + 1;
    }
    
    public int getSuncoins() {
    	return sunCoins;
    }
    
    public int getRemainingZombies() {
    	return remainingZombies;
    }
    
    public int restarZombies() {
    	return remainingZombies--;
    }
    
    public ExecutionResult update() {
    	for(int col =0;col<Game.NUM_COLS;col=col+1) {
    		for(int row =0;row<Game.NUM_ROWS;row = row+1) {
    			GameItem item = this.getGameItemInPosition(col, row);
    			if(item != null ) {  
    				item.receiveZombieAttack(this.damage);
    				return new ExecutionResult(true);
    			}
    		}
    	}
    }
     
    public GameItem getGameItemInPosition(int col, int row) { //quizá cambiar por getGameItemInContainer
    	
    }
    
    public void playerQuits() {
    	playerQuits = true;
    }
    
    public boolean addObject(GameObject object) {    	
    	if(object.canAdd()) {
    		if (this.consumeCoins(object)) {
    			this.addGameObject(object);
    			return true;
    		}
    		else {
    			System.out.println(error(Messages.NOT_ENOUGH_COINS));
    			return false;
    		}
    	}
    	else {
        	System.out.println(error(Messages.INVALID_POSITION));    			
        	return false;
    	}
    		
    	
    }
    
    public void addZombie() {
    	Zombies.addZombie();
    	cycle = cycle + 1;  	
    }
    
    public void addGameObject(GameObject object) {
    	lista.addObject(object);
    }
    
    public boolean consumeCoins(GameObject object) {
    	int coste = object.getCost();
    	if(coste <= this.sunCoins) {
        	this.sunCoins = this.sunCoins-coste;
        	return true;
    	}
    	return false;
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