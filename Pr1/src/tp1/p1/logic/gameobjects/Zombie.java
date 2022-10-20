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
	
	
	//¿ES REALMENTE NECESARIO?
	/*public void Zombie() {//De momento todos los zombies son comunes
		this.endurance=5;
		this.dano=1;
		this.velocidad=2;//Cuantos ciclos le cuesta avanzar una casilla
	}*/

	public Zombie(Game game) {
		this.game=game;
	}
	public int getZombie_x() {
		return this.x;
	}
	public int getZombie_y() {
		return this.y;
	}
	public void setZombie_x(int x) {
		this.x=x;
	}
	public void setZombie_y(int y) {
		this.y=y;
	}
	public int getZombie_dano() {
		return dano;
	}
	/*public void avanzar() {
		this.y--;
	}*/
	public boolean hay_Zombie(int x, int y) {
		return (this.x==x && this.y==y && this.endurance>0);
	}
	public void disparado_Peashooter() {
		this.endurance--;
	}
	
	public void aumentar_ciclos() {
		this.ciclos= this.ciclos + 1;
	}
	
	public int getCiclos() {
		return this.ciclos;
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
			this.game.p_atacado(posx -1, posy, 1);//Hace siempre 1 de dano en esta practica
			this.game.s_atacado(posx -1, posy, 1);
		} 	//CAMBIAR
	}
}
//TENGO QUE CREAR UN CONSTRUCTOR PARA A�ADIR ZOMBIS CON SUS ESPECIFICACIONES

//El valor con el que se construyen los zombis en esta primera pr�ctica supongo que ser� zombi com�n y tirando