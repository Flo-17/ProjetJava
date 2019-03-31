/**
 *
 * @author Florian Cammarata
 * @version 1.0
 */
package taxi.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import myconnections.DBConnection;
import taxi.metier.locationVue;
import taxi.metier.taxi;

public class locationVueDAO extends DAO<locationVue> {
    
    /**
     * lecture de la vue "vue_location" sur base d'un id entré 
     *
     * @throws SQLException recherche impossible
     * @param idrech : id de la location à rechercher
     * @return données de la vue vue_location
     */

    public List<locationVue> rechLoc(int idrech) throws SQLException {

        String req = "SELECT * FROM vue_location where idloc = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            List<locationVue> loc = new ArrayList<>();

            pstm.setInt(1, idrech);
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
                    int idtaxi = rs.getInt("IDTAXI");
                    int cp = rs.getInt("CP");
                    String localite = rs.getString("LOCALITE");
                    String rue = rs.getString("RUE");
                    String num = rs.getString("NUM");
                    int cpRetour = rs.getInt("CP du retour");
                    String localiteRetour = rs.getString("LOC du retour");
                    String rueRetour = rs.getString("RUE du retour");
                    String numRetour = rs.getString("NUM du retour");

                    loc.add(new locationVue(idloc, dateloc, kmtotal, acompte, total, idclient, idtaxi, cp, localite, rue, num, cpRetour, localiteRetour, rueRetour, numRetour));
                    }
                    if (!trouve) {
                        throw new SQLException("Recherche impossible");
                    } else {
                        return loc;
                    }
            }
        }

    }

    @Override
    public locationVue read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public locationVue create(locationVue obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public locationVue update(locationVue obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(locationVue obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
