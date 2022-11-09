package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;

public class Sunflower extends Plant  {//extends Plant tambi�n no?
	
	public Sunflower() {
		cost= 20;
		damage= 0;
		endurance = 1;
	}
	
	
	public String getDescription() {
		return Messages.PLANT_DESCRIPTION.formatted(Messages.SUNFLOWER_NAME_SHORTCUT,cost,damage,endurance);
	}
	public String getName() {
		return Messages.SUNFLOWER_NAME;
	}
	protected String getShortcut() {
		return Messages.SUNFLOWER_NAME_SHORTCUT;
	}
	
	public int getCost() {
		return this.cost;
	}
	



	
	@Override
	public String getSymbol() {
		return String.format(Messages.SUNFLOWER_SYMBOL, this.endurance);
	}
	
	public Sunflower create(GameWorld game, int col, int row) {
		Sunflower S = new Sunflower();
		S.game = game;
		S.col=col;
		S.row=row;
		return S;
	 }

	public int addSoles() {
		if (this.ciclo%4==0) {
			this.ciclo = 1;
			return 10;
		}
		return 0;
	}
	
	@Override
	public void update() { //preguntar si está bien hecho
		// TODO Auto-generated method stub
		this.addCycle();
		this.game.setSuncoins(this.game.getSuncoins()+this.addSoles());
	}
	
	@Override
	public void onEnter() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onExit() {
		// TODO Auto-generated method stub
		
	}
}
