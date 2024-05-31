package EduManager.Forms;

import java.util.List;

import javax.swing.JFrame;

import EduManager.Application.Application;
import EduManager.Components.GroupComponent;
import EduManager.Components.SimpleForm;
import EduManager.Components.SuccessComponent;
import EduManager.Components.SupportComponent;
import EduManager.Controllers.EnrollmentController;
import EduManager.Controllers.GroupSubjectController;
import EduManager.Controllers.UserController;
import EduManager.Entities.Enrollment;
import EduManager.Entities.GroupSubject;
import EduManager.Entities.Teacher;
import EduManager.Entities.User;
import EduManager.Menu.FormManager;
import EduManager.Utils.PdfGenerator;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import raven.swing.AvatarIcon;
import raven.toast.Notifications;

public class TeacherForm extends SimpleForm {

	GroupSubjectController groupController = new GroupSubjectController();
	GroupSubjectController groupSubjectController = new GroupSubjectController();
	EnrollmentController enrollmentController = new EnrollmentController();
	User user = UserController.getUser();
	Teacher teacher = (Teacher) user;

	public TeacherForm() {
		initComponents();
		String pathImage = user.getImagePath();
		AvatarIcon icon = new AvatarIcon(getClass().getResource(pathImage), 75, 75, 999);
		lblProfileImage.setIcon(icon);
		List<GroupSubject> groups = groupController.getGroupsSubjectsByTeacherId(teacher.getUserId());
		addGroupsToPanel(groups);
		lblWelcome.setText("Bienvenido " + teacher.getFirstName());
		lblName.setText(teacher.getFirstName() + " " + teacher.getLastName());
		lblSubject.setText("Profesor de " + teacher.getCareer());
	}

