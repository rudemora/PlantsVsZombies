package tp1.p2.logic;
import tp1.p2.control.Level;
import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;

public class Game implements GameStatus, GameWorld {

    public static final int INITIAL_SUNCOINS = 50;

    protected static boolean playerQuits;
    
    public Game (long seed, Level level) {//FALTA POR HACER
    	
    }
    public boolean execute (Command command,Game game) {//FALTA POR HACER
    	
    	return command.execute(game).draw();
    }
    public boolean isFinished() {
    	return false;
    }
    public boolean isPlayerQuits() {
    	return false;
    }
    public int getCycle() {
    	return 1;
    }
    public int getSuncoins() {
    	return 1;
    }
    public String positionToString(int x, int y) {
		return "hola";
	}
    public ExecutionResult update() {
    	return new ExecutionResult(true);
    }
    //...
}