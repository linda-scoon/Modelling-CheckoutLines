import java.util.LinkedList;
import java.util.Random;

/**
 * @author Flourish
 *
 */
public class Queue extends LinkedList<Customer> implements Comparable<Queue> {

	private static final long serialVersionUID = 1L;
	private int id;
	private int delay;
	private int speed;

	public Queue(int id) {
		this.id = id;
		this.delay = 5000;
	}

	/**
	 * @return the numCustomers
	 */
	public int getNumCustomers() {

		return size();
	}

	public String getQueues() {
		return super.toString();
	}

	@Override
	public String toString() {
		return "Queue [id=" + id + ", NumofCustomers=" + getNumCustomers() + "]";
	}

	@Override
	public int compareTo(Queue q) {
//		return this.getNumCustomers() - q.getNumCustomers();// alternative
		if (this.getNumCustomers() > q.getNumCustomers()) {
			return 1;
		}
		if (this.getNumCustomers() < q.getNumCustomers()) {
			return -1;
		}
		return 0;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param random number = speed
	 */
	public void setSpeed() {
		Random r = new Random();
		this.speed = r.nextInt(delay) + 1;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		setSpeed();
		return speed;
	}
}
