package EduManager.Forms;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import EduManager.Components.GroupStudentComponent;
import EduManager.Components.GroupSubjectComponent;
import EduManager.Components.SimpleForm;
import EduManager.Components.SuccessComponent;
import EduManager.Components.SupportComponent;
import EduManager.Controllers.EnrollmentController;
import EduManager.Controllers.GroupSubjectController;
import EduManager.Controllers.SubjectController;
import EduManager.Controllers.TeacherController;
import EduManager.Controllers.UserController;
import EduManager.Entities.Enrollment;
import EduManager.Entities.GroupSubject;
import EduManager.Entities.Student;
import EduManager.Entities.User;
import EduManager.Menu.FormManager;
import EduManager.Utils.PdfGenerator;
import javax.mail.MessagingException;
import raven.swing.AvatarIcon;
import raven.toast.Notifications;

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
	private TeacherController teacherController = new TeacherController();
	private SubjectController subjectController = new SubjectController();
	String pathImage = user.getImagePath();
	AvatarIcon icon = new AvatarIcon(getClass().getResource(pathImage), 75, 75, 999);

	public StudentForm() {
		initComponents();
		lblProfileImage.setIcon(icon);
		fillPanelSubjects();
		lblWelcome.setText("Bienvenido " + student.getFirstName());
		lblName.setText(student.getFirstName() + " " + student.getLastName());
		lblCareer.setText(student.getCareer());
		lblSemester.setText(student.getSemester() + " Semestre");
		fillComboBoxHours();
		fillPanelSchedule();
	}

	public void fillPanelSchedule() {
		List<Enrollment> enrollments = enrollmentController.getEnrollmentsByStudentId(student.getUserId());
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
			groupSubjectComponent.setStudentId(student.getUserId());
			groupSubjectComponent.setGroupSubjectId(groupSubject.getGroupSubjectId());
			panelSchedule.add(groupSubjectComponent);
		}

		panelSchedule.revalidate();
		panelSchedule.repaint();
	}

	public void fillPanelSubjectsWithHour(String time) {
		List<GroupSubject> groupSubjects = groupSubjectController.getGroupsBySemesterAndTime(student.getSemester(), time);

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

	private void fillComboBoxHours() {
		for (String timeSlot : timeSlots) {
			comboBoxHours.addItem(timeSlot);
		}

	}

	private void fillPanelSubjects() {
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

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                panelRound5 = new EduManager.Components.PanelRound();
                lblWelcome = new javax.swing.JLabel();
                lblUsernameContent3 = new javax.swing.JLabel();
                lblUsernameContent8 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                myButton1 = new EduManager.Components.MyButton();
                panelRound1 = new EduManager.Components.PanelRound();
                jScrollPane2 = new javax.swing.JScrollPane();
                panelSubjects = new javax.swing.JPanel();
                lblUsernameContent2 = new javax.swing.JLabel();
                panelRound6 = new EduManager.Components.PanelRound();
                jScrollPane1 = new javax.swing.JScrollPane();
                panelSchedule = new javax.swing.JPanel();
                lblName1 = new javax.swing.JLabel();
                panelRound8 = new EduManager.Components.PanelRound();
                btnDownloadSchedule = new EduManager.Components.MyButton();
                btnLogOut = new EduManager.Components.MyButtonOutLine();
                btnSupport = new EduManager.Components.MyButtonOutLine();
                lblUsernameContent4 = new javax.swing.JLabel();
                btnEmailSchedule = new EduManager.Components.MyButton();
                comboBoxHours = new EduManager.Components.Combobox();
                panelRound7 = new EduManager.Components.PanelRound();
                panelRound9 = new EduManager.Components.PanelRound();
                lblProfileImage = new javax.swing.JLabel();
                lblName = new javax.swing.JLabel();
                lblCareer = new javax.swing.JLabel();
                lblSemester = new javax.swing.JLabel();

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
                                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblWelcome)
                                        .addComponent(lblUsernameContent3)
                                        .addComponent(lblUsernameContent8))
                                .addGap(41, 41, 41)
                                .addComponent(jLabel3)
                                .addContainerGap(7, Short.MAX_VALUE))
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

                jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 870, 250));

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
                                .addContainerGap()
                                .addComponent(lblUsernameContent2)
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(42, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 1270, 580));

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

                panelRound8.setBackground(new java.awt.Color(255, 255, 255));
                panelRound8.setRoundBottomLeft(20);
                panelRound8.setRoundBottomRight(20);
                panelRound8.setRoundTopLeft(20);
                panelRound8.setRoundTopRight(20);

                btnDownloadSchedule.setText("Descargar Horario");
                btnDownloadSchedule.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnDownloadScheduleActionPerformed(evt);
                        }
                });

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

                lblUsernameContent4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent4.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent4.setText("Opciones");

                btnEmailSchedule.setText("Enviar Horario a tu email");
                btnEmailSchedule.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEmailScheduleActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
                panelRound8.setLayout(panelRound8Layout);
                panelRound8Layout.setHorizontalGroup(
                        panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound8Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUsernameContent4)
                                        .addGroup(panelRound8Layout.createSequentialGroup()
                                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnDownloadSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnEmailSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(17, Short.MAX_VALUE))
                );
                panelRound8Layout.setVerticalGroup(
                        panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound8Layout.createSequentialGroup()
                                .addContainerGap(8, Short.MAX_VALUE)
                                .addComponent(lblUsernameContent4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSupport, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDownloadSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnEmailSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21))
                );

                jPanel1.add(panelRound8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 790, 510, 190));

                comboBoxHours.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 148, 136), 2, true));
                comboBoxHours.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                comboBoxHours.setLabeText("Hora");
                comboBoxHours.addItemListener(new java.awt.event.ItemListener() {
                        public void itemStateChanged(java.awt.event.ItemEvent evt) {
                                comboBoxHoursItemStateChanged(evt);
                        }
                });
                jPanel1.add(comboBoxHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 1270, 50));

                panelRound7.setBackground(new java.awt.Color(255, 255, 255));
                panelRound7.setRoundBottomLeft(30);
                panelRound7.setRoundBottomRight(30);
                panelRound7.setRoundTopLeft(30);
                panelRound7.setRoundTopRight(30);

                panelRound9.setBackground(new java.awt.Color(13, 148, 136));
                panelRound9.setRoundTopLeft(30);
                panelRound9.setRoundTopRight(30);
                panelRound9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));
                panelRound9.add(lblProfileImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

                lblName.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 24)); // NOI18N
                lblName.setForeground(new java.awt.Color(51, 51, 51));
                lblName.setText("Cristian Hernandez");

                lblCareer.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 14)); // NOI18N
                lblCareer.setForeground(new java.awt.Color(102, 102, 102));
                lblCareer.setText("Estudiante Ing. Sistemas");

                lblSemester.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 14)); // NOI18N
                lblSemester.setForeground(new java.awt.Color(102, 102, 102));
                lblSemester.setText("4 Semestre");

                javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
                panelRound7.setLayout(panelRound7Layout);
                panelRound7Layout.setHorizontalGroup(
                        panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound7Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblSemester)
                                        .addComponent(lblCareer)
                                        .addComponent(lblName))
                                .addContainerGap(100, Short.MAX_VALUE))
                        .addComponent(panelRound9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                panelRound7Layout.setVerticalGroup(
                        panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound7Layout.createSequentialGroup()
                                .addComponent(panelRound9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCareer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSemester)
                                .addGap(0, 60, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 40, 370, 250));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1850, 1000));
        }// </editor-fold>//GEN-END:initComponents

        private void comboBoxHoursItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxHoursItemStateChanged
		// TODO add your handling code here:
		String selectedTimeRange = (String) comboBoxHours.getSelectedItem();

		if (selectedTimeRange != null && !selectedTimeRange.isEmpty()) {
			String[] times = selectedTimeRange.split("-");
			if (times.length == 2) {
				String startTime = times[0].trim();
				fillPanelSubjectsWithHour(startTime);
			} else {
				System.out.println("Formato de tiempo inválido.");
			}
		} else {
			System.out.println("Por favor seleccione un horario.");
		}
        }//GEN-LAST:event_comboBoxHoursItemStateChanged

        private void btnDownloadScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadScheduleActionPerformed

		List<Enrollment> enrollments = enrollmentController.getEnrollmentsByStudentId(student.getUserId());
		List<GroupSubject> groupSubjects = new ArrayList<>();

		for (Enrollment enrollment : enrollments) {
			GroupSubject groupSubject = groupSubjectController.getGroupSubjectById(enrollment.getGroupSubjectId());
			if (groupSubject != null) {
				groupSubjects.add(groupSubject);
			}
		}

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Guardar PDF");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo PDF", "pdf"));
		fileChooser.setSelectedFile(new java.io.File("Horario_Estudiante_" + student.getFirstName() + ".pdf"));

		int userSelection = fileChooser.showSaveDialog(null);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			java.io.File fileToSave = fileChooser.getSelectedFile();
			String pdfName = fileToSave.getAbsolutePath();

			if (!pdfName.toLowerCase().endsWith(".pdf")) {
				pdfName += ".pdf";
			}

			PdfGenerator pdfGenerator = new PdfGenerator();
			pdfGenerator.generateSchedulePDF(pdfName, groupSubjects);

			SuccessComponent successComponent = new SuccessComponent();
			successComponent.setText("PDF generado exitosamente");
			Notifications.getInstance().show(Notifications.Location.BOTTOM_RIGHT, successComponent);
		}

        }//GEN-LAST:event_btnDownloadScheduleActionPerformed

        private void btnEmailScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailScheduleActionPerformed
		// TODO add your handling code here:
		PdfGenerator pdfGenerator = new PdfGenerator();
		String fileName = "horario_estudiante.pdf";
		List<Enrollment> enrollments = enrollmentController.getEnrollmentsByStudentId(student.getUserId());
		List<GroupSubject> groupSubjects = new ArrayList<>();

		for (Enrollment enrollment : enrollments) {
			GroupSubject groupSubject = groupSubjectController.getGroupSubjectById(enrollment.getGroupSubjectId());
			if (groupSubject != null) {
				groupSubjects.add(groupSubject);
			}
		}
		String emailTo = student.getEmail();
		try {
			pdfGenerator.setCareer(student.getCareer());
			pdfGenerator.setUsername(student.getFirstName() + " " + student.getLastName());
			pdfGenerator.sendPdfByEmail(fileName, groupSubjects, emailTo);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

        }//GEN-LAST:event_btnEmailScheduleActionPerformed
