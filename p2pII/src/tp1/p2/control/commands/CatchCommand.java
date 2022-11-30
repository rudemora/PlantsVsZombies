package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

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
	public ExecutionResult execute(GameWorld game) {
		if (!caughtSunThisCycle) {
			if(game.tryToCatchObject(col, row)) {
				caughtSunThisCycle= true;
				game.removeDead();
				return new ExecutionResult(true);
			}
			else {
				System.out.println(error(Messages.INVALID_POSITION));
				return new ExecutionResult(false);
			}
		}
		else {
			System.out.println(error(Messages.SUN_ALREADY_CAUGHT));
			return new ExecutionResult(false);
		}
		
	}

	@Override
	protected Command create(String[] parameters) {
		if (parameters.length == 3) {
			try {
				int col = Integer.parseInt(parameters[1]);
				int row = Integer.parseInt(parameters[2]);
				Command command = new CatchCommand(col, row);
				return command;
			}
			catch (Exception e){
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