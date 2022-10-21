package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
import tp1.p1.view.Messages;

public class Sunflower {
	private int cost;
	private int damage;
	private int endurance;
	private int posx;
	private int posy;
	private int ciclos = 0; //Para contar el numero de ciclos que llevan creados. // LO PONGO A 1 PARA QUE NO AÑADA EN EL PRIMER CICLO
	private Game game;
	
	public Sunflower(Game game) {
		this.game=game;
	}
	
	public Sunflower(int x, int y, Game game) {
		this.cost = 20;
		this.damage =0;
		this.endurance = 1;
		this.posx=x;
		this.posy=y;
		this.game=game;
		this.ciclos = this.ciclos + 1;
	}
	
	public static String getDescription() {
		return Messages.SUNFLOWER_DESCRIPTION.formatted(20,0, 1);
	}
	
	public boolean haySunflower(int x, int y) {
		if(this.posx==x && this.posy==y && endurance>0) {
			return true;
		}
		else {
			return false;
		}
	}
	public void recibir_dano(int x, int y, int dano) {
		if(this.posx == x && this.posy == y) {
			endurance=endurance-dano;
		}
	}
		
	public void aumentar_ciclos() {
		this.ciclos++;
	}
	

	public int getEndurance() {
		return endurance;
	}
	
	public int anadir_soles() {
		if (this.ciclos%4==0) {
			this.ciclos = 1;
			return 10;
		}
		return 0;
	}
	
	public boolean muerto() {
		if (endurance<=0) {
			return true;
		}
		return false;
	}
	
	public void update() {
		this.game.setSuncoins(this.game.getSuncoins()+this.anadir_soles());
		aumentar_ciclos();
	}

	public int pagar() {
		return this.cost;
	}
}
