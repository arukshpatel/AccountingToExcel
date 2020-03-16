
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public abstract class Main extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					Graphics gui = new Graphics();
					gui.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}

}
