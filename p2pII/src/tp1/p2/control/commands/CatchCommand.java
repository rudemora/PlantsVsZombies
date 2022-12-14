package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

import tp1.p2.control.exceptions.CommandExecuteException;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.control.exceptions.NotCatchablePositionException;

public class CatchCommand extends Command {

	private static boolean caughtSunThisCycle;

	private int col;

	private int row;

	public CatchCommand() {
		
	}
	
	@Override
	protected void newCycleStarted() {
		caughtSunThisCycle = false;
	}

	private CatchCommand(int col, int row) {
		this.col = col;
		this.row = row;
		
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_CATCH_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_CATCH_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_CATCH_DETAILS+Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_CATCH_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException {
		if (!caughtSunThisCycle) {
			try {
				game.tryToCatchObject(col, row);
				caughtSunThisCycle= true;
				return true;
			}
			catch(NotCatchablePositionException e) {
				throw new CommandExecuteException(e.toString(), e);
			}
		}
		else {
			throw new GameException(error(Messages.SUN_ALREADY_CAUGHT));
		}
		
	}

	@Override
	public Command create(String[] parameters) throws GameException {
		if (parameters.length == 3) {
			try {
				try {
					int col = Integer.parseInt(parameters[1]);
					int row = Integer.parseInt(parameters[2]);
					Command command = new CatchCommand(col, row);
					return command;
				}
				catch( NumberFormatException nfe) {
					
					throw new CommandParseException(Messages.INVALID_POSITION.formatted(parameters[1], parameters[2]), nfe);
					
				}
				
			}
			
			finally {
				
			}
		}
		else {
			throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
//			System.out.println(error(Messages.COMMAND_PARAMETERS_MISSING));
//			return null;
		}
	}	
}