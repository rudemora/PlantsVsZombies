package tp1.p2.logic;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import tp1.p2.control.Level;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.control.exceptions.RecordException;
//import tp1.p2.logic.Game; quizá no hace falta
import tp1.p2.view.Messages;
import java.util.List;
import java.util.ArrayList;

public class Record {
		
	
	
	private static List<Record> records = new ArrayList<>(3);
	
	private int puntuacion;
	
	private Level level;
	
	
	private Record(int i) throws GameException {
		puntuacion=0; 
		if (i==0) level=EASY
		
		
	}
	
	public void loadRecord(String level) throws GameException { //así o con Level level
		for(int i=0; i<records.size(); i++) {
			records[i]= new Record(i);
		}
		readRecords();
	}
	
	private void readRecords() throws GameException {
		BufferedReader recordfile = null;
		try {
			recordfile = new BufferedReader(new FileReader(Messages.RECORD_FILENAME));
			String read;
			
			while((read = recordfile.readLine()) != null ) {
				String[] record = read.split(":");
				int i = 0;
				while (i < LEVELS.length && !find) {
					if (record[0].equalsIgnoreCase(LEVELS[i])) {
						try {
						int puntos = Integer.parseInt(record[1]);
						if (puntos < 0) {
							throw new RecordException(Messages.RECORD_READ_ERROR);
						}
						records[i] = puntos;
						find = true;
						} catch (NumberFormatException e) {
							throw new RecordException(Messages.RECORD_READ_ERROR, e);
						}
					} else i++;
				}
			}
			
		} catch(IOException e1) {
			throw new RecordException(e1.getMessage(), e1);
		} finally {							
			if (recordfile != null) {
				try {
					recordfile.close();
				}
				catch (IOException e2) {
					throw new RecordException(e2.getMessage(), e2);
				}
			}
		}
	}
	/*
	public void update() throws GameException {
		if (isNewRecord()) {
			for (int i = 0; i < LEVELS.length; i = i + 1) { // qué ocurre?
				if (LEVELS[i].equalsIgnoreCase(game.getLevel().toString())) {
					records[i] = game.getScore();
				}
			//return true;
			}
			
		}
		//return false;
	}*/
	
	public void save() throws GameException{
		if (isNewRecord()) {
			for (int i = 0; i < LEVELS.length; ++i) {
				if (LEVELS[i].equalsIgnoreCase(game.getLevel().toString())) {
					records[i] = game.getScore();
				}
			}
		}
		/*
		if (isNewRecord()) {
		BufferedWriter recordfile = null;
		try {
			recordfile = new BufferedWriter(new FileWriter(FILE));
			recordfile.write(this.recordsToString());
		} catch (IOException e1) {
			throw new RecordException(Messages.RECORD_WRITE_ERROR, e1);
		} finally {
			if (recordfile != null) {
				try {
					recordfile.close();
				} catch (IOException e2) {
					throw new RecordException(Messages.RECORD_WRITE_ERROR, e2);					
				}
			}
		}
		}*/
	}
	
	private boolean isNewRecord() {
		return game.getScore() > getRecord();
	}
	
	
	
	public int getRecord() {
		int record =  0;
		for (int i = 0; i < LEVELS.length; ++i) {
			if (LEVELS[i].equalsIgnoreCase(game.getLevel().toString())) { //Esto qué hace no lo entiendo
				record = records[i];
			}
		}
		return record;
	}
	
	public void showRecord() {
		System.out.println(game.getLevel().toString() + " record is " +(this.getRecord()));
	}
	
	private String recordsToString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < LEVELS.length; ++i) {
			if (game.getLevel().toString().equalsIgnoreCase(LEVELS[i]) && records[i] != 0) {
				str.append(LEVELS[i] + ":").append(records[i]).append(Messages.LINE_SEPARATOR);
			}
		}
		return str.toString();
	}
}
