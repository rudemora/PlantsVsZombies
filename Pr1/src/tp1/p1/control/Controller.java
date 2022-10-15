package tp1.p1.control;
//import java.io.PrintStream;
//Implementar código para imprimir mensaje(por ej, cuando termina el juego)
import static tp1.p1.view.Messages.*;
import java.util.Scanner;

import tp1.p1.logic.Game;
import tp1.p1.logic.gameobjects.*;
import tp1.p1.view.GamePrinter;
import tp1.p1.view.Messages;
/**
 * Accepts user input and coordinates the game execution logic.
 *
 */ 
public class Controller {//traduce la interación del usuario a acciones del juego

	private Game game;

	private Scanner scanner;

	private GamePrinter gamePrinter;
	
	
	private int count_cycles;
	private int remaining_zombies;
	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gamePrinter = new GamePrinter(game);
		this.count_cycles = 0;
		this.remaining_zombies = game.getRemainingZombies(); //Lo sacamos del level pero aun no sabemos
	}
	
	
	/**
	 * Draw / Paint the game.
	 */
	private void printGame() {
		System.out.println(String.format(Messages.NUMBER_OF_CYCLES, this.getCountCycles()));
		System.out.println(String.format(Messages.NUMBER_OF_COINS, game.getSuncoins()));
		System.out.println(String.format(Messages.REMAINING_ZOMBIES, this.game.getRemainingZombies()));
		System.out.println(gamePrinter);
	}

	/**
	 * Prints the final message once the match is finished.
	 */
	public void printEndMessage() {
		System.out.println(gamePrinter.endMessage());
	}

	/**
	 * Show prompt and request command.
	 *
	 * @return the player command as words
	 */
	//Las opciones del usuario solo se muestran por pantalla si el usuario pide informacion
	private String[] prompt() { 
		System.out.print(Messages.PROMPT);//Muestra por pantalla lo del comman
		String line = scanner.nextLine();//Scanner es la forma por la que se capturan l�nas escritas por el usuario
		String[] words = line.toLowerCase().trim().split("\\s+");//toLowerCase para pasar todo a minusculas  Trim para quitar los blancos y split para dividir el texto en array
		System.out.println(Messages.debug(line));

		return words;//Me devuelve lo que ha metido el usuario
	}
	

	
	private boolean swich(String[]lectura) {
		switch(lectura[0]){//Para leer lo que inserte el usuario desde Command
		case "a":
		case "add":
			if(lectura[1].equalsIgnoreCase("peashooter" ) || lectura[1].equalsIgnoreCase("p")) {
				if(this.game.getSuncoins()>=50) {
					int x = Integer.parseInt(lectura[2]);
					int y = Integer.parseInt(lectura[3]);
					if(this.game.isPositionEmpty(x, y)) {
						this.game.add_P(x, y);
					}
					//this.game.pagar(50); ya se paga en add_S
					
					
				}
			}
			else if(lectura[1].equalsIgnoreCase("sunflower") || lectura[1].equalsIgnoreCase("s")) {
				if(this.game.getSuncoins()>=20) {
					int x= Integer.parseInt(lectura[2]);
					int y = Integer.parseInt(lectura[3]);
					if(this.game.isPositionEmpty(x, y)) {
						this.game.add_S(x, y);
					}
					//this.game.pagar(20); ya se paga en add_S
				}
				
			}
			this.count_cycles +=1;
			break;
		case"l":
		case"list":
			System.out.println(Messages.LIST);

			return false;
			
		case"r":
		case "reset":

			return false;

		case "h":
		case "help":
			System.out.println(Messages.HELP);
			return false;
		
			
		case"n":
		case"none":
		case "":
			this.count_cycles +=1;
			return true;
		}
		return true;	//FALTAN LOS MESAJES DE INVALID COMMAND
	}
	
	public int getCountCycles() {
			return this.count_cycles;
		}
	
	public int getRemainingZombies() {
		return this.remaining_zombies;
	}
	/**
	 * Runs the game logic.
	 */
	public void run() {
		
		
		boolean end=true;
		this.printGame();
		boolean paint;
		while(end) {
			
			String[] lectura= prompt();
			paint = this.swich(lectura);
			         //end=game.update();			
			if (paint) {
				game.update(); 
				this.printGame();
			}
			
			

		}
		if(this.game.quiengana()) {
			System.out.println(Messages.ZOMBIES_WIN);
		}
		else {
			System.out.println(Messages.PLAYER_WINS);
		}
		
			
	
		
	}

}