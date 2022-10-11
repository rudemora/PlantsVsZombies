package tp1.p1.logic.gameobjects;

public class PeashooterList {
	private Peashooter[] Peashooterlist;
	private int contador;
	
	
	public boolean hayalgunPeashooter(int x, int y) {
		
		for (int i=0; i<contador; i++) {
			if(this.Peashooterlist[i].hay_Peashooter(x, y)) {
				return true;
			}
		}
		return false;
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

}
