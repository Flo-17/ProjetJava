/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxiSwing;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import taxi.DAO.locationDAO;
import taxi.metier.location;

/**
 *
 * @author camma
 */
public class rechDate extends javax.swing.JPanel {

    locationDAO locationDAO = null;
    DefaultTableModel dft1 = new DefaultTableModel();

    public rechDate() {

        initComponents();
        dft1.addColumn("ID loc");
        dft1.addColumn("Date loc");
        dft1.addColumn("KM total");
        dft1.addColumn("Acompte");
        dft1.addColumn("Total");
        dft1.addColumn("ID cli");
        dft1.addColumn("ID taxi");
        dft1.addColumn("ID adr deb");
        dft1.addColumn("ID adr fin");
        jTable1.setModel(dft1);

    }

    public void setLocationDAO(locationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    public String saisie(String message, String regex) {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.println(message);
            str = sc.nextLine();
            if (!str.matches(regex)) {
                JOptionPane.showMessageDialog(this, "Entrée incorrecte, veuillez entrer le format DD/MM/YYYY", "ERREUR", JOptionPane.ERROR_MESSAGE);
            }
        } while (!str.matches(regex));

        return str;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDateRecherche = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("Date :");

        txtDateRecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateRechercheActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(89, 89, 89)
                .addComponent(txtDateRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(226, 226, 226))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDateRecherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDateRechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateRechercheActionPerformed

        try {

            String date = txtDateRecherche.getText();
            List<location> listLoc = locationDAO.rechDate(date);
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (location loc : listLoc) {
                Vector v = new Vector();
                v.add(loc.getIdLoc());
                v.add(loc.getDateLoc());
                v.add(loc.getKmtotal());
                v.add(loc.getAcompte());
                v.add(loc.getTotal());
                v.add(loc.getIdClient());
                v.add(loc.getIdTaxi());
                v.add(loc.getIdAdrDebut());
                v.add(loc.getIdAdrFin());
                dft1.addRow(v);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_txtDateRechercheActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtDateRecherche;
    // End of variables declaration//GEN-END:variables
}
