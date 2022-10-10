package tp1.p1.logic.gameobjects;

public class Zombie {
	//comportamiento
	private int endurance;
	private int dano;
	private int velocidad;
	
	private int x;
	private int y;
	private int ciclos;//Estos ciclos seran aumentados desde el run para saber si por ej el zombie tiene que avanzar
	
	public void Zombie() {//De momento todos los zombies son comunes
		this.endurance=5;
		this.dano=1;
		this.velocidad=2;//Cuantos ciclos le cuesta avanzar una casilla
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
	public void avanzar() {
		this.y--;
	}
	public boolean hay_Zombie(int x, int y) {
		return (this.x==x && this.y==y && this.endurance>0);
	}
	public void disparado_Peashooter() {
		this.endurance--;
	}
	
	public void aumentar_ciclos() {
		this.ciclos++;
	}
	
	public int getCiclos() {
		return this.ciclos;
	}
	
}
//TENGO QUE CREAR UN CONSTRUCTOR PARA A�ADIR ZOMBIS CON SUS ESPECIFICACIONES

//El valor con el que se construyen los zombis en esta primera pr�ctica supongo que ser� zombi com�n y tirando