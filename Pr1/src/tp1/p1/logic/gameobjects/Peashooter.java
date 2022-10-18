package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Peashooter {
	private static int cost=50;
	private static int damage=1;
	private static int endurance=3;
	private int posx;
	private int posy;
	
	
	public Peashooter() {
		
	}
	
	public Peashooter(int x, int y) {
		
		this.posx=x;
		this.posy=y;
	}
	
	public static String getDescription() {
		return Messages.PEASHOOTER_DESCRIPTION.formatted(cost,damage, endurance);
	}
	
	
	public boolean hay_Peashooter(int x, int y) {
		
		return (this.posx==x && this.posy==y&& endurance>0); //Asegurarse que el doble igual funciona
	}
	
	public void recibir_dano(int dano) {//El dato dano lo pillo del zombie
		endurance=endurance-dano;
		
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
	public int getPosx() {
		return this.posx;
	}
	public int getPosy() {
		return this.posy;
	}
	

}
