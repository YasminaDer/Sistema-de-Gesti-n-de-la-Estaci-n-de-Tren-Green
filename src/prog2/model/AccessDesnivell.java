package prog2.model;

/**
 * Classe abstracta que representa els accessos amb desnivell.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public abstract class AccessDesnivell extends Acces {   
    
     // Atribut específic de la subclasse AccessDesnivell
    private double desnivell;
    
     // Constructor de la classe AccessDesnivell
    public AccessDesnivell(String nom, boolean estat, double desnivell) {
        // Crida al constructor de la classe pare (Acces)
        super(nom, estat);
        this.desnivell = desnivell;
    }
    
    // Mètode per obtenir el desnivell
    public double getDesnivell(){
        return desnivell;
    }
    
    public void setDesnivell(double desnivell){
        this.desnivell = desnivell;
    }
    
    @Override
    public String toString(){
        return super.toString() + ", té un desnivell de " + getDesnivell() + " metres.";
    }
}
