/**
 *
 * @author Florian Cammarata
 * @version 1.0
 */
package gestionTaxi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import taxi.DAO.taxiDAO;
import taxi.DAO.DAO;
import taxi.metier.taxi;
import myconnections.DBConnection;
import taxi.DAO.locationDAO;
import taxi.DAO.locationVueDAO;
import taxi.metier.location;
import taxi.metier.locationVue;

public class GestionTaxi {

    Scanner sc = new Scanner(System.in);
    taxi taxiActuel = null;
    location locationActuelle = null;
    DAO<taxi> taxiDAO = null;
    DAO<locationVue> locationVueDAO = null;
    DAO<location> locationDAO = null;

    public GestionTaxi() {

    }

    public void gestion() throws SQLException {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        taxiDAO = new taxiDAO();
        locationVueDAO = new locationVueDAO();
        locationDAO = new locationDAO();
        taxiDAO.setConnection(dbConnect);
        locationVueDAO.setConnection(dbConnect);
        locationDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("1.Taxi\n2.Location");
            System.out.print("Choix : ");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    int ch2 = 0;
                    do {
                        System.out.println("1.Nouveau taxi \n2.Recherche de taxi\n3.Modification d'un taxi\n4.Suppression d'un taxi\n5.Recherche sur la description\n6.Retour");
                        System.out.print("Choix : ");
                        ch2 = sc.nextInt();
                        sc.skip("\n");
                        switch (ch2) {
                            case 1:
                                nouveauTaxi();
                                break;
                            case 2:
                                rechercheTaxi();
                                break;
                            case 3:
                                modifTaxi();
                                break;
                            case 4:
                                supTaxi();
                                break;
                            case 5:
                                rechDescriptionTaxi();
                                break;
                            case 6:
                                System.out.println("Retour.");
                                break;
                            default:
                                System.out.println("Choix incorrect");
                        }

                    } while (ch2 != 6);
                    break;
                case 2:
                    int ch3 = 0;
                    do {
                        System.out.println("1.Nouvelle location \n2.Recherche d'une location\n3.Modification d'une location\n4.Suppression d'une location\n5.Total d'une location\n6.Retour");
                        System.out.print("Choix : ");
                        ch3 = sc.nextInt();
                        sc.skip("\n");
                        switch (ch3) {
                            case 1:
                        {
                            try {
                                nouvelleLoc();
                            } catch (ParseException ex) {
                                Logger.getLogger(GestionTaxi.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                                break;
                            case 2:
                                rechercheLoc();
                                break;
                            case 3:
                                modifLoc();
                                break;
                            case 4:
                                supLoc();
                                break;
                            case 5:
                                //totalLoc();
                                break;
                            case 6:
                                System.out.println("Retour.");
                                break;
                            default:
                                System.out.println("Choix incorrect");
                        }

                    } while (ch3 != 6);
                    break;
            }
        } while (ch != 2);

        DBConnection.closeConnection();
    }

    public void nouveauTaxi() {

        System.out.print("Immatriculation : ");
        String immatriculation = sc.nextLine();
        System.out.print("Carburant : ");
        String carburant = sc.nextLine();
        System.out.print("Prix au km : ");
        float prixkm = sc.nextFloat();
        sc.skip("\n");
        System.out.println("Description : ");
        String description = sc.nextLine();
        taxiActuel = new taxi(0, immatriculation, carburant, prixkm, description);
        try {
            taxiActuel = taxiDAO.create(taxiActuel);
            System.out.println("Taxi : " + taxiActuel);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }

    public void rechercheTaxi() {
        try {
            System.out.println("ID recherché :");
            int id = sc.nextInt();
            taxiActuel = taxiDAO.read(id);
            System.out.println("Taxi : " + taxiActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void modifTaxi() {
        System.out.println("ID ? ");
        int idtaxi = sc.nextInt();
        sc.skip("\n");
        System.out.println("Nouvelle immatriculation :");
        String immatriculation = sc.nextLine();
        System.out.println("Nouveau carburant :");
        String carburant = sc.nextLine();
        System.out.println("Nouveau prix au km :");
        float prixkm = sc.nextFloat();
        sc.skip("\n");
        System.out.println("Nouvelle description :");
        String description = sc.nextLine();

        taxiActuel = new taxi(idtaxi, immatriculation, carburant, prixkm, description);
        try {
            taxiDAO.update(taxiActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void supTaxi() {
        try {
            System.out.println("ID ? ");
            int idtaxi = sc.nextInt();
            taxiActuel = new taxi(idtaxi, "", "", 0, "");
            taxiDAO.delete(taxiActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void rechDescriptionTaxi() {
        System.out.println("Mot de la description recherché : ");
        String nom = sc.nextLine();
        try {
            List<taxi> plusieurs = ((taxiDAO) taxiDAO).rechDesc(nom);
            for (taxi t : plusieurs) {
                System.out.println(plusieurs);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void rechercheLoc() throws SQLException {
        System.out.println("Recherche d'une location. ");
        System.out.println("ID recherché : ");
        int id = sc.nextInt();

        List<locationVue> loc = ((locationVueDAO) locationVueDAO).rechLoc(id);
        for (locationVue t : loc) {
            System.out.println(loc);

        }
    }

    public void nouvelleLoc() throws ParseException {

        System.out.print("Date de la location : ");
        String dateloc = sc.nextLine();
        System.out.print("Km total : ");
        int kmtotal = sc.nextInt();
        System.out.print("Acompte : ");
        float acompte = sc.nextFloat();
        sc.skip("\n");
        System.out.println("Total : ");
        float total = sc.nextFloat();
        sc.skip("\n");
        System.out.println("ID Adresse de debut : ");
        int idadrdebut = sc.nextInt();
        System.out.println("ID Adresse de fin : ");
        int idadrfin = sc.nextInt();
        System.out.println("ID du taxi : ");
        int idtaxi = sc.nextInt();
        System.out.println("ID du client : ");
        int idclient = sc.nextInt();
        locationActuelle = new location(0, dateloc, kmtotal, acompte, total, idadrdebut, idadrfin, idtaxi, idclient);
        try {
            locationActuelle = locationDAO.create(locationActuelle);
            System.out.println("Location : " + locationActuelle);
        } catch (SQLException e) {
            System.out.println("erreur :" + e);
        }

    }
    
    public void modifLoc() {
        System.out.println("ID ? ");
        int idloc = sc.nextInt();
        sc.skip("\n");
        System.out.println("Nouvelle date :");
        String dateloc = sc.nextLine();
        System.out.println("Nouveau km total :");
        int kmtotal = sc.nextInt();
        System.out.println("Nouveau acompte :");
        float acompte = sc.nextFloat();
        sc.skip("\n");
        System.out.println("Nouveau total :");
        float total = sc.nextFloat();
        sc.skip("\n");
        System.out.println("Nouvel id d'adresse de debut :");
        int idadrdebut = sc.nextInt();
        System.out.println("Nouvel id d'adresse de fin :");
        int idadrfin = sc.nextInt();
        System.out.println("Nouveau id taxi :");
        int idtaxi = sc.nextInt();
        System.out.println("Nouveau id client :");
        int idclient = sc.nextInt();
        

        locationActuelle = new location(idloc, dateloc, kmtotal, acompte, total, idadrdebut, idadrfin, idtaxi, idclient);
        try {
            locationDAO.update(locationActuelle);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }
    
    public void supLoc() {
        try {
            System.out.println("ID ? ");
            int idloc = sc.nextInt();
            locationActuelle = new location(idloc, "", 0, 0, 0, 0, 0, 0, 0);
            locationDAO.delete(locationActuelle);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
    
    

    public static void main(String[] args) throws SQLException {
        GestionTaxi gt = new GestionTaxi();
        gt.gestion();

    }

}
