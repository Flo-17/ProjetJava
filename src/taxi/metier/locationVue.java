package taxi.metier;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import myconnections.DBConnection;

public class locationVue {

    protected int idLoc;
    protected Date dateLoc;
    protected int kmtotal;
    protected float acompte;
    protected float total;
    protected int idClient;
    protected int idTaxi;
    protected int cp;
    protected String localite;
    protected String rue;
    protected String num;
    protected int cpRetour;
    protected String localiteRetour;
    protected String rueRetour;
    protected String numRetour;

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
    public locationVue(int idLoc, Date dateLoc, int kmtotal, float acompte, float total, int idClient, int idTaxi, int cp, String localite, String rue, String num, int cpRetour, String localiteRetour, String rueRetour, String numRetour) {
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

    public int getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    public Date getDateLoc() {
        return dateLoc;
    }

    public void setDateLoc(Date dateLoc) {
        this.dateLoc = dateLoc;
    }

    public int getKmtotal() {
        return kmtotal;
    }

    public void setKmtotal(int kmtotal) {
        this.kmtotal = kmtotal;
    }

    public float getAcompte() {
        return acompte;
    }

    public void setAcompte(float acompte) {
        this.acompte = acompte;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdTaxi() {
        return idTaxi;
    }

    public void setIdTaxi(int idTaxi) {
        this.idTaxi = idTaxi;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getCpRetour() {
        return cpRetour;
    }

    public void setCpRetour(int cpRetour) {
        this.cpRetour = cpRetour;
    }

    public String getLocaliteRetour() {
        return localiteRetour;
    }

    public void setLocaliteRetour(String localiteRetour) {
        this.localiteRetour = localiteRetour;
    }

    public String getRueRetour() {
        return rueRetour;
    }

    public void setRueRetour(String rueRetour) {
        this.rueRetour = rueRetour;
    }

    public String getNumRetour() {
        return numRetour;
    }

    public void setNumRetour(String numRetour) {
        this.numRetour = numRetour;
    }

    @Override
    public String toString() {
        return "locationVue{" + "idLoc=" + idLoc + ", dateLoc=" + dateLoc + ", kmtotal=" + kmtotal + ", acompte=" + acompte + ", total=" + total + ", idClient=" + idClient + ", idTaxi=" + idTaxi + ", cp=" + cp + ", localite=" + localite + ", rue=" + rue + ", num=" + num + ", cpRetour=" + cpRetour + ", localiteRetour=" + localiteRetour + ", rueRetour=" + rueRetour + ", numRetour=" + numRetour + '}';
    }
    
    
    
}