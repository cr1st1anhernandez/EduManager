package EduManager.Components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class MyPasswordField extends JPasswordField {

    private JButton button;

    public MyPasswordField() {
        setBackground(new Color(0, 0, 0, 0));
        setForeground(Color.decode("#6F6F81"));
        setFont(new java.awt.Font("CaskaydiaCove NF", 1, 16));
        setSelectionColor(Color.decode("#2563eb"));
        setMargin(new Insets(10, 15, 10, 50)); // Aumenté la margen derecha para acomodar el botón

        setBorder(javax.swing.BorderFactory.createLineBorder(Color.decode("#ECECEE"), 2, true));
        setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));

        button = new JButton("Ocultar"); // Cambia "Ocultar" por el texto que desees mostrar en el botón
        button.setFocusable(false);
        button.setBackground(Color.RED);
        button.setForeground(Color.decode("#000000"));
        button.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 16));
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Posiciona el botón al final a la derecha dentro del campo de contraseña
        int buttonWidth = button.getPreferredSize().width;
        button.setBounds(getWidth() - buttonWidth - 10, 0, buttonWidth, getHeight());
        add(button);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        super.paintComponent(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText().length() == 0) {
            int h = getHeight();
            ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            Insets ins = getInsets();
            FontMetrics fm = g.getFontMetrics();
            g.setColor(new Color(200, 200, 200));
        }
    }
}

