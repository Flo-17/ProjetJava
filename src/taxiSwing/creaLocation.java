/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiSwing;

import javax.swing.JOptionPane;
import taxi.DAO.locationDAO;
import taxi.metier.location;

/**
 *
 * @author camma
 */
public class creaLocation extends javax.swing.JPanel {

    public creaLocation() {
        initComponents();
    }
    
    locationDAO locationDAO = null;

    public void setLocationDAO(locationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idloc = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        kmtotal = new javax.swing.JLabel();
        acompte = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        idcli = new javax.swing.JLabel();
        idtaxi = new javax.swing.JLabel();
        idadrdebut = new javax.swing.JLabel();
        idadrfin = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtLocation = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtKmtotal = new javax.swing.JTextField();
        txtAcompte = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtIdcli = new javax.swing.JTextField();
        txtIdtaxi = new javax.swing.JTextField();
        txtAdrDebut = new javax.swing.JTextField();
        txtAdrFin = new javax.swing.JTextField();

        idloc.setText("ID de la location ");

        date.setText("Date");

        kmtotal.setText("KM total");

        acompte.setText("Acompte");

        total.setText("Total");

        idcli.setText("ID client");

        idtaxi.setText("ID taxi");

        idadrdebut.setText("ID adresse debut");

        idadrfin.setText("ID adresse fin");

        jButton1.setText("Création");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtLocation.setEditable(false);

        txtAdrDebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdrDebutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idloc)
                    .addComponent(date)
                    .addComponent(kmtotal)
                    .addComponent(acompte)
                    .addComponent(total)
                    .addComponent(idcli)
                    .addComponent(idtaxi)
                    .addComponent(idadrdebut)
                    .addComponent(idadrfin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAdrDebut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(txtIdtaxi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtIdcli, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAcompte, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtKmtotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLocation, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAdrFin))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idloc)
                    .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kmtotal)
                    .addComponent(txtKmtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acompte)
                    .addComponent(txtAcompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idcli)
                    .addComponent(txtIdcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idtaxi)
                    .addComponent(txtIdtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idadrdebut)
                    .addComponent(txtAdrDebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idadrfin)
                    .addComponent(txtAdrFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String date = txtDate.getText();
            int kmtotal = Integer.parseInt(txtKmtotal.getText());
            float acompte = Float.parseFloat(txtAcompte.getText());
            float total = Float.parseFloat(txtTotal.getText());
            int idclient = Integer.parseInt(txtIdcli.getText());
            int idtaxi = Integer.parseInt(txtIdtaxi.getText());
            int idadrdebut = Integer.parseInt(txtAdrDebut.getText());
            int idadrfin = Integer.parseInt(txtAdrFin.getText());

            location loc = new location(0, date, kmtotal, acompte, total, idclient, idtaxi, idadrdebut, idadrfin);
            loc = locationDAO.create(loc);
            txtLocation.setText("" + loc.getIdLoc());
            JOptionPane.showMessageDialog(this, "Location créée ! ", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtAdrDebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdrDebutActionPerformed

    }//GEN-LAST:event_txtAdrDebutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acompte;
    private javax.swing.JLabel date;
    private javax.swing.JLabel idadrdebut;
    private javax.swing.JLabel idadrfin;
    private javax.swing.JLabel idcli;
    private javax.swing.JLabel idloc;
    private javax.swing.JLabel idtaxi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel kmtotal;
    private javax.swing.JLabel total;
    private javax.swing.JTextField txtAcompte;
    private javax.swing.JTextField txtAdrDebut;
    private javax.swing.JTextField txtAdrFin;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtIdcli;
    private javax.swing.JTextField txtIdtaxi;
    private javax.swing.JTextField txtKmtotal;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
