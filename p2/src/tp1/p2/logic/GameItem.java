package tp1.p2.logic;

/**
 * Represents a game item and its allowed game actions.
 *
 */
public interface GameItem {
	/**
	 * Receive a zombie attack.
	 * 
	 * @param damage Received damage.
	 * 
	 * @return <code>true</code> if a plant has been attacked, <code>false</code>
	 *         otherwise.
	 */
	abstract boolean receiveZombieAttack(int damage);
	abstract boolean receivePeashooterAttack(int damage);    // por qué ha de ser booleano?
}