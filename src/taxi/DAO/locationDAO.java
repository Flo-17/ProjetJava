/**
 *
 * @author Florian Cammarata
 * @version 1.0
 */
package taxi.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import taxi.metier.location;

public class locationDAO extends DAO<location> {

    /**
     * création d'une location sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj location à créer
     * @return location créée
     */
    @Override
    public location create(location obj) throws SQLException {

        Scanner sc = new Scanner(System.in);

        String query1 = "INSERT INTO location(dateloc,kmtotal,acompte,total,idadrdebut,idadrfin,idtaxi,idclient)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        String query2
                = "select idloc from location where idadrdebut =? and idadrfin = ? and idtaxi = ? and idclient = ?;";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {

            pstm1.setString(1, obj.getDateLoc());
            pstm1.setInt(2, obj.getKmtotal());
            pstm1.setFloat(3, obj.getAcompte());
            pstm1.setFloat(4, obj.getTotal());
            pstm1.setInt(5, obj.getIdAdrDebut());
            pstm1.setInt(6, obj.getIdAdrFin());
            pstm1.setInt(7, obj.getIdTaxi());
            pstm1.setInt(8, obj.getIdClient());
            int nl = pstm1.executeUpdate();
            System.out.println(nl + " ligne(s) insérée.");
            pstm2.setInt(5, obj.getIdAdrDebut());
            pstm2.setInt(6, obj.getIdAdrFin());
            pstm2.setInt(7, obj.getIdTaxi());
            pstm2.setInt(8, obj.getIdClient());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idloc = rs.getInt(1);
                    obj.setIdLoc(idloc);
                    return read(idloc);
                } else {
                    throw new SQLException("Erreur de création taxi, record introuvable");
                }
            }
        }
    }

    /**
     * mise à jour des données de la location sur base de son identifiant
     *
     * @return location
     * @param obj location à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public location update(location obj) throws SQLException {
        String query = "update location set dateloc = ?, kmtotal = ?, acompte = ?, total = ?, idadrdebut = ?, idadrfin = ?, idtaxi = ?, idclient = ? where idloc = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {

            pstm.setInt(9, obj.getIdLoc());
            pstm.setString(1, obj.getDateLoc());
            pstm.setInt(2, obj.getKmtotal());
            pstm.setFloat(3, obj.getAcompte());
            pstm.setFloat(4, obj.getTotal());
            pstm.setInt(5, obj.getIdAdrDebut());
            pstm.setInt(6, obj.getIdAdrFin());
            pstm.setInt(7, obj.getIdTaxi());
            pstm.setInt(8, obj.getIdClient());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Aucune ligne client mise à jour");
            } else {
                System.out.println("Taxi " + obj.getIdLoc() + " modifié.");
            }
            return read(obj.getIdLoc());
        }

    }

    /**
     * effacement d'une location sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj location à effacer
     */
    @Override
    public void delete(location obj) throws SQLException {
        String query1 = "DELETE FROM location WHERE idloc = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query1)) {
            pstm.setInt(1, obj.getIdLoc());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Aucune ligne de location effacée.");
            } else {
                System.out.println("Location " + obj.getIdLoc() + " supprimé.");
            }

        }
    }

    @Override
    public location read(int idloc) throws SQLException {
        String req = "select * from location where idloc = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idloc);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    String dateloc = rs.getString("DATELOC");
                    int kmtotal = rs.getInt("KMTOTAL");
                    float acompte = rs.getFloat("ACOMPTE");
                    float total = rs.getFloat("TOTAL");
                    int idclient = rs.getInt("IDCLIENT");
                    int idtaxi = rs.getInt("IDTAXI");
                    int idadrdebut = rs.getInt("IDADRDEBUT");
                    int idadrfin = rs.getInt("IDADRFIN");

                    return new location(idloc, dateloc, kmtotal, acompte, total, idclient, idtaxi, idadrdebut, idadrfin);

                } else {
                    throw new SQLException("L'ID est inconnu");
                }

            }

        }

    }
}
