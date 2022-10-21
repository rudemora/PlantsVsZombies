package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;
import tp1.p1.logic.Game;

public class Peashooter {
	private int cost;
	private int damage;
	private int endurance;
	private int posx;
	private int posy;
	private Game game;
	
	
	
	
	public Peashooter(int x, int y, Game game) {
		this.cost = 50;
		this.damage = 1;
		this.endurance=3;
		this.posx=x;
		this.posy=y;
		this.game=game;
	}
	
	public static String getDescription() {
		return Messages.PEASHOOTER_DESCRIPTION.formatted(50,1, 3);
	}
	
	
	public boolean hay_Peashooter(int x, int y) {
		
		return (this.posx==x && this.posy==y&& endurance>0); //Asegurarse que el doble igual funciona
	}
	
	public void recibir_dano(int x, int y, int dano) {
		if(this.posx == x && this.posy == y) {
			endurance=endurance-dano;
		}
	}
	
	public int getEndurance() {
		return endurance;
	}
	
	public boolean muerto() {
		if (endurance<=0) {
			return true;
		}
		return false;
	}
	
	void update() {
		this.game.zombie_atacado(posx, posy, this.damage);
	}
	
	public int pagar() {
		return this.cost;
	}
}
