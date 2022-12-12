package tp1.p2.logic;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import tp1.p2.control.exceptions.InputOutputRecordException;
//import tp1.p2.logic.Game; quizá no hace falta
import tp1.p2.view.Messages;

public class Record {
	
	private static final String FILE = "record.txt";
	
	private static final String[] LEVELS = {"TEST", "EASY", "HARD"};
	
	private static final String NOT_A_NUMBER = "the record is not a proper long number";
	
	private static final String DEFAULT_RECORD = "Creating default record for level ";
	
	private Long[] records;
	
	private Game game;
	
	public Record(Game game) throws InputOutputRecordException {
		this.game = game;
		this.records = new Long[LEVELS.length];
		for (int i = 0; i < LEVELS.length; ++i) {
			this.records[i] = Long.MAX_VALUE;
		}
		readRecords();
	}
	
	private void readRecords() throws InputOutputRecordException {
		BufferedReader recordfile = null;
		try {
			recordfile = new BufferedReader(new FileReader(FILE));
			String read;
			while((read = recordfile.readLine()) != null) {
				String[] record = read.split(":");
				boolean levelFound = false;
				int i = 0;
				while (!levelFound && i < LEVELS.length) {
					if (record[0].equalsIgnoreCase(LEVELS[i])) {
						levelFound = true;
						try {
						this.records[i] = Long.parseLong(record[1]);
						} catch (NumberFormatException e) {
							throw new InputOutputRecordException(String.format("[ERROR]: Command %s: %s%n%n", "record", NOT_A_NUMBER));
						}
					} else i++;
				}
			}
			if (getRecord() == Long.MAX_VALUE) {
				System.out.println(DEFAULT_RECORD + "'" + game.getLevel().toString() + "'");
			}
		} catch(IOException e1) {
			throw new InputOutputRecordException(e1.getMessage(), e1);
		} finally {
			if (recordfile != null) {
				try {
					recordfile.close();
				}
				catch (IOException e2) {
					throw new InputOutputRecordException(e2.getMessage(), e2);
				}
			}
		}
	}
	
	public void writeRecord(Game game) throws InputOutputRecordException{
		if (isNewRecord()) {
			saveNewRecord();
		}
		BufferedWriter recordfile = null;
		try {
			recordfile = new BufferedWriter(new FileWriter(FILE));
			recordfile.write(this.recordsToString());
		} catch (IOException e1) {
			throw new InputOutputRecordException(e1);
		} finally {
			if (recordfile != null) {
				try {
					recordfile.close();
				} catch (IOException e2) {
					throw new InputOutputRecordException(e2);					
				}
			}
		}
	}
	
	public boolean isNewRecord() {
		return game.getElapsedTime() < getRecord();
	}
	
	private void saveNewRecord() {
		if (isNewRecord()) {
			for (int i = 0; i < LEVELS.length; ++i) {
				if (LEVELS[i].equalsIgnoreCase(game.getLevel().toString())) {
					this.records[i] = this.game.getElapsedTime(); 
				}
			}
		}
	}
	
	public Long getRecord() {
		long record = (long) 0;
		for (int i = 0; i < LEVELS.length; ++i) {
			if (LEVELS[i].equalsIgnoreCase(game.getLevel().toString())) {
				record = this.records[i];
			}
		}
		return record;
	}
	
	public void showRecord() {
		System.out.println(game.getLevel().toString() + " record is " + formatTime(this.getRecord()));
	}
	
	private static String formatTime(long t) {
		return String.format("%.2f s", t / 1000.0);
	}
	
	private String recordsToString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < LEVELS.length; ++i) {
			if (this.records[i] != Long.MAX_VALUE) {
				str.append(LEVELS[i] + ":").append(records[i]).append(Messages.LINE_SEPARATOR);
			}
		}
		return str.toString();
	}
}
