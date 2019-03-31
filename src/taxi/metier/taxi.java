/**
 *
 * @author Florian Cammarata
 * @version 1.0
 */
package taxi.metier;

public class taxi {

    protected int idtaxi;
    /**
     * identifiant unique du taxi
     */
    protected String immatriculation;
    /**
     * immatriculation du taxi
     */
    protected String carburant;
    /**
     * carburant du taxi
     */
    protected float prixkm;
    /**
     * prix du taxi au kilometre
     */
    protected String description;
    /**
     * description détaillée du taxi
     */

    
    /**
     * constructeur par défaut
     */
    public taxi() {

    }

    /**
     * constructeur paramétré
     *
     * @param idtaxi identifiant unique du taxi, affecté par la base de donnée
     * @param immatriculation immatriculation du taxi
     * @param carburant carburant du taxi
     * @param prixkm prix au km pour le taxi
     * @param description description detaillée du taxi
     */
    public taxi(int idtaxi, String immatriculation, String carburant, float prixkm, String description) {

        this.idtaxi = idtaxi;
        this.immatriculation = immatriculation;
        this.carburant = carburant;
        this.prixkm = prixkm;
        this.description = description;

    }

    /**
     * getter id du taxi
     *
     * @return id tu taxi
     */
    public int getIdtaxi() {
        return idtaxi;
    }

    /**
     * setter id du taxi
     *
     * @param idtaxi id du taxi
     */
    public void setIdtaxi(int idtaxi) {
        this.idtaxi = idtaxi;
    }

    /**
     * getter immatriculation
     *
     * @return immatriculation du taxi
     */
    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * setter immatriculation
     *
     * @param immatriculation immatriculation du taxi
     */
    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    /**
     * getter carburant
     *
     * @return carburant du taxi
     */
    public String getCarburant() {
        return carburant;
    }

    /**
     * setter du carburant
     *
     * @param carburant carburant du taxi
     */
    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    /**
     * getter prix au km
     *
     * @return prix au km du taxi
     */
    public float getPrixkm() {
        return prixkm;
    }

    /**
     * setter prix au km
     *
     * @param prixkm prix au km
     */
    public void setPrixkm(float prixkm) {
        this.prixkm = prixkm;
    }

    /**
     * getter description
     *
     * @return description du taxi
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter description
     *
     * @param description description du taxi
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * methode toString
     *
     * @return infos completes
     */
    @Override
    public String toString() {
        return "Taxi : " + idtaxi + ", immatriculation : " + immatriculation + " (" + carburant + "), prix au km : " + prixkm + ". " + description;
    }

}
