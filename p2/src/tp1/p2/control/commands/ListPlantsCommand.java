package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class ListPlantsCommand extends Command {
	
	
	
	@Override
	protected String getName() {
		return Messages.COMMAND_LIST_NAME;
	}
	@Override
	protected String getShortcut() {
		return Messages.COMMAND_LIST_SHORTCUT;
	}
	@Override
	public String getDetails() {
		return Messages.COMMAND_LIST_DETAILS+Messages.HELP_DETAILS_COMMAND_HELP_SEPARATOR;
	}
	@Override
	public String getHelp() {
		return Messages.COMMAND_LIST_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		System.out.println(Messages.AVAILABLE_PLANTS);
		for(Plant p: PlantFactory.getAvailablePlants()) {
			System.out.println(p.getDescription());

		}
		// TODO add your code here
		
		System.out.println();

		return new ExecutionResult(false);
	}

}