package EduManager.Forms;

import EduManager.Components.SimpleForm;
import EduManager.Controllers.UserController;
import java.awt.Color;
import javax.swing.BorderFactory;
import EduManager.Menu.FormManager;

/**
 *
 * @author Raven
 */
public class CoordinatorForm extends SimpleForm {

    public CoordinatorForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                timePicker1 = new raven.datetime.component.time.TimePicker();
                timePicker2 = new raven.datetime.component.time.TimePicker();
                jPanel1 = new javax.swing.JPanel();
                lblTitle = new javax.swing.JLabel();

                setForeground(new java.awt.Color(246, 246, 246));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel1.setBackground(new java.awt.Color(246, 246, 246));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblTitle.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 36)); // NOI18N
                lblTitle.setForeground(new java.awt.Color(0, 0, 0));
                lblTitle.setText("COORDINATOR FORM");
                jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 14, -1, -1));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 760));
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lblTitle;
        private raven.datetime.component.time.TimePicker timePicker1;
        private raven.datetime.component.time.TimePicker timePicker2;
        // End of variables declaration//GEN-END:variables
}
