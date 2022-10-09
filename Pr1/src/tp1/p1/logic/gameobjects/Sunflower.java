package tp1.p1.logic.gameobjects;

import tp1.p1.view.Messages;

public class Sunflower {
	private int cost=20;
	private int damage=0;
	private int endurance=1;

	public String getDescription() {
		return Messages.SUNFLOWER_DESCRIPTION.formatted(cost,damage, endurance);
	}
}
