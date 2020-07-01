import java.util.HashSet;
import java.util.Random;

/**
 * 
 */

/**
 * @author Flourish
 *
 */
public class Identities {

	private HashSet<Integer> id;
	private Random rng;
	private int maxVal;
	private int minVal;
	private int randomId;

	public Identities() {
		id = new HashSet<Integer>();
		rng = new Random();
		maxVal = 10000;
		minVal = 1;
		randomId = 1;
	}

	/**
	 * add id
	 */
	public void addId() {

		while (!id.add(randomId)) {
			randomId = rng.nextInt(maxVal) + minVal;
		}
	}

	/**
	 * @return the randomId
	 */
	public int getRandomId() {
		return randomId;
	}

	/**
	 * @param randomId the randomId to set
	 */
	public void setRandomId(int randomId) {
		this.randomId = randomId;
	}
}
