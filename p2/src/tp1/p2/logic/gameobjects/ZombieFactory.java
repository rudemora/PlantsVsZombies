package tp1.p2.logic.gameobjects;
import java.util.*;


public class ZombieFactory {

	
		
		
		/* @formatter:off */
	public static final List<Zombie> AVAILABLE_ZOMBIES = Arrays.asList(
			new ZombieComun()
		);
		/* @formatter:on */
	
	
	public static List<Zombie> getAvailableZombies() {
		/*ArrayList<Integer> array = new ArrayList<Integer> (1);
		return Collections.unmodifiableList(array);
		*/
		return Collections.unmodifiableList(AVAILABLE_ZOMBIES);
	}
	
	
	
}
