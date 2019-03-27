/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import myconnections.DBConnection;
import taxi.metier.taxi;

/**
 *
 * @author camma
 */
public class taxiDAO extends DAO<taxi> {

    @Override
    public taxi create(taxi obj) throws SQLException {

        Scanner sc = new Scanner(System.in);

        String query1 = "INSERT INTO taxi(immatriculation,carburant,prixkm,description)"
                + "VALUES(?,?,?,?)";
        String query2
                = "select idtaxi from taxi where immatriculation=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {

            pstm1.setString(1, obj.getImmatriculation());
            pstm1.setString(2, obj.getCarburant());
            pstm1.setFloat(3, obj.getPrixkm());
            pstm1.setString(4, obj.getDescription());
            int nl = pstm1.executeUpdate();
            System.out.println(nl + " ligne insérée.");
            pstm2.setString(1, obj.getImmatriculation());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idtaxi = rs.getInt(1);
                    obj.setIdtaxi(idtaxi);
                    return read(idtaxi);
                } else {
                    throw new SQLException("Erreur de création taxi, record introuvable");
                }
            }
        }
    }

    @Override
    public taxi read(int idtaxi) throws SQLException {

        String req = "select * from taxi where idtaxi = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idtaxi);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    //int idtaxi = rs.getInt("IDTAXI");
                    String immatriculation = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getInt("PRIXKM");
                    String description = rs.getString("DESCRIPTION");

                    return new taxi(idtaxi, immatriculation, carburant, prixkm, description);

                } else {
                    throw new SQLException("ID inconnu");
                }

            }

        }

    }

    @Override
    public taxi update(taxi obj) throws SQLException {

        String query = "update taxi set immatriculation = ?, carburant = ?, prixkm = ?, description = ? where idtaxi = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {

            pstm.setInt(5, obj.getIdtaxi());
            pstm.setString(1, toUpperCase(obj.getImmatriculation()));
            pstm.setString(2, obj.getCarburant());
            pstm.setFloat(3, obj.getPrixkm());
            pstm.setString(4, obj.getDescription());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("aucune ligne client mise à jour");
            }
            else
            {
                System.out.println("Taxi "+obj.getIdtaxi()+" modifié.");
            }
            return read(obj.getIdtaxi());
        }

    }

    @Override
    public void delete(taxi obj) throws SQLException {

        String query1 = "DELETE FROM TAXI WHERE idtaxi = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query1)) {
            pstm.setInt(1, obj.getIdtaxi());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Aucune ligne du taxi effacée.");
            }
            else
            {
                System.out.println("Taxi "+obj.getIdtaxi()+" supprimé.");
            }

        }
    }

    public List<taxi> rechDesc(String desc) throws SQLException {
        List<taxi> plusieurs = new ArrayList<>();
        String req = "select * from taxi where description LIKE ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%"+desc+"%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idtaxi = rs.getInt("IDTAXI");
                    String immatriculation = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getFloat("PRIXKM");
                    String description = rs.getString("DESCRIPTION");
                    plusieurs.add(new taxi(idtaxi, immatriculation, carburant, prixkm, description));
                }

                if (!trouve) {
                    throw new SQLException("Recherche impossible");
                } else {
                    return plusieurs;
                }
            }
        }
    }
}
