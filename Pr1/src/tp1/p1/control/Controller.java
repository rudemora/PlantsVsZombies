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
	
	
	//private int count_cycles;
	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gamePrinter = new GamePrinter(game);
		//this.count_cycles = 0;
		//this.remaining_zombies = game.getRemainingZombies(); //Lo sacamos del level pero aun no sabemos
	}
	
	
	/**
	 * Draw / Paint the game.
	 */
	private void printGame() {
		System.out.println(String.format(Messages.NUMBER_OF_CYCLES, this.game.getCountCycles()));
		System.out.println(String.format(Messages.NUMBER_OF_COINS, this.game.getSuncoins()));
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
			if (lectura.length < 4) {
				System.out.println(Messages.error(Messages.COMMAND_PARAMETERS_MISSING));
				return false;
			}
			else if (lectura.length > 4) {
				System.out.println(Messages.error(Messages.INVALID_COMMAND));
				return false;
			}
			else if(lectura[1].equalsIgnoreCase("peashooter" ) || lectura[1].equalsIgnoreCase("p")) {
				if(this.game.getSuncoins()>=50) {
					int x = Integer.parseInt(lectura[2]);
					int y = Integer.parseInt(lectura[3]);
					if(this.game.isPositionEmpty(x, y)) {
						this.game.add_P(x, y);
					}
					else {
						System.out.println(Messages.error(Messages.INVALID_POSITION));
						return false;
					}
						//this.game.pagar(50); ya se paga en add_S
				}
				else {
					System.out.println(Messages.error(Messages.NOT_ENOUGH_COINS));
					return false;
				}
				this.game.addCycles();
			}
			else if(lectura[1].equalsIgnoreCase("sunflower") || lectura[1].equalsIgnoreCase("s")) {
				if(this.game.getSuncoins()>=20) {
					int x= Integer.parseInt(lectura[2]);
					int y = Integer.parseInt(lectura[3]);
					if(this.game.isPositionEmpty(x, y)) {
						this.game.add_S(x, y);
					}
					else {
						System.out.println(Messages.error(Messages.INVALID_POSITION));
						return false;
					}
						//this.game.pagar(20); ya se paga en add_S
				}
				else {
					System.out.println(Messages.error(Messages.NOT_ENOUGH_COINS));
					return false;
				}
				this.game.addCycles();
			}
			else {
				System.out.print(Messages.error(Messages.INVALID_GAME_OBJECT));
				return false;
			}
			return true;
			
			/*catch (IndexOutOfBoundsException nfe) {
				System.out.println(Messages.error(Messages.COMMAND_PARAMETERS_MISSING));
				return false;
			}*/
			
		case"l":
		case"list":
			if (lectura.length == 1) {
				System.out.println(Messages.LIST);
			}
			else {
				System.out.println(Messages.error(Messages.INVALID_COMMAND));
			}
			return false;

		case "h":
		case "help":
			if (lectura.length == 1) {
				System.out.println(Messages.HELP);
			}
			else {
				System.out.println(Messages.error(Messages.INVALID_COMMAND));
			}
			return false;
		
		case "r":
		case "reset":
			if (lectura.length == 1) {
				this.game = new Game(this.game.getSeed(), this.game.getLevel());
				this.gamePrinter = new GamePrinter(this.game);
				return true;

			}
			else {
				System.out.println(Messages.error(Messages.INVALID_COMMAND));
				return false;
			}
		case"n":
		case"none":
		case "":
			this.game.addCycles();
			return true;
		default:
			System.out.println(Messages.error(Messages.UNKNOWN_COMMAND));
			return false;
		}
		
	}
	
	/**
	 * Runs the game logic.
	 */
	public void run() {
		boolean end=false;
		this.printGame();
		boolean paint = true;
		boolean exit = false;
		while(!end && !exit) {
			String[] lectura= prompt();
			if (lectura[0].equalsIgnoreCase("e") || lectura[0].equalsIgnoreCase("exit")) {
				if (lectura.length==1) {
					exit = true;
					paint = false;	
					this.printGame();
					System.out.println(Messages.GAME_OVER);
					System.out.println(Messages.PLAYER_QUITS);
				}
				else {
					System.out.println(Messages.error(Messages.INVALID_COMMAND));
					paint = false;
				}
			}
			else {
				paint = this.swich(lectura);
			}	
			if (paint) {
				end = game.update(); 
				this.printGame();
			}
		}
		if (!exit) {
			System.out.println(Messages.GAME_OVER);
			if(this.game.quiengana()) {
				System.out.println(Messages.ZOMBIES_WIN);
			}
			else if (!this.game.quiengana()) {
				System.out.println(Messages.PLAYER_WINS);
			}
		}
	}

}