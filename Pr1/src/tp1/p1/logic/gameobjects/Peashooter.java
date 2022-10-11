package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Peashooter {
	private static final String description = "PEASHOOTER_DESCRIPTION";
	private int cost;
	private int damage;
	private int endurance;
	private int posx;
	private int posy;
	
	
	public Peashooter() {
		this.cost=50;//No sé si inicializarlo aqui o hacerlo en los atributos
		this.damage=1;
		this.endurance=3;
	}
	
	public static String getDescription() {
		return description;
	}
	
	
	public boolean hay_Peashooter(int x, int y) {
		
		return (this.posx==x && this.posy==y&& this.endurance>0); //Asegurarse que el doble igual funciona
	}
	
	public void recibir_dano(int dano) {//El dato dano lo pillo del zombie
		this.endurance=this.endurance-dano;
		
	}
	public int getEndurance() {
		return this.endurance;
	}
}
