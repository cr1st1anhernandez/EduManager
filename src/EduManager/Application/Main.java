/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EduManager.Application;

import EduManager.Forms.LoginForm;
import javax.swing.JFrame;

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
