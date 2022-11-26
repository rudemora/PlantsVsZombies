package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class AddPlantCheatCommand extends Command {
	private int col;
	private int row;
	private String plantName;
	private boolean consumeCoins;
	public AddPlantCheatCommand() {
		
	}
	
	public AddPlantCheatCommand(int columna, int fila, String name) {
	    this.consumeCoins=false;
		this.col=columna;
		this.row= fila;
		this.plantName=name;
		
	}
	
	@Override
	protected String getName() {
		return Messages.COMMAND_CHEAT_PLANT_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_CHEAT_PLANT_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_CHEAT_PLANT_DETAILS+Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR;
	}
	
	
	
	@Override
	public String getHelp() {
		return Messages.COMMAND_CHEAT_PLANT_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		// TODO Auto-generated method stub
		Plant plant = PlantFactory.spawnPlant(this.plantName, game, col, row);
		if (col>= 0 && col < Game.NUM_COLS && row>= 0 && row < Game.NUM_ROWS) {
			
			if(game.addItem(plant, this.consumeCoins)) {
			game.update(); 
			game.removeDead();
			return new ExecutionResult(true);
			}	
		}
		else {
			System.out.print(error(Messages.INVALID_POSITION));
		}
		return new ExecutionResult(false);
	}
	
	@Override
	public Command create(String[] parameters) {
		// TODO add your code here		
		if(parameters.length == 4) {
			String name = parameters[1];
			int col = Integer.parseInt(parameters[2]);
			int row = Integer.parseInt(parameters[3]);
			Command command= new AddPlantCheatCommand(col, row, name);
		return command;
		}
		else {
			System.out.println(error(Messages.COMMAND_PARAMETERS_MISSING));
			return null;
		}
		
	}
}
