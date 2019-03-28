package taxi.metier;

public class taxi {

    protected int idtaxi;
    protected String immatriculation;
    protected String carburant;
    protected float prixkm;
    protected String description;

    public taxi(int idtaxi, String immatriculation, String carburant, float prixkm, String description) {

        this.idtaxi = idtaxi;
        this.immatriculation = immatriculation;
        this.carburant = carburant;
        this.prixkm = prixkm;
        this.description = description;

    }

    public int getIdtaxi() {
        return idtaxi;
    }

    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public float getPrixkm() {
        return prixkm;
    }

    public void setPrixkm(float prixkm) {
        this.prixkm = prixkm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Taxi : " + idtaxi + ", immatriculation : " + immatriculation + " (" +carburant+ "), prix au km : " + prixkm + ". " + description;
    }


    
    
    

}
