package prog2.model;
import prog2.vista.ExcepcioEstacio;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

/**
 * Classe que representa una llista amb las vias.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class LlistaVies implements InLlistaVies, Serializable {
    
    private ArrayList<Via> totalVies;
    
    // Constructor sense paràmetres per inicialitzar una nova llista de vies buida
    public LlistaVies(){
        this.totalVies = new ArrayList<>();
    }
       
    // Constructor amb una llista de vies proporcionada per inicialitzar la llista
    public LlistaVies(ArrayList<Via> totalVies){
        this.totalVies = totalVies;
    }
    
    // Mètode per afegir una nova via a la llista
    @Override
    public void afegirVia(Via via) throws ExcepcioEstacio {
        // Comprovem si la via ja existeix a la llista
        if(totalVies.contains(via)) 
            throw new ExcepcioEstacio("La via amb nom " + via.getNom() + " ja està afegida.");
        // Afegim la via a la llista
        totalVies.add(via);
    }
    
    // Mètode per buidar la llista de vies
    @Override
    public void buidar() {
        totalVies.clear();
    }
    
    // Mètode per llistar les vies amb un estat determinat
    @Override
    public String llistarVies(String estat) throws ExcepcioEstacio {
        // StringBuilder per construir el resultat
        StringBuilder result = new StringBuilder();
        // Iterator per recórrer la llista de vies
        Iterator<Via> itr = totalVies.iterator();
  
        // Recorrem la llista de vies
        while(itr.hasNext()) {
            Via via = itr.next();
            //Si es vol retornar totes
            if(estat.equals("obert o tancat")){
                result.append(via.toString()).append("\n");
            }
            // Si la via té l'estat indicat, l'afegim al resultat
            else if (via.getEstat().equals(estat)) {
                result.append(via.toString()).append("\n");
            }
        }
        // Si no s'ha trobat cap via amb l'estat indicat, llancem una excepció
        if(result.length() == 0)
            throw new ExcepcioEstacio("No s'ha trobat cap via amb l'estat " + estat.toLowerCase() + ".");
        
        return result.toString();
    }
    
    // Mètode per comprovar si hi ha vies obertes a la llista
    @Override
    public boolean containsViesObertes() {
        // Iterator per recórrer la llista de vies
        Iterator<Via> itr = totalVies.iterator();
        // Recorrem la llista de vies
        while(itr.hasNext()){
            Via via = itr.next();
            // Si trobem una via oberta, retornem true
            if(via.getEstat().equals("obert")) {
                return true;
            }  
        }
        // Si no s'ha trobat cap via oberta, retornem false
        return false;
    }
    
    // Mètode per comprovar si la llista de vies conté una via específica
    @Override
    public boolean contains(Via via) {
        // Iterator per recórrer la llista de vies
        Iterator<Via> itr = totalVies.iterator();
        // Recorrem la llista de vies
        while(itr.hasNext()) {
            Via itrVia = itr.next();
            // Comprovem si la via coincideix amb la via actual de l'iterador
            if (itrVia.equals(via))
                return true;
        }
        // Si no s'ha trobat cap via que coincideixi, retornem false
        return false;
    }
    
    // Mètode per obtenir una via per nom
    @Override
    public Via getVia(String nom) throws ExcepcioEstacio {
        // Iterator per recórrer la llista de vies
        Iterator<Via> itr = totalVies.iterator();
        
        // Recorrem la llista de vies
        while(itr.hasNext()) {
            Via via = itr.next();
            // Comprovem si el nom de la via coincideix amb el nom proporcionat
            if (via.getNom().equals(nom))
                return via;  
       }
       // Si no s'ha trobat cap via amb el nom proporcionat, llancem una excepció
       throw new ExcepcioEstacio ("No s'ha trobat cap via amb el nom " + nom + ".");
    }    
}