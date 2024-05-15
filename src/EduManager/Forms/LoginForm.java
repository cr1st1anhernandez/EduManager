/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package EduManager.Forms;

import EduManager.Application.Application;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.UIManager;
import EduManager.Utils.Utilities;

/**
 *
 * @author cristian
 */
public class LoginForm extends javax.swing.JFrame {

	/**
	 * Creates new form LoginForm
	 */
	public LoginForm() {
		initComponents();
	}
	Utilities utilities = new Utilities();

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
                jPanel1 = new javax.swing.JPanel();
                panelRound1 = new EduManager.Components.PanelRound();
                lblLogin = new javax.swing.JLabel();
                lblUser = new javax.swing.JLabel();
                lblUser1 = new javax.swing.JLabel();
                btnLogin = new EduManager.Components.MyButton();
                myTextField1 = new EduManager.Components.MyTextField();
                panelRound12 = new EduManager.Components.PanelRound();
                btnShowPassword = new javax.swing.JButton();
                txtPassword = new javax.swing.JPasswordField();
                panelRound2 = new EduManager.Components.PanelRound();
                jLabel3 = new javax.swing.JLabel();
                lblLogin1 = new javax.swing.JLabel();
                lblLogin2 = new javax.swing.JLabel();
                lblLogin3 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(246, 246, 246));

                jPanel1.setBackground(new java.awt.Color(226, 226, 226));
                jPanel1.setPreferredSize(new java.awt.Dimension(1900, 1080));

                panelRound1.setBackground(new java.awt.Color(255, 255, 255));
                panelRound1.setRoundBottomRight(20);
                panelRound1.setRoundTopRight(20);

                lblLogin.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 36)); // NOI18N
                lblLogin.setText("Iniciar Sesión");

                lblUser.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUser.setForeground(new java.awt.Color(111, 111, 129));
                lblUser.setText("Usuario");

                lblUser1.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUser1.setForeground(new java.awt.Color(111, 111, 129));
                lblUser1.setText("Contraseña");

                btnLogin.setText("Iniciar Sesión");
                btnLogin.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnLoginActionPerformed(evt);
                        }
                });

                myTextField1.setHint("22161096");

                panelRound12.setBackground(new java.awt.Color(255, 255, 255));
                panelRound12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 238), 2, true));
                panelRound12.setRoundBottomLeft(15);
                panelRound12.setRoundBottomRight(15);
                panelRound12.setRoundTopLeft(15);
                panelRound12.setRoundTopRight(15);
                panelRound12.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                panelRound12FocusLost(evt);
                        }
                });

                btnShowPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/eyeOpen.png"))); // NOI18N
                btnShowPassword.setBorder(null);
                btnShowPassword.setContentAreaFilled(false);
                btnShowPassword.setFocusPainted(false);
                btnShowPassword.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnShowPasswordActionPerformed(evt);
                        }
                });

                txtPassword.setBackground(new java.awt.Color(255, 255, 255));
                txtPassword.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 16)); // NOI18N
                txtPassword.setForeground(new java.awt.Color(111, 111, 129));
                txtPassword.setBorder(null);
                txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
                        public void focusGained(java.awt.event.FocusEvent evt) {
                                txtPasswordFocusGained(evt);
                        }
                        public void focusLost(java.awt.event.FocusEvent evt) {
                                txtPasswordFocusLost(evt);
                        }
                });

                javax.swing.GroupLayout panelRound12Layout = new javax.swing.GroupLayout(panelRound12);
                panelRound12.setLayout(panelRound12Layout);
                panelRound12Layout.setHorizontalGroup(
                        panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound12Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtPassword)
                                .addGap(18, 18, 18)
                                .addComponent(btnShowPassword)
                                .addContainerGap())
                );
                panelRound12Layout.setVerticalGroup(
                        panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnShowPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                        .addComponent(txtPassword)
                );

                javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
                panelRound1.setLayout(panelRound1Layout);
                panelRound1Layout.setHorizontalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(myTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblUser1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUser, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addGap(0, 128, Short.MAX_VALUE))
                                        .addComponent(panelRound12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(62, 62, 62))
                );
                panelRound1Layout.setVerticalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUser)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblUser1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelRound12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                );

                panelRound2.setBackground(new java.awt.Color(13, 148, 136));
                panelRound2.setRoundBottomLeft(20);
                panelRound2.setRoundTopLeft(20);

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/logoWhite.png"))); // NOI18N

                lblLogin1.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblLogin1.setForeground(new java.awt.Color(255, 255, 255));
                lblLogin1.setText("Gestion Estudiantil");

                lblLogin2.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 36)); // NOI18N
                lblLogin2.setForeground(new java.awt.Color(255, 255, 255));
                lblLogin2.setText("EduManager");

                lblLogin3.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblLogin3.setForeground(new java.awt.Color(255, 255, 255));
                lblLogin3.setText("<html><body>Sistema de gestión educativa, en este sistemas podras realizar la configuración de cuentas, la creación de grupos y la asignación de materias, simplifica cada paso para profesores y estudiantes.</body></html>");

                javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
                panelRound2.setLayout(panelRound2Layout);
                panelRound2Layout.setHorizontalGroup(
                        panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblLogin3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelRound2Layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(70, Short.MAX_VALUE))
                );
                panelRound2Layout.setVerticalGroup(
                        panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(panelRound2Layout.createSequentialGroup()
                                                .addComponent(lblLogin2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblLogin1))
                                        .addComponent(jLabel3))
                                .addGap(38, 38, 38)
                                .addComponent(lblLogin3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(160, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(471, Short.MAX_VALUE)
                                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(400, 400, 400))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(421, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
		// TODO add your handling code here:			
        }//GEN-LAST:event_myButton1ActionPerformed

        private void btnShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowPasswordActionPerformed
		// TODO add your handling code here:
		utilities.togglePasswordIcon(txtPassword, btnShowPassword);
        }//GEN-LAST:event_btnShowPasswordActionPerformed

        private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
		// TODO add your handling code here:
		this.setVisible(false);
		FlatRobotoFont.install();
		FlatLaf.registerCustomDefaultsSource("themes");
		UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
		FlatMacLightLaf.setup();
		EventQueue.invokeLater(() -> new Application().setVisible(true));
        }//GEN-LAST:event_btnLoginActionPerformed

        private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
		// TODO add your handling code here:
		panelRound12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(13, 148, 136), 2));
        }//GEN-LAST:event_txtPasswordFocusGained

        private void panelRound12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelRound12FocusLost
                // TODO add your handling code here:
		
        }//GEN-LAST:event_panelRound12FocusLost

        private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost
                // TODO add your handling code here:
		panelRound12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(236, 236, 238), 2));
        }//GEN-LAST:event_txtPasswordFocusLost

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginForm().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private EduManager.Components.MyButton btnLogin;
        private javax.swing.JButton btnShowPassword;
        private javax.swing.Box.Filler filler1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lblLogin;
        private javax.swing.JLabel lblLogin1;
        private javax.swing.JLabel lblLogin2;
        private javax.swing.JLabel lblLogin3;
        private javax.swing.JLabel lblUser;
        private javax.swing.JLabel lblUser1;
        private EduManager.Components.MyTextField myTextField1;
        private EduManager.Components.PanelRound panelRound1;
        private EduManager.Components.PanelRound panelRound12;
        private EduManager.Components.PanelRound panelRound2;
        private javax.swing.JPasswordField txtPassword;
        // End of variables declaration//GEN-END:variables
}
