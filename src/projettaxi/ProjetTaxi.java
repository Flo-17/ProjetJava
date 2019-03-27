/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettaxi;

import java.sql.PreparedStatement;
import java.sql.*;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import myconnections.DBConnection;

/**
 *
 * @author camma
 */
public class ProjetTaxi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ProjetTaxi p = new ProjetTaxi();

        p.menu();

    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        String rep;
        int x;

        do {
            System.out.println("1. Ajout taxi + affichage id résultant ");
            System.out.println("2. Recherche exacte sur base de l'immatriculation ");
            System.out.println("3. Recherche partielle sur base de la description ");
            System.out.println("4. Modifications des infos sur base de l'immatriculation ");
            System.out.println("5. Suppression d'un taxi selon son immatriculation ");
            System.out.println("6. Fin ");
            rep = saisie("Choix ?", "[1-6]{1}");
            x = Integer.parseInt(rep);

            switch (x) {

                case 1:
                    sql1();
                    break;
                case 2:
                    sql2();
                    break;
                case 3:
                    sql3();
                    break;
                case 4:
                    sql4();
                    break;
                case 5:
                    sql5();
                    break;
                default:
                    System.out.println("Au revoir");
                    break;
            }
        } while (x != 4);
    }

    public void sql1() {

        Scanner sc = new Scanner(System.in);

        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }

        String query1 = "INSERT INTO taxi(immatriculation,carburant,prixkm,description)"
                + "VALUES(?,?,?,?)";
        String query2
                = "select idtaxi from taxi where immatriculation=? and description=?";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
            System.out.println("Nouveau taxi : ");
            System.out.print("Immatriculation : ");
            String immatriculation = sc.nextLine();
            System.out.print("Carburant : ");
            String carburant = sc.nextLine();
            System.out.print("Prix km : ");
            float prixkm = sc.nextInt();
            System.out.print("Description : ");
            String description = sc.nextLine();
            pstm1.setString(1, immatriculation);
            pstm1.setString(2, carburant);
            pstm1.setFloat(3, prixkm);
            pstm1.setString(4, description);
            int nl = pstm1.executeUpdate();
            System.out.println(nl + " ligne insérée");
            pstm2.setString(1, immatriculation);
            pstm2.setString(2, description);
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idtaxi = rs.getInt(1);
                    System.out.println("Id résultant : "
                            + idtaxi);
                } else {
                    System.out.println("erreur lors de l'insertion, id introuvable");
                }
            }
        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
    }

    public void sql2() {
        Scanner sc = new Scanner(System.in);

        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }

        System.out.println("Plaque recherchée : ");
        String plaque = sc.nextLine();
        try (Statement stmt = dbConnect.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM TAXI WHERE IMMATRICULATION = '" + plaque + "'");) {
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;
                int n = rs.getInt("IDTAXI");
                String carburant = rs.getString("CARBURANT");
                int x = rs.getInt("PRIXKM");
                String description = rs.getString("DESCRIPTION");
                System.out.println("\nId du taxi : " + n + " ..... " + carburant + " ... Prix au km : "
                        + x + " ..... " + description + "\n");
            }
            if (!trouve) {
                System.out.println("Taxi introuvable ! ");
            }
        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }

    }

    public void sql3() {
        Scanner sc = new Scanner(System.in);

        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }

        System.out.println("Descrpition recherchée : ");
        String descript = sc.nextLine();
        try (Statement stmt = dbConnect.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT * FROM TAXI WHERE DESCRIPTION LIKE '%" + descript + "%'");) {
            boolean trouve = false;
            while (rs.next()) {
                trouve = true;
                int n = rs.getInt("IDTAXI");
                String carburant = rs.getString("CARBURANT");
                int x = rs.getInt("PRIXKM");
                String description = rs.getString("DESCRIPTION");
                System.out.println("\nId du taxi : " + n + " ..... " + carburant + " ... Prix au km : "
                        + x + " ..... " + description + "\n");
            }
            if (!trouve) {
                System.out.println("Taxi introuvable ! ");
            }
        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
    }

    public void sql4() {
        Scanner sc = new Scanner(System.in);

        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }

        String query = "update taxi set immatriculation = ?, carburant = ?, prixkm = ?, description = ? where immatriculation = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            System.out.println("Immatriculation :");
            String immat = toUpperCase(sc.nextLine());

            pstm.setString(5, immat);
            System.out.println("Immatriculation nouvelle : ");
            String newImmat = sc.nextLine();
            pstm.setString(1, toUpperCase(newImmat));
            System.out.println("Modification carburant : ");
            String carburant = sc.nextLine();
            pstm.setString(2, carburant);
            System.out.println("Nouveau prix au km : ");
            String prixkm = sc.nextLine();
            pstm.setString(3, prixkm);
            System.out.println("Nouvelle description : ");
            String description = sc.nextLine();
            pstm.setString(4, description);
            int nl = pstm.executeUpdate();
            if (nl == 0) {
                System.out.println("Immatriculation introuvable");
            }
            System.out.println(nl + " ligne mise à jour");

        } catch (SQLException e) {
            System.out.println("erreur SQL =" + e);
        }
    }

    public void sql5() {
        Scanner sc = new Scanner(System.in);

        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.exit(1);
        }

        System.out.print("Immatriculation du taxi à supprimer : ");
        String immat = toUpperCase(sc.nextLine());
        String query1 = "DELETE FROM TAXI WHERE IMMATRICULATION = '" + immat +"'";
        try (PreparedStatement pstm1 = dbConnect.prepareStatement(query1)) {
            int nl = pstm1.executeUpdate();
            System.out.println("\n"+ nl + " ligne(s) effacée(s) dans la table TAXI \n");
        } catch (SQLException e) {
            System.out.println("erreur " + e);
        }
    }

    public String saisie(String message, String regex) {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.println(message);
            str = sc.nextLine();
            if (!str.matches(regex)) {
                System.out.println("Saisie incorrecte.");
            }
        } while (!str.matches(regex));

        return str;
    }

}
