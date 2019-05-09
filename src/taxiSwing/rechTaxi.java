/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiSwing;

import javax.swing.JOptionPane;
import taxi.DAO.taxiDAO;
import taxi.metier.taxi;

/**
 *
 * @author camma
 */
public class rechTaxi extends javax.swing.JPanel {

 
    
    
    taxiDAO taxiDAO=null;
    taxi tx=null;
    public rechTaxi() {
        initComponents();
    }

    public void setTaxiDAO(taxiDAO taxiDAO){
        this.taxiDAO=taxiDAO;
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        immatriculation = new javax.swing.JLabel();
        carburant = new javax.swing.JLabel();
        prixkm = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        txtImmatriculation = new javax.swing.JTextField();
        txtCarburant = new javax.swing.JTextField();
        txtPrixkm = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        buttonRechercher = new javax.swing.JButton();
        buttonMaj = new javax.swing.JButton();
        buttonEffacer = new javax.swing.JButton();
        numtaxi = new javax.swing.JLabel();
        txtNumtaxi = new javax.swing.JTextField();

        immatriculation.setText("Immatriculation");

        carburant.setText("Carburant");

        prixkm.setText("Prix au km");

        description.setText("Description");

        txtImmatriculation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImmatriculationActionPerformed(evt);
            }
        });

        buttonRechercher.setText("Rechercher");
        buttonRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRechercherActionPerformed(evt);
            }
        });

        buttonMaj.setText("MAJ");
        buttonMaj.setToolTipText("");
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

        numtaxi.setText("Numéro du taxi ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(numtaxi)
                        .addGap(18, 18, 18)
                        .addComponent(txtNumtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonRechercher)
                                .addGap(43, 43, 43)
                                .addComponent(buttonMaj)
                                .addGap(40, 40, 40)
                                .addComponent(buttonEffacer))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(description)
                                            .addComponent(prixkm)
                                            .addComponent(carburant))
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(immatriculation)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPrixkm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCarburant, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtImmatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numtaxi)
                    .addComponent(txtNumtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(immatriculation)
                    .addComponent(txtImmatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carburant)
                    .addComponent(txtCarburant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prixkm)
                    .addComponent(txtPrixkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(description)
                        .addContainerGap(93, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonEffacer)
                            .addComponent(buttonMaj)
                            .addComponent(buttonRechercher))
                        .addGap(19, 19, 19))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtImmatriculationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImmatriculationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImmatriculationActionPerformed

    private void buttonMajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMajActionPerformed
       try{  
       int numtaxi=Integer.parseInt(txtNumtaxi.getText());
       String immatriculation=txtImmatriculation.getText();
       String carburant=txtCarburant.getText();
       int prixkm=Integer.parseInt(txtPrixkm.getText());
       String description= txtDescription.getText();
       
       taxi tx = new taxi(numtaxi,immatriculation,carburant,prixkm,description);
       taxiDAO.update(tx);
       JOptionPane.showMessageDialog(this,"Taxi mis à jour ! ","succès",JOptionPane.INFORMATION_MESSAGE);
       
     }
     catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
               
    }//GEN-LAST:event_buttonMajActionPerformed

    private void buttonRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRechercherActionPerformed
        try{
             int numtaxi=Integer.parseInt(txtNumtaxi.getText());
             tx=taxiDAO.read(numtaxi);
             txtImmatriculation.setText(tx.getImmatriculation());
             txtCarburant.setText(tx.getCarburant());
             txtPrixkm.setText(""+tx.getPrixkm());
             txtDescription.setText(tx.getDescription());
            
             JOptionPane.showMessageDialog(this,"Taxi trouvé ! ","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_buttonRechercherActionPerformed

    private void buttonEffacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEffacerActionPerformed
        try{
             int numtaxi=Integer.parseInt(txtNumtaxi.getText());
             taxiDAO.delete(tx);
             txtNumtaxi.setText("");
             txtImmatriculation.setText("");
             txtCarburant.setText("");
             txtPrixkm.setText("");
             txtDescription.setText("");

             JOptionPane.showMessageDialog(this,"Taxi effacé !","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_buttonEffacerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEffacer;
    private javax.swing.JButton buttonMaj;
    private javax.swing.JButton buttonRechercher;
    private javax.swing.JLabel carburant;
    private javax.swing.JLabel description;
    private javax.swing.JLabel immatriculation;
    private javax.swing.JLabel numtaxi;
    private javax.swing.JLabel prixkm;
    private javax.swing.JTextField txtCarburant;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtImmatriculation;
    private javax.swing.JTextField txtNumtaxi;
    private javax.swing.JTextField txtPrixkm;
    // End of variables declaration//GEN-END:variables
}
