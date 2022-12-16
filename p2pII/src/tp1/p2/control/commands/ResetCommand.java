package tp1.p2.control.commands;

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
		return true;
	}

	@Override
	public Command create(String[] parameters) throws GameException {
		
		if(parameters.length==3) {
				try {
					Level level = Level.valueOfIgnoreCase(parameters[1]);
					long seed = System.currentTimeMillis() % 1000;
					seed = Long.parseLong(parameters[2]);
					Command command= new ResetCommand(level, seed);
					return command;
				}
				catch( NumberFormatException nfe) {
					
					throw new CommandParseException(Messages.INVALID_COMMAND);
					
				}
				
			
			}
			else if (parameters.length == 1) {
				Command command = new ResetCommand();
				return command;
			}
			else {
				throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
			}
			
		}
		
	}
		
	

