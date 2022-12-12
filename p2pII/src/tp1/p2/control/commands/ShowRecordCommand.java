package tp1.p2.control.commands;
import tp1.p2.control.Command;
import tp1.p2.control.exceptions.CommandExecuteException;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.control.exceptions.InputOutputRecordException;
import tp1.p2.logic.GameWorld;

public class ShowRecordCommand extends Command {

	private static final String NAME = "record";

	private static final String DETAILS = "rec[o]rd";

	private static final String SHORTCUT = "o";

	private static final String HELP = "show level record";

	public ShowRecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(GameWorld game) throws InputOutputRecordException, CommandExecuteException {	//llamamos a la función clearRoad() de game
		game.showRecord();
		return false;
	}

}
