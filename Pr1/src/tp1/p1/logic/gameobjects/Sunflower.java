package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Sunflower {
	private int cost;
	private int damage;
	private int endurance;
	private int posx;
	private int posy;
	private int ciclos; //Para contar el numero de ciclos que llevan creados
	
	
	public void Sunflower() {
		this.cost=20;
		this.damage=0;
		this.endurance=1;
	}

	public String getDescription() {
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
}
