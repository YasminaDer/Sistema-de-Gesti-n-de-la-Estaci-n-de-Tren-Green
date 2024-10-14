package prog2.model;
import java.util.ArrayList;
import prog2.vista.ExcepcioEstacio;
import java.util.Iterator;
import java.io.Serializable;

/**
 * Classe que representa una llista amb incidencies.
 * @author Yasmina Dermouh y Katerina Lothe
 */

public class LlistaIncidencies implements InLlistaIncidencies, Serializable {
    
    private ArrayList<Incidencia> totalIncidencies;
    
    // Constructor sense paràmetres per a inicialitzar una llista buida d'incidències
    public LlistaIncidencies() {
        this.totalIncidencies = new ArrayList<>();
    }
    
    // Constructor amb paràmetres per a inicialitzar la llista d'incidències amb una llista existent
    public LlistaIncidencies(ArrayList<Incidencia> totalIncidencies) {
        this.totalIncidencies = totalIncidencies;
    }
    
    // Mètode per afegir una incidència a la llista
    @Override
    public void afegirIncidencia(int num, String tipus, Via via, String data) throws ExcepcioEstacio {
        // Comprova si ja existeix una incidència associada a la via
        Iterator<Incidencia> itr = totalIncidencies.iterator();
        while(itr.hasNext()){
            Incidencia incidencia = itr.next();
            if(incidencia.getVia().equals(via))
                throw new ExcepcioEstacio("La via " + via.getNom() + " ja té una incidencia.");
        }
        
        // Si no hi ha cap incidència associada a la via, crea una nova incidència i tanca la via
        Incidencia in = new Incidencia(num, Incidencia.TipusIncidencia.valueOf(tipus), via, data);
        totalIncidencies.add(in);
        via.tancarVia(in);
    }
    
    // Mètode per eliminar una incidència de la llista
    @Override
    public void eliminarIncidencia(Incidencia in) throws ExcepcioEstacio {
        // Itera a través de les incidències per trobar la coincident amb la que volem eliminar
        Iterator<Incidencia> itr = totalIncidencies.iterator();
        while(itr.hasNext()){
            Incidencia incidencia = itr.next();
            if(incidencia.getId() == in.getId()){
                // Obre la via associada a la incidència eliminada
                incidencia.getVia().obrirVia();
                totalIncidencies.remove(in);
                return;
            }  
        }
        // Si no es troba cap incidència amb l'ID especificada, llança una excepció
        throw new ExcepcioEstacio("Incidència no trobada amb ID: " + in.getId());
    }
    
    // Mètode per llistar les incidències
    @Override
    public String llistarIncidencies() throws ExcepcioEstacio {
        StringBuilder infoIn = new StringBuilder();
        Iterator<Incidencia> itr = totalIncidencies.iterator();
        
        // Construeix una cadena amb la informació de totes les incidències
        while(itr.hasNext()) {
            Incidencia in = itr.next();
            infoIn.append(in.toString()).append("\n");
        }
        
        // Si no hi ha cap incidència, llança una excepció
        if(infoIn.length() == 0){
            throw new ExcepcioEstacio ("No hi ha cap incidència. ");
        }
        
        return infoIn.toString();
    }
    
    // Mètode per obtenir una incidència per ID
    @Override
    public Incidencia getIncidencia(int num) throws ExcepcioEstacio {
        Iterator<Incidencia> itr = totalIncidencies.iterator();
        while(itr.hasNext()) {
            Incidencia in = itr.next();
            if(in.getId() == num) {
                return in;
            }
        }
        // Si no es troba cap incidència amb l'ID especificada, llança una excepció
        throw new ExcepcioEstacio ("No s'ha trobat cap incidència amb l'ID " + num);
    }    
}