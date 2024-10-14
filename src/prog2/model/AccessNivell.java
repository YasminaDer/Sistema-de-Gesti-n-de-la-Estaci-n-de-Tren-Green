package prog2.model;

/**
 * Classe abstracta que representa els accessos sense desnivell.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public abstract class AccessNivell extends Acces {
    
    // Atribut específic de la classe AccessNivell
    private final double longitud;
    
    // Constructor de la classe AccessNivell
    public AccessNivell(String nom, boolean estat, double longitud) {
        // Crida al constructor de la classe pare (Acces)
        super(nom, estat);
        this.longitud = longitud;
    }
    
    // Mètode per obtenir la longitud de l'accés
    public double getLongitud() {
        return longitud;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", té una longitud de " + getLongitud() + " metres.";
    }
}