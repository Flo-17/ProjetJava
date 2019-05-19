/**
 *
 * @author Florian Cammarata
 * @version 1.0
 */
package taxi.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import taxi.metier.location;
import taxi.metier.taxi;

/**
 *
 * @author camma
 */
public class taxiDAO extends DAO<taxi> {

    /**
     * création d'un taxi sur base des valeurs de son objet métier
     *
     * @throws SQLException erreur de création
     * @param obj taxi à créer
     * @return taxi créé
     */
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

    /**
     * récupération des données d'un taxi sur base de son identifiant
     *
     * @throws SQLException id inconnu
     * @param idtaxi identifiant du taxi
     * @return taxi trouvé
     */
    @Override
    public taxi read(int idtaxi) throws SQLException {
        String req = "select * from taxi where idtaxi = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idtaxi);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    String immatriculation = rs.getString("IMMATRICULATION");
                    String carburant = rs.getString("CARBURANT");
                    float prixkm = rs.getInt("PRIXKM");
                    String description = rs.getString("DESCRIPTION");

                    return new taxi(idtaxi, immatriculation, carburant, prixkm, description);

                } else {
                    throw new SQLException("L'ID est inconnu");
                }

            }

        }

    }

    /**
     * mise à jour des données du taxi sur base de son identifiant
     *
     * @return taxi
     * @param obj taxi à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
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
                throw new SQLException("Aucune ligne client mise à jour");
            } else {
                System.out.println("Taxi " + obj.getIdtaxi() + " modifié.");
            }
            return read(obj.getIdtaxi());
        }

    }

    /**
     * effacement du taxi sur base de son identifiant
     *
     * @throws SQLException erreur d'effacement
     * @param obj taxi à effacer
     */
    @Override
    public void delete(taxi obj) throws SQLException {
        String query1 = "DELETE FROM TAXI WHERE idtaxi = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query1)) {
            pstm.setInt(1, obj.getIdtaxi());
            int n = pstm.executeUpdate();
            if (n == 0) {
                throw new SQLException("Aucune ligne du taxi effacée.");
            } else {
                System.out.println("Taxi " + obj.getIdtaxi() + " supprimé.");
            }

        }
    }

    /**
     * méthode permettant de récupérer tous les taxis dont la description
     * comporte un certain mot
     *
     * @param desc mot de la description recherché
     * @return liste de taxi
     * @throws SQLException mot introuvable
     */
    public List<taxi> rechDesc(String desc) throws SQLException {
        List<taxi> plusieurs = new ArrayList<>();
        String req = "select * from taxi where description LIKE ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%" + desc + "%");
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
    
    /**
     * méthode permettant de récupérer toutes les locations d'un id de taxi
     *
     * @param idtaxi id du taxi dont on veut afficher les locations
     * @return liste de location
     * @throws SQLException id introuvable
     */

    public List<location> rechLoc(int idtaxi) throws SQLException {
        List<location> taxi = new ArrayList<>();
        String req = "select * from location where idtaxi = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1,idtaxi);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idloc = rs.getInt("IDLOC");
                    String dateloc = rs.getString("DATELOC");
                    int kmtotal = rs.getInt("KMTOTAL");
                    float acompte = rs.getFloat("ACOMPTE");
                    float total = rs.getFloat("TOTAL");
                    int idclient = rs.getInt("IDCLIENT");
                    idtaxi = rs.getInt("IDTAXI");
                    int idadrdebut = rs.getInt("IDADRDEBUT");
                    int idadrfin = rs.getInt("IDADRFIN");
                    taxi.add(new location(idloc, dateloc, kmtotal, acompte, total, idclient, idtaxi, idadrdebut, idadrfin));
                }
                if (!trouve) {
                    throw new SQLException("Recherche impossible");
                } else {
                    return taxi;
                }
            }
        }
    }

}
