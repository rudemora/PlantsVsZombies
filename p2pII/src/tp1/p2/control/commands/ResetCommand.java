package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;

public class ResetCommand extends Command {

	private Level level;

	private long seed;

	public ResetCommand() {
		
	}

	private ResetCommand(Level level, long seed) {
		this.level = level;
		this.seed = seed;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_RESET_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_RESET_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_RESET_DETAILS+Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_RESET_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException {
		if (level == null) {
			level = game.getLevel();
			seed =  game.getSeed();
		}
		game.reset(seed, level);
		return new ExecutionResult(true);
	}

	@Override
	public Command create(String[] parameters) throws GameException {
		try {
			if(parameters.length==3) {
				Level level = Level.valueOfIgnoreCase(parameters[1]);
				long seed = System.currentTimeMillis() % 1000;
				seed = Long.parseLong(parameters[2]);
				Command command= new ResetCommand(level, seed);
			return command;
			}
			else if (parameters.length == 1) {
				Command command = new ResetCommand();
				return command;
			}
			else {
				System.out.println(error(Messages.COMMAND_PARAMETERS_MISSING));
				return null;
			}
		}
		catch (Exception e) {
			System.out.println(error(Messages.INVALID_COMMAND));
			return null;
		}
	}
		
	

}