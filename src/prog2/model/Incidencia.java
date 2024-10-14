package prog2.model;
import java.io.Serializable;

/**
 * Classe que representa una Incidencia en una Via.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class Incidencia implements Serializable{
    
    // Enumeració per als tipus d'incidències
    public static enum TipusIncidencia {
        REPARACIO,
        OBJECTE,
        TANCAMENT
    };
    
    // Atributs de la classe Incidencia
    private int id;
    private TipusIncidencia tipus; 
    private Via via;
    private String data;
    
    // Constructor de la classe Incidencia
    public Incidencia(int id, TipusIncidencia tipus, Via via, String data) {
        this.id = id;
        this.tipus = tipus;
        this.via = via;
        this.data = data;
    }

    // Mètode per obtenir l'identificador de la incidència
    public int getId() {
        return id;
    }
    
    // Mètode per establir l'identificador de la incidència
    public void setId(int id) {
        this.id = id;
    }
    
    // Mètode per obtenir el tipus de la incidència
    public TipusIncidencia getTipus() {
        return tipus;
    }
    
    // Mètode per establir el tipus de la incidència
    public void setTipus(TipusIncidencia tipus) {
        this.tipus = tipus;
    }

    // Mètode per obtenir la via associada a la incidència
    public Via getVia() {
        return via;
    }
    
    // Mètode per establir la via associada a la incidència
    public void setVia(Via via) {
        this.via = via;
    }

    // Mètode per obtenir la data de la incidència
    public String getData() {
        return data;
    }

    // Mètode per establir la data de la incidència
    public void setData(String data) {
        this.data = data;
    }
    
    // Mètode per obtenir l'índex d'il·luminació de la via en funció del tipus d'incidència
    public String getIluminacioVia(){  
        String iluminacio = "";
        switch(tipus) {
            case REPARACIO:
                iluminacio = "100%";
                break;
            case OBJECTE:
                iluminacio = "50%";
                break;  
            case TANCAMENT:
                iluminacio = "0%";
                break;   
        }
        return iluminacio;
    }
    
    // Mètode sobreescrit per proporcionar una representació en cadena de la Incidencia
    @Override
    public String toString() {
        return "Identificador de la incidència: " + getId() + "\n" + 
                "Tipus: " + getTipus().toString().toLowerCase() + "\n" +
                "Via: " + getVia().getNom() + " \n" + 
                "Data: " + getData();
    }
}
