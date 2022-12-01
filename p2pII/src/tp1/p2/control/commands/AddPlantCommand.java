package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class AddPlantCommand extends Command implements Cloneable {

	private int col;

	private int row;
	
	private String plantName;
	
	public AddPlantCommand() {
		
	}
	
	private AddPlantCommand(int columna, int fila, String name) {
		this.col=columna;
		this.row= fila;
		this.plantName=name;
		
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_ADD_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_ADD_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_ADD_DETAILS+Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_ADD_HELP;
	}


	@Override
	public ExecutionResult execute(GameWorld game) {
		
		
				
		Plant plant = PlantFactory.spawnPlant(this.plantName, game, col, row);
		if (plant != null) {
			if(game.addItem(plant)) {
				if (game.consumeCoins(plant, plant.getCost())) {
					game.update(); 
					return new ExecutionResult(true);
				}
				else {
					System.out.println(error(Messages.NOT_ENOUGH_COINS));
	    			return new ExecutionResult(false);
				}	
			}
			else {
				return new ExecutionResult(false);
			}
		}
		else {
			System.out.println(error(Messages.INVALID_GAME_OBJECT));
			return new ExecutionResult(false);
		}
		
		

	}

	@Override
	protected Command create(String[] parameters) {
		if(parameters.length == 4) {
			try {
				String name = parameters[1];
				int col = Integer.parseInt(parameters[2]);
				int row = Integer.parseInt(parameters[3]);
				Command command= new AddPlantCommand(col, row, name);
				return command;
			}
			catch (Exception e) {
				System.out.println(error(Messages.INVALID_POSITION));
				return null;
			}
		}
		else {
			System.out.println(error(Messages.COMMAND_PARAMETERS_MISSING));
			return null;
		}		
	}

}