// GEN-FIRST:event_btnSearchActionPerformed
// TODO add your handling code here:
// GEN-LAST:event_btnSearchActionPerformed

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
		SupportComponent supportFrame = new SupportComponent();
		supportFrame.setUser(student.getFirstName() + " " + student.getLastName());
		supportFrame.setEmail(student.getEmail());
		supportFrame.setVisible(true);
	}// GEN-LAST:event_btnSupportActionPerformed

	private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_myButton1ActionPerformed
		// TODO add your handling code here:
		FormManager.showForm(new ProfileForm());
	}// GEN-LAST:event_myButton1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private EduManager.Components.MyButton btnDownloadSchedule;
        private EduManager.Components.MyButton btnEmailSchedule;
        private EduManager.Components.MyButtonOutLine btnLogOut;
        private EduManager.Components.MyButtonOutLine btnSupport;
        private EduManager.Components.Combobox comboBoxHours;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JLabel lblCareer;
        private javax.swing.JLabel lblName;
        private javax.swing.JLabel lblName1;
        private javax.swing.JLabel lblProfileImage;
        private javax.swing.JLabel lblSemester;
        private javax.swing.JLabel lblUsernameContent2;
        private javax.swing.JLabel lblUsernameContent3;
        private javax.swing.JLabel lblUsernameContent4;
        private javax.swing.JLabel lblUsernameContent8;
        private javax.swing.JLabel lblWelcome;
        private EduManager.Components.MyButton myButton1;
        private EduManager.Components.PanelRound panelRound1;
        private EduManager.Components.PanelRound panelRound5;
        private EduManager.Components.PanelRound panelRound6;
        private EduManager.Components.PanelRound panelRound7;
        private EduManager.Components.PanelRound panelRound8;
        private EduManager.Components.PanelRound panelRound9;
        private javax.swing.JPanel panelSchedule;
        private javax.swing.JPanel panelSubjects;
        // End of variables declaration//GEN-END:variables
}
