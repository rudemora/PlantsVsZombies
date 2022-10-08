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
	
	//Igual meter un metodo para borrar los zombis
}
