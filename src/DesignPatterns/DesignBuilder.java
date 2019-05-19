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
public class DesignBuilder {

    public static void main(String[] args) {
        try {
            Taxi tx1 = new Taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setImmatriculation("1-CLL-111").
                    setPrixkm(10).
                    setCarburant("Diesel").
                    setDescription("Voiture neuve").
                    build();
            System.out.println(tx1);
        } catch (Exception e) {
            System.out.println("Erreurrr " + e);
        }
        try {
            Taxi tx2 = new Taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setCarburant("Diesel").
                    setDescription("Voiture neuve").
                    build();
            System.out.println(tx2);
        } catch (Exception e) {
            System.out.println("Erreur " + e);
        }
    }

}
