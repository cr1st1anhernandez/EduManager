package EduManager.Components;

public class ErrorComponent extends PanelRound {

    /**
     * Creates new form Error
     */
    public ErrorComponent() {
        initComponents();
    }
    
    public void setText(String text){
        jLabel2.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblErrorMessage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setRoundBottomLeft(20);
        setRoundBottomRight(20);
        setRoundTopLeft(20);
        setRoundTopRight(20);

        lblErrorMessage.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 24)); // NOI18N
        lblErrorMessage.setForeground(new java.awt.Color(225, 29, 72));
        lblErrorMessage.setText("Error");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EduManager/Icons/error.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("CaskaydiaCove NF", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Credenciales incorrectas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorMessage)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblErrorMessage;
    // End of variables declaration
}

