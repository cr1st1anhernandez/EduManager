package EduManager.Forms;

import EduManager.Application.Application;
import EduManager.Components.ComboBoxItem;
import EduManager.Components.ErrorComponent;
import EduManager.Components.GroupStudentComponent;
import EduManager.Components.GroupSubjectComponent;
import EduManager.Components.SimpleForm;
import EduManager.Components.SuccessComponent;
import EduManager.Controllers.EnrollmentController;
import EduManager.Controllers.GroupSubjectController;
import EduManager.Controllers.StudentController;
import EduManager.Controllers.UserController;
import EduManager.Entities.Coordinator;
import EduManager.Entities.Enrollment;
import EduManager.Entities.GroupSubject;
import EduManager.Entities.Student;
import EduManager.Entities.User;
import java.awt.Color;
import javax.swing.BorderFactory;
import EduManager.Menu.FormManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import raven.toast.Notifications;

/**
 *
 * @author Raven
 */
public class CoordinatorForm extends SimpleForm {

	User user = UserController.getUser();
	Coordinator coordinator = (Coordinator) user;
	EnrollmentController enrollmentController = new EnrollmentController();
	GroupSubjectController groupSubjectController = new GroupSubjectController();

	public CoordinatorForm() {
		initComponents();

	}

	private void fillPanelSubjects() {
		StudentController studentController = new StudentController();
		Student student = studentController.getStudentById(Integer.parseInt(txtControlNumberSearch.getText()));
		List<GroupSubject> groupSubjects = groupSubjectController.getGroupsBySemester(student.getSemester());
		panelSubjects.removeAll();

		for (GroupSubject groupSubject : groupSubjects) {
			GroupStudentComponent groupStudentComponent = new GroupStudentComponent();
			groupStudentComponent.setDaysOfWeek(groupSubject.getFullDaysOfWeek());
			groupStudentComponent.setSubject(groupSubject.getSubjectName());
			groupStudentComponent.setHour(groupSubject.getStartTime() + "-" + groupSubject.getEndTime());
			groupStudentComponent.setGroup(groupSubject.getGroupId() + "");
			groupStudentComponent.setGroupSubjectId(groupSubject.getGroupSubjectId());
			groupStudentComponent.setStudentId(student.getUserId());
			groupStudentComponent.setVacancies(groupSubject.getVacancies() + "");
			panelSubjects.add(groupStudentComponent);
		}

		panelSubjects.revalidate();
		panelSubjects.repaint();
	}

