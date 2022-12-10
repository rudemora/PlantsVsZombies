package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

import tp1.p2.control.exceptions.GameException;


public class NoneCommand extends Command {

	public NoneCommand() {
		super(true);
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_NONE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_NONE_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_NONE_DETAILS+Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_NONE_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException {
		game.update();
		return new ExecutionResult(true);
	}

}