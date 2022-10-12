package tp1.p1.logic.gameobjects;

public class SunflowerList {
	private Sunflower[] SunflowerList;
	private int contador=0;
	
	
	public boolean hayalgunSunflower(int x, int y) {
		for (int i=0; i<contador; i++) {
			if(this.SunflowerList[i].haySunflower(x, y)) {
				return true;
			}
		}
		return false;
	}
	public Sunflower hay_S(int x, int y) {
		Sunflower s= new Sunflower();
		for (int i=0; i<contador; i++) {
			if(this.SunflowerList[i].haySunflower(x, y)) {
				return this.SunflowerList[i];
			}
		}
		return s;
	}
	
	public int pos_S(int x, int y) {//Me da la posicion en la lista del sunflower de posicion de tablero (x,y)
		
		int pos=-1;
		for(int i=0; i<contador;i++) {
			if (this.SunflowerList[i].haySunflower(x, y)) {
				return i;
			}
		}
		return pos;
		
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
	public SunflowerList(int tamano){
		
		this.SunflowerList= new Sunflower[tamano];
		
	}
	public void add_Sunflower(int x, int y) {
		this.SunflowerList[this.contador]=new Sunflower(x,y);
		this.contador++;
	}
	public int update_S(){
		int suma=0;
		for (int i=0; i<this.contador; i++) {
			suma=suma+this.SunflowerList[i].anadir_soles();
		}
		return suma;
	}
	
	public void matar(int pos) {
		if (this.SunflowerList[pos].muerto()) {
			for(int i=pos; i<(contador-1);i++) {
				this.SunflowerList[i]=this.SunflowerList[i+1];
				
			}
			this.contador--;
		}
	}
	
	
	
	
	
	
}


