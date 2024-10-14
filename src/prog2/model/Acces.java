package prog2.model;
import prog2.vista.ExcepcioEstacio;
import java.io.Serializable;

/**
 * Classe abstracta que representa els accessos.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public abstract class Acces implements InAcces, Serializable {
    
    // Atributs de la classe Acces
    private String nom;
    private boolean accessibilitat;
    private boolean estat;
    private LlistaVies vies;
    
    // Constructor de la classe Acces
    public Acces(String nom, boolean estat){
        this.nom = nom;
        this.estat = estat;
        this.accessibilitat = this.isAccessibilitat();
        this.vies = new LlistaVies();
    }
    
    // Mètode abstracte per determinar l'accessibilitat
    public abstract boolean isAccessibilitat();
    
    // Mètode per obtenir el nom de l'accés
    public String getNom(){
        return nom;
    }
    
    // Mètode per obtenir l'estat de l'accés
    public boolean getEstat() {
        return estat;
    }
    
    // Mètode per obtenir la llista de vies associades a l'accés
    public LlistaVies getVies() {
        return vies;
    }
    
    public void setNom(String nom) {
    this.nom = nom;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }

    public void setVies(LlistaVies vies) {
        this.vies = vies;
    }
    
    // Mètode per afegir una via a l'accés
    @Override
    public void afegirVia(Via via) {
        try{
          vies.afegirVia(via);
        } catch(ExcepcioEstacio e){
            System.err.println(e.getMessage());
        }
    }
    
    // Mètode per tancar l'accés
    @Override
    public void tancarAcces() {
        setEstat(false);
    }
    
    // Mètode per obrir l'accés
    @Override
    public void obrirAcces() {
       setEstat(true);
    }
    
    @Override
    public String toString(){
       return " amb nom " + getNom() + " està " + (getEstat() ? "obert" : "tancat");
    }
}