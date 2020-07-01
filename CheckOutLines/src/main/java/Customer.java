import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Flourish
 *
 */
public class Customer {
	private Queue till;
	private int groceries;
	private int tillNo;
	private Instant start;
	private int customerId;

	public Customer(int id) {
		tillNo = 0;
		setGroceries();
		customerId = id;
	}

	/**
	 * Checks for shortest queue and adds customer
	 * 
	 * @param q
	 * @return
	 */
	public void joinQue(Queue[] tills) {
		Arrays.sort(tills);
		this.till = tills[0];

		// joining queue and recording time
		this.till.add(this);
		tillNo = this.till.getId();
		start = Instant.now();

		// printing joined queue
		System.out.println("\nJoined queue: " + till.toString() + " Customer ID: " + getCustomerId());

		// for debugging
//		System.out.println(
//				"customer-- " + till.getQueues() + "   " + "groceries " + groceries + "   " + this.till.getSpeed());
	}

	/**
	 * @return the groceries
	 */
	public int getGroceries() {
		return groceries;
	}

	/**
	 * @param groceries random num of groceries
	 */
	public void setGroceries() {
		Random r = new Random();
		this.groceries = r.nextInt(2000) + 1;

		// for debugging
//		System.out.println("groceries " + groceries);
	}

	/**
	 * @return the till
	 */
	public Queue getTill() {
		return till;
	}

	@Override
	public String toString() {
		return "Customer [till=" + till + ", groceries=" + groceries + "]";
	}

	/**
	 * @return the tillNo
	 */
	public int getTillNo() {
		return tillNo;
	}

	/**
	 * @return the start
	 */
	public Instant getStartTime() {
		return start;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
