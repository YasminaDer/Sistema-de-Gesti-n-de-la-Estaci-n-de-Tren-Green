package prog2.model;

/**
 *
 * @author Yasmina
 */

public interface InAcces {
    
    /**
     * Afegeix una via rebuda com a paràmetre a la llista de vies de l'accés
     * @param via 
     */
    public void afegirVia(Via via);
    
    /**
     * Canvia l'estat de l'accés a tancat
     */
    public void tancarAcces();
    
    /**
     * Canvia l'estat de l'accés a obert 
     */
    public void obrirAcces();
    
     /**
     * Retorna si l'accés permet accessibilitat o no.
     */
    public boolean isAccessibilitat();
}
