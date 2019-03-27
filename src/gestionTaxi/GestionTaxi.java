/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionTaxi;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import taxi.DAO.taxiDAO;
import taxi.DAO.DAO;
import taxi.metier.taxi;
import myconnections.DBConnection;

/**
 *
 * @author Michel
 */
public class GestionTaxi {

    Scanner sc = new Scanner(System.in);
    taxi taxiActuel = null;
    DAO<taxi> taxiDAO = null;

    public GestionTaxi() {

    }

    public void gestion() {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
            System.exit(1);
        }

        System.out.println("connexion établie");

        taxiDAO = new taxiDAO();
        taxiDAO.setConnection(dbConnect);

        int ch = 0;
        do {
            System.out.println("1.Nouveau taxi \n2.Recherche de taxi\n3.Modification d'un taxi\n4.Suppression d'un taxi\n5.Recherche sur la description\n6.fin");
            System.out.print("Choix : ");
            ch = sc.nextInt();
            sc.skip("\n");
            switch (ch) {
                case 1:
                    nouveau();
                    break;
                case 2:
                    recherche();
                    break;
                case 3:
                    modif();
                    break;
                case 4:
                    sup();
                    break;
                case 5:
                    rechDescription();
                    break;
                /*
                case 6:
                    derncom();
                    break;
                 */
                case 6:
                    System.out.println("Fin !");
                    break;
                default:
                    System.out.println("Choix incorrect");
            }

        } while (ch != 6);
        DBConnection.closeConnection();
    }

    public void nouveau() {

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

    public void recherche() {
        try {
            System.out.println("ID recherché :");
            int id = sc.nextInt();
            taxiActuel = taxiDAO.read(id);
            System.out.println("Taxi : " + taxiActuel);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void modif() {
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

    public void sup() {
        try {
            System.out.println("ID ? ");
            int idtaxi = sc.nextInt();
            taxiActuel = new taxi(idtaxi, "", "", 0, "");
            taxiDAO.delete(taxiActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }

    public void rechDescription() {
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

    /*
    public void derncom() {
        try {
            LocalDate dt = ((ClientDAO) clientDAO).dern_com(clActuel);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E d MMMM yyyy", Locale.FRENCH);
            String aff = dt.format(dtf);
            System.out.println("date de la denière commande de " + clActuel + " = " + aff);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
    }
     */
    public static void main(String[] args) {
        GestionTaxi gt = new GestionTaxi();
        gt.gestion();

    }

}
