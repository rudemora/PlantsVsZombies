package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;
public class Zombie {
	//comportamiento
	public int endurance = 5;
	private int dano = 1;
	private int velocidad = 2;
	private Game game;
	private int x;
	private int y;
	private int ciclos = 1;//Estos ciclos seran aumentados desde el run para saber si por ej el zombie tiene que avanzar
	
	public Zombie(Game game,int x, int y) {
		this.game=game;
		this.x=x;
		this.y=y;
	}
	

	public boolean hayZombie(int x, int y) {//Devuelve true si hay un zombie en la posicon x,y
		if(this.x==x&&this.y==y&&this.endurance>0) {
			return true;
		}
		return false;
	}
	public boolean zombiegana() {
		if (this.x<0) {
			return true;
			
		}
		return false;
	}

	public void disparado_Peashooter(int damage) {
		this.endurance = this.endurance - damage;
	}
	
	public void aumentar_ciclos() {
		this.ciclos= this.ciclos + 1;
	}
	
	public int getEndurance() {
		return this.endurance;
	}
	public void avance() {
		this.x--;
	}
	
	public boolean canAvanzar() {
		return (this.ciclos % this.velocidad) == 0;
	}
	
	public boolean muerto() {
		if(this.endurance<=0){
			return true;
		}
		return false;
	}
	
	public void update() {
		int posx=this.x;
		int posy=this.y;
		if(this.game.isPositionEmpty(posx-1, posy) && this.canAvanzar()) {//Compruebo si el zombie tiene que avanzar o hacer daño
			this.avance();

		}
		else {
			this.game.atacar(posx-1,posy, this.dano);
		} 	
	}
	
}

