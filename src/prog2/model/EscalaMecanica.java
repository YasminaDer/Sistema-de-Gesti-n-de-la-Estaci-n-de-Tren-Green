package prog2.model;

/**
 * Classe que representa una escala mecanica.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class EscalaMecanica extends AccessDesnivell {
    
    // Atribut específic de l'EscalaMecanica
    private String marca;
    
    // Constructor de l'EscalaMecanica
    public EscalaMecanica(String marca, double desnivell, String nom, boolean estat) {
        super(nom, estat, desnivell);
        this.marca = marca;
    }
    
    // Mètode getter per a la marca
    public String getMarca() {
        return marca;
    }
    
    // Mètode setter per a la marca
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    // Mètode sobreescrit per determinar l'accessibilitat
    @Override
    public boolean isAccessibilitat() {
        return false;
    }
    
    // Mètode sobreescrit per proporcionar una representació en cadena de l'EscalaMecanica
    @Override
    public String toString() {
        return "L'escala mecànica" + super.toString() + " I és de la marca " + getMarca() + ".";
    }
}