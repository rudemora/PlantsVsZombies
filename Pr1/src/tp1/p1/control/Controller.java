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
		this.remaining_zombies=8; //Lo sacamos del level pero aun no sabemos
	}
	
	
	/**
	 * Draw / Paint the game.
	 */
	private void printGame() {
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

		//System.out.println(debug(line));

		return words;//Me devuelve lo que ha metido el usuario
	}
	
	public void debug(String line) {
		//crear método debug
	}
	
	private boolean swich(String[]lectura) {
		switch(lectura[0]){//Para leer lo que inserte el usuario desde Command
		case "a":
		case "add":
			if(lectura[1].equalsIgnoreCase("peashooter")) {
				if(this.game.getSuncoins()>=50) {
					int y= Integer.parseInt(lectura[2]);
					int x = Integer.parseInt(lectura[3]);
					if(this.game.isPositionEmpty(x, y)) {
						this.game.add_P(x, y);
					}
					this.game.pagar(50);
					
					
				}
				
			}
			else if(lectura[1].equalsIgnoreCase("sunflower")) {
				if(this.game.getSuncoins()>=20) {
					int x= Integer.parseInt(lectura[2]);
					int y = Integer.parseInt(lectura[3]);
					if(this.game.isPositionEmpty(x, y)) {
						this.game.add_S(x, y);
					}
					this.game.pagar(20);
				}
				
			}
			break;
		case"l":
		case"list":
			System.out.println(Messages.LIST);

			break;
		case"r":
		case "reset":

			break;

		case "h":
		case "help":
			System.out.println(Messages.HELP);
			break;
		case "e":
		case "exit":
			System.out.println(Messages.GAME_OVER);
			return false;
			
		case"n":
		case"none":
		case "":
			break;
		}
		return true;	//FALTAN LOS MESAJES DE INVALID COMMAND
	}

	/**
	 * Runs the game logic.
	 */
	public void run() {
		// TODO fill your code
		//int contador_ciclos=0;
		//this.count_cycles =0;
		
		boolean end=true;
		while(end) {
			this.printGame();
			String[] lectura= prompt();
			end=this.swich(lectura);
			end=game.update();
			
		}
		
		if(this.game.quiengana()) {
			System.out.println(Messages.ZOMBIES_WIN);
		}
		else {
			System.out.println(Messages.PLAYER_WINS);
		}
	
			
		
		



		
		//bucle con pintar(pintar el juego), user action (pide comando al usuario y ejecuta, hay que usar PROMPT), 
		//game action, update, pintar 
		//hacer el método list de user action, utilizar game printer para imprimir la lista generada por list
		//none ejecuta un ciclo, el usuario no hace nada y se ejecuta game action (cosas aleatorias) y update (actualizar cambios)
		
		/*while () {
			pintar;
			userAction;
			game.update;
		}*/
		this.count_cycles += 1;
	}

}