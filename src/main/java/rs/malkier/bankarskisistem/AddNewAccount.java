/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.malkier.bankarskisistem;

import rs.malkier.bankarskisistem.domain.Banka;
import rs.malkier.bankarskisistem.kontroler.Kontroler;

/**
 *
 * @author PC
 */
public class AddNewAccount extends javax.swing.JDialog {

    /**
     * Creates new form AddNewAccount
     */
    public AddNewAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
        initComponents();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtImePrezime = new javax.swing.JTextField();
        lblJMBG = new javax.swing.JLabel();
        lblImePrezime = new javax.swing.JLabel();
        txtJMBG = new javax.swing.JTextField();
        lblAdresa = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        lblAdresa1 = new javax.swing.JLabel();
        lblPoruka = new javax.swing.JLabel();
        cmbTipRacuna = new javax.swing.JComboBox();
        btnPotvrdi = new javax.swing.JButton();
        lblBrojRacuna = new javax.swing.JLabel();
        txtBrojRacuna = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblJMBG.setText("JMBG");

        lblImePrezime.setText("Ime i Prezime");

        txtJMBG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJMBGFocusLost(evt);
            }
        });

        lblAdresa.setText("Adresa");

        lblAdresa1.setText("Tip Racuna");

        lblPoruka.setText("jLabel1");

        cmbTipRacuna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RSD", "EUR", "USD" }));

        btnPotvrdi.setText("Potvrdi");

        lblBrojRacuna.setText("Broj Racuna");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImePrezime)
                                    .addComponent(lblJMBG))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAdresa)
                                    .addComponent(lblAdresa1)
                                    .addComponent(lblBrojRacuna))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAdresa, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(cmbTipRacuna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBrojRacuna, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnPotvrdi, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJMBG)
                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPoruka)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImePrezime)
                    .addComponent(txtImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresa)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdresa1)
                    .addComponent(cmbTipRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojRacuna)
                    .addComponent(txtBrojRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnPotvrdi)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJMBGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJMBGFocusLost
        String JMBG = txtJMBG.getText();
        Banka banka = Kontroler.getInstance().getBanka();
        
        
        
    }//GEN-LAST:event_txtJMBGFocusLost

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JComboBox cmbTipRacuna;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblAdresa1;
    private javax.swing.JLabel lblBrojRacuna;
    private javax.swing.JLabel lblImePrezime;
    private javax.swing.JLabel lblJMBG;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtBrojRacuna;
    private javax.swing.JTextField txtImePrezime;
    private javax.swing.JTextField txtJMBG;
    // End of variables declaration//GEN-END:variables
}
