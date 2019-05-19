/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;


/**
 *
 * @author camma
 */
public class Client extends Observer {

    protected int idclient;
    protected String nom;
    protected String prenom;
    protected String tel;
    protected int idadr;
    
    public Client(int idclient, String nom, String prenom, String tel, int idadr)
    {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.idadr = idadr;
    }

    public int getIdclient() {
        return idclient;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getIdadr() {
        return idadr;
    }

    public void setIdadr(int idadr) {
        this.idadr = idadr;
    }
    

    public void msg()
    {
        System.out.println("Coucou");
    }
    
    @Override
    public void update(String msg) {
        System.out.println("Le client " +nom+" "+prenom+" a reçu le message : " + msg);
    }

}
