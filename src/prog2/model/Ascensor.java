package prog2.model;

/**
 * Classe que representa un ascensor.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class Ascensor extends AccessDesnivell {
    
    // Atributs específics de l'Ascensor
    private double pesMax;
    
    // Constructor per a l'Ascensor
    public Ascensor(double pesMax, double desnivell, String nom, boolean estat) {
        super(nom, estat, desnivell);
        this.pesMax = pesMax;    
    }
    
    // Mètode getter per a pesMax
    public double getPesMax() {
        return pesMax;
    }
    
    // Mètode setter per a pesMax
    public void setPesMax(double pesMax) {
        this.pesMax = pesMax;
    }
    
    // Mètode sobreescrit per determinar l'accessibilitat
    @Override
    public boolean isAccessibilitat() {
        return true;
    }
    
    // Mètode sobreescrit per proporcionar una representació en cadena de l'Ascensor
    @Override
    public String toString() {
        return "L'ascensor" + super.toString() + " I té un pes màxim de " + getPesMax() + "kg";
    }
}