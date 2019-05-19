/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPatterns;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author camma
 */
public class Taxi {

    protected int idtaxi;
    protected String immatriculation;
    protected String carburant;
    protected float prixkm;
    protected String description;
    protected Set<Location> locations = new HashSet<>();

    private Taxi(TaxiBuilder tb) {
        this.idtaxi = tb.idtaxi;
        this.immatriculation = tb.immatriculation;
        this.carburant = tb.carburant;
        this.prixkm = tb.prixkm;
        this.description = tb.description;
    }

    public int getIdtaxi() {
        return idtaxi;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public String getCarburant() {
        return carburant;
    }

    public float getPrixkm() {
        return prixkm;
    }

    public String getDescription() {
        return description;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public static class TaxiBuilder {

        protected int idtaxi;
        protected String immatriculation;
        protected String carburant;
        protected float prixkm;
        protected String description;
        protected Set<Location> locations = new HashSet<>();

        public TaxiBuilder setIdtaxi(int idtaxi) {
            this.idtaxi = idtaxi;
            return this;
        }

        public TaxiBuilder setImmatriculation(String immatriculation) {
            this.immatriculation = immatriculation;
            return this;
        }

        public TaxiBuilder setCarburant(String carburant) {
            this.carburant = carburant;
            return this;
        }

        public TaxiBuilder setPrixkm(float prixkm) {
            this.prixkm = prixkm;
            return this;
        }

        public TaxiBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public TaxiBuilder setLocations(Set<Location> locations) {
            this.locations = locations;
            return this;
        }

        public Taxi build() throws Exception {
            if (idtaxi <= 0 || immatriculation == null || prixkm <= 0) {
                throw new Exception("informations de construction incomplètes");
            }
            return new Taxi(this);
        }
    }

    @Override
    public String toString() {
        return "Taxi ID : " + idtaxi + ", immatriculation : " + immatriculation + ", carburant : " + carburant + ", prix au km : " + prixkm + ", description : " + description + ", locations liées : " + locations;
    }

}
