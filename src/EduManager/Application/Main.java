package EduManager.Application;

import javax.swing.JFrame;

import EduManager.Forms.LoginForm;

/**
 *
 * @author cristian
 */
public class Main extends JFrame {

	public static void main(String[] args) {
		JFrame loginForm = new LoginForm();
		loginForm.setVisible(true);
		Application app = new Application();
	}
}
