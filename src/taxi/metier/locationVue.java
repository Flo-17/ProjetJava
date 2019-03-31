/**
 *
 * @author Florian Cammarata
 * @version 1.0
 */
package taxi.metier;

import java.sql.Date;

public class locationVue {

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
    protected int idClient;
    /**
     * id du client
     */
    protected int idTaxi;
    /**
     * id du taxi
     */
    protected int cp;
    /**
     * code postal de l'aller
     */
    protected String localite;
    /**
     * localite de l'aller
     */
    protected String rue;
    /**
     * rue de l'aller
     */
    protected String num;
    /**
     * num de rue de l'aller
     */
    protected int cpRetour;
    /**
     * code postal du retour
     */
    protected String localiteRetour;
    /**
     * localite du retour
     */
    protected String rueRetour;
    /**
     * rue du retour
     */
    protected String numRetour;

    /**
     * numero de rue du retour
     */
    
    
    /**
     * constructeur par défaut
     */
    public locationVue() {

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
     *
     * @param cp code postal de l'adresse de l'aller
     * @param localite localite de l'adresse de l'aller
     * @param idTaxi identifiant unique du taxi loué
     * @param rue rue de l'adresse de l'aller
     * @param idClient identifiant unique du client qui loue le taxi
     * @param num numero de l'adresse de l'aller
     * @param cpRetour code postal de l'adresse de retour
     * @param localiteRetour localite de l'adresse de retour
     * @param rueRetour rue de l'adresse de retour
     * @param numRetour numéro de l'adresse de retour
     */
    public locationVue(int idLoc, String dateLoc, int kmtotal, float acompte, float total, int idClient, int idTaxi, int cp, String localite, String rue, String num, int cpRetour, String localiteRetour, String rueRetour, String numRetour) {
        this.idLoc = idLoc;
        this.dateLoc = dateLoc;
        this.kmtotal = kmtotal;
        this.acompte = acompte;
        this.total = total;
        this.idClient = idClient;
        this.idTaxi = idTaxi;
        this.cp = cp;
        this.localite = localite;
        this.rue = rue;
        this.num = num;
        this.cpRetour = cpRetour;
        this.localiteRetour = localiteRetour;
        this.rueRetour = rueRetour;
        this.numRetour = numRetour;

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
    public void setAccompte(float acompte) {
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
     * getter id du client
     *
     * @return id du client
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * setter id client
     *
     * @param idClient id du client
     */
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    /**
     * getter id taxi
     *
     * @return id du taxi
     */
    public int getIdTaxi() {
        return idTaxi;
    }

    /**
     * setter id du taxi
     *
     * @param idTaxi id du taxi
     */
    public void setIdTaxi(int idTaxi) {
        this.idTaxi = idTaxi;
    }

    /**
     * getter code postal de l'aller
     *
     * @return code postal de l'aller
     */
    public int getCp() {
        return cp;
    }

    /**
     * setter code postal aller
     *
     * @param cp code postal de l'aller
     */
    public void setCp(int cp) {
        this.cp = cp;
    }

    /**
     * getter localite de l'aller
     *
     * @return localité de l'aller
     */
    public String getLocalite() {
        return localite;
    }

    /**
     * setter localite de l'aller
     *
     * @param localite localité de l'aller
     */
    public void setLocalite(String localite) {
        this.localite = localite;
    }

    /**
     * getter rue de l'aller
     *
     * @return rue de l'aller
     */
    public String getRue() {
        return rue;
    }

    /**
     * setter rue de l'aller
     *
     * @param rue rue de l'aller
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     * getter numero de rue de l'aller
     *
     * @return numero de rue de l'aller
     */
    public String getNum() {
        return num;
    }

    /**
     * setter numero de l'aller
     *
     * @param num numero de rue de l'aller
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * getter code postal du retour
     *
     * @return code postal du retour
     */
    public int getCpRetour() {
        return cpRetour;
    }

    /**
     * setter code postal retour
     *
     * @param cpRetour code postal du retour
     */
    public void setCpRetour(int cpRetour) {
        this.cpRetour = cpRetour;
    }

    /**
     * getter localite du retour
     *
     * @return localite du retour
     */
    public String getLocaliteRetour() {
        return localiteRetour;
    }

    /**
     * setter localite du retour
     *
     * @param localiteRetour localite du retour
     */
    public void setLocaliteRetour(String localiteRetour) {
        this.localiteRetour = localiteRetour;
    }

    /**
     * getter rue du retour
     *
     * @return rue du retour
     */
    public String getRueRetour() {
        return rueRetour;
    }

    /**
     * setter rue du retour
     *
     * @param rueRetour rue du retour
     */
    public void setRueRetour(String rueRetour) {
        this.rueRetour = rueRetour;
    }

    /**
     * getter numero du retour
     *
     * @return numero du retour
     */
    public String getNumRetour() {
        return numRetour;
    }

    /**
     * setter numero de retour
     *
     * @param numRetour numero du retour
     */
    public void setNumRetour(String numRetour) {
        this.numRetour = numRetour;
    }

    /**
     * methode toString
     *
     * @return infos completes
     */
    @Override
    public String toString() {
        return "Location n° " + idLoc + ", effectuee le " + dateLoc + ". Total de km : " + kmtotal + ", acompte de " + acompte + " pour un total de " + total + ". L'ID du client est " + idClient + ", l'ID du taxi est " + idTaxi + ". Code postal de depart : " + cp + ", localite de depart : " + localite + ", rue de depart : " + rue + ", au numero " + num + "...... Code postal du retour : " + cpRetour + ", localite du retour : " + localiteRetour + ", rue du retour  : " + rueRetour + ", au numero " + numRetour + ".";
    }

}
