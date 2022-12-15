package tp1.p2.logic.actions;

import java.util.List;

import tp1.p2.logic.GameItem;
import tp1.p2.logic.GameWorld;


public class ExplosionAction implements GameAction {

	private int col;

	private int row;

	private int damage;

	private boolean affectsZombies;
	
	public ExplosionAction(int col, int row, int damage, boolean affectsZombies) {
		this.col = col;
		this.row = row;
		this.damage = damage;
		this.affectsZombies = affectsZombies;
	}

	@Override
	public void execute(GameWorld game) {
		for(int i = col-1; i <= col + 1; i++) {
			 for(int j = row-1; j<= row +1;j=j+1) {
				 List<GameItem> lista = game.getGameItemInPosition(i, j);
				 if (lista != null) {
						 if (affectsZombies) {
							 for(int k =0;k<lista.size();k=k+1) {
								 lista.get(k).receivePlantAttack(damage, true);
							 }

						 }
						 else {
							 for(int k =0;k<lista.size();k=k+1) {
								 lista.get(k).receiveZombieAttack(damage);
							 }
						 }
				}
			 }
		 }	 
		//game.explode(col, row, damage, affectsZombies);
	}

	
}