	public void fillPanelSchedule() {
		List<Enrollment> enrollments = enrollmentController.getEnrollmentsByStudentId(Integer.parseInt(txtControlNumberSearch.getText()));
		List<GroupSubject> groupSubjects = new ArrayList<>();

		for (Enrollment enrollment : enrollments) {
			GroupSubject groupSubject = groupSubjectController.getGroupSubjectById(enrollment.getGroupSubjectId());
			if (groupSubject != null) {
				groupSubjects.add(groupSubject);
			}
		}

		panelSchedule.removeAll();

		for (GroupSubject groupSubject : groupSubjects) {
			GroupSubjectComponent groupSubjectComponent = new GroupSubjectComponent();
			groupSubjectComponent.setDaysOfWeek(groupSubject.getFullDaysOfWeek());
			groupSubjectComponent.setSubject(groupSubject.getSubjectName());
			groupSubjectComponent.setTeacher(groupSubject.getTeacherName());
			groupSubjectComponent.setHour(groupSubject.getStartTime() + "-" + groupSubject.getEndTime());
			groupSubjectComponent.setStudentId(Integer.parseInt(txtControlNumberSearch.getText()));
			groupSubjectComponent.setGroupSubjectId(groupSubject.getGroupSubjectId());
			panelSchedule.add(groupSubjectComponent);
		}

		panelSchedule.revalidate();
		panelSchedule.repaint();
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                panelRound5 = new EduManager.Components.PanelRound();
                lblWelcome = new javax.swing.JLabel();
                lblUsernameContent3 = new javax.swing.JLabel();
                lblUsernameContent8 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                btnConfigs = new EduManager.Components.MyButton();
                panelRound8 = new EduManager.Components.PanelRound();
                btnSupport = new EduManager.Components.MyButtonOutLine();
                btnLogOut = new EduManager.Components.MyButtonOutLine();
                lblUsernameContent4 = new javax.swing.JLabel();
                panelRound9 = new EduManager.Components.PanelRound();
                lblUsernameContent7 = new javax.swing.JLabel();
                lblUsernameContent9 = new javax.swing.JLabel();
                lblUsernameContent10 = new javax.swing.JLabel();
                txtDeleteStudent = new EduManager.Components.MyTextField();
                btnDeleteStudent = new EduManager.Components.MyButton();
                panelRound1 = new EduManager.Components.PanelRound();
                jScrollPane2 = new javax.swing.JScrollPane();
                panelSubjects = new javax.swing.JPanel();
                lblUsernameContent2 = new javax.swing.JLabel();
                txtControlNumberSearch = new EduManager.Components.MyTextField();
                btnSearchAdd = new EduManager.Components.MyButton();
                panelRound6 = new EduManager.Components.PanelRound();
                jScrollPane1 = new javax.swing.JScrollPane();
                panelSchedule = new javax.swing.JPanel();
                lblName1 = new javax.swing.JLabel();

                setForeground(new java.awt.Color(246, 246, 246));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel1.setBackground(new java.awt.Color(234, 244, 242));
                jPanel1.setForeground(new java.awt.Color(250, 250, 250));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                                        .addComponent(lblWelcome)
                                        .addComponent(lblUsernameContent3)
                                        .addComponent(lblUsernameContent8))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelRound5Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(btnConfigs, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(585, Short.MAX_VALUE)))
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
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                                        .addContainerGap(182, Short.MAX_VALUE)
                                        .addComponent(btnConfigs, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)))
                );

                jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 830, 250));

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

                lblUsernameContent4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent4.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent4.setText("Opciones");

                javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
                panelRound8.setLayout(panelRound8Layout);
                panelRound8Layout.setHorizontalGroup(
                        panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound8Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblUsernameContent4)
                                        .addComponent(btnSupport, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                                        .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(29, Short.MAX_VALUE))
                );
                panelRound8Layout.setVerticalGroup(
                        panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound8Layout.createSequentialGroup()
                                .addContainerGap(9, Short.MAX_VALUE)
                                .addComponent(lblUsernameContent4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                );

                jPanel1.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 790, 510, 190));

                panelRound9.setBackground(new java.awt.Color(255, 255, 255));
                panelRound9.setRoundBottomLeft(20);
                panelRound9.setRoundBottomRight(20);
                panelRound9.setRoundTopLeft(20);
                panelRound9.setRoundTopRight(20);

                lblUsernameContent7.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 28)); // NOI18N
                lblUsernameContent7.setForeground(new java.awt.Color(225, 29, 72));
                lblUsernameContent7.setText("Acciones de riesgo");

                lblUsernameContent9.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent9.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent9.setText("Baja a un estudiante");

                lblUsernameContent10.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 16)); // NOI18N
                lblUsernameContent10.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent10.setText("Ingresar el numero de control");

                txtDeleteStudent.setHint("22161096");

                btnDeleteStudent.setBackground(new java.awt.Color(225, 29, 72));
                btnDeleteStudent.setText("Dar de baja");
                btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDeleteStudentActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound9Layout = new javax.swing.GroupLayout(panelRound9);
                panelRound9.setLayout(panelRound9Layout);
                panelRound9Layout.setHorizontalGroup(
                        panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound9Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound9Layout.createSequentialGroup()
                                                .addComponent(txtDeleteStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(17, 17, 17))
                                        .addGroup(panelRound9Layout.createSequentialGroup()
                                                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUsernameContent10)
                                                        .addComponent(lblUsernameContent9)
                                                        .addComponent(lblUsernameContent7))
                                                .addContainerGap(112, Short.MAX_VALUE))))
                );
                panelRound9Layout.setVerticalGroup(
                        panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound9Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblUsernameContent7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUsernameContent9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(lblUsernameContent10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                );

                jPanel1.add(panelRound9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 40, 420, 250));

                panelRound1.setBackground(new java.awt.Color(255, 255, 255));
                panelRound1.setRoundBottomLeft(30);
                panelRound1.setRoundBottomRight(30);
                panelRound1.setRoundTopLeft(30);
                panelRound1.setRoundTopRight(30);

                jScrollPane2.setBorder(null);

                panelSubjects.setBackground(new java.awt.Color(255, 255, 255));
                panelSubjects.setLayout(new java.awt.GridLayout(200, 1, 0, 10));
                jScrollPane2.setViewportView(panelSubjects);

                lblUsernameContent2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent2.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent2.setText("Materias Disponibles");

                javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
                panelRound1.setLayout(panelRound1Layout);
                panelRound1Layout.setHorizontalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUsernameContent2)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                );
                panelRound1Layout.setVerticalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(lblUsernameContent2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(42, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 1270, 580));

                txtControlNumberSearch.setHint("22161096");
                jPanel1.add(txtControlNumberSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 250, 50));

                btnSearchAdd.setText("Buscar");
                btnSearchAdd.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSearchAddActionPerformed(evt);
                        }
                });
                jPanel1.add(btnSearchAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 225, 50));

                panelRound6.setBackground(new java.awt.Color(255, 255, 255));
                panelRound6.setRoundBottomLeft(30);
                panelRound6.setRoundBottomRight(30);
                panelRound6.setRoundTopLeft(30);
                panelRound6.setRoundTopRight(30);
                panelRound6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jScrollPane1.setBorder(null);

                panelSchedule.setBackground(new java.awt.Color(255, 255, 255));
                panelSchedule.setLayout(new java.awt.GridLayout(8, 1, 0, 10));
                jScrollPane1.setViewportView(panelSchedule);

                panelRound6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 52, 470, 640));

                lblName1.setBackground(new java.awt.Color(51, 51, 51));
                lblName1.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblName1.setForeground(new java.awt.Color(51, 51, 51));
                lblName1.setText("Horario");
                panelRound6.add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

                jPanel1.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 40, 510, 720));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1850, 1000));
        }// </editor-fold>//GEN-END:initComponents

        private void btnSearchAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAddActionPerformed
		// TODO add your handling code here:
		fillPanelSchedule();
		fillPanelSubjects();
        }//GEN-LAST:event_btnSearchAddActionPerformed

        private void btnSupportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupportActionPerformed
		// TODO add your handling code here:

        }//GEN-LAST:event_btnSupportActionPerformed

        private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
		// TODO add your handling code here:
		this.setVisible(false);
		JFrame loginForm = new LoginForm();
		loginForm.setVisible(true);
		Application app = new Application();
        }//GEN-LAST:event_btnLogOutActionPerformed

        private void btnConfigsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigsActionPerformed
		// TODO add your handling code here:
		FormManager.showForm(new ProfileForm());
        }//GEN-LAST:event_btnConfigsActionPerformed

        private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed
		// TODO add your handling code here:
		StudentController studentController = new StudentController();
		if (studentController.deleteStudentById(Integer.parseInt(txtDeleteStudent.getText()))) {
			SuccessComponent successComponent = new SuccessComponent();
			successComponent.setText("Estudiante dado de baja");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
			return;
		}
		ErrorComponent errorComponent = new ErrorComponent();
		errorComponent.setText("No se ha podido dar de baja al estudiante");
		Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, errorComponent);
        }//GEN-LAST:event_btnDeleteStudentActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private EduManager.Components.MyButton btnConfigs;
        private EduManager.Components.MyButton btnDeleteStudent;
        private EduManager.Components.MyButtonOutLine btnLogOut;
        private EduManager.Components.MyButton btnSearchAdd;
        private EduManager.Components.MyButtonOutLine btnSupport;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JLabel lblName1;
        private javax.swing.JLabel lblUsernameContent10;
        private javax.swing.JLabel lblUsernameContent2;
        private javax.swing.JLabel lblUsernameContent3;
        private javax.swing.JLabel lblUsernameContent4;
        private javax.swing.JLabel lblUsernameContent7;
        private javax.swing.JLabel lblUsernameContent8;
        private javax.swing.JLabel lblUsernameContent9;
        private javax.swing.JLabel lblWelcome;
        private EduManager.Components.PanelRound panelRound1;
        private EduManager.Components.PanelRound panelRound5;
        private EduManager.Components.PanelRound panelRound6;
        private EduManager.Components.PanelRound panelRound8;
        private EduManager.Components.PanelRound panelRound9;
        private javax.swing.JPanel panelSchedule;
        private javax.swing.JPanel panelSubjects;
        private EduManager.Components.MyTextField txtControlNumberSearch;
        private EduManager.Components.MyTextField txtDeleteStudent;
        // End of variables declaration//GEN-END:variables
}
