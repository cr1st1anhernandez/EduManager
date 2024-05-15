package EduManager.Application;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.UIManager;
import EduManager.Components.Background;
import EduManager.Forms.ActionsForm;
import EduManager.Menu.FormManager;
import raven.popup.GlassPanePopup;

/**
 *
 * @author Cr1st1anH3rnand3z
 */
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
        // applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        GlassPanePopup.install(this);
        FormManager.install(this, UNDECORATED);
        FormManager.showForm(new ActionsForm());
        // applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    public static void main(String[] args) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        EventQueue.invokeLater(() -> new Application().setVisible(true));
    }
}