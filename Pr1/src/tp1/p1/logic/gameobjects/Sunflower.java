package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Sunflower {
	private static int cost=20;
	private static int damage=0;
	private static int endurance=1;
	private int posx;
	private int posy;
	private int ciclos; //Para contar el numero de ciclos que llevan creados
	
	
	public void Sunflower() {

	}

	public static String getDescription() {
		return Messages.SUNFLOWER_DESCRIPTION.formatted(cost,damage, endurance);
	}
	public boolean haySunflower(int x, int y) {
		if(this.posx==x && this.posy==y && this.endurance>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void recibir_dano(int dano) {
		this.endurance=this.endurance-dano;
	}
	public void aumentar_ciclos() {
		this.ciclos++;
	}
	public int getCiclos() {
		return this.ciclos;
	}
	public int getEndurance() {
		return this.endurance;
	}
}
