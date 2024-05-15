package EduManager.Forms;

import EduManager.Components.SimpleForm;

/**
 *
 * @author Raven
 */
public class ProfileForm extends SimpleForm {

    public ProfileForm() {
        initComponents();
	myLabelControlNumber.setText("22161096");
	myLabelCurp.setText("HERCO0402139H");
	myLabelDate.setText("02/03/2004");
	myLabelEmail.setText("cristian42134@mail.com");
	myLabelPhone.setText("95132352312");
	myLabelGender.setText("Masculino");
        myLabelAddress.setText("Avenida Revolucion #18");
        myLabelColony.setText("Alamos");
        myLabelmunicipality.setText("Montoya");
        myLabelPostalCode.setText("71233");
        myLabelState.setText("Oaxaca");	
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
                myLabelPhone = new EduManager.Components.MyLabel();
                lblUsername4 = new javax.swing.JLabel();
                lblUsername5 = new javax.swing.JLabel();
                lblUsername8 = new javax.swing.JLabel();
                lblUsername3 = new javax.swing.JLabel();
                lblUsername9 = new javax.swing.JLabel();
                lblUsername10 = new javax.swing.JLabel();
                myLabelName = new EduManager.Components.MyLabel();
                myLabelDate = new EduManager.Components.MyLabel();
                myLabelControlNumber = new EduManager.Components.MyLabel();
                myLabelCurp = new EduManager.Components.MyLabel();
                myLabelEmail = new EduManager.Components.MyLabel();
                myLabelGender = new EduManager.Components.MyLabel();
                jLabel2 = new javax.swing.JLabel();
                panelRound3 = new EduManager.Components.PanelRound();
                lblUsernameContent3 = new javax.swing.JLabel();
                lblUsername7 = new javax.swing.JLabel();
                myButtonOutLine3 = new EduManager.Components.MyButtonOutLine();
                panelRound4 = new EduManager.Components.PanelRound();
                lblUsernameContent4 = new javax.swing.JLabel();
                lblUsername12 = new javax.swing.JLabel();
                lblUsername13 = new javax.swing.JLabel();
                lblUsername14 = new javax.swing.JLabel();
                lblUsername15 = new javax.swing.JLabel();
                lblUsername16 = new javax.swing.JLabel();
                myLabelAddress = new EduManager.Components.MyLabel();
                myLabelmunicipality = new EduManager.Components.MyLabel();
                myLabelState = new EduManager.Components.MyLabel();
                myLabelColony = new EduManager.Components.MyLabel();
                myLabelPostalCode = new EduManager.Components.MyLabel();

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
                panelRound1.add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));
                panelRound1.add(myLabelPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 280, -1));

                lblUsername4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername4.setText("Curp");
                panelRound1.add(lblUsername4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 580, -1, -1));

                lblUsername5.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername5.setText("Fecha de Nacimiento");
                panelRound1.add(lblUsername5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, -1, -1));

                lblUsername8.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername8.setText("Numero de Control");
                panelRound1.add(lblUsername8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

                lblUsername3.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername3.setText("Email");
                panelRound1.add(lblUsername3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 350, -1));

                lblUsername9.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername9.setText("Telefono");
                panelRound1.add(lblUsername9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, -1, -1));

                lblUsername10.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername10.setText("Genero");
                panelRound1.add(lblUsername10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, -1, -1));
                panelRound1.add(myLabelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));
                panelRound1.add(myLabelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 270, -1));
                panelRound1.add(myLabelControlNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));
                panelRound1.add(myLabelCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 610, 280, -1));
                panelRound1.add(myLabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 570, -1));
                panelRound1.add(myLabelGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 270, -1));

                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Images/user.png"))); // NOI18N
                panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 80, 70));

                jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 690, 680));

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

                lblUsername12.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername12.setText("Calle y Numero");
                panelRound4.add(lblUsername12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

                lblUsername13.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername13.setText("Colonia");
                panelRound4.add(lblUsername13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

                lblUsername14.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername14.setText("Codigo Postal");
                panelRound4.add(lblUsername14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

                lblUsername15.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername15.setText("Municipio");
                panelRound4.add(lblUsername15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

                lblUsername16.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername16.setText("Estado");
                panelRound4.add(lblUsername16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));
                panelRound4.add(myLabelAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 400, -1));
                panelRound4.add(myLabelmunicipality, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 800, -1));
                panelRound4.add(myLabelState, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 800, -1));
                panelRound4.add(myLabelColony, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 800, -1));
                panelRound4.add(myLabelPostalCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 370, -1));

                jPanel1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 370, 860, 460));

                add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1660, 880));
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lblUsername;
        private javax.swing.JLabel lblUsername10;
        private javax.swing.JLabel lblUsername12;
        private javax.swing.JLabel lblUsername13;
        private javax.swing.JLabel lblUsername14;
        private javax.swing.JLabel lblUsername15;
        private javax.swing.JLabel lblUsername16;
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
        private EduManager.Components.MyLabel myLabelAddress;
        private EduManager.Components.MyLabel myLabelColony;
        private EduManager.Components.MyLabel myLabelControlNumber;
        private EduManager.Components.MyLabel myLabelCurp;
        private EduManager.Components.MyLabel myLabelDate;
        private EduManager.Components.MyLabel myLabelEmail;
        private EduManager.Components.MyLabel myLabelGender;
        private EduManager.Components.MyLabel myLabelName;
        private EduManager.Components.MyLabel myLabelPhone;
        private EduManager.Components.MyLabel myLabelPostalCode;
        private EduManager.Components.MyLabel myLabelState;
        private EduManager.Components.MyLabel myLabelmunicipality;
        private EduManager.Components.PanelRound panelRound1;
        private EduManager.Components.PanelRound panelRound3;
        private EduManager.Components.PanelRound panelRound4;
        // End of variables declaration//GEN-END:variables
}
