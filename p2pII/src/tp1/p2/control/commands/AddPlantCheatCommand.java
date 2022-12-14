package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.CommandExecuteException;//Importado por mi
import tp1.p2.control.exceptions.InvalidPositionException; //Importado por mi obviamente
import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.Game;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class AddPlantCheatCommand extends Command {
	private int col;
	private int row;
	private String plantName;
	
	public AddPlantCheatCommand() {
		
	}
	
	public AddPlantCheatCommand(int columna, int fila, String name) {
	 
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
	public boolean execute(GameWorld game) throws GameException{
		try {
			Plant plant = PlantFactory.spawnPlant(this.plantName, game, col, row);
			game.checkValidPlantPosition(col, row);
			game.addItem(plant); 
			game.update(); 
			return true;
			
		}
		finally {
			//Me obliga a incorporarlo??
		}
		
		
		
	}
	
	@Override
	public Command create(String[] parameters) throws GameException{
		if(parameters.length == 4) {
				try {
					String name = parameters[1];
					int col = Integer.parseInt(parameters[2]);
					int row = Integer.parseInt(parameters[3]);
					Command command= new AddPlantCheatCommand(col, row, name);
					return command;
				}
				catch( NumberFormatException nfe) {
					
					throw new CommandParseException(Messages.INVALID_POSITION.formatted(parameters[1], parameters[2]), nfe);
					
				}
			
				/*catch (InvalidPositionException e) { Creo que mejor esta en el execute
					throw new InvalidPositionException(Messages.INVALID_POSITION);
//					System.out.println(error(Messages.INVALID_POSITION));
//					return null;
			}*/
			
		}
		else {
			throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
			//System.out.println(error(Messages.COMMAND_PARAMETERS_MISSING));
//			return null;
		}
	}
}
