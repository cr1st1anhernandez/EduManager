package EduManager.Forms;

import EduManager.Components.SimpleForm;
import EduManager.Controllers.UserController;
import EduManager.Entities.Coordinator;
import EduManager.Entities.Student;
import EduManager.Entities.Teacher;
import EduManager.Entities.User;

/**
 *
 * @author Raven
 */
public class ProfileForm extends SimpleForm {
	
    User user = UserController.getUser();
    public ProfileForm() {
        initComponents();
        myLabelFirstName.setText(user.getFirstName());
	myLabelLastName.setText(user.getLastName());
        myLabelEmail.setText(user.getEmail());
	myLabelPhone.setText(user.getPhoneNumber());
        myLabelCurp.setText("NO DISPONIBLE");
        myLabelDate.setText("NO DISPONIBLE");
        myLabelGender.setText("NO DISPONIBLE");
	myLabelControlNumber.setText("NO DISPONIBLE");

        if (user instanceof Student) {
            Student student = (Student) user;
            myLabelCurp.setText(student.getCurp());
            myLabelDate.setText(student.getBirthDate().toString());
            myLabelGender.setText(String.valueOf(student.getGender()));
	    myLabelControlNumber.setText(student.getUserId()+"");
        } else if (user instanceof Teacher) {
            Teacher teacher = (Teacher) user;
            myLabelCurp.setText(teacher.getCurp());
            myLabelDate.setText(teacher.getBirthDate().toString());
            myLabelGender.setText(String.valueOf(teacher.getGender()));
	    myLabelControlNumber.setText(teacher.getUserId()+"");
        } else if (user instanceof Coordinator) {
            Coordinator coordinator = (Coordinator) user;
            myLabelCurp.setText(coordinator.getCurp());
            myLabelDate.setText(coordinator.getBirthDate().toString());
            myLabelGender.setText(String.valueOf(coordinator.getGender()));
	    myLabelControlNumber.setText(coordinator.getUserId()+"");
        } 
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                panelRound1 = new EduManager.Components.PanelRound();
                lblUsernameContent2 = new javax.swing.JLabel();
                myButtonOutLine2 = new EduManager.Components.MyButtonOutLine();
                lblUsername2 = new javax.swing.JLabel();
                lblUsername = new javax.swing.JLabel();
                lblUsername5 = new javax.swing.JLabel();
                lblUsername10 = new javax.swing.JLabel();
                myLabelFirstName = new EduManager.Components.MyLabel();
                myLabelDate = new EduManager.Components.MyLabel();
                myLabelGender = new EduManager.Components.MyLabel();
                jLabel2 = new javax.swing.JLabel();
                lblUsername11 = new javax.swing.JLabel();
                myLabelLastName = new EduManager.Components.MyLabel();
                panelRound3 = new EduManager.Components.PanelRound();
                lblUsernameContent3 = new javax.swing.JLabel();
                lblUsername7 = new javax.swing.JLabel();
                myButtonOutLine3 = new EduManager.Components.MyButtonOutLine();
                panelRound4 = new EduManager.Components.PanelRound();
                lblUsernameContent4 = new javax.swing.JLabel();
                lblUsername3 = new javax.swing.JLabel();
                myLabelEmail = new EduManager.Components.MyLabel();
                lblUsername9 = new javax.swing.JLabel();
                myLabelPhone = new EduManager.Components.MyLabel();
                myLabelControlNumber = new EduManager.Components.MyLabel();
                lblUsername8 = new javax.swing.JLabel();
                lblUsername4 = new javax.swing.JLabel();
                myLabelCurp = new EduManager.Components.MyLabel();

                setForeground(new java.awt.Color(246, 246, 246));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel1.setBackground(new java.awt.Color(246, 246, 246));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel1.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 48)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(6, 6, 6));
                jLabel1.setText("Configuraciones del Perfil");
                jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 730, 50));

                panelRound1.setBackground(new java.awt.Color(255, 255, 255));
                panelRound1.setRoundBottomLeft(20);
                panelRound1.setRoundBottomRight(20);
                panelRound1.setRoundTopLeft(20);
                panelRound1.setRoundTopRight(20);
                panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblUsernameContent2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent2.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent2.setText("Detalles del Perfil");
                panelRound1.add(lblUsernameContent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

                myButtonOutLine2.setText("Cambiar Foto De Perfil");
                panelRound1.add(myButtonOutLine2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, 40));

                lblUsername2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 12)); // NOI18N
                lblUsername2.setForeground(new java.awt.Color(170, 171, 184));
                lblUsername2.setText("<html><body>Las imagenes deben ser de al menos 360px.<br> Deben pesar menos de 500kb. Formatos permitidos .png .jpg</body></html>\n");
                panelRound1.add(lblUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 430, -1));

                lblUsername.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername.setText("Nombre");
                panelRound1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

                lblUsername5.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername5.setText("Fecha de Nacimiento");
                panelRound1.add(lblUsername5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 500, -1));

                lblUsername10.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername10.setText("Genero");
                panelRound1.add(lblUsername10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 360, -1));
                panelRound1.add(myLabelFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));
                panelRound1.add(myLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 570, -1));
                panelRound1.add(myLabelGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 570, -1));

                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/user.png"))); // NOI18N
                panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 80, 70));

                lblUsername11.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername11.setText("Apellido");
                panelRound1.add(lblUsername11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 130, -1));
                panelRound1.add(myLabelLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 570, -1));

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 690, 590));

                panelRound3.setBackground(new java.awt.Color(255, 255, 255));
                panelRound3.setMinimumSize(new java.awt.Dimension(80, 80));
                panelRound3.setRoundBottomLeft(20);
                panelRound3.setRoundBottomRight(20);
                panelRound3.setRoundTopLeft(20);
                panelRound3.setRoundTopRight(20);

                lblUsernameContent3.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent3.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent3.setText("Cambiar Contraseña");

                lblUsername7.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername7.setForeground(new java.awt.Color(170, 171, 184));
                lblUsername7.setText("Tu Contraseña Solo podra ser moficada maximo 3 veces");

                myButtonOutLine3.setText("Cambiar Contraseña");

                javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
                panelRound3.setLayout(panelRound3Layout);
                panelRound3Layout.setHorizontalGroup(
                        panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUsername7, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblUsernameContent3)
                                        .addComponent(myButtonOutLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))
                );
                panelRound3Layout.setVerticalGroup(
                        panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(lblUsernameContent3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUsername7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(myButtonOutLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                );

                jPanel1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 860, 190));

                panelRound4.setBackground(new java.awt.Color(255, 255, 255));
                panelRound4.setMinimumSize(new java.awt.Dimension(80, 80));
                panelRound4.setRoundBottomLeft(20);
                panelRound4.setRoundBottomRight(20);
                panelRound4.setRoundTopLeft(20);
                panelRound4.setRoundTopRight(20);
                panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblUsernameContent4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent4.setForeground(new java.awt.Color(111, 111, 129));
                lblUsernameContent4.setText("Informacion de Contacto");
                panelRound4.add(lblUsernameContent4, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 24, -1, -1));

                lblUsername3.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername3.setText("Email");
                panelRound4.add(lblUsername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 350, -1));
                panelRound4.add(myLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 810, -1));

                lblUsername9.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername9.setText("Telefono");
                panelRound4.add(lblUsername9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
                panelRound4.add(myLabelPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 390, -1));
                panelRound4.add(myLabelControlNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 390, -1));

                lblUsername8.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername8.setText("Numero de Control");
                panelRound4.add(lblUsername8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 190, -1));

                lblUsername4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername4.setText("Curp");
                panelRound4.add(lblUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 580, -1));
                panelRound4.add(myLabelCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 810, -1));

                jPanel1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, 860, 370));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1660, 880));
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lblUsername;
        private javax.swing.JLabel lblUsername10;
        private javax.swing.JLabel lblUsername11;
        private javax.swing.JLabel lblUsername2;
        private javax.swing.JLabel lblUsername3;
        private javax.swing.JLabel lblUsername4;
        private javax.swing.JLabel lblUsername5;
        private javax.swing.JLabel lblUsername7;
        private javax.swing.JLabel lblUsername8;
        private javax.swing.JLabel lblUsername9;
        private javax.swing.JLabel lblUsernameContent2;
        private javax.swing.JLabel lblUsernameContent3;
        private javax.swing.JLabel lblUsernameContent4;
        private EduManager.Components.MyButtonOutLine myButtonOutLine2;
        private EduManager.Components.MyButtonOutLine myButtonOutLine3;
        private EduManager.Components.MyLabel myLabelControlNumber;
        private EduManager.Components.MyLabel myLabelCurp;
        private EduManager.Components.MyLabel myLabelDate;
        private EduManager.Components.MyLabel myLabelEmail;
        private EduManager.Components.MyLabel myLabelFirstName;
        private EduManager.Components.MyLabel myLabelGender;
        private EduManager.Components.MyLabel myLabelLastName;
        private EduManager.Components.MyLabel myLabelPhone;
        private EduManager.Components.PanelRound panelRound1;
        private EduManager.Components.PanelRound panelRound3;
        private EduManager.Components.PanelRound panelRound4;
        // End of variables declaration//GEN-END:variables
}
