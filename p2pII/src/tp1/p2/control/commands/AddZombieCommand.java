package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;
import tp1.p2.view.Messages;

import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;

public class AddZombieCommand extends Command {

	private int zombieIdx;

	private int col;

	private int row;

	
	public AddZombieCommand() {

	}

	private AddZombieCommand(int col, int row, int zombieIdx) {
		this.col = col;
		this.row = row;
		this.zombieIdx = zombieIdx;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_ADD_ZOMBIE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_ADD_ZOMBIE_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_ADD_ZOMBIE_DETAILS+Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_ADD_ZOMBIE_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException {
		Zombie zombie = ZombieFactory.spawnZombie(this.zombieIdx, game, this.col, this.row);
		if (zombie != null) {
			if (game.addItem(zombie)) {
				game.update();
				return new ExecutionResult(true);	
			}
			else {
				System.out.print(error(Messages.INVALID_POSITION));
				return new ExecutionResult(false);
			}
		}
		else {
			System.out.print(error(Messages.INVALID_GAME_OBJECT));
			return new ExecutionResult(false);
		}		
	}
	
	
	@Override
	public Command create(String[] parameters) throws GameException {
		if(parameters.length == 4) {
			try {
				int type = Integer.parseInt(parameters[1]);
				int col = Integer.parseInt(parameters[2]);
				int row = Integer.parseInt(parameters[3]);
				Command command= new AddZombieCommand(col, row, type);
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