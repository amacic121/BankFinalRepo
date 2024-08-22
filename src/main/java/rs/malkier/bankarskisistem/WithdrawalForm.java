/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.malkier.bankarskisistem;

import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.JOptionPane;
import rs.malkier.bankarskisistem.domain.Racun;
import rs.malkier.bankarskisistem.exception.PlacanjeException;
import rs.malkier.bankarskisistem.kontroler.Kontroler;

/**
 *
 * @author Pedja
 */
public class WithdrawalForm extends javax.swing.JDialog {

    List<Racun> racuni;

    /**
     * Creates new form WithdrawalForm
     * @param racuni
     */
    //dobija listu racuna u konstruktoru 
    public WithdrawalForm(List<Racun> racuni) {
        setModal(true);
        initComponents();
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.racuni = racuni;

        for (Racun r : racuni) {
            cmbRacuni.addItem(r);
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

        lblRacun = new javax.swing.JLabel();
        cmbRacuni = new javax.swing.JComboBox<>();
        lblRaspolozivo = new javax.swing.JLabel();
        txtRaspolozivo = new javax.swing.JTextField();
        lblIsplata = new javax.swing.JLabel();
        txtIznos = new javax.swing.JTextField();
        btnIsplata = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRacun.setText("Odaberi racun korisnika");

        cmbRacuni.setModel(new javax.swing.DefaultComboBoxModel<>(new Racun[] {}));
        cmbRacuni.addItemListener(evt -> {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                Racun selectedItem = (Racun) cmbRacuni.getSelectedItem();
                txtRaspolozivo.setText(selectedItem.getIznos()+"");
            }
        });

        lblRaspolozivo.setText("Rapolozivo");

        lblIsplata.setText("Iznos za isplatu");

        btnIsplata.setText("Isplata");
        btnIsplata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIsplataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRacun)
                            .addComponent(lblRaspolozivo)
                            .addComponent(lblIsplata, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbRacuni, 0, 164, Short.MAX_VALUE)
                            .addComponent(txtRaspolozivo)
                            .addComponent(txtIznos)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnIsplata)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbRacuni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRacun))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRaspolozivo)
                    .addComponent(txtRaspolozivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIsplata)
                    .addComponent(txtIznos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnIsplata)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIsplataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIsplataActionPerformed

        float iznos = Float.parseFloat(txtIznos.getText());
        boolean uspeh;

        try {
            uspeh = Kontroler.getInstance().isplati(iznos, (Racun) cmbRacuni.getSelectedItem());
            JOptionPane.showMessageDialog(this, "Uspesno izvrsena isplata");
            dispose();
        } catch (PlacanjeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            dispose();
        }

    }//GEN-LAST:event_btnIsplataActionPerformed

    private void cmbRacuniItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbRacuniItemStateChanged
        txtRaspolozivo.setText(((Racun) cmbRacuni.getSelectedItem()).getIznos() + "");

    }//GEN-LAST:event_cmbRacuniItemStateChanged

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
            java.util.logging.Logger.getLogger(WithdrawalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WithdrawalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WithdrawalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WithdrawalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WithdrawalForm(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIsplata;
    private javax.swing.JComboBox<Racun> cmbRacuni;
    private javax.swing.JLabel lblIsplata;
    private javax.swing.JLabel lblRacun;
    private javax.swing.JLabel lblRaspolozivo;
    private javax.swing.JTextField txtIznos;
    private javax.swing.JTextField txtRaspolozivo;
    // End of variables declaration//GEN-END:variables
}