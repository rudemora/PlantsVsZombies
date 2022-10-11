package tp1.p1.logic.gameobjects;

import tp1.p1.logic.gameobjects.Zombie;

public class ZombieList {
	private Zombie[] zlista;
	private int contador;
	
	
public ZombieList (int i) { //M�todo constructor: a�ade una zombilist de longitud i
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
public boolean hayalgunzombie(int x, int y) {
	for (int i=0; i<contador; i++) {
		if (zlista[i].hay_Zombie(x, y)) {
			return true;
		}
	}
	return false;
}

public int endurance(int x, int y) {
	int endurance=0;
	for (int i=0; i<contador; i++) {
		if (zlista[i].hay_Zombie(x,y)) {
			endurance= zlista[i].getEndurance();
			return endurance;
		}
	}
	return endurance;
}
	//Igual meter un metodo para borrar los zombis
}
