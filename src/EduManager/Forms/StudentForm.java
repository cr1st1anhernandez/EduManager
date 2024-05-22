package EduManager.Forms;

import EduManager.Components.GroupSubjectComponent;
import EduManager.Components.SimpleForm;
import EduManager.Controllers.GroupSubjectController;
import EduManager.Entities.GroupSubject;
import java.awt.Color;
import EduManager.scheduleTable.TableActionCellRender;
import EduManager.scheduleTable.TableActionEvent;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class StudentForm extends SimpleForm {

	public StudentForm() {
		initComponents();

		combobox1.addItem("07:00:00-08:00:00");
		combobox1.addItem("08:00:00-09:00:00");
		combobox1.addItem("09:00:00-10:00:00");
		combobox1.addItem("10:00:00-11:00:00");
		combobox1.addItem("11:00:00-12:00:00");
		combobox1.addItem("12:00:00-13:00:00");
		combobox1.addItem("13:00:00-14:00:00");
		combobox1.addItem("14:00:00-15:00:00");
		combobox1.addItem("15:00:00-16:00:00");
		combobox1.addItem("16:00:00-17:00:00");
		combobox1.addItem("17:00:00-18:00:00");
		combobox1.addItem("19:00:00-20:00:00");
		combobox1.addItem("20:00:00-21:00:00");
		fillComboBoxBySemester(4);
	}

	public void addGroupSubjectToSchedule(GroupSubjectComponent groupSubjectComponent) {
		panelSchedule.add(groupSubjectComponent);
		panelSchedule.revalidate();
		panelSchedule.repaint();
	}

	GroupSubjectController controller = new GroupSubjectController();

	private void fillComboBoxBySemester(int semester) {
		List<GroupSubject> groupSubjects = controller.getGroupsBySemester(semester);
		combobox2.removeAllItems();
		for (GroupSubject groupSubject : groupSubjects) {
			String item = groupSubject.getSubjectName() + " (" + groupSubject.getStartTime() + "-" + groupSubject.getEndTime() + ") " + groupSubject.getTeacherName();
			combobox2.addItem(item);
		}
	}

	private void fillComboBoxBySemesterAndTime(int semester, String time) {
		List<GroupSubject> groupSubjects = controller.getGroupsBySemesterAndTime(semester, time);
		combobox2.removeAllItems();
		for (GroupSubject groupSubject : groupSubjects) {
			String item = groupSubject.getSubjectName() + " (" + groupSubject.getStartTime() + "-" + groupSubject.getEndTime() + ") " + groupSubject.getTeacherName();
			combobox2.addItem(item);
		}
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                lblTitle = new javax.swing.JLabel();
                combobox1 = new EduManager.Components.Combobox();
                combobox2 = new EduManager.Components.Combobox();
                btnMatricular = new EduManager.Components.MyButton();
                lblUsernameContent2 = new javax.swing.JLabel();
                btnSearch = new EduManager.Components.MyButtonOutLine();
                panelRound1 = new EduManager.Components.PanelRound();
                jScrollPane1 = new javax.swing.JScrollPane();
                panelSchedule = new javax.swing.JPanel();

                setForeground(new java.awt.Color(246, 246, 246));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel1.setBackground(new java.awt.Color(246, 246, 246));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblTitle.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 36)); // NOI18N
                lblTitle.setForeground(new java.awt.Color(0, 0, 0));
                lblTitle.setText("STUDENT FORM");
                jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 14, -1, -1));

                combobox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 148, 136), 2, true));
                combobox1.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                combobox1.setLabeText("Hora");
                jPanel1.add(combobox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 260, 50));

                combobox2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(13, 148, 136), 2, true));
                combobox2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                combobox2.setLabeText("Matricular Materia");
                jPanel1.add(combobox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 1180, 50));

                btnMatricular.setText("Matricular");
                btnMatricular.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnMatricularActionPerformed(evt);
                        }
                });
                jPanel1.add(btnMatricular, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 200, 220, 50));

                lblUsernameContent2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent2.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent2.setText("Horario");
                jPanel1.add(lblUsernameContent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

                btnSearch.setText("Buscar");
                btnSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSearchActionPerformed(evt);
                        }
                });
                jPanel1.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 190, 50));

                panelRound1.setBackground(new java.awt.Color(255, 255, 255));
                panelRound1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(19, 78, 77), 2, true));
                panelRound1.setRoundBottomLeft(20);
                panelRound1.setRoundBottomRight(20);
                panelRound1.setRoundTopLeft(20);
                panelRound1.setRoundTopRight(20);

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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(23, Short.MAX_VALUE))
                );
                panelRound1Layout.setVerticalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(45, Short.MAX_VALUE))
                );

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 1420, 390));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 830));
        }// </editor-fold>//GEN-END:initComponents

        private void btnMatricularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatricularActionPerformed
		String selectedItem = (String) combobox2.getSelectedItem();

		if (selectedItem != null && !selectedItem.isEmpty()) {

			int firstParen = selectedItem.indexOf('(');
			int secondParen = selectedItem.indexOf(')');
			String subject = selectedItem.substring(0, firstParen).trim();
			String time = selectedItem.substring(firstParen + 1, secondParen).trim();
			String teacherName = selectedItem.substring(secondParen + 1).trim();

			GroupSubjectComponent groupSubject = new GroupSubjectComponent();
			groupSubject.setSubject(subject);
			groupSubject.setHour(time);
			groupSubject.setTeacher(teacherName);
			groupSubject.setDaysOfWeek("Lunes Martes Miercoles Jueves Viernes");

			addGroupSubjectToSchedule(groupSubject);
		}


        }//GEN-LAST:event_btnMatricularActionPerformed

        private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
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
        }//GEN-LAST:event_btnSearchActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private EduManager.Components.MyButton btnMatricular;
        private EduManager.Components.MyButtonOutLine btnSearch;
        private EduManager.Components.Combobox combobox1;
        private EduManager.Components.Combobox combobox2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JLabel lblTitle;
        private javax.swing.JLabel lblUsernameContent2;
        private EduManager.Components.PanelRound panelRound1;
        private javax.swing.JPanel panelSchedule;
        // End of variables declaration//GEN-END:variables
}
