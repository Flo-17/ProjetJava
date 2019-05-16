/**
 *
 * @author Florian Cammarata
 * @version 1.0
 */
package taxi.metier;

import java.sql.Date;

public class location {

    protected int idLoc;
    /**
     * identifiant unique de la location
     */
    protected String dateLoc;
    /**
     * date de la location
     */
    protected int kmtotal;
    /**
     * km total parcouru
     */
    protected float acompte;
    /**
     * acompte
     */
    protected float total;
    /**
     * total
     */
    protected int idAdrDebut;
    /**
     * identifiant unique de l'adresse de début
     */
    protected int idAdrFin;
    /**
     * identifiant unique de l'adresse de fin
     */
    protected int idTaxi;
    /**
     * identifiant uniquedu taxi
     */
    protected int idClient;

    /**
     * identifiant unique du client
     */
    
    
    
    /**
     * constructeur par défaut
     */
    public location() {

    }

    /**
     * constructeur paramétré
     *
     * @param idLoc identifiant unique de la location, affecté par la base de
     * données
     * @param dateLoc date de la location
     * @param kmtotal total de km que le taxi effectue
     * @param acompte acompte de la location
     * @param total prix total de la location
     * @param idAdrDebut identifiant unique de l'adresse de dépard
     * @param idAdrFin identifiant unique de l'adresse de l'arrivée
     * @param idTaxi identifiant unique du taxi loué
     * @param idClient identifiant unique du client qui loue le taxi
     */
    public location(int idLoc, String dateLoc, int kmtotal, float acompte, float total, int idAdrDebut, int idAdrFin, int idTaxi, int idClient) {
        this.idLoc = idLoc;
        this.dateLoc = dateLoc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.idAdrDebut = idAdrDebut;
        this.idAdrFin = idAdrFin;
        this.idTaxi = idTaxi;
        this.idClient = idClient;
    }

    /**
     * getter idloc
     *
     * @return idloc identifiant de la location
     */
    public int getIdLoc() {
        return idLoc;
    }

    /**
     * setter idloc
     *
     * @param idLoc identifiant de la location
     */
    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    /**
     * getter date location
     *
     * @return date location
     */
    public String getDateLoc() {
        return dateLoc;
    }

    /**
     * setter dateloc
     *
     * @param dateLoc date de location
     */
    public void setDateLoc(String dateLoc) {
        this.dateLoc = dateLoc;
    }

    /**
     * getter km total
     *
     * @return kilometrage total
     */
    public int getKmtotal() {
        return kmtotal;
    }

    /**
     * setter kmtotal
     *
     * @param kmtotal kilometrage total
     */
    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    /**
     * getter acompte
     *
     * @return acompte
     */
    public float getAcompte() {
        return acompte;
    }

    /**
     * setter acompte
     *
     * @param acompte acompte
     */
    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

    /**
     * getter total
     *
     * @return total
     */
    public float getTotal() {
        return total;
    }

    /**
     * setter total
     *
     * @param total total
     */
    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * getter de l'id de l'adresse de debut
     *
     * @return id de l'adresse de debut
     */
    public int getIdAdrDebut() {
        return idAdrDebut;
    }

    /**
     * setter idadrdebut
     *
     * @param idAdrDebut id de l'adresse de debut
     */
    public void setIdAdrDebut(int idAdrDebut) {
        this.idAdrDebut = idAdrDebut;
    }

    /**
     * getter id de l'adresse de fin
     *
     * @return id de l'adresse de fin
     */
    public int getIdAdrFin() {
        return idAdrFin;
    }

    /**
     * setter idadrfin
     *
     * @param idAdrFin id de l'adresse de fin
     */
    public void setIdAdrFin(int idAdrFin) {
        this.idAdrFin = idAdrFin;
    }

    /**
     * getter id du taxi
     *
     * @return id du taxi
     */
    public int getIdTaxi() {
        return idTaxi;
    }

    /**
     * setter idtaxi
     *
     * @param idTaxi id du taxi
     */
    public void setIdTaxi(int idTaxi) {
        this.idTaxi = idTaxi;
    }

    /**
     * getter id du client
     *
     * @return id du client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * setter idclient
     *
     * @param idClient id du client
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * methode toString
     *
     * @return infos completes
     */
    @Override
    public String toString() {
        return "Location : "+idLoc+" en date du "+dateLoc+". Total de km : "+kmtotal+", acompte de "+acompte+" pour un total de "+total+". ID du client : "+idClient+", ID du taxi : "+idTaxi+". ID adresse début : "+idAdrDebut+", ID adresse fin : "+idAdrFin;
    }

}
