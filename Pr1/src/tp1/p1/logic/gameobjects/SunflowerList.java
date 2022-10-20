package tp1.p1.logic.gameobjects;

import tp1.p1.logic.Game;

public class SunflowerList {
	private Sunflower[] SunflowerList;
	private int contador=0;
	private Game game;
	
	public boolean hayalgunSunflower(int x, int y) {
		for (int i=0; i<contador; i++) {
			if(this.SunflowerList[i].haySunflower(x, y)) {
				return true;
			}
		}
		return false;
	}
	public Sunflower hay_S(int x, int y) {
		Sunflower s= new Sunflower(this.game);
		for (int i=0; i<contador; i++) {
			if(this.SunflowerList[i].haySunflower(x, y)) {
				return this.SunflowerList[i];
			}
		}
		return s;
	}
	
	
	public int endurance (int x, int y) {
		int endurance=0;
		for(int i=0; i<contador; i++) {
			if (this.SunflowerList[i].haySunflower(x, y)) {
				endurance = this.SunflowerList[i].getEndurance();
				return endurance;
			}
		}
		return endurance;
	}

	public SunflowerList(int tamano,Game game){
		
		this.SunflowerList= new Sunflower[tamano];
		this.game=game;
		
	}
	public void add_Sunflower(int x, int y) {
		this.SunflowerList[this.contador]=new Sunflower(x,y,this.game);
		this.contador++;
	}
	public void s_atacado(int x, int y, int dano) {
		Sunflower s= new Sunflower(this.game);
		if(this.hayalgunSunflower(x, y)) {
			s= this.hay_S(x, y);
			s.recibir_dano(dano);
		}
	}
	
	public void actualizar_ciclos() {
		for (int i=0; i<this.contador; i++) {
			this.SunflowerList[i].aumentar_ciclos();
		}
	}
	public void matar() {
		for (int p=0; p<contador; p++) {
			if (this.SunflowerList[p].muerto()) {
				for(int i=p; i<(contador-1);i++) {
					this.SunflowerList[i]=this.SunflowerList[i+1];
					
				}
				this.contador--;
			}
		}
		
	}
	public void update(){
		for (int i=0; i<this.contador; i++) {
			this.SunflowerList[i].update();
		}
		
		this.matar();
	}
	
	
	
	
	
	
	
}


