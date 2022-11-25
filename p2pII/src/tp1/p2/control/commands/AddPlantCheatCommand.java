package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class AddPlantCheatCommand extends Command {
	private int col;
	private int row;
	private String plantName;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		// TODO Auto-generated method stub
		return null;
	}

}
