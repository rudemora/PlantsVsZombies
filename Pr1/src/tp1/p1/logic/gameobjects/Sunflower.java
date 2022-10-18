package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Sunflower {
	private static int cost=20;
	private static int damage=0;
	private static int endurance=1;
	private int posx;
	private int posy;
	private int ciclos = 0; //Para contar el numero de ciclos que llevan creados. // LO PONGO A 1 PARA QUE NO AÑADA EN EL PRIMER CICLO
	
	public Sunflower() {
		
	}
	public Sunflower(int x, int y) {
		
		this.posx=x;
		this.posy=y;	
		this.ciclos = this.ciclos + 1;
	}
	
	public static String getDescription() {
		return Messages.SUNFLOWER_DESCRIPTION.formatted(cost,damage, endurance);
	}
	public boolean haySunflower(int x, int y) {
		if(this.posx==x && this.posy==y && endurance>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void recibir_dano(int dano) {
		endurance=endurance-dano;
	}
	public void aumentar_ciclos() {
		this.ciclos++;
	}
	public int getCiclos() {
		return this.ciclos;
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
}
