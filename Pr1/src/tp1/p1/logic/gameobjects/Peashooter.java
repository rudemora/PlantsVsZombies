package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Peashooter {
	private static final String description = "PEASHOOTER_DESCRIPTION";
	private int posx;
	private int posy;
	
	public static String getDescription() {
		return description;
	}
	
	public boolean hay_Peashooter(int x, int y) {
		
		return (this.posx==x && this.posy==y); //Asegurarse que el doble igual funciona
	}
		
}
