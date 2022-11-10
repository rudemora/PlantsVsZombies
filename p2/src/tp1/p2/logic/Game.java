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
	private GameObjectContainer lista;
	
    private static final int INITIAL_SUNCOINS = 50;
    private static final int INITIAL_CYCLE = 0;
    
    private static boolean playerQuits;
    
    private Level level;
    private long seed;
    private int cycle;
    private int sunCoins;
    private Random rand;
    private ZombiesManager Zombies;

    
    public Game (long s, Level l) {
    	this.reset(s, l);    	
    }
    
    public boolean execute (Command command) {
    	return command.execute(this).draw();
    }
    
    public boolean isFinished() {
    	if (this.Zombies.getRemainingZombies() == 0 && Zombies.zombiesDead()) { 
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
    	System.out.println(String.format(Messages.CONFIGURED_LEVEL, level.name()));
		System.out.println(String.format(Messages.CONFIGURED_SEED, seed));	
    }
    
    public void addSuncoins(int coins) {
    	sunCoins = sunCoins + coins;
    }
        
    public int getSuncoins() {
    	return sunCoins;
    }
   
    
    public ExecutionResult update() {
    	boolean add = this.addZombie();
    	cycle = cycle + 1;
    	this.lista.update(add);
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
        	return false;
    	}
    }
    
    private boolean addZombie() {
    	return Zombies.addZombie();  	
    }
    
    private void addGameObject(GameObject object) {
    	lista.addObject(object);
    }
    
    private boolean consumeCoins(GameObject object) {
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
    
    public void removeDead() {
    	lista.removeDead();
    }
    
    private boolean zombiesGana() {
    	return lista.zombiesGana();
    }
    
    public Level getLevel() {
    	return this.level;
    }
    
    public long getSeed() {
    	return this.seed;
    }
    
    //...
}