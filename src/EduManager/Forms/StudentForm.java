package EduManager.Forms;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import EduManager.Components.ComboBoxItem;
import EduManager.Components.GroupSubjectComponent;
import EduManager.Components.SimpleForm;
import EduManager.Controllers.EnrollmentController;
import EduManager.Controllers.GroupSubjectController;
import EduManager.Controllers.UserController;
import EduManager.Entities.Enrollment;
import EduManager.Entities.GroupSubject;
import EduManager.Entities.Student;
import EduManager.Entities.User;
import EduManager.Menu.FormManager;
import raven.swing.AvatarIcon;

public class StudentForm extends SimpleForm {

	String[] timeSlots = {
		"07:00:00-08:00:00", "08:00:00-09:00:00", "09:00:00-10:00:00",
		"10:00:00-11:00:00", "11:00:00-12:00:00", "12:00:00-13:00:00",
		"13:00:00-14:00:00", "14:00:00-15:00:00", "15:00:00-16:00:00",
		"16:00:00-17:00:00", "17:00:00-18:00:00", "19:00:00-20:00:00",
		"20:00:00-21:00:00"
	};

	User user = UserController.getUser();
	Student student = (Student) user;
	EnrollmentController enrollmentController = new EnrollmentController();
	GroupSubjectController groupSubjectController = new GroupSubjectController();
	AvatarIcon icon = new AvatarIcon(getClass().getResource("/EduManager/Images/profile.png"), 75, 75, 999);

	public StudentForm() {
		initComponents();
		lblProfileImage.setIcon(icon);
		for (String timeSlot : timeSlots) {
			combobox1.addItem(timeSlot);
		}
		fillComboBoxBySemester(student.getSemester());
		lblWelcome.setText("Bienvenido " + student.getFirstName());
		lblName.setText(student.getFirstName() + " " + student.getLastName());
		lblCareer.setText(student.getCareer());
		fillPanelSchedule();
	}

	public void fillPanelSchedule() {
		List<Enrollment> enrollments = enrollmentController.getEnrollmentsByStudentId(student.getUserId());
		List<GroupSubject> groupSubjects = new ArrayList<>();

		for (Enrollment enrollment : enrollments) {
			GroupSubject groupSubject = groupSubjectController
				.getGroupSubjectById(enrollment.getGroupSubjectId());
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
			groupSubjectComponent.setHour(groupSubject.getStartTime() + "");
                        groupSubjectComponent.setStudentId(student.getUserId());
                        groupSubjectComponent.setGroupSubjectId(groupSubject.getGroupSubjectId());
			panelSchedule.add(groupSubjectComponent);
		}

		panelSchedule.revalidate();
		panelSchedule.repaint();
	}

	private void fillComboBoxBySemester(int semester) {
		List<GroupSubject> groupSubjects = groupSubjectController.getGroupsBySemester(semester);
		combobox2.removeAllItems();
		for (GroupSubject groupSubject : groupSubjects) {
			String item = groupSubject.getSubjectName() + " [" + groupSubject.getStartTime() + "-"
				+ groupSubject.getEndTime() + "] " + groupSubject.getTeacherName()
				+ " Cupo:" + groupSubject.getCapacity() + " Id:"
				+ groupSubject.getGroupSubjectId() + " Dias:" + groupSubject.getDaysOfWeek();
			ComboBoxItem comboBoxItem = new ComboBoxItem(groupSubject.getGroupSubjectId(), item);
			combobox2.addItem(comboBoxItem);
		}
	}

