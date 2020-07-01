import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Flourish
 *
 */
public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private JButton btn;
	private Shop shop;
	private CopyOnWriteArrayList<PersonComp> pCompList;
	private Identities cusIds;

	/**
	 * @param title
	 */
	public UserInterface(String title) {
		super(title);
		width = 300;
		height = 300;

		shop = new Shop();
		pCompList = new CopyOnWriteArrayList<PersonComp>();
		btn = new JButton("ADD CUSTOMER");
		cusIds = new Identities();

		setUpPcomps(shop.getNumOfTills());
		add(btn, BorderLayout.SOUTH);

		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setUpPcomps(int tills) {
		for (int i = 0; i < tills; i++) {
			pCompList.add(new PersonComp(i));
		}
		JPanel personPanel = new JPanel();
		personPanel.setLayout(new GridLayout(tills, 1));
		for (PersonComp p : pCompList) {
			personPanel.add(p);
		}
		add(personPanel, BorderLayout.CENTER);
	}

	public void start() {
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btn) {

					// create customer id and customer
					cusIds.addId();
					Customer c = new Customer(cusIds.getRandomId());
					c.joinQue(shop.getTills());
					managePeople(c.getTillNo());

					for (PersonComp p : pCompList) {
						Thread t = new Thread(p);
						t.start();
					}
				}
			}
		});
		Thread st = new Thread(shop);
		st.start();
	}

	private void managePeople(int tillNo) {
		for (PersonComp p : pCompList) {
			if (tillNo == p.getId()) {
				p.addPerson();
				p.setSpeed(shop.getSpeed());
			}
		}
	}
}