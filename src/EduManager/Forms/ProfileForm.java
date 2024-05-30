package EduManager.Forms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import EduManager.Components.ChangePasswordComponent;
import EduManager.Components.SimpleForm;
import EduManager.Controllers.UserController;
import EduManager.Entities.Coordinator;
import EduManager.Entities.Student;
import EduManager.Entities.Teacher;
import EduManager.Entities.User;
import EduManager.Menu.FormManager;
import raven.swing.AvatarIcon;

/**
 *
 * @author Raven
 */
public class ProfileForm extends SimpleForm {

        User user = UserController.getUser();

        public ProfileForm() {
                initComponents();
                String pathImage = user.getImagePath();
                AvatarIcon icon = new AvatarIcon(getClass().getResource(pathImage), 75, 75, 999);
                lblProfileImage.setIcon(icon);

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
                        myLabelControlNumber.setText(student.getUserId() + "");
                } else if (user instanceof Teacher) {
                        Teacher teacher = (Teacher) user;
                        myLabelCurp.setText(teacher.getCurp());
                        myLabelDate.setText(teacher.getBirthDate().toString());
                        myLabelGender.setText(String.valueOf(teacher.getGender()));
                        myLabelControlNumber.setText(teacher.getUserId() + "");
                } else if (user instanceof Coordinator) {
                        Coordinator coordinator = (Coordinator) user;
                        myLabelCurp.setText(coordinator.getCurp());
                        myLabelDate.setText(coordinator.getBirthDate().toString());
                        myLabelGender.setText(String.valueOf(coordinator.getGender()));
                        myLabelControlNumber.setText(coordinator.getUserId() + "");
                }
        }

        private void updateProfileImage(String imagePath) {
                // Si estás usando rutas absolutas, asegúrate de convertirlas a URLs válidas
                // para el AvatarIcon
                File imageFile = new File(imagePath);
                try {
                        AvatarIcon icon = new AvatarIcon(imageFile.toURI().toURL(), 75, 75, 999);
                        icon.setBorder(2);
                        lblProfileImage.setIcon(icon);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                panelRound1 = new EduManager.Components.PanelRound();
                lblUsernameContent2 = new javax.swing.JLabel();
                btnChangeProfile = new EduManager.Components.MyButtonOutLine();
                lblUsername2 = new javax.swing.JLabel();
                lblUsername = new javax.swing.JLabel();
                lblUsername5 = new javax.swing.JLabel();
                lblUsername10 = new javax.swing.JLabel();
                myLabelFirstName = new EduManager.Components.MyLabel();
                myLabelDate = new EduManager.Components.MyLabel();
                myLabelGender = new EduManager.Components.MyLabel();
                lblUsername11 = new javax.swing.JLabel();
                myLabelLastName = new EduManager.Components.MyLabel();
                lblProfileImage = new javax.swing.JLabel();
                panelRound3 = new EduManager.Components.PanelRound();
                lblUsernameContent3 = new javax.swing.JLabel();
                lblUsername7 = new javax.swing.JLabel();
                btnChangePassword = new EduManager.Components.MyButton();
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
                panelRound5 = new EduManager.Components.PanelRound();
                lblWelcome = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                myButton1 = new EduManager.Components.MyButton();

                setForeground(new java.awt.Color(246, 246, 246));
                setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel1.setBackground(new java.awt.Color(234, 244, 242));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

                btnChangeProfile.setText("Cambiar Foto De Perfil");
                btnChangeProfile.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnChangeProfileActionPerformed(evt);
                        }
                });
                panelRound1.add(btnChangeProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 250, 40));

                lblUsername2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 12)); // NOI18N
                lblUsername2.setForeground(new java.awt.Color(170, 171, 184));
                lblUsername2.setText(
                                "<html><body>Las imagenes deben ser de al menos 360px.<br> Deben pesar menos de 5mb. Formatos permitidos *.png *.jpg *.jpeg *.gif</body></html> ");
                panelRound1.add(lblUsername2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 500, -1));

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

                lblUsername11.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername11.setText("Apellido");
                panelRound1.add(lblUsername11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 130, -1));
                panelRound1.add(myLabelLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 570, -1));

                lblProfileImage.setPreferredSize(new java.awt.Dimension(75, 75));
                panelRound1.add(lblProfileImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 690, 590));

                panelRound3.setBackground(new java.awt.Color(13, 148, 136));
                panelRound3.setMinimumSize(new java.awt.Dimension(80, 80));
                panelRound3.setRoundBottomLeft(20);
                panelRound3.setRoundBottomRight(20);
                panelRound3.setRoundTopLeft(20);
                panelRound3.setRoundTopRight(20);

                lblUsernameContent3.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsernameContent3.setForeground(new java.awt.Color(255, 255, 255));
                lblUsernameContent3.setText("Cambiar Contraseña");

                lblUsername7.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername7.setForeground(new java.awt.Color(255, 255, 255));
                lblUsername7.setText("Tu Contraseña Solo podra ser moficada maximo 3 veces");

                btnChangePassword.setBackground(new java.awt.Color(255, 255, 255));
                btnChangePassword.setForeground(new java.awt.Color(102, 102, 102));
                btnChangePassword.setText("Cambiar");
                btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnChangePasswordActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
                panelRound3.setLayout(panelRound3Layout);
                panelRound3Layout.setHorizontalGroup(
                                panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRound3Layout.createSequentialGroup()
                                                                .addGap(21, 21, 21)
                                                                .addGroup(panelRound3Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(lblUsername7,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                582,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(lblUsernameContent3)
                                                                                .addComponent(btnChangePassword,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                815,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(24, Short.MAX_VALUE)));
                panelRound3Layout.setVerticalGroup(
                                panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout
                                                                .createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addComponent(lblUsernameContent3)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(lblUsername7)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                34, Short.MAX_VALUE)
                                                                .addComponent(btnChangePassword,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                50,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(19, 19, 19)));

                jPanel1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 860, 190));

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
                panelRound4.add(myLabelControlNumber,
                                new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 390, -1));

                lblUsername8.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername8.setText("Numero de Control");
                panelRound4.add(lblUsername8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 190, -1));

                lblUsername4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername4.setText("Curp");
                panelRound4.add(lblUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 580, -1));
                panelRound4.add(myLabelCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 810, -1));

                jPanel1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 570, 860, 370));

                panelRound5.setBackground(new java.awt.Color(13, 148, 136));
                panelRound5.setRoundBottomLeft(30);
                panelRound5.setRoundBottomRight(30);
                panelRound5.setRoundTopLeft(30);
                panelRound5.setRoundTopRight(30);

                lblWelcome.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 48)); // NOI18N
                lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
                lblWelcome.setText("Configuraciones del perfil");

                jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/settings.png"))); // NOI18N

                myButton1.setBackground(new java.awt.Color(255, 255, 255));
                myButton1.setForeground(new java.awt.Color(102, 102, 102));
                myButton1.setText("Volver al panel de Acciones");
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
                                                                                .addComponent(lblWelcome)
                                                                                .addComponent(myButton1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                378,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                561, Short.MAX_VALUE)
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
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(myButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                52,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(25, 25, 25)));

                jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 1590, 250));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1850, 1000));
        }// </editor-fold>//GEN-END:initComponents

        private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChangePasswordActionPerformed
                // TODO add your handling code here:
                ChangePasswordComponent changePasswordFrame = new ChangePasswordComponent();
                changePasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                changePasswordFrame.setVisible(true);
        }// GEN-LAST:event_btnChangePasswordActionPerformed

        private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_myButton1ActionPerformed
                // TODO add your handling code here:

                if (user instanceof Student) {
                        FormManager.showForm(new StudentForm());
                } else if (user instanceof Teacher) {
                        FormManager.showForm(new TeacherForm());
                } else if (user instanceof Coordinator) {
                        FormManager.showForm(new CoordinatorForm());
                }

        }// GEN-LAST:event_myButton1ActionPerformed

        private void btnChangeProfileActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChangeProfileActionPerformed

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccione una imagen de perfil");

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes",
                                "jpg", "jpeg", "png", "gif"));

                int userSelection = fileChooser.showOpenDialog(null);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();

                        File dir = new File("src/EduManager/Images_profile/");
                        if (!dir.exists()) {
                                dir.mkdirs();
                        }

                        String destPath = "src/EduManager/Images_profile/" + fileToSave.getName();
                        File destFile = new File(destPath);

                        try {
                                Files.copy(fileToSave.toPath(), destFile.toPath());
                                String imagePath = destFile.getAbsolutePath();

                                // Actualizar la ruta de la imagen en la base de datos y en el objeto en memoria
                                boolean success = UserController.updateImagePath(imagePath);

                                if (success) {
                                        // Actualizar la imagen de perfil en la interfaz
                                        updateProfileImage(imagePath);
                                        JOptionPane.showMessageDialog(null, "Imagen de perfil actualizada con éxito.");
                                } else {
                                        JOptionPane.showMessageDialog(null, "Error al actualizar la imagen de perfil.",
                                                        "Error", JOptionPane.ERROR_MESSAGE);
                                }
                        } catch (IOException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Error al guardar la imagen: " + ex.getMessage(),
                                                "Error", JOptionPane.ERROR_MESSAGE);
                        }
                }
        }// GEN-LAST:event_btnChangeProfileActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private EduManager.Components.MyButton btnChangePassword;
        private EduManager.Components.MyButtonOutLine btnChangeProfile;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lblProfileImage;
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
        private javax.swing.JLabel lblWelcome;
        private EduManager.Components.MyButton myButton1;
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
        private EduManager.Components.PanelRound panelRound5;
        // End of variables declaration//GEN-END:variables
}
