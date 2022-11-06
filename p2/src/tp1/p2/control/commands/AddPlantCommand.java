package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.Game;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class AddPlantCommand extends Command implements Cloneable {

	private int col;

	private int row;

	private String plantName;

	private boolean consumeCoins;
	
	private Game game;
	
	public AddPlantCommand() {
		super(true);
	}

	public AddPlantCommand(boolean consumeCoins, int columna, int fila, String name) {
		super(consumeCoins);
		this.consumeCoins = consumeCoins;
		this.col = columna;
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
		// TODO add your code here	
		Plant plant = PlantFactory.spawnPlant(this.plantName, game, col, row);
		game.addPlant(plant);
		return new ExecutionResult(true);
	}

	@Override
	public Command create(String[] parameters) {
		// TODO add your code here
		if(parameters.length == 4) {
			String name = parameters[1];
			int col = Integer.parseInt(parameters[2]);
			int row = Integer.parseInt(parameters[3]);
			Command command= new AddPlantCommand(true, col, row, name);
		return command;
		}
		else {
			System.out.println(Messages.COMMAND_PARAMETERS_MISSING);
			return null;
		}
		
	}
}