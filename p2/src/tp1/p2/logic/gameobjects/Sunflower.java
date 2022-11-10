package tp1.p2.logic.gameobjects;
import tp1.p2.view.Messages;
import tp1.p2.logic.GameWorld;

public class Sunflower extends Plant  {
	private int soles;
	
	protected Sunflower() {
		cost= 20;
		damage= 0;
		endurance = 1;
		soles = 10;
	}
	
	protected Sunflower(GameWorld game, int col, int row) {
		super(game, col, row);
		cost= 20;
		damage= 0;
		endurance = 1;
		soles = 10;
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
		Sunflower sunflower = new Sunflower(game, col, row);
		return sunflower;
	 }

	private int addSoles() {
		if (this.ciclo%4==0) {
			this.ciclo = 1;
			return soles;
		}
		return 0;
	}
	
	@Override
	public void update() { 
		// TODO Auto-generated method stub
		this.addCycle();
		this.game.addSuncoins(this.addSoles());
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
