package prog2.model;

/**
 * Classe que representa una escala.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class Escala extends AccessDesnivell {
    
    // Constructor per a l'Escala
    public Escala(double desnivell, String nom, boolean estat) {
        super(nom, estat, desnivell);
    }
    
    // Mètode sobreescrit per determinar l'accessibilitat
    @Override
    public boolean isAccessibilitat() {
        return false;
    }  
    
    // Mètode sobreescrit per proporcionar una representació en cadena de l'Escala
    @Override
    public String toString() {
        return "L'escala" + super.toString();
    }
}