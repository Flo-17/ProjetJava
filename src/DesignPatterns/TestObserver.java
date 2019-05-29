/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import DesignPatterns.Taxi.TaxiBuilder;

/**
 *
 * @author camma
 */
public class TestObserver {

    public static void main(String[] args) throws Exception {
        
        Taxi t1 = new Taxi.TaxiBuilder().
                setIdtaxi(1).
                setImmatriculation("1-IOL-222").
                setPrixkm(15).
                setCarburant("Essence").
                setDescription("Voiture ancienne").
                build();
        Taxi t2 = new Taxi.TaxiBuilder().
                    setIdtaxi(1).
                    setImmatriculation("1-PMA-111").
                    setPrixkm(10).
                    setCarburant("Diesel").
                    setDescription("Voiture neuve").
                    build();
        Location l1 = new Location(1, "19/05/2019", 10, 50, 100, 1, 1, t1, 1);
        Location l2 = new Location(2, "20/05/2019", 100, 500, 1000, 1, 1, t2, 2);
        Client cl1 = new Client(10, "Durand", "Jean", "0476123456", 2);
        Client cl2 = new Client(11, "Donny", "Marc", "0476987654", 1);
        l1.addObserver(cl1);
        l1.addObserver(cl2);
        l2.addObserver(cl1);
        l1.setT(t2);
        l2.setT(t1);
    }

}
