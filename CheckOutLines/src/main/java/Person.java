import java.awt.Graphics;

/**
 * @author Flourish
 *
 */
public class Person {

	private int x;

	public Person() {
		setX(10);
	}

	public void draw(Graphics g2) {
		g2.fillOval(x, 0, 10, 10);
//		g2.drawOval(x, 0, 20, 20);
//		g2.drawLine(x + 10, 20, x + 10, 60);
//		g2.drawLine(x + 10, 30, x + 20, 40);
//		g2.drawLine(x + 10, 30, x + 5, 40);
//		g2.drawLine(x + 10, 60, x + 20, 80);
//		g2.drawLine(x + 10, 60, x + 5, 80);
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	public void move() {
		x += 10;
	}
}
