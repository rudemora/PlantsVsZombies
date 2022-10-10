package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Sunflower {
	private int cost=20;
	private int damage=0;
	private int endurance=1;
	private int posx;
	private int posy;
	

	public String getDescription() {
		return Messages.SUNFLOWER_DESCRIPTION.formatted(cost,damage, endurance);
	}
	public boolean haySunflower(int x, int y) {
		if(this.posx==x && this.posy==y) {
			return true;
		}
		else {
			return false;
		}
	}
}
