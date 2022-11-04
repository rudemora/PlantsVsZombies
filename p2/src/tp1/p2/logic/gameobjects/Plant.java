package tp1.p2.logic.gameobjects;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import tp1.p2.view.Messages;
//Las subclases y superclases tienen que importarse mutuamente?




public abstract class Plant {

	 protected String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(null)//aqui le metemos el this.getSymbol, this.get endurance....
	};
	
	public abstract String getName();
	public abstract String getSymbol();
	
}
