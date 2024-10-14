package prog2.model;

/**
 * Classe que representa una cinta transportadora.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class CintaTransportadora extends AccessNivell {
    
    // Atributs específics de la CintaTransportadora
    private double vel;
    
    // Constructor per a la CintaTransportadora
    public CintaTransportadora(double vel, double longitud, String nom, boolean estat) {
        super(nom, estat, longitud);
        this.vel = vel;
    }
    
    // Mètode getter per a la velocitat
    public double getVelocitat() {
        return vel;
    }
    
    // Mètode setter per a la velocitat
    public void setVelocitat(double velocitat) {
        this.vel = velocitat;
    }
    
    // Mètode sobreescrit per determinar l'accessibilitat
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
    
    // Mètode sobreescrit per proporcionar una representació en cadena de la CintaTransportadora
    @Override
    public String toString() {
        return "La cinta transportadora" + super.toString() + " I té una velocitat de " + getVelocitat() + "m/s";
    }
}