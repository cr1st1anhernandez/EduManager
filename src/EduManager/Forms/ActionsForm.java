package EduManager.Forms;

import EduManager.Components.SimpleForm;
import java.awt.Color;
import javax.swing.BorderFactory;
import EduManager.Menu.FormManager;

/**
 *
 * @author Raven
 */
public class ActionsForm extends SimpleForm {

    public ActionsForm() {
        initComponents();
	timePicker1.setColor(Color.decode("#0d9488"));
	timePicker2.setColor(Color.decode("#0d9488"));
	txtTimeEditor.setBorder(BorderFactory.createCompoundBorder(txtTimeEditor.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 20)));
	txtTimeEditor1.setBorder(BorderFactory.createCompoundBorder(txtTimeEditor1.getBorder(), BorderFactory.createEmptyBorder(0, 10, 0, 20)));
	timePicker1.setEditor(txtTimeEditor);
	timePicker2.setEditor(txtTimeEditor1);
    }

    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                timePicker1 = new raven.datetime.component.time.TimePicker();
                timePicker2 = new raven.datetime.component.time.TimePicker();
                jPanel1 = new javax.swing.JPanel();
                lblUsernameContent1 = new javax.swing.JLabel();
                panelRound12 = new EduManager.Components.PanelRound();
                lblUsername21 = new javax.swing.JLabel();
                lblUsername22 = new javax.swing.JLabel();
                lblUsername23 = new javax.swing.JLabel();
                myTextField13 = new EduManager.Components.MyTextField();
                myTextField14 = new EduManager.Components.MyTextField();
                myButtonOutLine1 = new EduManager.Components.MyButtonOutLine();
                myButtonOutLine2 = new EduManager.Components.MyButtonOutLine();
                panelRound11 = new EduManager.Components.PanelRound();
                lblUsername4 = new javax.swing.JLabel();
                lblUsername13 = new javax.swing.JLabel();
                lblUsername16 = new javax.swing.JLabel();
                myTextField7 = new EduManager.Components.MyTextField();
                myTextField9 = new EduManager.Components.MyTextField();
                myButton2 = new EduManager.Components.MyButton();
                panelRound10 = new EduManager.Components.PanelRound();
                lblUsername2 = new javax.swing.JLabel();
                lblUsername1 = new javax.swing.JLabel();
                lblUsername3 = new javax.swing.JLabel();
                lblUsername5 = new javax.swing.JLabel();
                lblUsername6 = new javax.swing.JLabel();
                lblUsername14 = new javax.swing.JLabel();
                lblUsername15 = new javax.swing.JLabel();
                myTextField1 = new EduManager.Components.MyTextField();
                myTextField2 = new EduManager.Components.MyTextField();
                myTextField3 = new EduManager.Components.MyTextField();
                myTextField4 = new EduManager.Components.MyTextField();
                myTextField5 = new EduManager.Components.MyTextField();
                myTextField6 = new EduManager.Components.MyTextField();
                myButton1 = new EduManager.Components.MyButton();
                panelRound13 = new EduManager.Components.PanelRound();
                lblUsername24 = new javax.swing.JLabel();
                lblUsername27 = new javax.swing.JLabel();
                myTextField17 = new EduManager.Components.MyTextField();
                lblUsername25 = new javax.swing.JLabel();
                myTextField21 = new EduManager.Components.MyTextField();
                lblUsername26 = new javax.swing.JLabel();
                lblUsername28 = new javax.swing.JLabel();
                myButtonOutLine3 = new EduManager.Components.MyButtonOutLine();
                lblUsername29 = new javax.swing.JLabel();
                lblUsername30 = new javax.swing.JLabel();
                txtTimeEditor = new javax.swing.JFormattedTextField();
                txtTimeEditor1 = new javax.swing.JFormattedTextField();
                lblUsername31 = new javax.swing.JLabel();

                setForeground(new java.awt.Color(246, 246, 246));

                jPanel1.setBackground(new java.awt.Color(246, 246, 246));

                lblUsernameContent1.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 36)); // NOI18N
                lblUsernameContent1.setForeground(new java.awt.Color(0, 0, 0));
                lblUsernameContent1.setText("Acciones");

                panelRound12.setBackground(new java.awt.Color(255, 255, 255));
                panelRound12.setMinimumSize(new java.awt.Dimension(80, 80));
                panelRound12.setRoundBottomLeft(20);
                panelRound12.setRoundBottomRight(20);
                panelRound12.setRoundTopLeft(20);
                panelRound12.setRoundTopRight(20);

                lblUsername21.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsername21.setText("Carga Academica");

                lblUsername22.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername22.setText("Id Alumno");

                lblUsername23.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername23.setText("Id Docente");

                myTextField13.setHint("4SA");

                myTextField14.setHint("1");
                myTextField14.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                myTextField14ActionPerformed(evt);
                        }
                });

                myButtonOutLine1.setText("Descargar");

                myButtonOutLine2.setText("Descargar");

                javax.swing.GroupLayout panelRound12Layout = new javax.swing.GroupLayout(panelRound12);
                panelRound12.setLayout(panelRound12Layout);
                panelRound12Layout.setHorizontalGroup(
                        panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound12Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblUsername21)
                                        .addGroup(panelRound12Layout.createSequentialGroup()
                                                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(myButtonOutLine1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                                                        .addComponent(lblUsername22, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(myTextField13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblUsername23)
                                                        .addComponent(myTextField14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(myButtonOutLine2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                panelRound12Layout.setVerticalGroup(
                        panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound12Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblUsername21)
                                .addGap(18, 18, 18)
                                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername22)
                                        .addComponent(lblUsername23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(myTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(myButtonOutLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myButtonOutLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(24, Short.MAX_VALUE))
                );

                panelRound11.setBackground(new java.awt.Color(255, 255, 255));
                panelRound11.setMinimumSize(new java.awt.Dimension(80, 80));
                panelRound11.setRoundBottomLeft(20);
                panelRound11.setRoundBottomRight(20);
                panelRound11.setRoundTopLeft(20);
                panelRound11.setRoundTopRight(20);

                lblUsername4.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsername4.setText("Agregar Grupo");

                lblUsername13.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername13.setText("Codigo");

                lblUsername16.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername16.setText("Id");

                myTextField7.setHint("4SA");

                myTextField9.setHint("1");
                myTextField9.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                myTextField9ActionPerformed(evt);
                        }
                });

                myButton2.setText("Agregar");

                javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
                panelRound11.setLayout(panelRound11Layout);
                panelRound11Layout.setHorizontalGroup(
                        panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound11Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound11Layout.createSequentialGroup()
                                                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUsername13)
                                                        .addComponent(myTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelRound11Layout.createSequentialGroup()
                                                                .addComponent(lblUsername16)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 345, Short.MAX_VALUE))
                                                        .addComponent(myTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(panelRound11Layout.createSequentialGroup()
                                                .addComponent(lblUsername4)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(myButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32))
                );
                panelRound11Layout.setVerticalGroup(
                        panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound11Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblUsername4)
                                .addGap(18, 18, 18)
                                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername13)
                                        .addComponent(lblUsername16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(myTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addComponent(myButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(34, Short.MAX_VALUE))
                );

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblUsernameContent1)
                                        .addComponent(panelRound11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelRound12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(624, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(lblUsernameContent1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                                .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(panelRound12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84))
                );

                panelRound10.setBackground(new java.awt.Color(255, 255, 255));
                panelRound10.setMinimumSize(new java.awt.Dimension(80, 80));
                panelRound10.setRoundBottomLeft(20);
                panelRound10.setRoundBottomRight(20);
                panelRound10.setRoundTopLeft(20);
                panelRound10.setRoundTopRight(20);

                lblUsername2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsername2.setText("Agregar Materia");

                lblUsername1.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername1.setText("Nombre");

                lblUsername3.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername3.setText("Id");

                lblUsername5.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername5.setText("Docente");

                lblUsername6.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername6.setText("Cupo");

                lblUsername14.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername14.setText("No Unidades");

                lblUsername15.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername15.setText("No Creditos");

                myTextField1.setHint("Programacion Orientada a Objetos");

                myTextField2.setHint("Arturo Sorroza");

                myTextField3.setHint("1");

                myTextField4.setHint("3");

                myTextField5.setHint("40");

                myTextField6.setHint("5");

                myButton1.setText("Agregar");

                javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
                panelRound10.setLayout(panelRound10Layout);
                panelRound10Layout.setHorizontalGroup(
                        panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound10Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                .addComponent(lblUsername2)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                                .addComponent(lblUsername1)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(panelRound10Layout.createSequentialGroup()
                                                                .addComponent(lblUsername3)
                                                                .addGap(318, 318, 318))
                                                        .addComponent(myTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUsername5)
                                                        .addComponent(myTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(256, 256, 256))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound10Layout.createSequentialGroup()
                                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound10Layout.createSequentialGroup()
                                                                .addComponent(lblUsername15)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(myTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(myTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(18, 18, 18)
                                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound10Layout.createSequentialGroup()
                                                                .addComponent(lblUsername6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                                                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(myTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lblUsername14)))
                                                        .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(myTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(32, 32, 32))))
                );
                panelRound10Layout.setVerticalGroup(
                        panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound10Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblUsername2)
                                .addGap(18, 18, 18)
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername1)
                                        .addComponent(lblUsername5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(myTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername3)
                                        .addComponent(lblUsername6)
                                        .addComponent(lblUsername14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(myTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblUsername15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(myTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                                .addContainerGap(30, Short.MAX_VALUE))
                );

                panelRound13.setBackground(new java.awt.Color(255, 255, 255));
                panelRound13.setMinimumSize(new java.awt.Dimension(80, 80));
                panelRound13.setRoundBottomLeft(20);
                panelRound13.setRoundBottomRight(20);
                panelRound13.setRoundTopLeft(20);
                panelRound13.setRoundTopRight(20);

                lblUsername24.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 24)); // NOI18N
                lblUsername24.setText("Crear Horario");

                lblUsername27.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername27.setText("Id Grupo");

                myTextField17.setHint("1");

                lblUsername25.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername25.setText("Id Materia");

                myTextField21.setHint("1");

                lblUsername26.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername26.setText("Hora Inicio");

                lblUsername28.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                lblUsername28.setText("Hora Final");

                myButtonOutLine3.setText("Crear");
                myButtonOutLine3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                myButtonOutLine3ActionPerformed(evt);
                        }
                });

                lblUsername29.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 12)); // NOI18N
                lblUsername29.setForeground(new java.awt.Color(170, 171, 184));
                lblUsername29.setText("Si se selecciona una hora con minutos automaticamente");

                lblUsername30.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 12)); // NOI18N
                lblUsername30.setForeground(new java.awt.Color(170, 171, 184));
                lblUsername30.setText("Ej: 10:15 pasara automaticamente a 10:00");

                txtTimeEditor.setBackground(new java.awt.Color(255, 255, 255));
                txtTimeEditor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 238), 2, true));

                txtTimeEditor1.setBackground(new java.awt.Color(255, 255, 255));
                txtTimeEditor1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 238), 2, true));

                lblUsername31.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 12)); // NOI18N
                lblUsername31.setForeground(new java.awt.Color(170, 171, 184));
                lblUsername31.setText("pasara a la hora exacta");

                javax.swing.GroupLayout panelRound13Layout = new javax.swing.GroupLayout(panelRound13);
                panelRound13.setLayout(panelRound13Layout);
                panelRound13Layout.setHorizontalGroup(
                        panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound13Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelRound13Layout.createSequentialGroup()
                                                .addComponent(lblUsername26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblUsername28)
                                                .addGap(325, 325, 325))
                                        .addGroup(panelRound13Layout.createSequentialGroup()
                                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblUsername24)
                                                        .addComponent(lblUsername29)
                                                        .addComponent(lblUsername30)
                                                        .addComponent(lblUsername31))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound13Layout.createSequentialGroup()
                                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(myButtonOutLine3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(panelRound13Layout.createSequentialGroup()
                                                                .addComponent(txtTimeEditor)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtTimeEditor1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound13Layout.createSequentialGroup()
                                                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(myTextField17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(panelRound13Layout.createSequentialGroup()
                                                                                .addComponent(lblUsername25)
                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lblUsername27)
                                                                        .addComponent(myTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(33, 33, 33))))
                );
                panelRound13Layout.setVerticalGroup(
                        panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound13Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblUsername24)
                                .addGap(18, 18, 18)
                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername27)
                                        .addComponent(lblUsername25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(myTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(myTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblUsername28)
                                        .addComponent(lblUsername26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTimeEditor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTimeEditor1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(lblUsername29)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUsername31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUsername30)
                                .addGap(19, 19, 19)
                                .addComponent(myButtonOutLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(panelRound10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(panelRound13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(33, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(panelRound10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panelRound13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(537, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap()))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void myTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myTextField9ActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_myTextField9ActionPerformed

        private void myTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myTextField14ActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_myTextField14ActionPerformed

        private void myButtonOutLine3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButtonOutLine3ActionPerformed
                // TODO add your handling code here:
        }//GEN-LAST:event_myButtonOutLine3ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lblUsername1;
        private javax.swing.JLabel lblUsername13;
        private javax.swing.JLabel lblUsername14;
        private javax.swing.JLabel lblUsername15;
        private javax.swing.JLabel lblUsername16;
        private javax.swing.JLabel lblUsername2;
        private javax.swing.JLabel lblUsername21;
        private javax.swing.JLabel lblUsername22;
        private javax.swing.JLabel lblUsername23;
        private javax.swing.JLabel lblUsername24;
        private javax.swing.JLabel lblUsername25;
        private javax.swing.JLabel lblUsername26;
        private javax.swing.JLabel lblUsername27;
        private javax.swing.JLabel lblUsername28;
        private javax.swing.JLabel lblUsername29;
        private javax.swing.JLabel lblUsername3;
        private javax.swing.JLabel lblUsername30;
        private javax.swing.JLabel lblUsername31;
        private javax.swing.JLabel lblUsername4;
        private javax.swing.JLabel lblUsername5;
        private javax.swing.JLabel lblUsername6;
        private javax.swing.JLabel lblUsernameContent1;
        private EduManager.Components.MyButton myButton1;
        private EduManager.Components.MyButton myButton2;
        private EduManager.Components.MyButtonOutLine myButtonOutLine1;
        private EduManager.Components.MyButtonOutLine myButtonOutLine2;
        private EduManager.Components.MyButtonOutLine myButtonOutLine3;
        private EduManager.Components.MyTextField myTextField1;
        private EduManager.Components.MyTextField myTextField13;
        private EduManager.Components.MyTextField myTextField14;
        private EduManager.Components.MyTextField myTextField17;
        private EduManager.Components.MyTextField myTextField2;
        private EduManager.Components.MyTextField myTextField21;
        private EduManager.Components.MyTextField myTextField3;
        private EduManager.Components.MyTextField myTextField4;
        private EduManager.Components.MyTextField myTextField5;
        private EduManager.Components.MyTextField myTextField6;
        private EduManager.Components.MyTextField myTextField7;
        private EduManager.Components.MyTextField myTextField9;
        private EduManager.Components.PanelRound panelRound10;
        private EduManager.Components.PanelRound panelRound11;
        private EduManager.Components.PanelRound panelRound12;
        private EduManager.Components.PanelRound panelRound13;
        private raven.datetime.component.time.TimePicker timePicker1;
        private raven.datetime.component.time.TimePicker timePicker2;
        private javax.swing.JFormattedTextField txtTimeEditor;
        private javax.swing.JFormattedTextField txtTimeEditor1;
        // End of variables declaration//GEN-END:variables
}
