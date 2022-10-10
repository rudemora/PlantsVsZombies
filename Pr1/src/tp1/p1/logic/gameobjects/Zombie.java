package tp1.p1.logic.gameobjects;

public class Zombie {
	//comportamiento
	private int resistencia;
	private int dano;
	private int velocidad;
	
	private int x;
	private int y;
	
	public void Zombie() {//De momento todos los zombies son comunes
		this.resistencia=5;
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
	public void avanzar() {
		this.y--;
	}
}
//TENGO QUE CREAR UN CONSTRUCTOR PARA A�ADIR ZOMBIS CON SUS ESPECIFICACIONES

//El valor con el que se construyen los zombis en esta primera pr�ctica supongo que ser� zombi com�n y tirando