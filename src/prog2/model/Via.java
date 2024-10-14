package prog2.model;
import java.io.Serializable;

/**
 * Classe que representa una via.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class Via implements InVia, Serializable  {
    
    // Atributs de la classe Via
    private String nom;
    private String amplada;
    private int numTunels;
    private boolean obert;
    private String illuminacio;
    
    //Constructor
    public Via(String nom, String amplada, int numTunels, boolean obert, String illuminacio){
        this.nom = nom;
        this.amplada = amplada;
        this.numTunels = numTunels;
        this.obert = obert;
        this.illuminacio = illuminacio;
    }
    // Mètode per obtenir el nom de la via
    public String getNom() {
        return nom;
    }
    
    // Mètode per establir el nom de la via
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    // Mètode per obtenir l'amplada de la via
    public String getAmplada() {
        return amplada;
    }
    
    // Mètode per establir l'amplada de la via
    public void setAmplada(String amplada){
        this.amplada = amplada;
    }
    
    // Mètode per obtenir el nombre de túnels de la via
    public int getNumTunels() {
        return numTunels;
    }
    
    // Mètode per establir el nombre de túnels de la via
    public void setNumTunels(int numTunels){
        this.numTunels = numTunels;
    }
    
    // Mètode per establir l'estat de la via
    public void setEstat(boolean estat) {
        obert = estat;
    }
    // Mètode per obtenir l'estat de la via, en string para que sea compatible con llistarVies(String estat) de LlistaVies()
    public String getEstat() {
        if(obert) return "obert";
        else
            return "tancat";
    }
    
    // Mètode per obtenir la il·luminació de la via
    public String getIlluminacio() {
        return illuminacio;
    }
    
    // Mètode per establir la il·luminació de la via
    public void setIlluminacio(String illuminacio) {
        this.illuminacio = illuminacio;
    }
    
    // Mètode per tancar la via amb una incidència
    @Override
    public void tancarVia(Incidencia in) {
        setEstat(false);
        setIlluminacio(in.getIluminacioVia());
    }

    // Mètode per obrir la via
    @Override
    public void obrirVia() {
       setEstat(true);
       setIlluminacio("100%");
    } 
    
    // Mètode per obtenir una representació en format String de la via
    @Override
    public String toString() {
        return "Nom de la via: " + getNom() + "\n" + 
               "Amplada: " + getAmplada() + "\n" + 
               "Nombre de túnels: " + getNumTunels() + "\n" + 
               "Estat: " + getEstat() + "\n" + 
               "Illuminació: " + getIlluminacio();
    }
}
