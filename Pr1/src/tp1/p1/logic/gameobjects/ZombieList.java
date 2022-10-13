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

public int getcontador() {
	return this.contador;
}
public int getposx(int pos) {
	return this.zlista[pos].getZombie_x();
}
public int getposy(int pos) {
	return this.zlista[pos].getZombie_y();
}

public Zombie getzombie(int pos) {//ME da el zombie de la posicion i de la lista
	return this.zlista[pos];
}
		

public int endurance(int pos) {
	int endurance=0;
	endurance=this.zlista[pos].getEndurance();
	return endurance;
}



public Zombie sacar_zombie(int i) {
	return this.zlista[i];
}

public void matar(int pos) {
	if(this.zlista[pos].muerto()) {
		for(int i=pos; i<(this.contador-1); i++) {
			this.zlista[i]=this.zlista[i+1];
		}
		this.contador--;
	}
}

	//Igual meter un metodo para borrar los zombis
}
