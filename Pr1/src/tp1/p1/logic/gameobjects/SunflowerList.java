package tp1.p1.logic.gameobjects;

public class SunflowerList {
	private Sunflower[] SunflowerList;
	private int contador;
	
	
	public boolean hayalgunSunflower(int x, int y) {
		for (int i=0; i<contador; i++) {
			if(this.SunflowerList[i].haySunflower(x, y)) {
				return true;
			}
		}
		return false;
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
	
	
	
	
	
	
	
	
}


