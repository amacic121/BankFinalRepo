/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.malkier.bankarskisistem;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.malkier.bankarskisistem.domain.Banka;
import rs.malkier.bankarskisistem.domain.Klijent;
import rs.malkier.bankarskisistem.domain.Racun;
import rs.malkier.bankarskisistem.domain.TipRacuna;
import rs.malkier.bankarskisistem.exception.KlijentException;
import rs.malkier.bankarskisistem.exception.RacunException;
import rs.malkier.bankarskisistem.kontroler.Kontroler;

/**
 *
 * @author PC
 */
public class AddNewAccount extends javax.swing.JDialog {

    Klijent klijent;
    boolean ucitanKlijent;

    /**
     * Creates new form AddNewAccount
     */
    public AddNewAccount(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setLocationRelativeTo(null);
        initComponents();
        srediFormu();
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
        cmbTipRacuna = new javax.swing.JComboBox();
        btnPotvrdi = new javax.swing.JButton();
        lblBrojRacuna = new javax.swing.JLabel();
        txtBrojRacuna = new javax.swing.JTextField();
        txtPoruka = new javax.swing.JTextField();

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

        cmbTipRacuna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RSD", "EUR", "USD" }));

        btnPotvrdi.setText("Potvrdi");
        btnPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdiActionPerformed(evt);
            }
        });

        lblBrojRacuna.setText("Broj Racuna");

        txtPoruka.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImePrezime)
                            .addComponent(lblJMBG))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJMBG, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtImePrezime, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtPoruka)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAdresa)
                            .addComponent(lblAdresa1)
                            .addComponent(lblBrojRacuna))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTipRacuna, 0, 169, Short.MAX_VALUE)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtBrojRacuna, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(btnPotvrdi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJMBG)
                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImePrezime)
                    .addComponent(txtImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresa)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresa1)
                    .addComponent(cmbTipRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojRacuna)
                    .addComponent(txtBrojRacuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnPotvrdi)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJMBGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJMBGFocusLost
        String JMBG = txtJMBG.getText();

        if(JMBG.equals("")){
            return;
        }

        Banka banka = Kontroler.getInstance().getBanka();
        ArrayList<Racun> racuni = new ArrayList<>();

        txtImePrezime.setEnabled(true);
        txtAdresa.setEnabled(true);
        txtImePrezime.setText("");
        txtAdresa.setText("");
        txtPoruka.setText("");

        try {
            racuni = Kontroler.getInstance().getKlijent(Long.parseLong(JMBG), banka.getPib());
            klijent = racuni.get(0).getKlijent();

        } catch (RacunException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        if (racuni.size() > 0) {//postojeci korisnik
            if(racuni.size()==3){
                JOptionPane.showMessageDialog(this, "Klijent vec ima sve moguce tipove racuna!");
                dispose();
            }
            popuniTipove(racuni);
            txtPoruka.setText("Klijent pronadjen");
            txtImePrezime.setText(racuni.get(0).getKlijent().getImePrezime());
            txtAdresa.setText(racuni.get(0).getKlijent().getAdresa());
            txtImePrezime.setEnabled(false);
            txtAdresa.setEnabled(false);
            ucitanKlijent = true;
            return;
        }
        ucitanKlijent = false;
        popuniTipove(null);

    }//GEN-LAST:event_txtJMBGFocusLost

    private void btnPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdiActionPerformed

        Banka banka = Kontroler.getInstance().getBanka();
        String JMBG = txtJMBG.getText();
        TipRacuna tip = (TipRacuna) cmbTipRacuna.getSelectedItem();
        String adresa = txtAdresa.getText();
        String brojRacuna = txtBrojRacuna.getText();
        String ime = txtImePrezime.getText();

        if (!ucitanKlijent) {
            try {
                klijent = new Klijent(Long.parseLong(JMBG), ime, adresa);
                Kontroler.getInstance().sacuvajKlijenta(klijent);
            } catch (KlijentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
        Racun racun = new Racun(tip, klijent, banka, 0, brojRacuna);
        try {
            Kontroler.getInstance().sacuvajRacun(racun);
        } catch (RacunException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        JOptionPane.showMessageDialog(this, "Uspesno sacuvan racun");
        dispose();
    }//GEN-LAST:event_btnPotvrdiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JComboBox cmbTipRacuna;
    private javax.swing.JLabel lblAdresa;
    private javax.swing.JLabel lblAdresa1;
    private javax.swing.JLabel lblBrojRacuna;
    private javax.swing.JLabel lblImePrezime;
    private javax.swing.JLabel lblJMBG;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtBrojRacuna;
    private javax.swing.JTextField txtImePrezime;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtPoruka;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        popuniTipove(null);

    }

    private void popuniTipove(ArrayList<Racun> racuni) {

        List<TipRacuna> tipoviRacuna = Kontroler.getInstance().vratiTipoveRacune();
        cmbTipRacuna.removeAllItems();

        for (TipRacuna racun : tipoviRacuna) {
            cmbTipRacuna.addItem(racun);
        }

        if (!txtJMBG.getText().equals("") && racuni != null) {
            cmbTipRacuna.removeAllItems();
            racuni.stream()
                    .forEach(x -> tipoviRacuna.remove(x.getTipRacuna()));

            for (TipRacuna racun : tipoviRacuna) {
                cmbTipRacuna.addItem(racun);
            }
        }

    }

}
