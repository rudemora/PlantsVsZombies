package tp1.p2.logic;
import tp1.p2.control.Level;
import tp1.p2.view.Messages;
import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.gameobjects.GameObject;
 //añadido para que addplant funcione
import java.util.Random;			   //añadido para nuevo atributo
 //añadido por nosotros para inicializarlo
import static tp1.p2.view.Messages.error; //error suncoins insuficientes






public class Game implements GameStatus, GameWorld {
	public GameObjectContainer lista;
	
    public static final int INITIAL_SUNCOINS = 50;
    public static final int INITIAL_CYCLE = 0;
    
    protected static boolean playerQuits;
    
    protected Level level;
    protected long seed;
    protected int cycle;
    protected int sunCoins;
    private Random rand;
    private ZombiesManager Zombies;

    
    public Game (long s, Level l) {//FALTA POR HACER
    	this.reset(s, l);    	
    }
    public boolean execute (Command command) {//FALTA POR HACER
    	
    	return command.execute(this).draw();
    }
    public boolean isFinished() {
    	if (this.Zombies.getRemainingZombies() == 0 && Zombies.zombiesDead()) {    // está bien utilizar esto o es mejor crear un atributo??
    		return true; 
    	}
    	else {
    		if (zombiesGana()) {
    			return true;
    		}
    		else {
        		return false;
    		}
    	}
    }
    public boolean isPlayerQuits() {
    	return playerQuits;
    }
    public int getCycle() {
    	return cycle;
    }
    
    public void reset(long seed, Level level) {
    	playerQuits=false;
    	lista = new GameObjectContainer();
    	this.seed = seed;
    	this.level = level;
    	this.rand = new Random(this.seed);
    	this.Zombies= new ZombiesManager(this,level,rand);
    	cycle = INITIAL_CYCLE;
    	sunCoins = INITIAL_SUNCOINS;
    }
    
    public int getSuncoins() {
    	return sunCoins;
    }
    
	public void setSuncoins(int coins) {
		sunCoins = coins;
	}
    
    
   
    
    public ExecutionResult update() {
    	this.lista.update();
    	this.addZombie();
    	return new ExecutionResult(true);
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
    
    private void addZombie() {
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
			GameItem item = this.getGameItemInPosition(col, row);
			return item.toString();
			
		}
		
		return escribe;
	}
    
    public int getRemainingZombies() {
    	return this.Zombies.getRemainingZombies();
    }
    
    public GameItem getGameItemInPosition(int col, int row) {
    	return lista.getGameItemInPosition(col, row);
    }

    public boolean jugadorGanador() {
    	return this.Zombies.getRemainingZombies() == 0;
    }
    
    public void matarZombie() {
    	Zombies.matarZombie();
    }
    
    public boolean zombiesGana() {
    	return lista.zombiesGana();
    }
    
    //...
}