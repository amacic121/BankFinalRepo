/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.malkier.bankarskisistem;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import rs.malkier.bankarskisistem.domain.Racun;
import rs.malkier.bankarskisistem.exception.PlacanjeException;
import rs.malkier.bankarskisistem.kontroler.Kontroler;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/**
 *
 * @author Pedja
 */
public class DepositForm extends javax.swing.JDialog {
    
    List<Racun> racuni;

    /**
     * Creates new form DepositForm
     * @param racuni
     */
    public DepositForm(List<Racun> racuni) {
        setModal(true);
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.racuni = racuni;
        
        for(Racun r : racuni){
            cmbRacun.addItem(r);
        }
        txtRaspolozivo.setEnabled(false);
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRacunsksr = new javax.swing.JLabel();
        lblRaspolozivoT = new javax.swing.JLabel();
        lblIznos = new javax.swing.JLabel();
        txtIznos = new javax.swing.JTextField();
        btnUplati = new javax.swing.JButton();
        cmbRacun = new javax.swing.JComboBox<>();
        txtRaspolozivo = new javax.swing.JTextField();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRacunsksr.setText("Odaeri racun korisnika");

        lblRaspolozivoT.setText("trenutno raspolozivo");

        lblIznos.setText("Iznos za uplatu");

        btnUplati.setText("Uplati");
        btnUplati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUplatiActionPerformed(evt);
            }
        });

        cmbRacun.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbRacunItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lblRaspolozivoT)
                                    .addGap(52, 52, 52))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblIznos)
                                    .addGap(62, 62, 62)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRacunsksr)
                                .addGap(43, 43, 43)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIznos)
                            .addComponent(cmbRacun, 0, 190, Short.MAX_VALUE)
                            .addComponent(txtRaspolozivo)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnUplati)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRacunsksr)
                    .addComponent(cmbRacun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRaspolozivoT)
                    .addComponent(txtRaspolozivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIznos)
                    .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnUplati)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUplatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUplatiActionPerformed
        
        float iznos = Float.parseFloat(txtIznos.getText());
        boolean uspeh;
        
        try {
            uspeh = Kontroler.getInstance().uplati(iznos, (Racun) cmbRacun.getSelectedItem());
            JOptionPane.showMessageDialog(this, "Uspesno izvrsena uplata");
            dispose();
        } catch (PlacanjeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            dispose();
        }
        
        
    }//GEN-LAST:event_btnUplatiActionPerformed

    private void cmbRacunItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbRacunItemStateChanged
        txtRaspolozivo.setText(((Racun)cmbRacun.getSelectedItem()).getIznos() + "");
    }//GEN-LAST:event_cmbRacunItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DepositForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepositForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepositForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepositForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepositForm(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUplati;
    private javax.swing.JComboBox<Racun> cmbRacun;
    private javax.swing.JLabel lblIznos;
    private javax.swing.JLabel lblRacunsksr;
    private javax.swing.JLabel lblRaspolozivoT;
    private javax.swing.JTextField txtIznos;
    private javax.swing.JTextField txtRaspolozivo;
    // End of variables declaration//GEN-END:variables
}
