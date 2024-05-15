package EduManager.Components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class MyTextField extends JTextField implements FocusListener {

    private String hint = "";

    public MyTextField() {
        setBackground(new Color(0, 0, 0, 0));
        setForeground(Color.decode("#6F6F81"));
        setFont(new java.awt.Font("CaskaydiaCove NF", 1, 16));
        setSelectionColor(Color.decode("#2563eb"));
        setMargin(new Insets(10, 15, 10, 15));
        
        setBorder(javax.swing.BorderFactory.createLineBorder(Color.decode("#ECECEE"), 2, true));
        setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));

        addFocusListener(this);
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
            g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 148, 136), 2));
	setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 236, 238), 2));
	setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
}

