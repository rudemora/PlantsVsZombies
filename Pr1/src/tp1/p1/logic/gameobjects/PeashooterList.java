package tp1.p1.logic.gameobjects;
import tp1.p1.logic.Game;
public class PeashooterList {
	private Peashooter[] Peashooterlist;
	private int contador=0;
	
	public PeashooterList(int tamano){
		
		this.Peashooterlist= new Peashooter[tamano];
		
	}
	public boolean hayalgunPeashooter(int x, int y) {
		
		for (int i=0; i<contador; i++) {
			if(this.Peashooterlist[i].hay_Peashooter(x, y)) {
				return true;
			}
		}
		return false;
	}
	
	public Peashooter hay_P(int x, int y) {
		Peashooter p= new Peashooter();
		for (int i=0; i<contador; i++) {
			if(this.Peashooterlist[i].hay_Peashooter(x, y)) {
				return this.Peashooterlist[i];
			}
		}
		return p;
	}
	
public int pos_P(int x, int y) {//Me da la posicion en la lista del sunflower de posicion de tablero (x,y)
		
		int pos=-1;
		for(int i=0; i<contador;i++) {
			if (this.Peashooterlist[i].hay_Peashooter(x, y)) {
				return i;
			}
		}
		return pos;
		
	}
	public int endurance(int x, int y) {
		int endurance=0;
		for (int i=0; i<contador;i++) {
			if (this.Peashooterlist[i].hay_Peashooter(x, y)) {
				endurance=this.Peashooterlist[i].getEndurance();
				return endurance;
			}
		}
		return endurance;
	}

	public void add_Peashooter(int x, int y) {
		this.Peashooterlist[this.contador]=new Peashooter(x,y);
		this.contador++;
	}
	
	public void matar(int pos) {
		if (this.Peashooterlist[pos].muerto()) {
			for(int i=pos; i<(contador-1);i++) {
				this.Peashooterlist[i]=this.Peashooterlist[i+1];
				
			}
			this.contador--;
		}
	}
	
	public void update() {
		int posx;
		int posy;
		for(int i=0; i<this.contador; i++) {
			posx=this.Peashooterlist[i].getPosx();
			posy=this.Peashooterlist[i].getPosy();
			
		}
		
	}
	
	
	
}
