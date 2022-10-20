package tp1.p1.logic.gameobjects;
import tp1.p1.logic.Game;
public class PeashooterList {
	private Peashooter[] Peashooterlist;
	private int contador=0;
	private Game game;
	
	public PeashooterList(int tamano,Game game){
		
		this.Peashooterlist= new Peashooter[tamano];
		this.game=game;
		
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
		Peashooter p= new Peashooter(this.game);
		for (int i=0; i<contador; i++) {
			if(this.Peashooterlist[i].hay_Peashooter(x, y)) {
				return this.Peashooterlist[i];
			}
		}
		return p;
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
		this.Peashooterlist[this.contador]=new Peashooter(x,y, this.game);
		this.contador++;
	}
	
	public void matar() {
		for(int p=0; p<contador;p++) {
			if (this.Peashooterlist[p].muerto()) {
				for(int i=p; i<(contador-1);i++) {
					this.Peashooterlist[i]=this.Peashooterlist[i+1];
					
				}
				this.contador--;
			}
		}
		
	}
	
	public void p_atacado(int x, int y, int dano) {
		Peashooter p= new Peashooter(this.game);
		if(this.hayalgunPeashooter(x, y)) {
			p=this.hay_P(x, y);
			p.recibir_dano(dano);
		}
	}
	public void update() {
		for(int i=0; i<this.contador; i++) {
			this.Peashooterlist[i].update();
			
		}
		this.matar();
		
	}
	
	
	
}
