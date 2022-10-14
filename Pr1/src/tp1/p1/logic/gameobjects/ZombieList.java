package tp1.p1.logic.gameobjects;

import tp1.p1.logic.gameobjects.Zombie;

public class ZombieList {
	private Zombie[] zlista;
	private int contador;
	
	
	public ZombieList (int i) { //M�todo constructor: a�ade una zombielist de longitud i
			this.zlista = new Zombie[i];
			this.contador=0;
		}
	
	public int getposx(int i) {
		return this.zlista[i].getZombie_x();
		
	}
	public int endurance(int x, int y) {
		for(int i=0;i<contador;i++) {
			if(zlista[i].getZombie_x()==x&&zlista[i].getZombie_y()==y) {
				return zlista[i].getEndurance();
			}
		}
		return -1;
	}
	public int getposy(int i) {
		return this.zlista[i].getZombie_y();
	}
	public void insertar(Zombie z) {
			this.zlista[contador]=z;
			contador++;
		}

	public int getcontador() {
		return this.contador;
	}

	
	public Zombie getzombie(int pos) {//ME da el zombie de la posicion i de la lista
		return this.zlista[pos];
	}
			
	

	
	public boolean hayalgunzombie(int x, int y) {
		for(int i=0; i<this.contador; i++) {
			if(this.zlista[i].getZombie_x()==x&&this.zlista[i].getZombie_y()==y) {
				return true;
			}
		}
		return false;
	}
	public void actualizar_ciclos() {
		for (int i=0; i<this.contador;i++) {
			this.zlista[i].aumentar_ciclos();
		}
	}
	public void matar_muertos() {

		for (int i=0; i<contador; i++) {
			if(this.zlista[i].muerto()) {
				for(int p=i;p<(contador-1);p++) {
					zlista[p]=zlista[p+1];
				}
				this.contador--;
				
			}
		}
	
	}
	public void zombie_atacado(int x, int y, int num_cols) {
		
		boolean ok=true;
		int p=x+1;
		while(ok&&p<num_cols) {
			for(int i=0; i<contador; i++) {
				if(this.zlista[i].getZombie_x()==p&&this.zlista[i].getZombie_y()==y) {
					this.zlista[i].disparado_Peashooter();
					ok=false;
				}
			}
			p++;
		
		}
		
	}
	
	public boolean quedan_zombies() {
		if (contador==0) {
			return false;
		}
		return true;
	}
	
	public boolean zombie_gana() {
		for(int i=0; i<contador; i++) {
			if (this.zlista[i].getZombie_x()==0) {
				return true;
			}
		}
		return false;
	}


}
