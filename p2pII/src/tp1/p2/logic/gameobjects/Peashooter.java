 package tp1.p2.logic.gameobjects;

import java.util.List;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class Peashooter extends Plant {
	private static final int INITIAL_ENDURANCE = 3;
	private static final int COST = 50;
	private static final int DAMAGE = 1;
	
	protected Peashooter (){
		endurance = INITIAL_ENDURANCE;
	}
	
	private Peashooter(GameWorld game, int col, int row) {
		super(game, col, row);
		endurance = INITIAL_ENDURANCE;
	}
	
	

	@Override
	public boolean catchObject() {
		return false;
	}

	

	@Override
	protected String getSymbol() {
		return String.format(Messages.PEASHOOTER_SYMBOL, this.getEndurance());
	}

	@Override
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.PEASHOOTER_NAME_SHORTCUT,getCost(),getDamage(),getEndurance());
	}

	@Override
	public void update() {
		this.addCycle();
		int i = col + 1;
		boolean atacked = false;
		while (!atacked && i < GameWorld.NUM_COLS) {
			List<GameItem> lista = game.getGameItemInPosition(i, row);
			if(lista != null) { 
				for(int i1 =0;i1<lista.size();i1=i1+1) {
					atacked=lista.get(i1).receivePlantAttack(this.getDamage(), false);
				}
				
			}
			i = i +1;
		}
		
	}
		
	@Override
	public void onEnter() {
		
	}

	@Override
	public void onExit() {
		
	}
	
	@Override
	public int getCost() {
		return COST;
	}
	
	@Override
	public int getEndurance() {
		return endurance;
	}
	
	@Override
	public int getDamage() {
		return DAMAGE;
	}
	
	@Override
	public boolean fillPosition() {
		return true;
	}

	@Override
	public String getName() {
		return Messages.PEASHOOTER_NAME;
	}
	
	@Override
	public Peashooter create(GameWorld game, int col, int row) {
		Peashooter P = new Peashooter(game, col, row);
		return P;
	 }

}
