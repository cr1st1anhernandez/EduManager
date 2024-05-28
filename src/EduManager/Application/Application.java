package EduManager.Application;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import EduManager.Components.Background;
import EduManager.Controllers.UserController;
import EduManager.Entities.Admin;
import EduManager.Entities.Coordinator;
import EduManager.Entities.Student;
import EduManager.Entities.Teacher;
import EduManager.Forms.AdminForm;
import EduManager.Forms.CoordinatorForm;
import EduManager.Forms.StudentForm;
import EduManager.Forms.TeacherForm;
import EduManager.Menu.FormManager;
import raven.popup.GlassPanePopup;

public class Application extends JFrame {

	private final boolean UNDECORATED = !true;

	public Application() {
		init();
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(UIScale.scale(new Dimension(1920, 1080)));
		setLocationRelativeTo(null);
		if (UNDECORATED) {
			setUndecorated(UNDECORATED);
			setBackground(new Color(0, 0, 0, 0));
		} else {
			getRootPane().putClientProperty(FlatClientProperties.FULL_WINDOW_CONTENT, true);
		}
		setContentPane(new Background(UNDECORATED));
		GlassPanePopup.install(this);
		FormManager.install(this, UNDECORATED);
		if (UserController.getUser() instanceof Student) {
			FormManager.showForm(new StudentForm());
		} else if (UserController.getUser() instanceof Coordinator) {
			FormManager.showForm(new CoordinatorForm());
		} else if (UserController.getUser() instanceof Teacher) {
			FormManager.showForm(new TeacherForm());
		} else if (UserController.getUser() instanceof Admin){
			FormManager.showForm(new AdminForm());
		}
	}
}
