package tp1.p1.logic.gameobjects;

public class Zombie {
	//comportamiento
	private int resistencia;
	private int dano;
	private int velocidad;
	private int x;
	private int y;
	
	public ZombiComun() {
		this.resistencia=5
		this.dano=1
		this.velocidad=2//Cuantos ciclos le cuesta avanzar una casilla
	}
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
//TENGO QUE CREAR UN CONSTRUCTOR PARA AÑADIR ZOMBIS CON SUS ESPECIFICACIONES

//El valor con el que se construyen los zombis en esta primera práctica supongo que será zombi común y tirando