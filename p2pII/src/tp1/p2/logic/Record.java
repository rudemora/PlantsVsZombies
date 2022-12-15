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
		
	
	
	private static List<Record> records;
	
	private int puntuacion;
	
	private Level level;

	private boolean isNewRecord;

	
	
	private Record(Level level, int puntuacion)throws GameException  {
		
		//records.add(this);//ñapa
		//records.add(this);//ñapa
		//records.add(this);//ñapa
		//contador=0;//ñapa
		this.level= level; 
		this.puntuacion=puntuacion;
		isNewRecord=false;
		
		
		
	}
	
	public static Record loadRecord(Level level) throws GameException { 
		Record r = new Record(level,0);
		r.records= new ArrayList<>();
		r.readRecords();
		return r;
	}
	
	private void readRecords() throws GameException {
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
					if(record[0].equalsIgnoreCase(level.name())){
						isLevel=true;
					}
					Level lv=level; 
					for (Level l : Level.values()) {
						if (l.name().equalsIgnoreCase(record[0])) {
							
							lv= l;
							
						}
					
				    }
					/*this.records.get(contador).level=lv;//ñapa
					this.records.get(contador).puntuacion=puntos;//ñapa
					this.contador++;//ñapa*/
		
					Record newrecord= new Record(lv,puntos);
					records.add(newrecord);
					
					
					if(!isLevel) {
						/*this.records.get(contador).level=level;//ñapa
						this.records.get(contador).puntuacion=0;//ñapa
						contador++;//ñapa*/
						
						Record myrecord= new Record(level,0);
						records.add(myrecord);
						
					}
					
						
					
					
					
				} catch (NumberFormatException e) {
					throw new RecordException(Messages.RECORD_READ_ERROR, e);
				}catch(RecordException e) {
					throw e;
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
			for (int i = 0; i < records.size(); ++i) {
				if (records.get(i).level.equals(this.level)) {
					if(records.get(i).puntuacion<score) {
						records.get(i).puntuacion=score;
						isNewRecord=true;
					}
				}
			}
	}
	
	
		
	public void writeRecord() throws GameException{
		
		if (isNewRecord()) {
			BufferedWriter recordfile = null;
			try {
				recordfile = new BufferedWriter(new FileWriter(Messages.RECORD_FILENAME));
				recordfile.write(this.recordsToString());
			} catch (IOException e1) {
				throw new RecordException(e1.getMessage(),e1);
			} finally {
				if (recordfile != null) {
					try {
						recordfile.close();
					} catch (IOException e2) {
						throw new RecordException(e2.getMessage(), e2);					
					}
				}
			}
		}
		
	}
	
	private boolean isNewRecord() { //Para que lo quieres??
		return isNewRecord;
	}
	
	
	
	private int getRecord() {
		int record =  0;
		
		for (int i = 0; i <records.size(); ++i) {
			
			if (records.get(i).level.equals(this.level)) { 
				record = records.get(i).puntuacion;

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
			
				str.append(records.get(i).level.name() + ":").append(records.get(i).puntuacion).append(Messages.LINE_SEPARATOR);
		
		}
		return str.toString();
	}
}
