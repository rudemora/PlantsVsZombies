package tp1.p1.logic.gameobjects;

import tp1.p1.logic.gameobjects.Zombie;

public class ZombieList {
	private Zombie[] zlista;
	private int contador;
	
	
	public ZombieList (int i) { //Método constructor: añade una zombilist de longitud i
		this.zlista = new Zombie[i];
		this.contador=0;
	}
	
	public void insertar(Zombie z) {
		this.zlista[contador]=z;
		contador++;
	}
public void cambiarposx_ultimo(int pos) {
	this.zlista[contador-1].setZombie_x(pos);
}
public void cambiarposy_ultimo(int pos) {
	this.zlista[contador-1].setZombie_y(pos);
}
	//Igual meter un metodo para borrar los zombis
}