	public void addGroupsToPanel(List<GroupSubject> groups) {

		for (GroupSubject group : groups) {
			GroupComponent groupComponent = new GroupComponent();
			groupComponent.setDaysOfWeek(group.getFullDaysOfWeek());
			groupComponent.setGroup(group.getGroupId());
			groupComponent.setHour(group.getStartTime().toString() + "-" + group.getEndTime().toString());
			groupComponent.setSubject(group.getSubjectName());
			groupComponent.setGroupSubjectId(group.getGroupSubjectId());
			panelSchedule.add(groupComponent);
		}

		panelSchedule.revalidate();
		panelSchedule.repaint();
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                timePicker1 = new raven.datetime.component.time.TimePicker();
                timePicker2 = new raven.datetime.component.time.TimePicker();
                jPanel1 = new javax.swing.JPanel();
                panelRound1 = new EduManager.Components.PanelRound();
                jScrollPane1 = new javax.swing.JScrollPane();
                panelSchedule = new javax.swing.JPanel();
                lblUsernameContent4 = new javax.swing.JLabel();
                panelRound5 = new EduManager.Components.PanelRound();
                lblWelcome = new javax.swing.JLabel();
                lblUsernameContent3 = new javax.swing.JLabel();
                lblUsernameContent8 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                myButton1 = new EduManager.Components.MyButton();
                lblUsernameContent5 = new javax.swing.JLabel();
                panelRound6 = new EduManager.Components.PanelRound();
                lblName = new javax.swing.JLabel();
                lblSubject = new javax.swing.JLabel();
                calendar1 = new raven.calendar.Calendar();
                lblProfileImage = new javax.swing.JLabel();
                panelRound8 = new EduManager.Components.PanelRound();
                btnSupport = new EduManager.Components.MyButtonOutLine();
                btnLogOut = new EduManager.Components.MyButtonOutLine();

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

                jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
                jScrollPane1.setBorder(null);

                panelSchedule.setBackground(new java.awt.Color(255, 255, 255));
                panelSchedule.setLayout(new java.awt.GridLayout(8, 1, 0, 10));
                jScrollPane1.setViewportView(panelSchedule);

                javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
                panelRound1.setLayout(panelRound1Layout);
                panelRound1Layout.setHorizontalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(27, Short.MAX_VALUE))
                );
                panelRound1Layout.setVerticalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 1390, 600));

                lblUsernameContent4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent4.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent4.setText("Opciones");
                jPanel1.add(lblUsernameContent4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 730, -1, -1));

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

                myButton1.setBackground(new java.awt.Color(255, 255, 255));
                myButton1.setForeground(new java.awt.Color(102, 102, 102));
                myButton1.setText("Ver Configuraciones");
                myButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                myButton1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
                panelRound5.setLayout(panelRound5Layout);
                panelRound5Layout.setHorizontalGroup(
                        panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound5Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1390, 250));

                lblUsernameContent5.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent5.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent5.setText("Grupos Asignados");
                jPanel1.add(lblUsernameContent5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

                panelRound6.setBackground(new java.awt.Color(255, 255, 255));
                panelRound6.setRoundBottomLeft(30);
                panelRound6.setRoundBottomRight(30);
                panelRound6.setRoundTopLeft(30);
                panelRound6.setRoundTopRight(30);

                lblName.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblName.setForeground(new java.awt.Color(51, 51, 51));
                lblName.setText("Arturo Sorroza");

                lblSubject.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 14)); // NOI18N
                lblSubject.setForeground(new java.awt.Color(102, 102, 102));
                lblSubject.setText("Profesor de programacion");

                lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));

                javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
                panelRound6.setLayout(panelRound6Layout);
                panelRound6Layout.setHorizontalGroup(
                        panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound6Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelRound6Layout.createSequentialGroup()
                                                .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblName)
                                                        .addComponent(lblSubject))))
                                .addContainerGap(26, Short.MAX_VALUE))
                );
                panelRound6Layout.setVerticalGroup(
                        panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound6Layout.createSequentialGroup()
                                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound6Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(lblName)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblSubject))
                                        .addGroup(panelRound6Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblProfileImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addComponent(calendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 40, 390, 580));

                panelRound8.setBackground(new java.awt.Color(255, 255, 255));
                panelRound8.setRoundBottomLeft(20);
                panelRound8.setRoundBottomRight(20);
                panelRound8.setRoundTopLeft(20);
                panelRound8.setRoundTopRight(20);

                btnSupport.setText("Dudas o Sugerencias");
                btnSupport.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSupportActionPerformed(evt);
                        }
                });

                btnLogOut.setText("Cerrar Sesión");
                btnLogOut.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnLogOutActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
                panelRound8.setLayout(panelRound8Layout);
                panelRound8Layout.setHorizontalGroup(
                        panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound8Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnSupport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLogOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(23, Short.MAX_VALUE))
                );
                panelRound8Layout.setVerticalGroup(
                        panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound8Layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addComponent(btnSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                );

                jPanel1.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 780, 390, 180));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1850, 1000));
        }// </editor-fold>//GEN-END:initComponents

        private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
		// TODO add your handling code here:
		this.setVisible(false);
		JFrame loginForm = new LoginForm();
		loginForm.setVisible(true);
		Application app = new Application();
        }//GEN-LAST:event_btnLogOutActionPerformed

        private void btnSupportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupportActionPerformed
		// TODO add your handling code here:
		SupportComponent supportFrame = new SupportComponent();
		supportFrame.setUser(teacher.getFirstName() + " " + teacher.getLastName());
		supportFrame.setEmail(teacher.getEmail());
		supportFrame.setVisible(true);
        }//GEN-LAST:event_btnSupportActionPerformed

        private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
		// TODO add your handling code here:
		FormManager.showForm(new ProfileForm());
        }//GEN-LAST:event_myButton1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private EduManager.Components.MyButtonOutLine btnLogOut;
        private EduManager.Components.MyButtonOutLine btnSupport;
        private raven.calendar.Calendar calendar1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel lblName;
        private javax.swing.JLabel lblProfileImage;
        private javax.swing.JLabel lblSubject;
        private javax.swing.JLabel lblUsernameContent3;
        private javax.swing.JLabel lblUsernameContent4;
        private javax.swing.JLabel lblUsernameContent5;
        private javax.swing.JLabel lblUsernameContent8;
        private javax.swing.JLabel lblWelcome;
        private EduManager.Components.MyButton myButton1;
        private EduManager.Components.PanelRound panelRound1;
        private EduManager.Components.PanelRound panelRound5;
        private EduManager.Components.PanelRound panelRound6;
        private EduManager.Components.PanelRound panelRound8;
        private javax.swing.JPanel panelSchedule;
        private raven.datetime.component.time.TimePicker timePicker1;
        private raven.datetime.component.time.TimePicker timePicker2;
        // End of variables declaration//GEN-END:variables
}
