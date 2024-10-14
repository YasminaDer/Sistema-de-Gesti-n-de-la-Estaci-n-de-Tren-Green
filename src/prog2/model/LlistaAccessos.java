package prog2.model;
import prog2.vista.ExcepcioEstacio;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

/**
 * Classe que representa una llista amb accessos.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class LlistaAccessos implements InLlistaAccessos, Serializable {

     // Llista d'accessos
    private ArrayList<Acces> totalAccessos;
    
    // Constructor sense paràmetres, inicialitza la llista d'accessos buida
    public LlistaAccessos(){
        this.totalAccessos = new ArrayList<>();
    }
    
    // Constructor amb una llista d'accessos com a paràmetre
    public LlistaAccessos(ArrayList<Acces> totalAccessos){
        this.totalAccessos = totalAccessos;
    }
    
    // Mètode per afegir un accés a la llista
    @Override
    public void afegirAcces(Acces acces) throws ExcepcioEstacio {
        // Iterador per recórrer la llista d'accessos
        Iterator<Acces> itr = totalAccessos.iterator();
        
        // Comprova si ja existeix un accés amb el mateix nom
        while(itr.hasNext()){
            Acces acc = itr.next();
            if(acc.getNom().equals(acces.getNom()))
                throw new ExcepcioEstacio("L'accés amb nom " + acces.getNom() + " ja està afegit.");
        }
        // Afegir l'accés a la llista si no hi ha cap amb el mateix nom
        totalAccessos.add(acces);
    }
    
    // Mètode per buidar la llista d'accessos
    @Override
    public void buidar() {
       totalAccessos.clear();
    }
    
    // Mètode per llistar els accessos amb un determinat estat
    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioEstacio {
        // Iterador per recórrer la llista d'accessos
        Iterator<Acces> itr = totalAccessos.iterator();
        StringBuilder result = new StringBuilder();
        
        // Recorre la llista d'accessos
        while(itr.hasNext()) {
            Acces acc = itr.next();
            // Comprova si l'estat de l'acces coincideix amb l'estat especificat
            if(acc.getEstat() == estat) 
                result.append(acc.toString()).append("\n"); 
        }
        // Llança una excepció si no s'han trobat accessos amb l'estat especificat
        if(result.length() == 0)
            throw new ExcepcioEstacio("No s'ha trobat cap accés amb l'estat " + (estat ? "obert" : "tancat") + ".");

        return result.toString();
    }
    
    // Mètode per actualitzar l'estat dels accessos segons les vies obertes o tancades
    @Override
    public void actualitzaEstatAccessos() {
        // Iterador per recórrer la llista d'accessos
        Iterator<Acces> itr = totalAccessos.iterator();
        
        // Recorre la llista d'accessos
        while(itr.hasNext()) {
            Acces acc = itr.next();
            // Tanca l'accés si cap de les vies associades està oberta, sinó l'obre
            acc.tancarAcces();
            if(acc.getVies().containsViesObertes())
                acc.obrirAcces();
        } 
    }

    // Mètode per calcular el nombre d'accessos accessibles
    @Override
    public int calculaAccessosAccessibles() {
        int numAcc = 0;
        // Iterador per recórrer la llista d'accessos
        Iterator<Acces> itr = totalAccessos.iterator();
        
        // Recorre la llista d'accessos
        while(itr.hasNext()) {
            Acces acc = itr.next();
            // Incrementa el comptador si l'accés és accessible
            if(acc.isAccessibilitat()) {
                numAcc++;
            }
        }
        return numAcc;
    }
    
    // Mètode per calcular la longitud dels accessos de tipus AccessNivell
    @Override
    public float calculaLongitudAccessosNivell() {
       float longitud = 0;
       // Iterador per recórrer la llista d'accessos
       Iterator<Acces> itr = totalAccessos.iterator();
       
       // Recorre la llista d'accessos
       while(itr.hasNext()) {
           Acces acc = itr.next();
           // Suma la longitud dels accessos de tipus AccessNivell
           if(acc instanceof AccessNivell) {
               longitud += ((AccessNivell) acc).getLongitud();
           }
       }
       return longitud;
    }  
}
