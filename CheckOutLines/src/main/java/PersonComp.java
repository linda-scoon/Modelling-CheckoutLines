import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JComponent;

/**
 * @author Flourish
 *
 */
public class PersonComp extends JComponent implements Runnable {

	private static final long serialVersionUID = 1L;
	private ConcurrentLinkedQueue<Person> people;
	private int id;
	private long speed;
	private long delay;

	public PersonComp(int id) {
		delay = 100;
		people = new ConcurrentLinkedQueue<>();
		this.id = id;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.BLUE);
		g2.setFont(new Font("Arial", Font.BOLD, 14));
		g2.drawString("TILL: " + id, 20, 15);

		for (Person p : people) {
			g2.setColor(Color.BLACK);
			p.draw(g2);
		}

	}

	public synchronized void move() {

		while (!people.isEmpty()) {

			try {
				for (Person p : people) {
					p.move();
					repaint();

					Thread.sleep(delay);
				}

				if (people.peek().getX() >= 200) {
					people.poll();
					repaint();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the people
	 */
	public ConcurrentLinkedQueue<Person> getPeople() {
		return people;
	}

	public void addPerson() {
		people.add(new Person());
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the speed
	 */
	public long getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public void run() {
		move();

	}
}
