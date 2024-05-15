/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package EduManager.Components;

/**
 *
 * @author cristian
 */
public class MyLabel extends javax.swing.JPanel {

	private String text;

	public MyLabel() {
		initComponents();
	}

	public void setText(String text) {
		this.text = text;
		jLabel2.setText(text);
	}

	public String getText() {
		return text;
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                panelRound1 = new EduManager.Components.PanelRound();
                jLabel2 = new javax.swing.JLabel();

                panelRound1.setBackground(new java.awt.Color(255, 255, 255));
                panelRound1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 236, 238), 2, true));

                jLabel2.setFont(new java.awt.Font("CaskaydiaCove NF", 0, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(111, 111, 129));
                jLabel2.setText("Texto");

                javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
                panelRound1.setLayout(panelRound1Layout);
                panelRound1Layout.setHorizontalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                                .addContainerGap())
                );
                panelRound1Layout.setVerticalGroup(
                        panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRound1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                .addContainerGap())
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
        }// </editor-fold>//GEN-END:initComponents


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel jLabel2;
        private EduManager.Components.PanelRound panelRound1;
        // End of variables declaration//GEN-END:variables
}
