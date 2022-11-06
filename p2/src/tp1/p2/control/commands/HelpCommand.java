package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class HelpCommand extends Command {

	public HelpCommand() {
		super(false);
	}
	
	@Override
	protected String getName() {
		return Messages.COMMAND_HELP_NAME ;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_HELP_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_HELP_DETAILS+Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_HELP_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		StringBuilder buffer = new StringBuilder(Messages.HELP_AVAILABLE_COMMANDS);

		for (Command command : Command.getAvailableCommands()) {
			/* @formatter:off */
			buffer.append(Messages.LINE_SEPARATOR);
			// TODO add your code here
			buffer.append(command.getDetails());			
			buffer.append(command.getHelp());
			/* @formatter:on */
		}

		System.out.println(buffer.toString());
		return new ExecutionResult(false);

		
	} 
	
}