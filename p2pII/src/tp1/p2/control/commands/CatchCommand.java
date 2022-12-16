package tp1.p2.control.commands;


import tp1.p2.control.Command;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

import tp1.p2.control.exceptions.CommandExecuteException;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;

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
			game.tryToCatchObject(col, row);
			caughtSunThisCycle= true;
			return true;
		}
		else {
			throw new CommandExecuteException(Messages.SUN_ALREADY_CAUGHT);
		}
		
	}

	@Override
	public Command create(String[] parameters) throws GameException {
		if (parameters.length == 3) {
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
		if (parameters.length<3) {
			throw new CommandParseException(Messages.COMMAND_PARAMETERS_MISSING);
		}
		else {
			throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
		}
	}	
}