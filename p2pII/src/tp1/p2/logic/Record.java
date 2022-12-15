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
	
	private boolean isNewRecord;
	
	
	private Record(Level level, int puntuacion)  {//throws GameException
		
		this.level= level; 
		this.puntuacion=puntuacion;
		isNewRecord=false;
		
		
	}
	
	public void loadRecord(Level level) throws GameException { 
//		for(int i=0; i<records.size(); i++) {
//			records[i]= new Record(i);
//		}
		readRecords(level);
		this.level=level;
		this.puntuacion=0;
	}
	
	private void readRecords(Level level) throws GameException {
		BufferedReader recordfile = null;
		try {
			recordfile = new BufferedReader(new FileReader(Messages.RECORD_FILENAME));
			String read;
			
			while((read = recordfile.readLine()) != null ) {
				String[] record = read.split(":");
				try {
					int puntos = Integer.parseInt(record[1]);
					if (puntos < 0) {
						throw new RecordException(Messages.RECORD_READ_ERROR);
					}
					boolean isLevel=false;
					for (int i=0; i<records.size(); i++) {
						if(record[0].equalsIgnoreCase(records.get(i).toString())) {
							isLevel=true;
							records.get(i).puntuacion=puntos;
						}
					}
					if(!isLevel) {
						boolean ok=false;
						while(!ok) {
							if() {//aqui tengo que conseguir sacar el Level level que tiene el string de record[0]
								ok=true;
								Level level= ;
							}
						}
						Record newrecord= new Record(level,puntos);
						records.add(newrecord);
						
					}
					
					
				} catch (NumberFormatException e) {
					throw new RecordException(Messages.RECORD_READ_ERROR, e);
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
	/* Cual es la diferencia entre el update y el save?? Es que no se que tengo que hacer aqui
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
	
	public void save(int score) throws GameException{
//		if (isNewRecord()) { Creo que no hace falta
			boolean encontrado= false;
			for (int i = 0; i < records.size(); ++i) {
				if (records.get(i).level.equals(this.level)) {
					encontrado=true;
					if(records.get(i).puntuacion<score) {
						records.get(i).puntuacion=score;
						this.isNewRecord=true; //Y luego cuando se escriba volverlos a poner todos a false (no se como lo ves)
					}
				}
			}
			if(!encontrado) { //creo un nuevo record en el array con puntuacion 0 porque sera 0
				Record newRecord= new Record(this.level, this.puntuacion);
				records.add(newRecord);
				
			}
	}
	
	
		
	public void writeRecord(Game game) throws RecordException{
		if (isNewRecord()) {
			BufferedWriter recordfile = null;
			try {
				recordfile = new BufferedWriter(new FileWriter(Messages.RECORD_FILENAME));
				recordfile.write(this.recordsToString());
			} catch (IOException e1) {
				throw new RecordException(e1);
			} finally {
				if (recordfile != null) {
					try {
						recordfile.close();
					} catch (IOException e2) {
						throw new RecordException(e2);					
					}
				}
			}
		}
		
	}
	
	private boolean isNewRecord() { //Para que lo quieres??
		return this.isNewRecord;
	}
	
	
	
	public int getRecord() {
		int record =  0;
		boolean encontrado=false;
		for (int i = 0; i <records.size(); ++i) {
			if (records.get(i).level.equals(this.level)) { //Esto qué hace no lo entiendo
				record = records.get(i).puntuacion;
				encontrado=true;
			}
		}
		
		return record;
	}
	
	public void showRecord() {
		System.out.println(level.toString() + " record is " +(this.getRecord()));
	}
	
	private String recordsToString() {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < records.size(); ++i) {
			if (records.get(i).level.equals(level)) {
				str.append(level + ":").append(records.get(i).puntuacion).append(Messages.LINE_SEPARATOR);
			}
		}
		return str.toString();
	}
}
