/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiSwing;

import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import myconnections.DBConnection;
import taxi.DAO.taxiDAO;

/**
 *
 * @author camma
 */
public class gestionTaxi extends javax.swing.JFrame {

    CardLayout cardl;

    public gestionTaxi() {
        initComponents();
        cardl = (CardLayout) this.getContentPane().getLayout();
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            JOptionPane.showMessageDialog(this, "connexion invalide", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

        taxiDAO taxiDAO = new taxiDAO();
        taxiDAO.setConnection(dbConnect);
        
        
        creaTaxi1.setTaxiDAO(taxiDAO);
        rechTaxi1.setTaxiDAO(taxiDAO);
        rechDescription1.setTaxiDAO(taxiDAO);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creaTaxi1 = new taxiSwing.creaTaxi();
        rechDescription1 = new taxiSwing.rechDescription();
        rechTaxi1 = new taxiSwing.rechTaxi();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemCrea1 = new javax.swing.JMenuItem();
        itemCrea2 = new javax.swing.JMenuItem();
        itemCrea3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(creaTaxi1, "card2");
        getContentPane().add(rechDescription1, "card3");
        getContentPane().add(rechTaxi1, "card4");

        jMenu1.setText("Options");

        itemCrea1.setText("Création");
        itemCrea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrea1ActionPerformed(evt);
            }
        });
        jMenu1.add(itemCrea1);

        itemCrea2.setText("Recherche (numero)");
        itemCrea2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrea2ActionPerformed(evt);
            }
        });
        jMenu1.add(itemCrea2);

        itemCrea3.setText("Recherche (description)");
        itemCrea3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCrea3ActionPerformed(evt);
            }
        });
        jMenu1.add(itemCrea3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCrea2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrea2ActionPerformed
        cardl.show(this.getContentPane(), "card4");
    }//GEN-LAST:event_itemCrea2ActionPerformed

    private void itemCrea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrea1ActionPerformed
        cardl.show(this.getContentPane(), "card2");
    }//GEN-LAST:event_itemCrea1ActionPerformed

    private void itemCrea3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCrea3ActionPerformed
        cardl.show(this.getContentPane(), "card3");
    }//GEN-LAST:event_itemCrea3ActionPerformed

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
            java.util.logging.Logger.getLogger(gestionTaxi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gestionTaxi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gestionTaxi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gestionTaxi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestionTaxi().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private taxiSwing.creaTaxi creaTaxi1;
    private javax.swing.JMenuItem itemCrea1;
    private javax.swing.JMenuItem itemCrea2;
    private javax.swing.JMenuItem itemCrea3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private taxiSwing.rechDescription rechDescription1;
    private taxiSwing.rechTaxi rechTaxi1;
    // End of variables declaration//GEN-END:variables
}
