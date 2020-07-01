import java.time.Duration;
import java.time.Instant;

/**
 * @author Flourish
 *
 */
public class Shop implements Runnable {

	private int speed;
	private int numOfTills;
	private Queue[] tills;
	private Instant end;
	private Duration timeElapsed;

	public Shop() {
		numOfTills = 5;
		setUpTills();
	}

	@Override
	public void run() {
		while (true) {
			for (Queue q : tills) {// O(N)
				if (q != null && !q.isEmpty()) {

					setSpeed(q.peek());// O(1)

					try {
						Thread.sleep(getSpeed());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					end = Instant.now();
					Customer leavingCustomer = q.pop();// O(1)
					timeElapsed = Duration.between(leavingCustomer.getStartTime(), end);

					// end checkout
					System.err.println(
							"End check out: " + q.toString() + " Customer ID: " + leavingCustomer.getCustomerId()
									+ " left the queue. Time spent= " + timeElapsed.getSeconds() + " seconds\n");
				}
			}
		}
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param queue speed + groceries = speed
	 */
	public void setSpeed(Customer c) {

		this.speed = c.getGroceries() + c.getTill().getSpeed() + 1000;
	}

	/**
	 * @return the tills
	 */
	public Queue[] getTills() {
		return tills;
	}

	/**
	 * tills the tills to set
	 */
	private void setUpTills() {
		tills = new Queue[numOfTills];
		for (int i = 0; i < numOfTills; i++) {
			tills[i] = new Queue(i);
		}

//		tills = new PriorityQueue<Queue>();
//		for (int i = 0; i < numOfTills; i++) {
//			tills.add(new Queue(i));
//		}

	}

	/**
	 * @return the numOfTills
	 */
	public int getNumOfTills() {
		return numOfTills;
	}
}
