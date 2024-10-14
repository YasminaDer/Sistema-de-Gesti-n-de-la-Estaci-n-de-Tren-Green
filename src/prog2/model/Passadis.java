package prog2.model;

/**
 * Classe que representa un passadís.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class Passadis extends AccessNivell {
    
    // Constructor de la classe Passadis
    public Passadis(double longitud, String nom, boolean estat){
        // Crida al constructor de la classe pare (AccessNivell)
        super(nom, estat, longitud);
    }
    
    // Implementació del mètode abstracte isAccessibilitat de la classe pare
    @Override
    public boolean isAccessibilitat(){
        // El passadís sempre té accessibilitat, per tant retornem true
        return true;
    }
    
    @Override
    public String toString(){
        return "El passadís amb nom " + getNom() + " està " + (getEstat() ? "obert" : "tancat") + ", i té una longitud de " + getLongitud() + " metres.";
    }
}
