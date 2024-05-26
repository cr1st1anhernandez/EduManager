package EduManager.Menu;

import javax.swing.JPanel;

import com.formdev.flatlaf.FlatClientProperties;

/**
 *
 * @author Raven
 */
public class ThemesChange extends JPanel {

    public ThemesChange() {
        init();
    }

    private void init() {
        putClientProperty(FlatClientProperties.STYLE, ""
                + "background:null");
    }
}