	private void fillComboBoxBySemesterAndTime(int semester, String time) {
		List<GroupSubject> groupSubjects = groupSubjectController.getGroupsBySemesterAndTime(semester, time);
		combobox2.removeAllItems();
		for (GroupSubject groupSubject : groupSubjects) {
			String item = groupSubject.getSubjectName() + " [" + groupSubject.getStartTime() + "-"
				+ groupSubject.getEndTime() + "] " + groupSubject.getTeacherName()
				+ " Cupo:" + groupSubject.getCapacity() + " Id:"
				+ groupSubject.getGroupSubjectId() + " Dias:"
				+ groupSubject.getFullDaysOfWeek();
			ComboBoxItem comboBoxItem = new ComboBoxItem(groupSubject.getGroupSubjectId(), item);
			combobox2.addItem(comboBoxItem);
		}
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                panelRound5 = new EduManager.Components.PanelRound();
                lblWelcome = new javax.swing.JLabel();
                lblUsernameContent3 = new javax.swing.JLabel();
                lblUsernameContent8 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                myButton1 = new EduManager.Components.MyButton();
                combobox1 = new EduManager.Components.Combobox();
                btnSearch = new EduManager.Components.MyButtonOutLine();
                combobox2 = new EduManager.Components.Combobox();
                btnMatricular = new EduManager.Components.MyButton();
                lblUsernameContent2 = new javax.swing.JLabel();
                panelRound1 = new EduManager.Components.PanelRound();
                jScrollPane1 = new javax.swing.JScrollPane();
                panelSchedule = new javax.swing.JPanel();
                panelRound6 = new EduManager.Components.PanelRound();
                lblName = new javax.swing.JLabel();
                lblCareer = new javax.swing.JLabel();
                calendar1 = new raven.calendar.Calendar();
                lblProfileImage = new javax.swing.JLabel();
                lblUsernameContent4 = new javax.swing.JLabel();
                panelRound8 = new EduManager.Components.PanelRound();
                myButton2 = new EduManager.Components.MyButton();
                btnLogOut = new EduManager.Components.MyButtonOutLine();
                btnSupport = new EduManager.Components.MyButtonOutLine();

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
                lblWelcome.setText("Bienvenido Cristian");

                lblUsernameContent3.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 24)); // NOI18N
                lblUsernameContent3.setForeground(new java.awt.Color(250, 250, 250));
                lblUsernameContent3.setText("en la pestaña configuraciones de perfil");

                lblUsernameContent8.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 24)); // NOI18N
                lblUsernameContent8.setForeground(new java.awt.Color(250, 250, 250));
                lblUsernameContent8.setText("Puedes cambiar los datos de tu perfil");

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/Learning.png"))); // NOI18N

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
                                                                .addGroup(panelRound5Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(myButton1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                225,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblWelcome)
                                                                                .addComponent(lblUsernameContent3)
                                                                                .addComponent(lblUsernameContent8))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                543, Short.MAX_VALUE)
                                                                .addComponent(jLabel3)
                                                                .addGap(25, 25, 25)));
                panelRound5Layout.setVerticalGroup(
                                panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                panelRound5Layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(panelRound5Layout.createSequentialGroup()
                                                                .addGap(15, 15, 15)
                                                                .addComponent(lblWelcome)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(lblUsernameContent8)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblUsernameContent3)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(myButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                52,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1390, 250));

                combobox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 148, 136), 2, true));
                combobox1.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                combobox1.setLabeText("Hora");
                jPanel1.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 1110, 50));

                btnSearch.setText("Buscar");
                btnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSearchActionPerformed(evt);
                        }
                });
                jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 330, 260, 50));

                combobox2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 148, 136), 2, true));
                combobox2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                combobox2.setLabeText("Matricular Materia");
                jPanel1.add(combobox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 1110, 50));

                btnMatricular.setText("Matricular");
                btnMatricular.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnMatricularActionPerformed(evt);
                        }
                });
                jPanel1.add(btnMatricular, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 410, 260, 50));

                lblUsernameContent2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent2.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent2.setText("Horario");
                jPanel1.add(lblUsernameContent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

                panelRound1.setBackground(new java.awt.Color(255, 255, 255));
                panelRound1.setRoundBottomLeft(30);
                panelRound1.setRoundBottomRight(30);
                panelRound1.setRoundTopLeft(30);
                panelRound1.setRoundTopRight(30);

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
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                1347,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(27, Short.MAX_VALUE)));
                panelRound1Layout.setVerticalGroup(
                                panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRound1Layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                442,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(21, Short.MAX_VALUE)));

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 1390, 480));

                panelRound6.setBackground(new java.awt.Color(255, 255, 255));
                panelRound6.setRoundBottomLeft(30);
                panelRound6.setRoundBottomRight(30);
                panelRound6.setRoundTopLeft(30);
                panelRound6.setRoundTopRight(30);

                lblName.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblName.setForeground(new java.awt.Color(51, 51, 51));
                lblName.setText("Cristian Hernandez");

                lblCareer.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 14)); // NOI18N
                lblCareer.setForeground(new java.awt.Color(102, 102, 102));
                lblCareer.setText("Estudiante Ing. Sistemas");

                lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));

                javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
                panelRound6.setLayout(panelRound6Layout);
                panelRound6Layout.setHorizontalGroup(
                                panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRound6Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addGroup(panelRound6Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(calendar1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                345,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(panelRound6Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(lblProfileImage,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(panelRound6Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(lblName)
                                                                                                                .addComponent(lblCareer))))
                                                                .addContainerGap(26, Short.MAX_VALUE)));
                panelRound6Layout.setVerticalGroup(
                                panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRound6Layout.createSequentialGroup()
                                                                .addGroup(panelRound6Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelRound6Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(26, 26, 26)
                                                                                                .addComponent(lblName)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(lblCareer))
                                                                                .addGroup(panelRound6Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(lblProfileImage,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(12, 12, 12)
                                                                .addComponent(calendar1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                477,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(20, Short.MAX_VALUE)));

                jPanel1.add(panelRound6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 40, 390, 590));

                lblUsernameContent4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent4.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent4.setText("Opciones");
                jPanel1.add(lblUsernameContent4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 650, -1, -1));

                panelRound8.setBackground(new java.awt.Color(255, 255, 255));
                panelRound8.setRoundBottomLeft(20);
                panelRound8.setRoundBottomRight(20);
                panelRound8.setRoundTopLeft(20);
                panelRound8.setRoundTopRight(20);

                myButton2.setText("Descargar Horario");

                btnLogOut.setText("Cerrar Sesion");
                btnLogOut.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnLogOutActionPerformed(evt);
                        }
                });

                btnSupport.setText("Dudas o Sugerencias");
                btnSupport.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSupportActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
                panelRound8.setLayout(panelRound8Layout);
                panelRound8Layout.setHorizontalGroup(
                                panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRound8Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addGroup(panelRound8Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(btnLogOut,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                350, Short.MAX_VALUE)
                                                                                .addComponent(myButton2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(btnSupport,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                350, Short.MAX_VALUE))
                                                                .addContainerGap(20, Short.MAX_VALUE)));
                panelRound8Layout.setVerticalGroup(
                                panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRound8Layout.createSequentialGroup()
                                                                .addGap(28, 28, 28)
                                                                .addComponent(myButton2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                53,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(btnSupport,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                54,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnLogOut,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                54,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(61, Short.MAX_VALUE)));

                jPanel1.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 700, 390, 280));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1850, 1000));
        }// </editor-fold>//GEN-END:initComponents

	private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchActionPerformed
		// TODO add your handling code here:
		String selectedTimeRange = (String) combobox1.getSelectedItem();

		if (selectedTimeRange != null && !selectedTimeRange.isEmpty()) {
			String[] times = selectedTimeRange.split("-");
			if (times.length == 2) {
				String startTime = times[0].trim();
				String endTime = times[1].trim();
				fillComboBoxBySemesterAndTime(4, startTime);
			} else {
				System.out.println("Formato de tiempo inválido.");
			}
		} else {
			System.out.println("Por favor seleccione un horario.");
		}
	}// GEN-LAST:event_btnSearchActionPerformed

	private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnMatricularActionPerformed
		ComboBoxItem selectedItem = (ComboBoxItem) combobox2.getSelectedItem();
		int groupSubjectId = selectedItem.getValue();

		Enrollment enrollment = new Enrollment();
		enrollment.setStudentId(student.getUserId());
		enrollment.setGroupSubjectId(groupSubjectId);

		if (enrollmentController.addEnrollment(enrollment)) {
			fillPanelSchedule();
		}
	}// GEN-LAST:event_btnMatricularActionPerformed

	private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLogOutActionPerformed
		// TODO add your handling code here:
		JFrame currentFrame = (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);
		currentFrame.dispose();

		EventQueue.invokeLater(() -> {
			JFrame loginForm = new LoginForm();
			loginForm.setVisible(true);
		});
	}// GEN-LAST:event_btnLogOutActionPerformed

	private void btnSupportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSupportActionPerformed
		// TODO add your handling code here:
		SupportFrame supportFrame = new SupportFrame();
		supportFrame.setEmail(student.getEmail());
		supportFrame.setVisible(true);
	}// GEN-LAST:event_btnSupportActionPerformed

	private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_myButton1ActionPerformed
		// TODO add your handling code here:
		FormManager.showForm(new ProfileForm());
	}// GEN-LAST:event_myButton1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private EduManager.Components.MyButtonOutLine btnLogOut;
        private EduManager.Components.MyButton btnMatricular;
        private EduManager.Components.MyButtonOutLine btnSearch;
        private EduManager.Components.MyButtonOutLine btnSupport;
        private raven.calendar.Calendar calendar1;
        private EduManager.Components.Combobox combobox1;
        private EduManager.Components.Combobox combobox2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel lblCareer;
        private javax.swing.JLabel lblName;
        private javax.swing.JLabel lblProfileImage;
        private javax.swing.JLabel lblUsernameContent2;
        private javax.swing.JLabel lblUsernameContent3;
        private javax.swing.JLabel lblUsernameContent4;
        private javax.swing.JLabel lblUsernameContent8;
        private javax.swing.JLabel lblWelcome;
        private EduManager.Components.MyButton myButton1;
        private EduManager.Components.MyButton myButton2;
        private EduManager.Components.PanelRound panelRound1;
        private EduManager.Components.PanelRound panelRound5;
        private EduManager.Components.PanelRound panelRound6;
        private EduManager.Components.PanelRound panelRound8;
        private javax.swing.JPanel panelSchedule;
        // End of variables declaration//GEN-END:variables
}
