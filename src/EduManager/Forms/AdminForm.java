package EduManager.Forms;

import EduManager.Application.Application;
import EduManager.Components.SimpleForm;
import EduManager.Components.SuccessComponent;
import EduManager.Controllers.UserController;
import EduManager.DataBase.Database;
import EduManager.DataBase.DatabaseAccess;
import EduManager.Menu.FormManager;
import EduManager.Excel.InsertCoordinators;
import EduManager.Excel.InsertGroupSubjects;
import EduManager.Excel.InsertGroups;
import EduManager.Excel.InsertStudents;
import EduManager.Excel.InsertSubjects;
import EduManager.Excel.InsertTeachers;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static EduManager.Utils.Utilities.hashPassword;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import raven.toast.Notifications;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

/**
 *
 * @author Raven
 */
public class AdminForm extends SimpleForm {

	public AdminForm() {
		initComponents();
	}
	SuccessComponent successComponent = new SuccessComponent();
	
	private static Connection connection;
	
	private static void processSheet(Sheet sheet, String sql) throws SQLException {
        if (sheet == null) {
            return;
        }
	connection = DatabaseAccess.getConnection();
	
        PreparedStatement statement = connection.prepareStatement(sql);
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip header row
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (int i = 0; i < row.getLastCellNum(); i++) {
                statement.setString(i + 1, row.getCell(i).toString());
            }
            statement.addBatch();
        }
        statement.executeBatch();
    }

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                timePicker1 = new raven.datetime.component.time.TimePicker();
                timePicker2 = new raven.datetime.component.time.TimePicker();
                jPanel1 = new javax.swing.JPanel();
                panelRound1 = new EduManager.Components.PanelRound();
                lblUsernameContent5 = new javax.swing.JLabel();
                btnImportData = new EduManager.Components.MyButton();
                lblUsernameContent6 = new javax.swing.JLabel();
                lblUsernameContent7 = new javax.swing.JLabel();
                lblUsernameContent9 = new javax.swing.JLabel();
                lblUsernameContent10 = new javax.swing.JLabel();
                panelRound5 = new EduManager.Components.PanelRound();
                lblWelcome = new javax.swing.JLabel();
                lblUsernameContent3 = new javax.swing.JLabel();
                lblUsernameContent8 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                btnConfigs = new EduManager.Components.MyButton();
                panelRound8 = new EduManager.Components.PanelRound();
                btnLogOut = new EduManager.Components.MyButtonOutLine();
                lblUsernameContent4 = new javax.swing.JLabel();
                panelRound10 = new EduManager.Components.PanelRound();
                lblUsernameContent13 = new javax.swing.JLabel();
                btnHashPassword = new EduManager.Components.MyButton();
                txtPassword = new EduManager.Components.MyTextField();
                lblUsernameContent15 = new javax.swing.JLabel();
                lblUsernameContent14 = new javax.swing.JLabel();
                lblHashPassword = new javax.swing.JLabel();
                btnCopy = new javax.swing.JButton();
                panelRound11 = new EduManager.Components.PanelRound();
                lblUsernameContent16 = new javax.swing.JLabel();
                lblUsernameContent17 = new javax.swing.JLabel();
                btnDeleteUser1 = new EduManager.Components.MyButton();
                txtDeleteUser1 = new EduManager.Components.MyTextField();
                lblUsernameContent18 = new javax.swing.JLabel();

                setForeground(new java.awt.Color(246, 246, 246));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel1.setBackground(new java.awt.Color(234, 244, 242));
                jPanel1.setForeground(new java.awt.Color(250, 250, 250));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                panelRound1.setBackground(new java.awt.Color(255, 255, 255));
                panelRound1.setRoundBottomLeft(30);
                panelRound1.setRoundBottomRight(30);
                panelRound1.setRoundTopLeft(30);
                panelRound1.setRoundTopRight(30);
                panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblUsernameContent5.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 12)); // NOI18N
                lblUsernameContent5.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent5.setText("Studentes, Teachers, Coordinators, Subjects,Groups, GroupsSubjects");
                panelRound1.add(lblUsernameContent5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

                btnImportData.setText("Importar");
                btnImportData.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnImportDataActionPerformed(evt);
                        }
                });
                panelRound1.add(btnImportData, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 240, 50));

                lblUsernameContent6.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent6.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent6.setText("Importar datos desde un archivo excel");
                panelRound1.add(lblUsernameContent6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

                lblUsernameContent7.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent7.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent7.setText("Importar datos desde un archivo excel");
                panelRound1.add(lblUsernameContent7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

                lblUsernameContent9.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 12)); // NOI18N
                lblUsernameContent9.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent9.setText("Para poder importar datos el archivo debera contener 5 hojas de excel");
                panelRound1.add(lblUsernameContent9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

                lblUsernameContent10.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 12)); // NOI18N
                lblUsernameContent10.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent10.setText("el archivo se encuentra en la raiz del proyecto con el nombre Data.xslx");
                panelRound1.add(lblUsernameContent10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 1390, 210));

                panelRound5.setBackground(new java.awt.Color(13, 148, 136));
                panelRound5.setRoundBottomLeft(30);
                panelRound5.setRoundBottomRight(30);
                panelRound5.setRoundTopLeft(30);
                panelRound5.setRoundTopRight(30);

                lblWelcome.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 48)); // NOI18N
                lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
                lblWelcome.setText("Bienvenido Arturo");

                lblUsernameContent3.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 24)); // NOI18N
                lblUsernameContent3.setForeground(new java.awt.Color(250, 250, 250));
                lblUsernameContent3.setText("en la pestaña configuraciones de perfil");

                lblUsernameContent8.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 24)); // NOI18N
                lblUsernameContent8.setForeground(new java.awt.Color(250, 250, 250));
                lblUsernameContent8.setText("Puedes cambiar los datos de tu perfil");

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/Programming.png"))); // NOI18N

                btnConfigs.setBackground(new java.awt.Color(255, 255, 255));
                btnConfigs.setForeground(new java.awt.Color(102, 102, 102));
                btnConfigs.setText("Ver Configuraciones");
                btnConfigs.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnConfigsActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
                panelRound5.setLayout(panelRound5Layout);
                panelRound5Layout.setHorizontalGroup(
                        panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnConfigs, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblWelcome)
                                        .addComponent(lblUsernameContent3)
                                        .addComponent(lblUsernameContent8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 543, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25))
                );
                panelRound5Layout.setVerticalGroup(
                        panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panelRound5Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lblWelcome)
                                .addGap(18, 18, 18)
                                .addComponent(lblUsernameContent8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUsernameContent3)
                                .addGap(18, 18, 18)
                                .addComponent(btnConfigs, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1390, 250));

                panelRound8.setBackground(new java.awt.Color(255, 255, 255));
                panelRound8.setRoundBottomLeft(20);
                panelRound8.setRoundBottomRight(20);
                panelRound8.setRoundTopLeft(20);
                panelRound8.setRoundTopRight(20);

                btnLogOut.setText("Cerrar Sesión");
                btnLogOut.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnLogOutActionPerformed(evt);
                        }
                });

                lblUsernameContent4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent4.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent4.setText("Opciones");

                javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
                panelRound8.setLayout(panelRound8Layout);
                panelRound8Layout.setHorizontalGroup(
                        panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUsernameContent4)
                                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                );
                panelRound8Layout.setVerticalGroup(
                        panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound8Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblUsernameContent4)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(132, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 40, 390, 250));

                panelRound10.setBackground(new java.awt.Color(255, 255, 255));
                panelRound10.setRoundBottomLeft(20);
                panelRound10.setRoundBottomRight(20);
                panelRound10.setRoundTopLeft(20);
                panelRound10.setRoundTopRight(20);

                lblUsernameContent13.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 28)); // NOI18N
                lblUsernameContent13.setForeground(new java.awt.Color(13, 148, 136));
                lblUsernameContent13.setText("Obtener el hash de una contraseña");

                btnHashPassword.setText("Hashear");
                btnHashPassword.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnHashPasswordActionPerformed(evt);
                        }
                });

                txtPassword.setHint("Password9$");

                lblUsernameContent15.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 16)); // NOI18N
                lblUsernameContent15.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent15.setText("Ingresar contraseña");

                lblUsernameContent14.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 28)); // NOI18N
                lblUsernameContent14.setForeground(new java.awt.Color(13, 148, 136));
                lblUsernameContent14.setText("Contraseña hasheada");

                lblHashPassword.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 18)); // NOI18N
                lblHashPassword.setForeground(new java.awt.Color(153, 153, 153));
                lblHashPassword.setText("bd9509aba7d1e5ab68bc526195d369f2418f26f044f5bc2c9af3871a486a6bd3");

                btnCopy.setBackground(new java.awt.Color(255, 255, 255));
                btnCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Icons/copy.png"))); // NOI18N
                btnCopy.setBorderPainted(false);
                btnCopy.setContentAreaFilled(false);
                btnCopy.setFocusPainted(false);
                btnCopy.setFocusable(false);
                btnCopy.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCopyActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
                panelRound10.setLayout(panelRound10Layout);
                panelRound10Layout.setHorizontalGroup(
                        panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound10Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnHashPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUsernameContent15)
                                                        .addComponent(lblUsernameContent13))
                                                .addContainerGap(842, Short.MAX_VALUE))
                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblHashPassword)
                                                        .addComponent(lblUsernameContent14))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnCopy)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                );
                panelRound10Layout.setVerticalGroup(
                        panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound10Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblUsernameContent13)
                                .addGap(18, 18, 18)
                                .addComponent(lblUsernameContent15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnHashPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lblUsernameContent14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblHashPassword))
                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(btnCopy)))
                                .addContainerGap(135, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 1390, 370));

                panelRound11.setBackground(new java.awt.Color(255, 255, 255));
                panelRound11.setRoundBottomLeft(20);
                panelRound11.setRoundBottomRight(20);
                panelRound11.setRoundTopLeft(20);
                panelRound11.setRoundTopRight(20);

                lblUsernameContent16.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 28)); // NOI18N
                lblUsernameContent16.setForeground(new java.awt.Color(225, 29, 72));
                lblUsernameContent16.setText("Acciones de riesgo");

                lblUsernameContent17.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent17.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent17.setText("Eliminar algun usuario");

                btnDeleteUser1.setBackground(new java.awt.Color(225, 29, 72));
                btnDeleteUser1.setText("Eliminar");
                btnDeleteUser1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDeleteUser1ActionPerformed(evt);
                        }
                });

                txtDeleteUser1.setHint("22161096");

                lblUsernameContent18.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 16)); // NOI18N
                lblUsernameContent18.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent18.setText("Ingresar el numero de control");

                javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
                panelRound11.setLayout(panelRound11Layout);
                panelRound11Layout.setHorizontalGroup(
                        panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound11Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound11Layout.createSequentialGroup()
                                                .addComponent(lblUsernameContent16)
                                                .addContainerGap(82, Short.MAX_VALUE))
                                        .addGroup(panelRound11Layout.createSequentialGroup()
                                                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUsernameContent18)
                                                        .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(lblUsernameContent17)
                                                                .addComponent(txtDeleteUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(btnDeleteUser1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                );
                panelRound11Layout.setVerticalGroup(
                        panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound11Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblUsernameContent16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUsernameContent17)
                                .addGap(19, 19, 19)
                                .addComponent(lblUsernameContent18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDeleteUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeleteUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(366, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 360, 390, 610));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1850, 1000));
        }// </editor-fold>//GEN-END:initComponents

        private void btnConfigsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigsActionPerformed
		// TODO add your handling code here:
		FormManager.showForm(new ProfileForm());
        }//GEN-LAST:event_btnConfigsActionPerformed

        private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
		// TODO add your handling code here:
		this.setVisible(false);
		JFrame loginForm = new LoginForm();
		loginForm.setVisible(true);
		Application app = new Application();
        }//GEN-LAST:event_btnLogOutActionPerformed

        private void btnImportDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportDataActionPerformed
		try {
			// TODO add your handling code here:
			SuccessComponent successComponent = new SuccessComponent();
			successComponent.setText("Si existen datos duplicados no seran tomados en cuenta");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
			InsertTeachers.main(new String[0]);
			InsertCoordinators.main(new String[0]);
			InsertStudents.main(new String[0]);
			InsertGroups.main(new String[0]);
			InsertSubjects.main(new String[0]);
			InsertGroupSubjects.main(new String[0]);
		} catch (SQLException ex) {
			Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ParseException ex) {
			Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
		}
		
        }//GEN-LAST:event_btnImportDataActionPerformed

        private void btnHashPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHashPasswordActionPerformed
                // TODO add your handling code here:
		String password = txtPassword.getText();
		String hashPassword = hashPassword(password);
		lblHashPassword.setText(hashPassword);
        }//GEN-LAST:event_btnHashPasswordActionPerformed

        private void btnDeleteUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUser1ActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_btnDeleteUser1ActionPerformed

        private void btnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyActionPerformed
                // TODO add your handling code here:
		String hashPassword = lblHashPassword.getText();
		StringSelection stringSelection = new StringSelection(hashPassword);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		successComponent.setText("Contraseña copiada al portapapeles");
		Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
        }//GEN-LAST:event_btnCopyActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private EduManager.Components.MyButton btnConfigs;
        private javax.swing.JButton btnCopy;
        private EduManager.Components.MyButton btnDeleteUser1;
        private EduManager.Components.MyButton btnHashPassword;
        private EduManager.Components.MyButton btnImportData;
        private EduManager.Components.MyButtonOutLine btnLogOut;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lblHashPassword;
        private javax.swing.JLabel lblUsernameContent10;
        private javax.swing.JLabel lblUsernameContent13;
        private javax.swing.JLabel lblUsernameContent14;
        private javax.swing.JLabel lblUsernameContent15;
        private javax.swing.JLabel lblUsernameContent16;
        private javax.swing.JLabel lblUsernameContent17;
        private javax.swing.JLabel lblUsernameContent18;
        private javax.swing.JLabel lblUsernameContent3;
        private javax.swing.JLabel lblUsernameContent4;
        private javax.swing.JLabel lblUsernameContent5;
        private javax.swing.JLabel lblUsernameContent6;
        private javax.swing.JLabel lblUsernameContent7;
        private javax.swing.JLabel lblUsernameContent8;
        private javax.swing.JLabel lblUsernameContent9;
        private javax.swing.JLabel lblWelcome;
        private EduManager.Components.PanelRound panelRound1;
        private EduManager.Components.PanelRound panelRound10;
        private EduManager.Components.PanelRound panelRound11;
        private EduManager.Components.PanelRound panelRound5;
        private EduManager.Components.PanelRound panelRound8;
        private raven.datetime.component.time.TimePicker timePicker1;
        private raven.datetime.component.time.TimePicker timePicker2;
        private EduManager.Components.MyTextField txtDeleteUser1;
        private EduManager.Components.MyTextField txtPassword;
        // End of variables declaration//GEN-END:variables
}
