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
public class rechLocation extends javax.swing.JPanel {

    locationDAO locationDAO=null;
    location loc=null;
    public rechLocation() {
        initComponents();
    }

    public void setLocationDAO(locationDAO locationDAO){
        this.locationDAO=locationDAO;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idloc = new javax.swing.JLabel();
        txtIdloc = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idclient = new javax.swing.JLabel();
        idtaxi = new javax.swing.JLabel();
        idadrdebut = new javax.swing.JLabel();
        idadrfin = new javax.swing.JLabel();
        txtAcompte = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtKmtotal = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtIdcli = new javax.swing.JTextField();
        txtIdtaxi = new javax.swing.JTextField();
        txtIdadrdebut = new javax.swing.JTextField();
        txtIdadrfin = new javax.swing.JTextField();
        buttonRechercher = new javax.swing.JButton();
        buttonMaj = new javax.swing.JButton();
        buttonEffacer = new javax.swing.JButton();

        idloc.setText("ID de location :");

        jLabel1.setText("Acompte");

        jLabel2.setText("Date");

        jLabel3.setText("KM total");

        jLabel4.setText("Total");

        idclient.setText("ID client");

        idtaxi.setText("ID taxi");

        idadrdebut.setText("ID adresse debut");

        idadrfin.setText("ID adresse fin");

        buttonRechercher.setText("Rechercher");
        buttonRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRechercherActionPerformed(evt);
            }
        });

        buttonMaj.setText("MAJ");
        buttonMaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMajActionPerformed(evt);
            }
        });

        buttonEffacer.setText("Effacer");
        buttonEffacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEffacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRechercher)
                        .addGap(53, 53, 53)
                        .addComponent(buttonMaj)
                        .addGap(53, 53, 53)
                        .addComponent(buttonEffacer))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idloc)
                        .addGap(46, 46, 46)
                        .addComponent(txtIdloc, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(idclient)
                    .addComponent(idtaxi)
                    .addComponent(idadrdebut)
                    .addComponent(idadrfin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAcompte, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKmtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdcli, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdadrdebut, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdadrfin, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idloc)
                    .addComponent(txtIdloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAcompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtKmtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idclient)
                    .addComponent(txtIdcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idtaxi)
                    .addComponent(txtIdtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idadrdebut)
                    .addComponent(txtIdadrdebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idadrfin)
                    .addComponent(txtIdadrfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRechercher)
                    .addComponent(buttonMaj)
                    .addComponent(buttonEffacer))
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMajActionPerformed
        try{  
       int idloc=Integer.parseInt(txtIdloc.getText());    
       String date = txtDate.getText();
       int kmtotal =Integer.parseInt(txtKmtotal.getText());
       float acompte = Float.parseFloat(txtAcompte.getText());
       float total = Float.parseFloat(txtTotal.getText());
       int idcli =Integer.parseInt(txtIdcli.getText());
       int idtaxi =Integer.parseInt(txtIdtaxi.getText());
       int idadrdebut =Integer.parseInt(txtIdadrdebut.getText());
       int idadrfin =Integer.parseInt(txtIdadrfin.getText());

       
       location loc = new location(idloc,date,kmtotal,acompte,total,idcli,idtaxi,idadrdebut,idadrfin);
       locationDAO.update(loc);
       JOptionPane.showMessageDialog(this,"Location mise à jour ! ","succès",JOptionPane.INFORMATION_MESSAGE);
       
     }
     catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_buttonMajActionPerformed

    private void buttonRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRechercherActionPerformed
        try{
             int idloc=Integer.parseInt(txtIdloc.getText());
             loc=locationDAO.read(idloc);
             
             txtDate.setText(loc.getDateLoc());
             txtKmtotal.setText(""+loc.getKmtotal());
             txtTotal.setText(""+loc.getTotal());
             txtAcompte.setText(""+loc.getAcompte());
             txtIdcli.setText(""+loc.getIdClient());
             txtIdtaxi.setText(""+loc.getIdTaxi());
             txtIdadrdebut.setText(""+loc.getIdAdrDebut());
             txtIdadrfin.setText(""+loc.getIdAdrFin());
            
             JOptionPane.showMessageDialog(this,"Location trouvée ! ","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_buttonRechercherActionPerformed

    private void buttonEffacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEffacerActionPerformed
        try{
             int idloc=Integer.parseInt(txtIdloc.getText());
             locationDAO.delete(loc);
             txtDate.setText("");
             txtKmtotal.setText("");
             txtAcompte.setText("");
             txtKmtotal.setText("");
             txtIdcli.setText("");
             txtIdtaxi.setText("");
             txtIdadrdebut.setText("");
             txtIdadrfin.setText("");

             JOptionPane.showMessageDialog(this,"Location effacé !","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_buttonEffacerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEffacer;
    private javax.swing.JButton buttonMaj;
    private javax.swing.JButton buttonRechercher;
    private javax.swing.JLabel idadrdebut;
    private javax.swing.JLabel idadrfin;
    private javax.swing.JLabel idclient;
    private javax.swing.JLabel idloc;
    private javax.swing.JLabel idtaxi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtAcompte;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtIdadrdebut;
    private javax.swing.JTextField txtIdadrfin;
    private javax.swing.JTextField txtIdcli;
    private javax.swing.JTextField txtIdloc;
    private javax.swing.JTextField txtIdtaxi;
    private javax.swing.JTextField txtKmtotal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
